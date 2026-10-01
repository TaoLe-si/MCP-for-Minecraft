package com.taolesi.mcpforminecraft.client;

import java.io.File;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonObject;

import net.minecraft.client.Minecraft;
import net.minecraft.client.Screenshot;
import net.minecraft.client.multiplayer.ClientPacketListener;

/**
 * 客户端侧的 op 路由。这里才真正碰游戏状态，所以**每一步都必须落在游戏线程上**。
 *
 * <p>{@link #start} 由 {@code Dispatcher}（收包线程）调用，它只负责把活儿排进游戏线程，
 * 然后立刻拿到一个 future；"要占时间"的动作（按键 N tick、挖穿一个方块）
 * 由 {@link GameActions} 在 tick 里推进、到点自己 complete —— 收包线程在外面等，
 * 游戏线程一秒不卡。
 */
public final class ClientOps {
    private ClientOps() {
    }

    public static CompletableFuture<JsonObject> start(String op, JsonObject args) {
        Minecraft mc = Minecraft.getInstance();
        CompletableFuture<JsonObject> out = new CompletableFuture<>();
        mc.execute(() -> {
            try {
                switch (op) {
                    // ---- 观测 ----
                    case "state" -> out.complete(Observation.of(mc));
                    case "probe" -> out.complete(Probe.of(mc));
                    case "vitals" -> out.complete(Info.vitals(mc));
                    case "world" -> out.complete(Info.world(mc));
                    case "light" -> out.complete(Info.light(mc, args));
                    case "biome" -> out.complete(Info.biome(mc, args));
                    case "blockentity" -> out.complete(Info.blockEntity(mc, args));
                    case "entity" -> out.complete(Info.entity(mc, args));
                    case "scoreboard" -> out.complete(Info.scoreboard(mc));
                    case "server" -> out.complete(Info.server(mc));
                    case "recipes" -> out.complete(Info.recipes(mc, args));
                    case "recipebook" -> out.complete(Info.recipeBook(mc));
                    // ---- 批次2：动作纵深 ----
                    case "useOnEntity" -> Actions.useOnEntity(mc, args, out);
                    case "useOnEntityAt" -> out.complete(Actions.useOnEntityAt(mc, args));
                    case "placeRecipe" -> out.complete(Actions.placeRecipe(mc, args));
                    case "recipeOptions" -> out.complete(Actions.recipeOptions(mc, args));
                    case "containerButton" -> out.complete(Actions.containerButton(mc, args));
                    case "creativeGive" -> out.complete(Actions.creativeGive(mc, args));
                    case "releaseUsing" -> out.complete(Actions.releaseUsing(mc, args));
                    case "startUsing" -> out.complete(Actions.startUsing(mc, args));
                    case "pickItem" -> out.complete(Actions.pickItem(mc, args));
                    case "drop" -> out.complete(Actions.drop(mc, args));
                    case "stopBreak" -> out.complete(Actions.stopBreak(mc, args));
                    case "digStatus" -> out.complete(Actions.digStatus(mc));
                    case "sleep" -> out.complete(Actions.sleep(mc, args));
                    case "wakeUp" -> out.complete(Actions.wakeUp(mc, args));
                    case "ride" -> out.complete(Actions.ride(mc, args));
                    case "dismount" -> out.complete(Actions.dismount(mc, args));
                    case "respawn" -> out.complete(Actions.respawn(mc, args));
                    case "fly" -> out.complete(Actions.fly(mc, args));
                    case "openInventory" -> out.complete(Actions.openInventory(mc, args));
                    case "clientLevel" -> out.complete(Actions.clientLevel(mc));
                    // ---- 批次3/4：交易、进度、世界设定、实体 ----
                    case "trades" -> out.complete(Trade.trades(mc, args));
                    case "trade" -> out.complete(Trade.trade(mc, args));
                    case "advancements" -> out.complete(WorldOps.advancements(mc, args));
                    case "setWorld" -> out.complete(WorldOps.setWorld(mc, args));
                    case "spawn" -> out.complete(WorldOps.spawn(mc, args));
                    case "kill" -> out.complete(WorldOps.kill(mc, args));
                    case "nameTag" -> out.complete(WorldOps.nameTag(mc, args));
                    // ---- 感官：统计 / 声音 / 首领条 ----
                    case "stats" -> Senses.stats(mc, args, out);
                    case "sounds" -> out.complete(Senses.sounds(mc, args));
                    case "bossBars" -> out.complete(Senses.bossBars(mc, args));
                    case "block" -> out.complete(Blocks.block(mc, args));
                    case "blocks" -> out.complete(Blocks.blocks(mc, args));
                    case "entities" -> out.complete(Blocks.entities(mc, args));
                    case "inventory" -> out.complete(Blocks.inventory(mc));
                    case "ray" -> out.complete(Blocks.ray(mc, args));
                    case "screen" -> out.complete(GuiOps.screen(mc));
                    // ---- 朝向 ----
                    case "look" -> look(mc, args, out);
                    case "lookAt" -> {
                        JsonObject before = Observation.of(mc);
                        InputOverride.lookAt(mc, args);
                        out.complete(Observation.pair(before, Observation.of(mc), null));
                    }
                    // ---- 世界改动 ----
                    case "break" -> Blocks.breakBlock(mc, args, out);
                    case "place" -> out.complete(Blocks.place(mc, args));
                    case "interact" -> Blocks.interact(mc, args, out);
                    case "attack" -> out.complete(Blocks.attack(mc, args));
                    case "use" -> out.complete(Blocks.use(mc, args));
                    case "selectSlot" -> out.complete(Blocks.selectSlot(mc, args));
                    case "scroll" -> out.complete(Blocks.scroll(mc, args));
                    // ---- 界面 ----
                    case "clickButton" -> out.complete(GuiOps.clickButton(mc, args));
                    case "typeText" -> out.complete(GuiOps.typeText(mc, args));
                    case "clickSlot" -> out.complete(GuiOps.clickSlot(mc, args));
                    case "closeScreen" -> out.complete(GuiOps.closeScreen(mc));
                    // ---- 通信 / 截图 ----
                    case "chat" -> out.complete(chat(mc, args));
                    case "shot" -> shot(mc, args, out);
                    // ---- 按键类（key/move/jump/press）：挂账到 tick 走完 ----
                    default -> InputOverride.start(mc, op, args, out);
                }
            } catch (Throwable t) {
                out.completeExceptionally(t);
            }
        });
        return out;
    }

    private static void look(Minecraft mc, JsonObject args, CompletableFuture<JsonObject> out) {
        JsonObject before = Observation.of(mc);
        InputOverride.look(mc, args);
        out.complete(Observation.pair(before, Observation.of(mc), null));
    }

    /** 发聊天 / 发命令。1.20.x 之后这两条路是分开的，别混用。 */
    private static JsonObject chat(Minecraft mc, JsonObject args) {
        String text = args.get("text").getAsString();
        boolean command = args.has("command") && args.get("command").getAsBoolean();
        ClientPacketListener connection = mc.getConnection();
        if (connection == null) {
            throw new IllegalStateException("还没连上服务端");
        }
        if (command) {
            connection.sendCommand(text.startsWith("/") ? text.substring(1) : text);
        } else {
            connection.sendChat(text);
        }
        JsonObject result = new JsonObject();
        result.addProperty("sent", text);
        return result;
    }

    /**
     * 截图。
     *
     * <p>两个坑都在 1.20.1 的 {@code Screenshot} 里躺着：像素是同步抓的，
     * 但**写盘丢给了 {@code Util.ioPool()}** 异步干（{@code Screenshot.java:66}）；
     * 文件名由参数决定。所以给死名字、然后另开一条线程等文件出现 —— 不能占着游戏线程等。
     */
    private static void shot(Minecraft mc, JsonObject args, CompletableFuture<JsonObject> out) {
        String name = args.has("name") ? args.get("name").getAsString().trim() : "";
        if (name.isEmpty()) {
            name = "mcp";
        }
        if (!name.endsWith(".png")) {
            name = name + ".png";
        }
        File dir = new File(mc.gameDirectory, Screenshot.SCREENSHOT_DIR);
        dir.mkdirs();
        File target = new File(dir, name);
        if (target.exists() && !target.delete()) {
            throw new IllegalStateException("旧的截图删不掉：" + target);
        }

        Screenshot.grab(mc.gameDirectory, name, mc.getMainRenderTarget(), message -> { });

        String fileName = name;
        Thread waiter = new Thread(() -> {
            long deadline = System.currentTimeMillis() + 10_000L;
            while (!target.isFile() && System.currentTimeMillis() < deadline) {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            if (target.isFile()) {
                JsonObject result = new JsonObject();
                result.addProperty("path", target.getAbsolutePath());
                result.addProperty("bytes", target.length());
                out.complete(result);
            } else {
                out.completeExceptionally(new IllegalStateException("截图没落盘（10s 内）：" + fileName));
            }
        }, "mcpforminecraft-shot");
        waiter.setDaemon(true);
        waiter.start();
    }
}
