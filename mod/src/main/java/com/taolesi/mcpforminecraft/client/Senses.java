package com.taolesi.mcpforminecraft.client;

import java.util.ArrayDeque;
import java.util.concurrent.CompletableFuture;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatType;
import net.minecraft.stats.Stats;
import net.minecraft.world.BossEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * "感官"：听得到的声音、看得到的首领血条、以及玩家的统计数字。
 *
 * <p>这三样都不能靠"读某个字段"拿到，得挂事件或者遍历注册表：
 * <ul>
 *   <li><b>声音</b>：{@code PlaySoundEvent} 在 {@code ForgeHooksClient:408} 发在
 *       {@code MinecraftForge.EVENT_BUS} 上，每播一个声音来一次 —— 收进环形缓冲；</li>
 *   <li><b>首领条</b>：只有 {@code BossHealthOverlay.events}（包级私有，读不到），
 *       但渲染时会发 {@code CustomizeGuiOverlayEvent.BossEventProgress}
 *       （{@code BossHealthOverlay:36}），按 UUID 记"最后一次看到"，
 *       超过两秒没再看到就算它没了；</li>
 *   <li><b>统计</b>：{@code LocalPlayer.getStats() :372} 给的是 {@code StatsCounter}，
 *       按类别遍历对应注册表取值。</li>
 * </ul>
 *
 * <p>线程：事件回调都发生在客户端主线程；读取方是收包线程，所以两条缓冲都加锁。
 */
public final class Senses {
    private static final int SOUND_CAP = 300;
    /** 超过这么多 tick 没再看到某个首领条，就当它已经消失。 */
    private static final int BOSS_TTL_TICKS = 40;

    private static final Deque<JsonObject> SOUNDS = new ArrayDeque<>();
    private static final Map<UUID, JsonObject> BOSS_BARS = new LinkedHashMap<>();

    private Senses() {
    }

    // ------------------------------------------------------------------ 事件入口

    /**
     * 抄下每一个要播的声音。
     *
     * <p>**整个函数体被 try/catch 包着，这是必须的。** 踩过的坑：音乐轨那种
     * "还没解析出 {@code Sound} 的实例"，`AbstractSoundInstance.getVolume()`
     * （`AbstractSoundInstance:75`）会直接 NPE；而事件回调里抛出去的异常会被
     * Forge 事件总线一路抛到 `Minecraft.tick`，**整局游戏当场崩掉**
     * （实测崩在 `MusicManager.startPlaying` 那条路上）。
     *
     * <p>教训：**请求-应答路径（Dispatcher）我们早就 try/catch 了，
     * 但事件回调是另一条路，忘了包就是崩游戏。** op 出错只是回一个 ok=false，
     * 事件回调出错是玩家掉线。
     */
    @SubscribeEvent
    public static void onPlaySound(PlaySoundEvent event) {
        try {
            var sound = event.getSound();
            if (sound == null) {
                return;
            }
            JsonObject o = new JsonObject();
            o.addProperty("tick", ClientHooks.ticks());
            o.addProperty("sound", String.valueOf(sound.getLocation()));
            o.addProperty("source", sound.getSource().name().toLowerCase());
            // 这三个字段要读实例内部的 Sound，可能还没解析出来 —— 读不到就留空，
            // 不能让它把整个回调炸掉
            o.addProperty("volume", safeVolume(sound));
            o.addProperty("pitch", safePitch(sound));
            o.addProperty("x", sound.getX());
            o.addProperty("y", sound.getY());
            o.addProperty("z", sound.getZ());
            synchronized (SOUNDS) {
                SOUNDS.addLast(o);
                while (SOUNDS.size() > SOUND_CAP) {
                    SOUNDS.removeFirst();
                }
            }
        } catch (Throwable t) {
            // 静默吞掉：这类失败只该让"少记一条声音"，绝不该影响游戏
        }
    }

    private static float safeVolume(net.minecraft.client.resources.sounds.SoundInstance sound) {
        try {
            return sound.getVolume();
        } catch (Throwable t) {
            return -1.0F;
        }
    }

    private static float safePitch(net.minecraft.client.resources.sounds.SoundInstance sound) {
        try {
            return sound.getPitch();
        } catch (Throwable t) {
            return -1.0F;
        }
    }

    /** 首领条：渲染路径上的回调，同样**必须**自己兜住异常（见 {@link #onPlaySound} 的说明）。 */
    @SubscribeEvent
    public static void onBossBar(CustomizeGuiOverlayEvent.BossEventProgress event) {
        try {
            BossEvent bar = event.getBossEvent();
            JsonObject o = new JsonObject();
            o.addProperty("tick", ClientHooks.ticks());
            o.addProperty("name", bar.getName().getString());
            o.addProperty("progress", bar.getProgress());
            o.addProperty("color", bar.getColor().name().toLowerCase());
            o.addProperty("overlay", bar.getOverlay().name().toLowerCase());
            synchronized (BOSS_BARS) {
                BOSS_BARS.put(bar.getId(), o);
            }
        } catch (Throwable t) {
            // 同上：宁可少记一条，也不能崩游戏
        }
    }

    // ------------------------------------------------------------------ 读取

    /** 最近听到的声音。{@code filter} 按声音名子串过滤。 */
    static JsonObject sounds(Minecraft mc, JsonObject args) {
        String filter = args.has("filter") ? args.get("filter").getAsString() : "";
        int limit = args.has("limit") ? args.get("limit").getAsInt() : 40;
        JsonArray out = new JsonArray();
        synchronized (SOUNDS) {
            int skip = Math.max(0, SOUNDS.size() - limit);
            int i = 0;
            for (JsonObject o : SOUNDS) {
                if (i++ < skip) {
                    continue;
                }
                if (filter.isEmpty() || o.get("sound").getAsString().contains(filter)) {
                    out.add(o);
                }
            }
        }
        JsonObject result = new JsonObject();
        result.add("sounds", out);
        result.addProperty("count", out.size());
        result.addProperty("note", "这是我们挂 PlaySoundEvent 抄下来的流水（最多存 300 条），"
                + "不是原版提供的接口");
        return result;
    }

    /** 当前显示着的首领血条（末影龙/凋灵/袭击/自定义）。 */
    static JsonObject bossBars(Minecraft mc, JsonObject args) {
        int now = ClientHooks.ticks();
        JsonArray out = new JsonArray();
        synchronized (BOSS_BARS) {
            BOSS_BARS.entrySet().removeIf(e ->
                    now - e.getValue().get("tick").getAsInt() > BOSS_TTL_TICKS);
            for (Map.Entry<UUID, JsonObject> entry : BOSS_BARS.entrySet()) {
                JsonObject o = entry.getValue().deepCopy();
                o.addProperty("uuid", entry.getKey().toString());
                o.addProperty("ageTicks", now - o.get("tick").getAsInt());
                out.add(o);
            }
        }
        JsonObject result = new JsonObject();
        result.add("bossBars", out);
        result.addProperty("count", out.size());
        result.addProperty("note", "判据是渲染时被画出来过（BossHealthOverlay 发的事件）；"
                + "超过 " + BOSS_TTL_TICKS + " tick 没再画出来就算消失");
        return result;
    }

    /**
     * 玩家统计。
     *
     * <p>**必须先请求再读。** 客户端这份 {@code StatsCounter} 默认是空的：
     * 原版只在打开统计界面时才向服务端要（`StatsScreen:69`：
     * {@code send(new ServerboundClientCommandPacket(REQUEST_STATS))}`），
     * 服务端回 {@code ClientboundAwardStatsPacket} 才把它填进来
     * （`ClientPacketListener:1374` 的 `handleAwardStats`）。
     *
     * <p>所以这个 op 是**挂账型**的：发请求 → 等几个 tick 让回包落地 → 再读。
     * 实测直接读会得到 0 条 —— 那不是没统计，是还没要。
     */
    static void stats(Minecraft mc, JsonObject args, CompletableFuture<JsonObject> out) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        JsonObject before = Observation.of(mc);
        if (mc.getConnection() != null) {
            mc.getConnection().send(new net.minecraft.network.protocol.game
                    .ServerboundClientCommandPacket(
                    net.minecraft.network.protocol.game.ServerboundClientCommandPacket.Action
                            .REQUEST_STATS));
        }
        int waitTicks = Math.max(1, args.has("waitTicks") ? args.get("waitTicks").getAsInt() : 10);
        JsonObject extra = new JsonObject();
        int[] left = {waitTicks};
        GameActions.submit(before, extra, waitTicks + 200,
                m -> --left[0] <= 0,
                () -> {
                    JsonObject read = readStats(mc, args);
                    for (String key : read.keySet()) {
                        extra.add(key, read.get(key));
                    }
                    extra.addProperty("requested", true);
                    extra.addProperty("note", "先向服务端请求了一次统计（原版只在打开统计界面时才要），"
                            + "等了 " + waitTicks + " tick 让回包落地再读");
                },
                out);
    }

    /**
     * 真正读统计。
     *
     * <p>{@code category} 取值：`mined`（挖方块）/ `crafted`（合成）/ `used`（使用物品）/
     * `broken`（用坏工具）/ `picked_up`（捡起）/ `dropped`（丢出）/ `killed`（击杀）/
     * `killed_by`（被什么杀）/ `custom`（自定义，如游戏时长、死亡次数）。
     *
     * <p>只回**非零**的，按数值从大到小排 —— 几千个方块里绝大多数是 0，全回没有意义。
     */
    private static JsonObject readStats(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        String category = args.has("category") ? args.get("category").getAsString() : "custom";
        String filter = args.has("filter") ? args.get("filter").getAsString() : "";
        int limit = args.has("limit") ? args.get("limit").getAsInt() : 40;
        var counter = player.getStats();

        JsonArray out = new JsonArray();
        switch (category) {
            case "mined" -> collect(counter, Stats.BLOCK_MINED, ForgeRegistries.BLOCKS.getKeys(),
                    filter, limit, out, id -> id.toString());
            case "crafted" -> collect(counter, Stats.ITEM_CRAFTED, ForgeRegistries.ITEMS.getKeys(),
                    filter, limit, out, id -> id.toString());
            case "used" -> collect(counter, Stats.ITEM_USED, ForgeRegistries.ITEMS.getKeys(),
                    filter, limit, out, id -> id.toString());
            case "broken" -> collect(counter, Stats.ITEM_BROKEN, ForgeRegistries.ITEMS.getKeys(),
                    filter, limit, out, id -> id.toString());
            case "picked_up" -> collect(counter, Stats.ITEM_PICKED_UP, ForgeRegistries.ITEMS.getKeys(),
                    filter, limit, out, id -> id.toString());
            case "dropped" -> collect(counter, Stats.ITEM_DROPPED, ForgeRegistries.ITEMS.getKeys(),
                    filter, limit, out, id -> id.toString());
            case "killed" -> collect(counter, Stats.ENTITY_KILLED,
                    ForgeRegistries.ENTITY_TYPES.getKeys(), filter, limit, out, id -> id.toString());
            case "killed_by" -> collect(counter, Stats.ENTITY_KILLED_BY,
                    ForgeRegistries.ENTITY_TYPES.getKeys(), filter, limit, out, id -> id.toString());
            case "custom" -> collect(counter, Stats.CUSTOM, BuiltInRegistries.CUSTOM_STAT.keySet(),
                    filter, limit, out, id -> id.toString());
            default -> throw new IllegalArgumentException("category 不认识：" + category
                    + "（可用 mined/crafted/used/broken/picked_up/dropped/killed/killed_by/custom）");
        }
        JsonObject result = new JsonObject();
        result.add("stats", out);
        result.addProperty("count", out.size());
        result.addProperty("category", category);
        result.addProperty("note", "只回非零项，按数值排序；读的是客户端这份 StatsCounter"
                + "（LocalPlayer.getStats()）");
        return result;
    }

    private static <T> void collect(net.minecraft.stats.StatsCounter counter,
                                    StatType<T> type, Iterable<ResourceLocation> keys,
                                    String filter, int limit, JsonArray out,
                                    java.util.function.Function<ResourceLocation, String> namer) {
        record Row(String name, int value) {
        }
        java.util.List<Row> rows = new java.util.ArrayList<>();
        var registry = type.getRegistry();
        for (ResourceLocation key : keys) {
            if (!filter.isEmpty() && !key.toString().contains(filter)) {
                continue;
            }
            T value = registry.get(key);
            if (value == null) {
                continue;
            }
            Stat<T> stat = type.get(value);
            int count = counter.getValue(stat);
            if (count != 0) {
                rows.add(new Row(namer.apply(key), count));
            }
        }
        rows.sort((a, b) -> Integer.compare(b.value(), a.value()));
        for (int i = 0; i < rows.size() && i < limit; i++) {
            JsonObject o = new JsonObject();
            o.addProperty("stat", rows.get(i).name());
            o.addProperty("value", rows.get(i).value());
            out.add(o);
        }
    }
}
