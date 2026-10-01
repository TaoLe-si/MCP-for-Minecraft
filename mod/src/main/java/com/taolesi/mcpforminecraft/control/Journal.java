package com.taolesi.mcpforminecraft.control;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Deque;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 游戏内流水账：聊天、事件、以及"我们执行过的每个动作"。
 *
 * <p>为什么要自己记：聊天窗口的内容在客户端是 {@code GuiMessage} 那种渲染期结构，
 * 想取回纯文本得拐好几道弯；而"操作日志"原版压根没有。自己攒一个环形缓冲，
 * 既能给 {@code log}/{@code chatlog}/{@code events} 三个观测 op 供数，
 * 也让排查"我明明发了包为什么没动"时有据可查。
 *
 * <p>线程：写的人（游戏线程/事件总线）和读的人（收包线程）不是一个，所以全加锁。
 */
public final class Journal {
    private static final int CAPACITY = 500;
    private static final DateTimeFormatter CLOCK = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static final Deque<JsonObject> EVENTS = new ArrayDeque<>();
    private static final Deque<JsonObject> CHAT = new ArrayDeque<>();

    private Journal() {
    }

    /** 记一条事件。{@code kind} 用来分类（op / screen / dim / death / respawn / item ...）。 */
    public static void event(String kind, String text) {
        JsonObject o = new JsonObject();
        o.addProperty("at", LocalTime.now().format(CLOCK));
        o.addProperty("kind", kind);
        o.addProperty("text", text);
        synchronized (EVENTS) {
            push(EVENTS, o);
        }
    }

    public static void chat(String text) {
        JsonObject o = new JsonObject();
        o.addProperty("at", LocalTime.now().format(CLOCK));
        o.addProperty("text", text);
        synchronized (CHAT) {
            push(CHAT, o);
        }
    }

    private static void push(Deque<JsonObject> queue, JsonObject o) {
        queue.addLast(o);
        while (queue.size() > CAPACITY) {
            queue.removeFirst();
        }
    }

    public static JsonArray events(int limit) {
        return tail(EVENTS, limit);
    }

    public static JsonArray chat(int limit) {
        return tail(CHAT, limit);
    }

    private static JsonArray tail(Deque<JsonObject> queue, int limit) {
        JsonArray out = new JsonArray();
        synchronized (queue) {
            int skip = Math.max(0, queue.size() - Math.max(1, limit));
            int i = 0;
            for (JsonObject o : queue) {
                if (i++ >= skip) {
                    out.add(o);
                }
            }
        }
        return out;
    }

    public static int size() {
        synchronized (EVENTS) {
            return EVENTS.size();
        }
    }
}
