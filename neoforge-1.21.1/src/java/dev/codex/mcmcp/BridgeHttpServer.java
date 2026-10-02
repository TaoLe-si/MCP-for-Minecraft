package dev.codex.mcmcp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.blaze3d.platform.NativeImage;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Screenshot;
import net.minecraft.client.gui.screens.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelSettings;
import net.minecraft.world.level.WorldDataConfiguration;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.WorldOptions;
import net.minecraft.world.level.levelgen.presets.WorldPresets;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.gametest.framework.GameTestRegistry;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class BridgeHttpServer {
    private static final Logger LOGGER = LoggerFactory.getLogger("MinecraftMcpBridge");
    private static final Gson GSON = new Gson();
    private static final int MAX_BODY_BYTES = 1_048_576;
    private static final Pattern TEST_ID = Pattern.compile("[a-z0-9_.-]+:[a-z0-9_./-]+");
    private static volatile HttpServer server;
    private static volatile String token;
    private static boolean autoWorldAttempted;

    private BridgeHttpServer() { }

    static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(BridgeHttpServer::startFromEnvironment);
    }

    private static synchronized void startFromEnvironment() {
        if (server != null) return;
        String host = System.getenv("MC_MCP_HOST");
        String portValue = System.getenv("MC_MCP_PORT");
        token = System.getenv("MC_MCP_TOKEN");
        if (!"127.0.0.1".equals(host) || token == null || token.length() < 32) {
            LOGGER.info("MCP bridge is disabled; local launcher credentials were not supplied.");
            return;
        }

        try {
            int port = Integer.parseInt(portValue);
            HttpServer localServer = HttpServer.create(
                    new InetSocketAddress(InetAddress.getByName("127.0.0.1"), port), 0);
            localServer.setExecutor(Executors.newFixedThreadPool(3, runnable -> {
                Thread thread = new Thread(runnable, "mcmcp-http");
                thread.setDaemon(true);
                return thread;
            }));
            localServer.createContext("/health", BridgeHttpServer::handleHealth);
            localServer.createContext("/rpc", BridgeHttpServer::handleRpc);
            localServer.start();
            server = localServer;
            LOGGER.info("Local MCP bridge listening on 127.0.0.1:{}", port);
        } catch (Exception exception) {
            LOGGER.error("Could not start local MCP bridge", exception);
        }
    }

    static void maybeCreateValidationWorld(Minecraft client) {
        if (!"true".equalsIgnoreCase(System.getenv("MC_MCP_AUTOWORLD"))) return;
        if (client.options.pauseOnLostFocus) {
            client.options.pauseOnLostFocus = false;
            LOGGER.info("Disabled pause-on-lost-focus for the isolated unattended validation client.");
        }
        if (autoWorldAttempted) return;
        if (client.screen instanceof AccessibilityOnboardingScreen onboarding) {
            onboarding.onClose();
            LOGGER.info("Closed Minecraft first-run accessibility onboarding through the client API.");
            return;
        }
        if (client.player != null || client.level != null || !(client.screen instanceof TitleScreen)) return;

        autoWorldAttempted = true;
        String worldName = System.getenv("MC_MCP_WORLD_NAME");
        if (worldName == null || !worldName.matches("[a-z0-9_-]{1,64}")) {
            LOGGER.error("Auto-world creation was requested without a valid isolated world name.");
            return;
        }

        try {
            var settings = new LevelSettings(
                    "MCP Validation", GameType.SURVIVAL, false, Difficulty.PEACEFUL, true,
                    new GameRules(), WorldDataConfiguration.DEFAULT);
            var options = new WorldOptions(20261002L, true, false);
            client.createWorldOpenFlows().createFreshLevel(
                    worldName, settings, options, WorldPresets::createNormalWorldDimensions, client.screen);
            LOGGER.info("Requested creation of isolated MCP validation world {}", worldName);
        } catch (Exception failure) {
            LOGGER.error("Could not create isolated MCP validation world {}", worldName, failure);
        }
    }

    static synchronized void stop() {
        HttpServer current = server;
        server = null;
        if (current != null) current.stop(0);
    }

    private static void handleHealth(HttpExchange exchange) throws IOException {
        if (!authorized(exchange)) {
            respond(exchange, 401, error("unauthorized", "Missing or invalid bearer token."));
            return;
        }
        if (!"GET".equals(exchange.getRequestMethod())) {
            respond(exchange, 405, error("method_not_allowed", "Use GET."));
            return;
        }
        Minecraft client = Minecraft.getInstance();
        JsonObject health = new JsonObject();
        health.addProperty("ready", true);
        health.addProperty("modId", MinecraftMcpBridge.MOD_ID);
        health.addProperty("minecraftVersion", SharedConstants.getCurrentVersion().getName());
        health.addProperty("inWorld", client.player != null && client.level != null);
        health.addProperty("localIntegratedServer", client.isLocalServer());
        respond(exchange, 200, health);
    }

    private static void handleRpc(HttpExchange exchange) throws IOException {
        if (!authorized(exchange)) {
            respond(exchange, 401, error("unauthorized", "Missing or invalid bearer token."));
            return;
        }
        if (!"POST".equals(exchange.getRequestMethod())) {
            respond(exchange, 405, error("method_not_allowed", "Use POST."));
            return;
        }

        byte[] body = exchange.getRequestBody().readNBytes(MAX_BODY_BYTES + 1);
        if (body.length > MAX_BODY_BYTES) {
            respond(exchange, 413, error("body_too_large", "Request exceeds the local bridge limit."));
            return;
        }

        try {
            JsonObject request = JsonParser.parseString(new String(body, StandardCharsets.UTF_8)).getAsJsonObject();
            String operation = requiredString(request, "op");
            JsonObject arguments = request.has("args") && request.get("args").isJsonObject()
                    ? request.getAsJsonObject("args") : new JsonObject();
            JsonObject result;
            if ("screenshot".equals(operation)) {
                result = captureScreenshot();
            } else {
                result = onClientThread(() -> dispatch(Minecraft.getInstance(), operation, arguments), 10);
            }
            respond(exchange, 200, result);
        } catch (TimeoutException timeout) {
            respond(exchange, 504, error("game_thread_timeout", "The client did not answer within the operation timeout."));
        } catch (IllegalArgumentException invalid) {
            respond(exchange, 400, error("invalid_request", invalid.getMessage()));
        } catch (Exception failure) {
            LOGGER.warn("MCP bridge request failed", failure);
            respond(exchange, 500, error("bridge_error", safeMessage(failure)));
        }
    }

    private static JsonObject dispatch(Minecraft client, String operation, JsonObject args) {
        return switch (operation) {
            case "runtime_info" -> runtimeInfo(client);
            case "registry_list" -> registryList(args);
            case "player_state" -> playerState(client);
            case "player_action" -> playerAction(client, args);
            case "inventory_state" -> inventoryState(client);
            case "inventory_click" -> inventoryClick(client, args);
            case "give_item" -> giveItem(client, args);
            case "interact_block" -> interactBlock(client, args);
            case "block_at" -> blockAt(client, args);
            case "world_inspect" -> worldInspect(client, args);
            case "world_setup" -> worldSetup(client, args);
            case "game_test" -> runGameTest(client, args);
            case "shutdown" -> shutdownClient(client);
            default -> throw new IllegalArgumentException("Unsupported bridge operation: " + operation);
        };
    }

    private static JsonObject shutdownClient(Minecraft client) {
        JsonObject result = new JsonObject();
        result.addProperty("accepted", true);
        client.stop();
        return result;
    }

    private static JsonObject runtimeInfo(Minecraft client) {
        JsonObject result = new JsonObject();
        result.addProperty("minecraftVersion", SharedConstants.getCurrentVersion().getName());
        result.addProperty("modId", MinecraftMcpBridge.MOD_ID);
        result.addProperty("inWorld", client.player != null && client.level != null);
        result.addProperty("localIntegratedServer", client.isLocalServer());
        if (client.level != null) result.addProperty("dimension", client.level.dimension().location().toString());
        if (client.player != null) result.addProperty("playerName", client.player.getGameProfile().getName());
        JsonArray mods = new JsonArray();
        ModList.get().getMods().forEach(mod -> {
            JsonObject info = new JsonObject();
            info.addProperty("id", mod.getModId());
            info.addProperty("version", mod.getVersion().toString());
            mods.add(info);
        });
        result.add("loadedMods", mods);
        return result;
    }

    private static JsonObject registryList(JsonObject args) {
        String registryName = requiredString(args, "registry");
        List<String> ids = switch (registryName) {
            case "blocks" -> BuiltInRegistries.BLOCK.keySet().stream().map(Object::toString).sorted().toList();
            case "items" -> BuiltInRegistries.ITEM.keySet().stream().map(Object::toString).sorted().toList();
            case "entities" -> BuiltInRegistries.ENTITY_TYPE.keySet().stream().map(Object::toString).sorted().toList();
            default -> throw new IllegalArgumentException("registry must be blocks, items, or entities.");
        };
        String namespace = optionalString(args, "namespace", "");
        String prefix = optionalString(args, "prefix", "");
        List<String> filtered = ids.stream()
                .filter(id -> namespace.isEmpty() || id.startsWith(namespace + ":"))
                .filter(id -> prefix.isEmpty() || id.startsWith(prefix))
                .toList();
        int offset = boundedInt(args, "offset", 0, 0, Integer.MAX_VALUE);
        int limit = boundedInt(args, "limit", 100, 1, 200);
        int from = Math.min(offset, filtered.size());
        int to = Math.min(from + limit, filtered.size());
        JsonArray entries = new JsonArray();
        filtered.subList(from, to).forEach(entries::add);
        JsonObject result = new JsonObject();
        result.addProperty("registry", registryName);
        result.addProperty("total", filtered.size());
        result.addProperty("offset", from);
        result.addProperty("nextOffset", to < filtered.size() ? to : -1);
        result.add("entries", entries);
        return result;
    }

    private static JsonObject playerState(Minecraft client) {
        var player = requireLocalPlayer(client);
        JsonObject result = new JsonObject();
        result.addProperty("name", player.getGameProfile().getName());
        result.addProperty("uuid", player.getUUID().toString());
        result.addProperty("x", player.getX());
        result.addProperty("y", player.getY());
        result.addProperty("z", player.getZ());
        result.addProperty("yaw", player.getYRot());
        result.addProperty("pitch", player.getXRot());
        result.addProperty("health", player.getHealth());
        result.addProperty("maxHealth", player.getMaxHealth());
        result.addProperty("food", player.getFoodData().getFoodLevel());
        result.addProperty("saturation", player.getFoodData().getSaturationLevel());
        result.addProperty("onGround", player.onGround());
        result.addProperty("gameMode", client.gameMode == null ? "unknown" : client.gameMode.getPlayerMode().getName());
        result.addProperty("selectedSlot", player.getInventory().selected);
        JsonArray inventory = new JsonArray();
        for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
            ItemStack stack = player.getInventory().getItem(slot);
            JsonObject item = new JsonObject();
            item.addProperty("slot", slot);
            item.addProperty("id", BuiltInRegistries.ITEM.getKey(stack.getItem()).toString());
            item.addProperty("count", stack.getCount());
            if (!stack.isEmpty()) item.addProperty("name", stack.getHoverName().getString());
            inventory.add(item);
        }
        result.add("inventory", inventory);
        result.add("target", targetInfo(client));
        return result;
    }

    private static JsonObject targetInfo(Minecraft client) {
        JsonObject target = new JsonObject();
        HitResult hit = client.hitResult;
        if (hit == null || hit.getType() == HitResult.Type.MISS) {
            target.addProperty("type", "miss");
        } else if (hit instanceof BlockHitResult blockHit && client.level != null) {
            BlockPos pos = blockHit.getBlockPos();
            target.addProperty("type", "block");
            target.addProperty("x", pos.getX());
            target.addProperty("y", pos.getY());
            target.addProperty("z", pos.getZ());
            target.addProperty("id", BuiltInRegistries.BLOCK.getKey(client.level.getBlockState(pos).getBlock()).toString());
        } else if (hit instanceof EntityHitResult entityHit) {
            target.addProperty("type", "entity");
            target.add("entity", entityInfo(entityHit.getEntity()));
        } else {
            target.addProperty("type", hit.getType().name().toLowerCase());
        }
        return target;
    }

    private static JsonObject playerAction(Minecraft client, JsonObject args) {
        var player = requireLocalPlayer(client);
        String action = requiredString(args, "action");
        JsonObject result = new JsonObject();
        switch (action) {
            case "hold" -> {
                int ticks = boundedInt(args, "ticks", 1, 1, PlayerControls.MAX_HOLD_TICKS);
                List<String> controls = new ArrayList<>();
                if (args.has("controls") && args.get("controls").isJsonArray()) {
                    for (JsonElement element : args.getAsJsonArray("controls")) {
                        if (!element.isJsonPrimitive() || !element.getAsJsonPrimitive().isString()) {
                            throw new IllegalArgumentException("controls must contain strings.");
                        }
                        controls.add(element.getAsString());
                    }
                } else if (args.has("control")) {
                    controls.add(requiredString(args, "control"));
                } else {
                    throw new IllegalArgumentException("Provide control or controls.");
                }
                if (controls.isEmpty() || controls.size() > 4) throw new IllegalArgumentException("Use 1 to 4 controls per hold action.");
                controls.forEach(control -> PlayerControls.hold(client, control, ticks));
                result.addProperty("accepted", true);
                result.addProperty("ticks", ticks);
                result.add("controls", strings(controls));
            }
            case "release_all" -> {
                PlayerControls.releaseAll(client);
                result.addProperty("accepted", true);
            }
            case "look" -> {
                float yaw = finiteFloat(args, "yaw") % 360.0F;
                float pitch = Math.max(-90.0F, Math.min(90.0F, finiteFloat(args, "pitch")));
                player.setYRot(yaw);
                player.setXRot(pitch);
                result.addProperty("yaw", yaw);
                result.addProperty("pitch", pitch);
            }
            case "select_slot" -> {
                int slot = boundedInt(args, "slot", -1, 0, 8);
                player.getInventory().selected = slot;
                result.addProperty("selectedSlot", slot);
            }
            case "chat" -> {
                String message = requiredString(args, "message");
                if (message.isBlank() || message.length() > 256 || message.stripLeading().startsWith("/")
                        || message.codePoints().anyMatch(Character::isISOControl)) {
                    throw new IllegalArgumentException("Chat text must be 1–256 characters and cannot start with '/'.");
                }
                player.connection.sendChat(message);
                result.addProperty("sent", true);
            }
            default -> throw new IllegalArgumentException("action must be hold, release_all, look, select_slot, or chat.");
        }
        return result;
    }

    private static JsonObject blockAt(Minecraft client, JsonObject args) {
        requireLocalPlayer(client);
        int x = boundedInt(args, "x", 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int y = boundedInt(args, "y", 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int z = boundedInt(args, "z", 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        BlockPos pos = new BlockPos(x, y, z);
        if (client.player.blockPosition().distSqr(pos) > 128.0 * 128.0) {
            throw new IllegalArgumentException("Requested block is more than 128 blocks from the player.");
        }
        JsonObject result = new JsonObject();
        result.addProperty("x", x);
        result.addProperty("y", y);
        result.addProperty("z", z);
        if (!client.level.hasChunkAt(pos)) {
            result.addProperty("loaded", false);
            return result;
        }
        BlockState state = client.level.getBlockState(pos);
        result.addProperty("loaded", true);
        result.addProperty("id", BuiltInRegistries.BLOCK.getKey(state.getBlock()).toString());
        JsonObject properties = new JsonObject();
        state.getValues().forEach((property, value) -> properties.addProperty(property.getName(), propertyValue(property, value)));
        result.add("properties", properties);
        result.addProperty("hasBlockEntity", state.hasBlockEntity());
        return result;
    }

    private static JsonObject inventoryState(Minecraft client) {
        var player = requireLocalPlayer(client);
        var menu = player.containerMenu;
        JsonObject result = new JsonObject();
        result.addProperty("containerId", menu.containerId);
        result.addProperty("screen", client.screen == null ? "none" : client.screen.getClass().getSimpleName());
        JsonArray slots = new JsonArray();
        for (var slot : menu.slots) {
            ItemStack stack = slot.getItem();
            JsonObject item = new JsonObject();
            item.addProperty("slot", slot.index);
            item.addProperty("containerSlot", slot.getContainerSlot());
            item.addProperty("id", BuiltInRegistries.ITEM.getKey(stack.getItem()).toString());
            item.addProperty("count", stack.getCount());
            if (!stack.isEmpty()) item.addProperty("name", stack.getHoverName().getString());
            slots.add(item);
        }
        result.add("slots", slots);
        return result;
    }

    private static JsonObject inventoryClick(Minecraft client, JsonObject args) {
        var player = requireLocalPlayer(client);
        var menu = player.containerMenu;
        int slot = boundedInt(args, "slot", -1, -999, Math.max(-999, menu.slots.size() - 1));
        int button = boundedInt(args, "button", 0, 0, 8);
        String clickTypeName = optionalString(args, "clickType", "PICKUP");
        ClickType clickType = switch (clickTypeName) {
            case "PICKUP" -> ClickType.PICKUP;
            case "QUICK_MOVE" -> ClickType.QUICK_MOVE;
            case "SWAP" -> ClickType.SWAP;
            case "THROW" -> ClickType.THROW;
            case "PICKUP_ALL" -> ClickType.PICKUP_ALL;
            default -> throw new IllegalArgumentException("clickType must be PICKUP, QUICK_MOVE, SWAP, THROW, or PICKUP_ALL.");
        };
        if (slot != -999 && (slot < 0 || slot >= menu.slots.size())) {
            throw new IllegalArgumentException("slot must be -999 (outside) or a valid active menu slot.");
        }
        if (client.gameMode == null) throw new IllegalArgumentException("The player interaction manager is unavailable.");
        client.gameMode.handleInventoryMouseClick(menu.containerId, slot, button, clickType, player);
        JsonObject result = new JsonObject();
        result.addProperty("accepted", true);
        result.addProperty("containerId", menu.containerId);
        result.addProperty("slot", slot);
        result.addProperty("clickType", clickType.name());
        return result;
    }

    private static JsonObject giveItem(Minecraft client, JsonObject args) {
        requireLocalWorld(client);
        String itemId = requiredString(args, "itemId");
        int count = boundedInt(args, "count", 1, 1, 64);
        if (!itemId.matches("[a-z0-9_.-]+:[a-z0-9_./-]+")) {
            throw new IllegalArgumentException("itemId must be a namespaced registry ID.");
        }
        ResourceLocation id = ResourceLocation.parse(itemId);
        if (!BuiltInRegistries.ITEM.containsKey(id)) throw new IllegalArgumentException("No item is registered with that ID.");
        runLocalCommand(client, "give @a " + id + " " + count);
        JsonObject result = new JsonObject();
        result.addProperty("accepted", true);
        result.addProperty("itemId", id.toString());
        result.addProperty("count", count);
        return result;
    }

    private static JsonObject interactBlock(Minecraft client, JsonObject args) {
        var player = requireLocalPlayer(client);
        requireLocalWorld(client);
        int x = boundedInt(args, "x", 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int y = boundedInt(args, "y", 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int z = boundedInt(args, "z", 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        BlockPos pos = new BlockPos(x, y, z);
        if (player.blockPosition().distSqr(pos) > 128.0 * 128.0) {
            throw new IllegalArgumentException("Requested block is more than 128 blocks from the player.");
        }
        if (!client.level.hasChunkAt(pos)) throw new IllegalArgumentException("Requested block is not in a loaded chunk.");
        if (client.gameMode == null) throw new IllegalArgumentException("The player interaction manager is unavailable.");
        Direction face = switch (optionalString(args, "face", "up")) {
            case "down" -> Direction.DOWN;
            case "up" -> Direction.UP;
            case "north" -> Direction.NORTH;
            case "south" -> Direction.SOUTH;
            case "west" -> Direction.WEST;
            case "east" -> Direction.EAST;
            default -> throw new IllegalArgumentException("face must be down, up, north, south, west, or east.");
        };
        BlockHitResult hit = new BlockHitResult(Vec3.atCenterOf(pos), face, pos, false);
        var interaction = client.gameMode.useItemOn(player, InteractionHand.MAIN_HAND, hit);
        JsonObject result = new JsonObject();
        result.addProperty("accepted", interaction.consumesAction());
        result.addProperty("interaction", interaction.name());
        result.addProperty("x", x);
        result.addProperty("y", y);
        result.addProperty("z", z);
        result.addProperty("face", face.getName());
        result.addProperty("block", BuiltInRegistries.BLOCK.getKey(client.level.getBlockState(pos).getBlock()).toString());
        result.addProperty("heldItem", BuiltInRegistries.ITEM.getKey(player.getMainHandItem().getItem()).toString());
        return result;
    }

    private static JsonObject worldInspect(Minecraft client, JsonObject args) {
        var player = requireLocalPlayer(client);
        double radius = boundedDouble(args, "radius", 16.0, 1.0, 64.0);
        int limit = boundedInt(args, "limit", 50, 1, 100);
        List<Entity> nearby = client.level.getEntitiesOfClass(Entity.class,
                player.getBoundingBox().inflate(radius), entity -> entity != player);
        JsonArray entities = new JsonArray();
        nearby.stream().sorted(Comparator.comparingDouble(player::distanceToSqr)).limit(limit)
                .map(BridgeHttpServer::entityInfo).forEach(entities::add);
        JsonObject result = new JsonObject();
        result.addProperty("dimension", client.level.dimension().location().toString());
        result.addProperty("radius", radius);
        result.addProperty("totalEntities", nearby.size());
        result.add("entities", entities);
        result.add("target", targetInfo(client));
        return result;
    }

    private static JsonObject entityInfo(Entity entity) {
        JsonObject info = new JsonObject();
        info.addProperty("id", BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString());
        info.addProperty("uuid", entity.getUUID().toString());
        info.addProperty("name", entity.getName().getString());
        info.addProperty("x", entity.getX());
        info.addProperty("y", entity.getY());
        info.addProperty("z", entity.getZ());
        if (entity instanceof LivingEntity living) {
            info.addProperty("health", living.getHealth());
            info.addProperty("maxHealth", living.getMaxHealth());
        }
        return info;
    }

    private static JsonObject worldSetup(Minecraft client, JsonObject args) {
        requireLocalWorld(client);
        String preset = requiredString(args, "preset");
        String command = switch (preset) {
            case "time_day" -> "time set day";
            case "time_night" -> "time set night";
            case "weather_clear" -> "weather clear";
            case "weather_rain" -> "weather rain";
            case "creative" -> "gamemode creative @a";
            case "survival" -> "gamemode survival @a";
            default -> throw new IllegalArgumentException("Unknown world preset.");
        };
        runLocalCommand(client, command);
        JsonObject result = new JsonObject();
        result.addProperty("accepted", true);
        result.addProperty("preset", preset);
        return result;
    }

    private static JsonObject runGameTest(Minecraft client, JsonObject args) {
        requireLocalWorld(client);
        String selector = optionalString(args, "selector", "all");
        var registeredTests = GameTestRegistry.getAllTestFunctions();
        JsonArray testIds = new JsonArray();
        registeredTests.stream().map(test -> test.testName()).sorted().forEach(testIds::add);
        if ("list".equals(selector)) {
            JsonObject result = new JsonObject();
            result.addProperty("accepted", true);
            result.addProperty("executed", false);
            result.addProperty("registeredTests", registeredTests.size());
            result.add("registeredTestIds", testIds);
            result.addProperty("available", !registeredTests.isEmpty());
            if (registeredTests.isEmpty()) {
                result.addProperty("note", "No GameTests are registered. NeoForge does not register GameTests in the installed production client profile; use a development client or runGameTestServer.");
            }
            return result;
        }
        if ("all".equals(selector) && registeredTests.isEmpty()) {
            JsonObject result = new JsonObject();
            result.addProperty("accepted", false);
            result.addProperty("selector", selector);
            result.addProperty("registeredTests", 0);
            result.add("registeredTestIds", testIds);
            result.addProperty("note", "No GameTests are registered. NeoForge does not register GameTests in the installed production client profile; use a development client or runGameTestServer.");
            return result;
        }
        String command;
        if ("all".equals(selector)) {
            command = "test runall";
        } else {
            if (!TEST_ID.matcher(selector).matches()) throw new IllegalArgumentException("selector must be all or a namespaced GameTest id.");
            boolean registered = registeredTests.stream().anyMatch(test -> selector.equals(test.testName()));
            if (!registered) throw new IllegalArgumentException("No GameTest is registered with that ID.");
            command = "test run " + selector;
        }
        runLocalCommand(client, command);
        JsonObject result = new JsonObject();
        result.addProperty("accepted", true);
        result.addProperty("selector", selector);
        result.addProperty("registeredTests", registeredTests.size());
        result.add("registeredTestIds", testIds);
        result.addProperty("note", "Read game logs for per-test completion and failure details.");
        return result;
    }

    private static void runLocalCommand(Minecraft client, String command) {
        var integratedServer = client.getSingleplayerServer();
        if (integratedServer == null || integratedServer.isStopped()) {
            throw new IllegalArgumentException("No active local integrated server.");
        }
        integratedServer.execute(() -> integratedServer.getCommands().performPrefixedCommand(
                integratedServer.createCommandSourceStack().withPermission(4).withSuppressedOutput(), command));
    }

    private static void requireLocalWorld(Minecraft client) {
        requirePlayer(client);
        if (!client.isLocalServer() || client.getSingleplayerServer() == null) {
            throw new IllegalArgumentException("This operation is limited to a local single-player test world.");
        }
    }

    private static JsonObject captureScreenshot() throws Exception {
        CompletableFuture<JsonObject> captured = new CompletableFuture<>();
        Minecraft client = Minecraft.getInstance();
        client.execute(() -> {
            try {
                NativeImage image = Screenshot.takeScreenshot(client.getMainRenderTarget());
                {
                    try (image) {
                        byte[] png = image.asByteArray();
                        JsonObject result = new JsonObject();
                        result.addProperty("mimeType", "image/png");
                        result.addProperty("imageBase64", Base64.getEncoder().encodeToString(png));
                        result.addProperty("width", image.getWidth());
                        result.addProperty("height", image.getHeight());
                        captured.complete(result);
                    } catch (Exception failure) {
                        captured.completeExceptionally(failure);
                    }
                }
            } catch (Exception failure) {
                captured.completeExceptionally(failure);
            }
        });
        try {
            return captured.get(15, TimeUnit.SECONDS);
        } catch (TimeoutException timeout) {
            throw new TimeoutException("Screenshot callback timed out.");
        }
    }

    private static <T> T onClientThread(java.util.concurrent.Callable<T> operation, int timeoutSeconds) throws Exception {
        Minecraft client = Minecraft.getInstance();
        CompletableFuture<T> future = new CompletableFuture<>();
        client.execute(() -> {
            try {
                future.complete(operation.call());
            } catch (Throwable failure) {
                future.completeExceptionally(failure);
            }
        });
        try {
            return future.get(timeoutSeconds, TimeUnit.SECONDS);
        } catch (java.util.concurrent.ExecutionException failure) {
            Throwable cause = failure.getCause();
            if (cause instanceof RuntimeException runtime) throw runtime;
            throw new IllegalStateException(cause);
        }
    }

    private static net.minecraft.client.player.LocalPlayer requirePlayer(Minecraft client) {
        if (client.player == null || client.level == null) {
            throw new IllegalArgumentException("The client has no active world/player. Open a test world first.");
        }
        return client.player;
    }

    private static net.minecraft.client.player.LocalPlayer requireLocalPlayer(Minecraft client) {
        var player = requirePlayer(client);
        if (!client.isLocalServer() || client.getSingleplayerServer() == null) {
            throw new IllegalArgumentException("This operation is limited to a local single-player test world.");
        }
        return player;
    }

    private static boolean authorized(HttpExchange exchange) {
        String header = exchange.getRequestHeaders().getFirst("Authorization");
        return token != null && ("Bearer " + token).equals(header);
    }

    private static void respond(HttpExchange exchange, int status, JsonObject payload) throws IOException {
        byte[] bytes = GSON.toJson(payload).getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        exchange.getResponseHeaders().set("Cache-Control", "no-store");
        exchange.sendResponseHeaders(status, bytes.length);
        try (var output = exchange.getResponseBody()) {
            output.write(bytes);
        }
    }

    private static JsonObject error(String code, String message) {
        JsonObject result = new JsonObject();
        result.addProperty("error", code);
        result.addProperty("message", message);
        return result;
    }

    private static JsonArray strings(List<String> values) {
        JsonArray array = new JsonArray();
        values.forEach(array::add);
        return array;
    }

    private static String requiredString(JsonObject object, String key) {
        if (!object.has(key) || !object.get(key).isJsonPrimitive() || !object.getAsJsonPrimitive(key).isString()) {
            throw new IllegalArgumentException(key + " must be a string.");
        }
        return object.get(key).getAsString();
    }

    private static String optionalString(JsonObject object, String key, String fallback) {
        return object.has(key) ? requiredString(object, key) : fallback;
    }

    private static int boundedInt(JsonObject object, String key, int fallback, int min, int max) {
        if (!object.has(key)) return fallback;
        try {
            long value = object.get(key).getAsLong();
            if (value < min || value > max) throw new IllegalArgumentException(key + " is out of range.");
            return (int) value;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(key + " must be an integer.");
        }
    }

    private static double boundedDouble(JsonObject object, String key, double fallback, double min, double max) {
        if (!object.has(key)) return fallback;
        double value = object.get(key).getAsDouble();
        if (!Double.isFinite(value) || value < min || value > max) throw new IllegalArgumentException(key + " is out of range.");
        return value;
    }

    private static float finiteFloat(JsonObject object, String key) {
        if (!object.has(key)) throw new IllegalArgumentException(key + " is required.");
        float value = object.get(key).getAsFloat();
        if (!Float.isFinite(value)) throw new IllegalArgumentException(key + " must be finite.");
        return value;
    }

    private static String safeMessage(Throwable failure) {
        String message = failure.getMessage();
        return message == null || message.isBlank() ? failure.getClass().getSimpleName() : message;
    }

    private static String propertyValue(Property<?> property, Comparable<?> value) {
        return propertyValueUnchecked(property, value);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> String propertyValueUnchecked(Property<T> property, Comparable<?> value) {
        return property.getName((T) value);
    }
}
