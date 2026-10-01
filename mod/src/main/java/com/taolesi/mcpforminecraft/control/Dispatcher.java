package com.taolesi.mcpforminecraft.control;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.taolesi.mcpforminecraft.client.ClientHooks;
import com.taolesi.mcpforminecraft.client.ClientOps;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.server.ServerLifecycleHooks;

/**
 * 包 → 操作。完整 op 表见 docs/protocol.md。
 *
 * <p>这里只做三件事：解析包、把活儿交给客户端游戏线程、把结果包成回包。
 * 具体动作（按键/方块/界面/截图）在 {@code ClientOps} 那边，
 * 日志类（{@code log}/{@code events}/{@code chatlog}）与游戏状态无关，这里就地答。
 */
public final class Dispatcher {
    private static final Gson GSON = new Gson();

    /** 这些 op 要客户端（本地玩家、渲染、界面）。 */
    private static final Set<String> CLIENT_OPS = Set.of(
            // 观测
            "state", "probe", "block", "blocks", "entities", "inventory", "ray", "screen",
            "vitals", "world", "light", "biome", "blockentity", "entity", "scoreboard",
            "server", "recipes", "recipebook",
            "useOnEntity", "useOnEntityAt", "placeRecipe", "recipeOptions",
            "containerButton", "creativeGive", "releaseUsing", "startUsing",
            "pickItem", "drop", "stopBreak", "digStatus", "sleep", "wakeUp",
            "ride", "dismount", "respawn", "fly", "openInventory", "clientLevel",
            "trades", "trade", "advancements", "setWorld", "spawn", "kill", "nameTag",
            "stats", "sounds", "bossBars",
            // 朝向
            "look", "lookAt",
            // 世界改动
            "break", "place", "interact", "attack", "use", "selectSlot", "scroll",
            // 界面
            "clickButton", "typeText", "clickSlot", "closeScreen",
            // 通信与截图
            "chat", "shot",
            // 按键层
            "key", "move", "jump", "press");

    /** 这些 op 要占着时间走完，回包晚 —— 超时得按 ticks 放宽。 */
    private static final Set<String> TIMED_OPS =
            Set.of("key", "move", "jump", "press", "break", "stats");

    private Dispatcher() {
    }

    public static String handle(String line) {
        int id = 0;
        JsonObject req;
        try {
            req = JsonParser.parseString(line).getAsJsonObject();
            if (req.has("id")) {
                id = req.get("id").getAsInt();
            }
        } catch (RuntimeException e) {
            return GSON.toJson(envelope(0, false, null, "包不是合法 JSON 对象：" + e.getMessage()));
        }

        String op = req.has("op") ? req.get("op").getAsString() : "";
        JsonObject args = req.has("args") && req.get("args").isJsonObject()
                ? req.getAsJsonObject("args") : new JsonObject();
        try {
            return GSON.toJson(envelope(id, true, run(op, args), null));
        } catch (Throwable t) {
            return GSON.toJson(envelope(id, false, null, describe(t)));
        }
    }

    private static JsonObject run(String op, JsonObject args) throws Exception {
        switch (op) {
            case "ping":
                return ping();
            case "log":
                return log(args);
            case "events":
                return journal("events", Journal.events(limit(args)));
            case "chatlog":
                return journal("chatlog", Journal.chat(limit(args)));
            default:
                break;
        }
        if (!CLIENT_OPS.contains(op)) {
            throw new IllegalArgumentException("未知 op：" + op + "（完整表见 docs/protocol.md）");
        }

        CompletableFuture<JsonObject> future = DistExecutor.unsafeCallWhenOn(Dist.CLIENT,
                () -> () -> ClientOps.start(op, args));
        if (future == null) {
            throw new UnsupportedOperationException(op + " 只在客户端可用（当前是专用服务端）");
        }
        // 在收包线程上等，不占游戏线程。"占时间"的动作由游戏线程 tick 到点时自己 complete。
        long seconds = 20;
        if (TIMED_OPS.contains(op) && args.has("ticks")) {
            seconds += Math.max(0, args.get("ticks").getAsInt()) / 20;
        }
        return future.get(seconds, TimeUnit.SECONDS);
    }

    private static int limit(JsonObject args) {
        return args.has("lines") ? Math.max(1, Math.min(args.get("lines").getAsInt(), 500)) : 50;
    }

    private static JsonObject journal(String name, JsonArray entries) {
        JsonObject out = new JsonObject();
        out.add(name, entries);
        out.addProperty("count", entries.size());
        return out;
    }

    /**
     * 游戏日志尾部。
     *
     * <p>不记在内存里而是**读日志文件**：log4j 已经把所有东西（含原版和别的模组）
     * 写进去了，我们自己再存一份只会更差、更假。读法是从文件尾往前捞固定字节数，
     * 别把几十 MB 的日志整个读进来。
     */
    private static JsonObject log(JsonObject args) throws IOException {
        int lines = args.has("lines") ? Math.max(1, Math.min(args.get("lines").getAsInt(), 1000)) : 80;
        String filter = args.has("filter") ? args.get("filter").getAsString() : "";
        Path path = FMLPaths.GAMEDIR.get().resolve("logs").resolve("latest.log");
        if (!Files.isRegularFile(path)) {
            throw new IllegalStateException("找不到日志文件：" + path);
        }
        List<String> tail = tail(path, lines * 4 + 200);
        List<String> out = new ArrayList<>();
        for (int i = tail.size() - 1; i >= 0 && out.size() < lines; i--) {
            String line = tail.get(i);
            if (filter.isEmpty() || line.contains(filter)) {
                out.add(0, line);
            }
        }
        JsonObject result = new JsonObject();
        JsonArray array = new JsonArray();
        out.forEach(array::add);
        result.add("lines", array);
        result.addProperty("count", array.size());
        result.addProperty("path", path.toString());
        return result;
    }

    /** 从文件尾捞最多 512KiB，切成行返回。开头那行可能被截断，直接丢掉。 */
    private static List<String> tail(Path path, int want) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(path.toFile(), "r")) {
            long length = raf.length();
            long chunk = Math.min(length, 512L * 1024L);
            boolean partial = chunk < length;
            raf.seek(length - chunk);
            byte[] bytes = new byte[(int) chunk];
            raf.readFully(bytes);
            String text = new String(bytes, StandardCharsets.UTF_8);
            String[] split = text.split("\r?\n", -1);
            List<String> lines = new ArrayList<>();
            for (int i = partial ? 1 : 0; i < split.length; i++) {
                lines.add(split[i]);
            }
            int from = Math.max(0, lines.size() - want);
            return lines.subList(from, lines.size());
        }
    }

    /** 存活探针。只读 volatile 快照，不碰游戏状态，专服上也能答。 */
    private static JsonObject ping() {
        JsonObject result = new JsonObject();
        result.addProperty("pong", true);

        JsonObject client = DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> ClientHooks::status);
        if (client == null) {
            result.addProperty("side", "server");
            result.addProperty("inWorld", ServerLifecycleHooks.getCurrentServer() != null);
            result.addProperty("tick", -1);
        } else {
            result.addProperty("side", "client");
            for (String key : client.keySet()) {
                result.add(key, client.get(key));
            }
        }
        return result;
    }

    private static JsonObject envelope(int id, boolean ok, JsonObject result, String error) {
        JsonObject o = new JsonObject();
        o.addProperty("id", id);
        o.addProperty("ok", ok);
        if (result != null) {
            o.add("result", result);
        }
        if (error != null) {
            o.addProperty("error", error);
        }
        return o;
    }

    private static String describe(Throwable t) {
        Throwable cause = t;
        if (t instanceof ExecutionException && t.getCause() != null) {
            cause = t.getCause();
        }
        if (cause instanceof TimeoutException) {
            return "等超时了：动作没在预期时间内走完（游戏卡了？还是 ticks 给太大？）";
        }
        String message = cause.getMessage();
        return cause.getClass().getSimpleName() + (message == null ? "" : ": " + message);
    }
}
