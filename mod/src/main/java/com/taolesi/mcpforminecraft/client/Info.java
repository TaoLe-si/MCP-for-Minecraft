package com.taolesi.mcpforminecraft.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * 观测面的纵深：`state` 只给"人在哪、有多少血"这类最常用的，这里给剩下的全部。
 *
 * <p>拆成多个 op 而不是塞进一个大 `state`，是为了让回包读起来不费劲：
 * 要生存数据看 `vitals`，要世界看 `world`，要环境看 `light`/`biome`。
 *
 * <p>全部只读，全部只在客户端游戏线程上跑。
 */
public final class Info {
    private Info() {
    }

    // ------------------------------------------------------------------ 玩家纵深

    /** 生存/经验/药水效果/能力/游戏模式/护甲/氧气。 */
    static JsonObject vitals(Minecraft mc) {
        LocalPlayer p = InputOverride.requireWorld(mc);
        JsonObject o = new JsonObject();

        o.addProperty("health", p.getHealth());
        o.addProperty("maxHealth", p.getMaxHealth());
        FoodData food = p.getFoodData();
        o.addProperty("food", food.getFoodLevel());
        o.addProperty("saturation", food.getSaturationLevel());
        o.addProperty("exhaustion", food.getExhaustionLevel());
        o.addProperty("armor", p.getArmorValue());
        o.addProperty("air", p.getAirSupply());
        o.addProperty("maxAir", p.getMaxAirSupply());

        o.addProperty("xpLevel", p.experienceLevel);
        o.addProperty("xpProgress", p.experienceProgress);
        o.addProperty("xpTotal", p.totalExperience);

        Abilities a = p.getAbilities();
        JsonObject abilities = new JsonObject();
        abilities.addProperty("flying", a.flying);
        abilities.addProperty("mayfly", a.mayfly);
        abilities.addProperty("instabuild", a.instabuild);
        abilities.addProperty("invulnerable", a.invulnerable);
        abilities.addProperty("walkingSpeed", a.getWalkingSpeed());
        abilities.addProperty("flyingSpeed", a.getFlyingSpeed());
        o.add("abilities", abilities);

        o.addProperty("gameMode", mc.gameMode == null ? null : mc.gameMode.getPlayerMode().getName());
        o.addProperty("dead", p.isDeadOrDying());
        o.addProperty("onFire", p.isOnFire());
        o.addProperty("inWater", p.isInWater());
        o.addProperty("inLava", p.isInLava());
        o.addProperty("fallDistance", p.fallDistance);
        o.addProperty("vehicle", p.getVehicle() == null
                ? null : ForgeRegistries.ENTITY_TYPES.getKey(p.getVehicle().getType()).toString());
        o.addProperty("sleeping", p.isSleeping());
        o.addProperty("elytraFlying", p.isFallFlying());
        o.add("effects", effects(p));
        return o;
    }

    private static JsonArray effects(LivingEntity living) {
        JsonArray out = new JsonArray();
        for (MobEffectInstance effect : living.getActiveEffects()) {
            JsonObject o = new JsonObject();
            o.addProperty("effect",
                    ForgeRegistries.MOB_EFFECTS.getKey(effect.getEffect()).toString());
            o.addProperty("amplifier", effect.getAmplifier());
            o.addProperty("durationTicks", effect.getDuration());
            o.addProperty("ambient", effect.isAmbient());
            o.addProperty("visible", effect.isVisible());
            out.add(o);
        }
        return out;
    }

    /** 哪些物品正在冷却、还剩多少（弓、末影珍珠、盾、紫颂果…）。 */
    static JsonObject cooldowns(Minecraft mc) {
        LocalPlayer p = InputOverride.requireWorld(mc);
        var cooldowns = p.getCooldowns();
        JsonArray out = new JsonArray();
        for (var item : ForgeRegistries.ITEMS.getValues()) {
            if (!cooldowns.isOnCooldown(item)) {
                continue;
            }
            JsonObject o = new JsonObject();
            o.addProperty("item", ForgeRegistries.ITEMS.getKey(item).toString());
            o.addProperty("percent", cooldowns.getCooldownPercent(item, 0.0F));
            out.add(o);
        }
        JsonObject o = new JsonObject();
        o.add("cooldowns", out);
        o.addProperty("count", out.size());
        return o;
    }

    // ------------------------------------------------------------------ 世界

    /** 时间/天气/难度/维度/世界边界。 */
    static JsonObject world(Minecraft mc) {
        ClientLevel level = mc.level;
        JsonObject o = new JsonObject();
        o.addProperty("dim", level.dimension().location().toString());
        o.addProperty("gameTime", level.getGameTime());
        o.addProperty("dayTime", level.getDayTime());
        o.addProperty("day", level.isDay() && !level.isNight());
        o.addProperty("night", level.isNight());
        o.addProperty("raining", level.isRaining());
        o.addProperty("rainLevel", level.getRainLevel(1.0F));
        o.addProperty("thundering", level.isThundering());
        o.addProperty("thunderLevel", level.getThunderLevel(1.0F));
        o.addProperty("difficulty", level.getDifficulty().getKey());
        o.addProperty("difficultyLocked", level.getLevelData().isDifficultyLocked());

        WorldBorder border = level.getWorldBorder();
        JsonObject b = new JsonObject();
        b.addProperty("minX", border.getMinX());
        b.addProperty("maxX", border.getMaxX());
        b.addProperty("minZ", border.getMinZ());
        b.addProperty("maxZ", border.getMaxZ());
        b.addProperty("centerX", border.getCenterX());
        b.addProperty("centerZ", border.getCenterZ());
        b.addProperty("size", border.getSize());
        o.add("worldBorder", b);
        return o;
    }

    /** 指定坐标的光照：总亮度 / 天光 / 方块光。 */
    static JsonObject light(Minecraft mc, JsonObject args) {
        ClientLevel level = mc.level;
        BlockPos pos = Blocks.readPos(args);
        JsonObject o = new JsonObject();
        o.addProperty("x", pos.getX());
        o.addProperty("y", pos.getY());
        o.addProperty("z", pos.getZ());
        o.addProperty("brightness", level.getMaxLocalRawBrightness(pos));
        o.addProperty("sky", level.getBrightness(net.minecraft.world.level.LightLayer.SKY, pos));
        o.addProperty("block", level.getBrightness(net.minecraft.world.level.LightLayer.BLOCK, pos));
        o.addProperty("skyDarken", level.getSkyDarken());
        return o;
    }

    /** 指定坐标的生物群系。 */
    static JsonObject biome(Minecraft mc, JsonObject args) {
        ClientLevel level = mc.level;
        BlockPos pos = Blocks.readPos(args);
        Holder<Biome> holder = level.getBiome(pos);
        JsonObject o = new JsonObject();
        o.addProperty("x", pos.getX());
        o.addProperty("y", pos.getY());
        o.addProperty("z", pos.getZ());
        var key = holder.unwrapKey();
        if (key.isPresent()) {
            o.addProperty("biome", key.get().location().toString());
        } else {
            o.add("biome", com.google.gson.JsonNull.INSTANCE);
        }
        return o;
    }

    // ------------------------------------------------------------------ 方块实体 / 实体

    /** 某坐标方块实体里的数据（箱子装了什么、熔炉烧到哪、告示牌写了什么）。 */
    static JsonObject blockEntity(Minecraft mc, JsonObject args) {
        ClientLevel level = mc.level;
        BlockPos pos = Blocks.readPos(args);
        BlockEntity be = level.getBlockEntity(pos);
        JsonObject o = new JsonObject();
        o.addProperty("x", pos.getX());
        o.addProperty("y", pos.getY());
        o.addProperty("z", pos.getZ());
        if (be == null) {
            o.addProperty("present", false);
            return o;
        }
        o.addProperty("present", true);
        o.addProperty("type", ForgeRegistries.BLOCK_ENTITY_TYPES.getKey(be.getType()).toString());
        // 用 saveWithoutMetadata()（`BlockEntity:75`，public final）——它会调 saveAdditional。
        // **别用 getUpdateTag()**：基类那个（`BlockEntity:163`）直接 `return new CompoundTag()`，
        // 只有少数几类（刷怪笼/营火/结构方块/饰纹陶罐…）自己覆写了它，箱子之流读出来就是 `{}`。
        // 换句话说"用 getUpdateTag 读箱子"读到的空不是 bug，是当时读错了方法。
        o.addProperty("nbt", be.saveWithoutMetadata().toString());
        // 客户端这份方块实体**没有容器内容**：原版不同步物品给没开界面的客户端。
        // 想看箱子装了什么，只能把界面开出来读槽位（见 docs/api-ledger.md 的 B9 行）。
        o.addProperty("containerContents",
                be instanceof net.minecraft.world.Container ? "需要开界面读（mc_open → mc_screen）"
                        : "不适用");
        return o;
    }

    /** 单个实体：位置/朝向/血量/速度/骑乘关系 + 完整 NBT。 */
    static JsonObject entity(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        int id = args.get("entityId").getAsInt();
        Entity e = player.level().getEntity(id);
        if (e == null) {
            throw new IllegalStateException("附近没有 id=" + id + " 的实体"
                    + "（先用 entities 拿 id；实体可能已经走远或被卸载）");
        }
        JsonObject o = new JsonObject();
        o.addProperty("id", e.getId());
        o.addProperty("uuid", e.getUUID().toString());
        o.addProperty("type", ForgeRegistries.ENTITY_TYPES.getKey(e.getType()).toString());
        o.addProperty("name", e.getName().getString());
        o.addProperty("customName", e.getCustomName() == null
                ? null : e.getCustomName().getString());
        o.addProperty("x", e.getX());
        o.addProperty("y", e.getY());
        o.addProperty("z", e.getZ());
        o.addProperty("yaw", e.getYRot());
        o.addProperty("pitch", e.getXRot());
        o.addProperty("distance", Math.sqrt(e.distanceToSqr(player)));
        o.addProperty("onFire", e.isOnFire());
        o.addProperty("invulnerable", e.isInvulnerable());
        o.addProperty("passenger", e.isPassenger());
        o.addProperty("vehicle", e.getVehicle() == null
                ? null : ForgeRegistries.ENTITY_TYPES.getKey(e.getVehicle().getType()).toString());
        if (e instanceof LivingEntity living) {
            o.addProperty("health", living.getHealth());
            o.addProperty("maxHealth", living.getMaxHealth());
            o.add("effects", effects(living));
        }
        AABB box = e.getBoundingBox();
        JsonObject bb = new JsonObject();
        bb.addProperty("width", box.getXsize());
        bb.addProperty("height", box.getYsize());
        o.add("size", bb);
        o.addProperty("nbt", e.saveWithoutId(new CompoundTag()).toString());
        return o;
    }

    // ------------------------------------------------------------------ 计分板 / 服务器

    /**
     * 计分板：目标、队伍、分数。
     *
     * <p>**两个来源都要看**（这是实测撞出来的）：客户端 `ClientLevel.getScoreboard()`
     * 那份在单机下可能是空的 —— 即使服务端日志明明回了 "Created new objective"。
     * 单机时服务端对象就在同一个进程里，直接读它的权威副本（`MinecraftServer.getScoreboard()`
     * 返回 `ServerScoreboard`），并在回包里标明 `source`，不含糊。
     */
    static JsonObject scoreboard(Minecraft mc) {
        ClientLevel level = mc.level;
        var sb = level.getScoreboard();
        JsonObject o = new JsonObject();
        o.addProperty("clientLevelHash", System.identityHashCode(level));
        o.addProperty("connectionLevelHash",
                System.identityHashCode(mc.getConnection() == null
                        ? level : mc.getConnection().getLevel()));
        o.addProperty("clientObjectives", sb.getObjectives().size());

        var server = mc.getSingleplayerServer();
        if (server != null && server.getScoreboard() != null) {
            o.add("server", dumpBoard(server.getScoreboard()));
            o.addProperty("serverObjectives",
                    server.getScoreboard().getObjectives().size());
        }
        JsonObject board = dumpBoard(sb);
        o.addProperty("source", !board.get("objectives").getAsJsonArray().isEmpty()
                || server == null ? "client" : "server");
        for (String key : board.keySet()) {
            o.add(key, board.get(key));
        }
        return o;
    }

    /** 把一个 {@code Scoreboard} 摊成 JSON。客户端/服务端两份都用它，口径才一致。 */
    private static JsonObject dumpBoard(net.minecraft.world.scores.Scoreboard sb) {
        JsonObject o = new JsonObject();
        JsonArray objectives = new JsonArray();
        for (var objective : sb.getObjectives()) {
            JsonObject obj = new JsonObject();
            obj.addProperty("name", objective.getName());
            obj.addProperty("display", objective.getDisplayName().getString());
            obj.addProperty("criteria", objective.getCriteria().getName());
            JsonArray scores = new JsonArray();
            for (var score : sb.getPlayerScores(objective)) {
                JsonObject s = new JsonObject();
                s.addProperty("owner", score.getOwner());
                s.addProperty("score", score.getScore());
                scores.add(s);
            }
            obj.add("scores", scores);
            objectives.add(obj);
        }
        o.add("objectives", objectives);

        JsonArray teams = new JsonArray();
        for (var team : sb.getPlayerTeams()) {
            JsonObject t = new JsonObject();
            t.addProperty("name", team.getName());
            JsonArray members = new JsonArray();
            team.getPlayers().forEach(members::add);
            t.add("members", members);
            teams.add(t);
        }
        o.add("teams", teams);
        return o;
    }

    /** 服务器与连接：单机还是联机、延迟、在线玩家列表。 */
    static JsonObject server(Minecraft mc) {
        JsonObject o = new JsonObject();
        o.addProperty("singleplayer", mc.hasSingleplayerServer());
        o.addProperty("localServer", mc.isLocalServer());
        var data = mc.getCurrentServer();
        o.addProperty("address", data == null ? null : data.ip);
        o.addProperty("name", data == null ? null : data.name);
        if (mc.getSingleplayerServer() != null) {
            o.addProperty("published", mc.getSingleplayerServer().isPublished());
            o.addProperty("playerCount", mc.getSingleplayerServer().getPlayerCount());
            o.addProperty("maxPlayers", mc.getSingleplayerServer().getMaxPlayers());
        }
        ClientPacketListener connection = mc.getConnection();
        if (connection != null) {
            JsonArray players = new JsonArray();
            for (PlayerInfo info : connection.getOnlinePlayers()) {
                JsonObject p = new JsonObject();
                p.addProperty("name", info.getProfile().getName());
                p.addProperty("uuid", info.getProfile().getId().toString());
                p.addProperty("latency", info.getLatency());
                p.addProperty("gameMode", info.getGameMode() == null
                        ? null : info.getGameMode().getName());
                players.add(p);
            }
            o.add("players", players);
        }
        return o;
    }

    // ------------------------------------------------------------------ 配方

    /**
     * 查配方："这个东西怎么做 / 能做出什么"。
     *
     * <p>数据来源是客户端那份 {@code RecipeManager}（服务端同步下来的），所以查到的
     * 就是"这个世界里真的存在"的配方，不是查表查出来的。
     */
    static JsonObject recipes(Minecraft mc, JsonObject args) {
        ClientLevel level = mc.level;
        String filter = args.has("filter") ? args.get("filter").getAsString() : "";
        String station = args.has("station") ? args.get("station").getAsString() : "";
        int limit = args.has("limit") ? Math.min(args.get("limit").getAsInt(), 200) : 40;

        RegistryAccess access = level.registryAccess();
        JsonArray out = new JsonArray();
        int total = 0;
        for (ResourceLocation id : mc.level.getRecipeManager().getRecipeIds().toList()) {
            var holder = mc.level.getRecipeManager().byKey(id);
            if (holder.isEmpty()) {
                continue;
            }
            Recipe<?> recipe = holder.get();
            String type = ForgeRegistries.RECIPE_TYPES.getKey(recipe.getType()).toString();
            if (!station.isEmpty() && !type.contains(station)) {
                continue;
            }
            ItemStack result = recipe.getResultItem(access);
            String resultId = result.isEmpty() ? "minecraft:air"
                    : ForgeRegistries.ITEMS.getKey(result.getItem()).toString();
            if (!filter.isEmpty() && !resultId.contains(filter) && !id.toString().contains(filter)) {
                continue;
            }
            total++;
            if (out.size() >= limit) {
                continue;
            }
            JsonObject o = new JsonObject();
            o.addProperty("id", id.toString());
            o.addProperty("type", type);
            o.addProperty("result", resultId);
            o.addProperty("count", result.getCount());
            List<String> ingredients = new ArrayList<>();
            for (Ingredient ingredient : recipe.getIngredients()) {
                ItemStack[] items = ingredient.getItems();
                if (items.length == 0) {
                    continue;
                }
                List<String> choices = new ArrayList<>();
                for (int i = 0; i < Math.min(items.length, 4); i++) {
                    choices.add(ForgeRegistries.ITEMS.getKey(items[i].getItem()).toString());
                }
                ingredients.add(choices.size() == 1
                        ? choices.get(0) : "[" + String.join("|", choices) + "]");
            }
            JsonArray ing = new JsonArray();
            ingredients.forEach(ing::add);
            o.add("ingredients", ing);
            o.addProperty("special", recipe.isSpecial());
            out.add(o);
        }
        JsonObject o = new JsonObject();
        o.add("recipes", out);
        o.addProperty("count", out.size());
        o.addProperty("matched", total);
        o.addProperty("truncated", total > out.size());
        return o;
    }

    /**
     * 配方书现在是什么状态：分了几组、各组认了多少、哪些现在做得出来。
     *
     * <p>{@code RecipeCollection} 没有"分类名"这种东西（分组是 UI 层的事），
     * 但它有 {@code hasKnownRecipes}/{@code hasCraftable} —— 这两个才是
     * "我现在能做什么"的真答案。
     */
    static JsonObject recipeBook(Minecraft mc) {
        LocalPlayer p = InputOverride.requireWorld(mc);
        JsonObject o = new JsonObject();
        JsonArray groups = new JsonArray();
        int known = 0;
        int craftable = 0;
        for (var collection : p.getRecipeBook().getCollections()) {
            JsonObject g = new JsonObject();
            g.addProperty("recipes", collection.getRecipes().size());
            g.addProperty("known", collection.hasKnownRecipes());
            g.addProperty("craftable", collection.hasCraftable());
            if (collection.hasKnownRecipes()) {
                known++;
            }
            if (collection.hasCraftable()) {
                craftable++;
            }
            JsonArray results = new JsonArray();
            for (Recipe<?> recipe : collection.getDisplayRecipes(true)) {
                ItemStack stack = recipe.getResultItem(mc.level.registryAccess());
                if (!stack.isEmpty()) {
                    results.add(ForgeRegistries.ITEMS.getKey(stack.getItem()).toString());
                }
                if (results.size() >= 12) {
                    break;
                }
            }
            g.add("results", results);
            groups.add(g);
        }
        o.add("groups", groups);
        o.addProperty("groups", groups.size());
        o.addProperty("groupsWithKnown", known);
        o.addProperty("groupsCraftable", craftable);
        return o;
    }
}
