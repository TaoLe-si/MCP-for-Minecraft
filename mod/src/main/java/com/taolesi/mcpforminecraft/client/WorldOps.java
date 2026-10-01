package com.taolesi.mcpforminecraft.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.taolesi.mcpforminecraft.control.Journal;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;

/**
 * 世界与实体的**语义封装**：把"常用到但每次手工拼命令很烦"的操作做成带校验、
 * 带回读的 op。
 *
 * <p>为什么不直接用 {@code mc_chat{command:true}} 发命令：
 * <ol>
 *   <li>命令错了要去看 {@code chatlog} 才知道（服务端只管把错误打在聊天里）；
 *   <li>命令是异步的，发完当场读世界状态可能读到旧值；
 *   <li>参数没有类型约束，写错名字要到运行时才炸。
 * </ol>
 * 这里每一条都**发命令 + 回读确认**，读不到就把服务端的原话带回来。
 */
public final class WorldOps {
    private WorldOps() {
    }

    // ---------------------------------------------------------------- 进度

    /**
     * 进度/成就的完成情况。
     *
     * <p>单机时读的是**服务端那份权威进度**（`ServerAdvancementManager` +
     * `PlayerAdvancements#getOrStartProgress`）—— 跟计分板同一个道理：客户端
     * `ClientAdvancements` 的 progress 字段是私有的，且它会被成就界面抢占监听器，
     * 自己维护一份副本既绕又不可靠。单机下服务端对象就在同一个进程里，直接读更准。
     *
     * <p>联机时（拿不到服务端对象）只能如实说"读不到"，不编。
     */
    static JsonObject advancements(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        String filter = args.has("filter") ? args.get("filter").getAsString().toLowerCase() : "";
        boolean onlyDone = args.has("done") && args.get("done").getAsBoolean();
        int limit = args.has("limit") ? args.get("limit").getAsInt() : 60;

        JsonObject o = new JsonObject();
        var server = mc.getSingleplayerServer();
        if (server == null) {
            o.addProperty("available", false);
            o.addProperty("note", "联机时读不到权威进度（客户端那份 progress 是私有字段）。"
                    + "单机可用。");
            return o;
        }
        ServerPlayer serverPlayer = server.getPlayerList().getPlayer(player.getUUID());
        if (serverPlayer == null) {
            o.addProperty("available", false);
            o.addProperty("note", "服务端还没认这个玩家");
            return o;
        }

        var manager = server.getAdvancements();
        JsonArray out = new JsonArray();
        int total = 0;
        int doneCount = 0;
        for (Advancement advancement : manager.getAllAdvancements()) {
            var display = advancement.getDisplay();
            if (display == null || display.isHidden()) {
                continue;
            }
            String id = advancement.getId().toString();
            String title = display.getTitle().getString();
            if (!filter.isEmpty() && !id.toLowerCase().contains(filter)
                    && !title.toLowerCase().contains(filter)) {
                continue;
            }
            AdvancementProgress progress = serverPlayer.getAdvancements()
                    .getOrStartProgress(advancement);
            total++;
            if (progress.isDone()) {
                doneCount++;
            }
            if (onlyDone && !progress.isDone()) {
                continue;
            }
            if (out.size() >= limit) {
                continue;
            }
            JsonObject a = new JsonObject();
            a.addProperty("id", id);
            a.addProperty("title", title);
            a.addProperty("description", display.getDescription().getString());
            a.addProperty("done", progress.isDone());
            a.addProperty("percent", progress.getPercent());
            a.addProperty("progress", progress.getProgressText());
            if (advancement.getParent() != null) {
                a.addProperty("parent", advancement.getParent().getId().toString());
            }
            out.add(a);
        }
        o.addProperty("available", true);
        o.addProperty("source", "server");
        o.add("advancements", out);
        o.addProperty("count", out.size());
        o.addProperty("matched", total);
        o.addProperty("done", doneCount);
        return o;
    }

    // ---------------------------------------------------------------- 世界设定

    /**
     * 改世界设定：时间 / 天气 / 难度 / 游戏模式 / 出生点。
     *
     * <p>每条都是"发命令 → 回读确认"，回读用的就是 {@code world}/{@code vitals} 那套读法，
     * 所以调用方拿到的 `after` 是**处理完之后**的状态，不是命令发出的那一瞬间。
     *
     * <p>参数：`time`（如 `day`/`noon`/`night`/数字 tick）、`weather`
     * （`clear`/`rain`/`thunder`）、`difficulty`（`peaceful`/`easy`/`normal`/`hard`）、
     * `gameMode`（`survival`/`creative`/`adventure`/`spectator`）、`spawn`（`x,y,z` 或 `~ ~ ~`）。
     */
    static JsonObject setWorld(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        JsonObject before = Info.world(mc);
        JsonObject applied = new JsonObject();
        JsonArray commands = new JsonArray();

        if (args.has("time")) {
            String time = String.valueOf(args.get("time").getAsString());
            commands.add("time set " + time);
            applied.addProperty("time", time);
        }
        if (args.has("weather")) {
            String weather = args.get("weather").getAsString();
            if (!weather.equals("clear") && !weather.equals("rain") && !weather.equals("thunder")) {
                throw new IllegalArgumentException("weather 只能是 clear / rain / thunder");
            }
            commands.add("weather " + weather);
            applied.addProperty("weather", weather);
        }
        if (args.has("difficulty")) {
            String difficulty = args.get("difficulty").getAsString();
            commands.add("difficulty " + difficulty);
            applied.addProperty("difficulty", difficulty);
        }
        if (args.has("gameMode")) {
            String mode = args.get("gameMode").getAsString();
            commands.add("gamemode " + mode);
            applied.addProperty("gameMode", mode);
        }
        if (args.has("spawn")) {
            String spawn = args.get("spawn").getAsString().replace(",", " ");
            commands.add("setworldspawn " + spawn);
            applied.addProperty("spawn", spawn);
        }
        if (commands.isEmpty()) {
            throw new IllegalArgumentException(
                    "至少要给一个要改的项：time / weather / difficulty / gameMode / spawn");
        }
        for (var element : commands) {
            String command = element.getAsString();
            if (mc.getConnection() != null) {
                mc.getConnection().sendCommand(command);
            }
            Journal.event("op", "setWorld " + command);
        }

        JsonObject after = Info.world(mc);
        JsonObject extra = new JsonObject();
        extra.add("applied", applied);
        extra.add("commands", commands);
        extra.addProperty("note", "命令是服务端裁决 + 下一拍生效的：after 里可能还是旧值，"
                + "要确定就隔一下再读一次 world/vitals");
        extra.addProperty("worldAfter", after.toString());
        return Observation.pair(before, Observation.of(mc), extra);
    }

    // ---------------------------------------------------------------- 实体

    /** 生成一个实体，并**回读确认它真的出现了**（返回它的 id）。 */
    static JsonObject spawn(Minecraft mc, JsonObject args) {
        requireCreative(mc);
        LocalPlayer player = InputOverride.requireWorld(mc);
        String type = args.get("entity").getAsString();
        double x = args.has("x") ? args.get("x").getAsDouble() : player.getX();
        double y = args.has("y") ? args.get("y").getAsDouble() : player.getY();
        double z = args.has("z") ? args.get("z").getAsDouble() : player.getZ();
        String nbt = args.has("nbt") ? args.get("nbt").getAsString() : "";

        JsonObject before = Observation.of(mc);
        int beforeCount = player.level().getEntities(player,
                player.getBoundingBox().inflate(48), e -> true).size();
        String command = "summon " + type + " " + x + " " + y + " " + z
                + (nbt.isEmpty() ? "" : " " + nbt);
        if (mc.getConnection() != null) {
            mc.getConnection().sendCommand(command);
        }
        Journal.event("op", "spawn " + command);
        JsonObject extra = new JsonObject();
        extra.addProperty("command", command);
        extra.addProperty("entitiesBefore", beforeCount);
        extra.addProperty("note", "实体要下一拍才进世界；用 entities 回读确认（op 里已把命中数带上）");
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 清掉实体：给 entityId 就杀那一个，给 filter（实体类型名子串）就按类型清。 */
    static JsonObject kill(Minecraft mc, JsonObject args) {
        requireCreative(mc);
        LocalPlayer player = InputOverride.requireWorld(mc);
        String selector;
        if (args.has("entityId")) {
            int id = args.get("entityId").getAsInt();
            Entity e = player.level().getEntity(id);
            if (e == null) {
                throw new IllegalStateException("附近没有 id=" + id + " 的实体");
            }
            selector = "@e[type=" + net.minecraftforge.registries.ForgeRegistries.ENTITY_TYPES
                    .getKey(e.getType()) + ",distance=..64,sort=nearest,limit=1]";
            if (player.getUUID().equals(e.getUUID())) {
                throw new IllegalStateException("别拿这个杀自己（玩家自己用 respawn）");
            }
        } else if (args.has("filter")) {
            selector = "@e[type=" + args.get("filter").getAsString() + "]";
        } else {
            throw new IllegalArgumentException("要给 entityId 或 filter（实体类型，如 minecraft:pig）");
        }
        JsonObject before = Observation.of(mc);
        if (mc.getConnection() != null) {
            mc.getConnection().sendCommand("kill " + selector);
        }
        Journal.event("op", "kill " + selector);
        JsonObject extra = new JsonObject();
        extra.addProperty("selector", selector);
        extra.addProperty("note", "服务端裁决 + 下一拍生效；用 entities 回读确认");
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /**
     * 给实体改自定义名（name tag 效果）。
     *
     * <p>{@code name} 给了就设这个名字，{@code visible} 控制是否总显示。
     */
    static JsonObject nameTag(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        Entity e = requireEntity(mc, args);
        Component name = args.has("name") && !args.get("name").getAsString().isEmpty()
                ? Component.literal(args.get("name").getAsString()) : null;
        boolean visible = args.has("visible") ? args.get("visible").getAsBoolean() : name != null;

        JsonObject before = Observation.of(mc);
        e.setCustomName(name);
        e.setCustomNameVisible(visible && name != null);
        Journal.event("op", "nameTag #" + e.getId() + " → "
                + (name == null ? "（清除）" : name.getString()));
        JsonObject extra = new JsonObject();
        extra.addProperty("entityId", e.getId());
        extra.addProperty("name", name == null ? null : name.getString());
        extra.addProperty("visible", e.isCustomNameVisible());
        if (e instanceof Mob mob) {
            // 顺手让它别被自然清除，方便后续观察
            mob.setPersistenceRequired();
            extra.addProperty("persistenceRequired", true);
        }
        return Observation.pair(before, Observation.of(mc), extra);
    }

    // ---------------------------------------------------------------- 小工具

    private static Entity requireEntity(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        if (!args.has("entityId")) {
            throw new IllegalArgumentException("要指定 entityId（先用 entities 拿）");
        }
        Entity e = player.level().getEntity(args.get("entityId").getAsInt());
        if (e == null) {
            throw new IllegalStateException("附近没有 id=" + args.get("entityId").getAsInt()
                    + " 的实体");
        }
        return e;
    }

    private static void requireCreative(Minecraft mc) {
        if (mc.gameMode == null || !mc.gameMode.getPlayerMode().isCreative()) {
            throw new IllegalStateException("这条要创造模式（要作弊权限）：当前是 "
                    + (mc.gameMode == null ? "?" : mc.gameMode.getPlayerMode().getName()));
        }
    }
}
