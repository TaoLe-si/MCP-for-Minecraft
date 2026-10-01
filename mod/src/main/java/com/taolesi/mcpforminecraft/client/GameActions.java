package com.taolesi.mcpforminecraft.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonObject;

import net.minecraft.client.Minecraft;

/**
 * "要占着时间才能做完"的动作的统一驱动。
 *
 * <p>挖一个方块要好几 tick；按住某个键要按住 N tick。这类活儿**不能**在游戏线程上
 * 干等（那就是把游戏冻住），也不能在收包线程上干等（等多久游戏也不知道）。
 * 所以做成挂账：起动作时说清楚"每 tick 干什么、什么时候算完"，
 * 之后由 {@link ClientHooks} 每 tick 推一步，推完自动回包。
 *
 * <p>{@code step} 返回 true = 收工。{@code onDone} 在收工那一 tick 先跑（用来松键、
 * 补报结果），然后才取 after 快照回包 —— 顺序很重要，不然回包里的状态是"还没收尾"的。
 *
 * <p>线程：只在客户端游戏线程上动。
 */
public final class GameActions {
    /** 每 tick 推进一步；返回 true 表示这个动作做完了。 */
    public interface Step {
        boolean tick(Minecraft mc) throws Exception;
    }

    private static final class Task {
        final Step step;
        final JsonObject before;
        final JsonObject extra;
        final Runnable onDone;
        final CompletableFuture<JsonObject> out;
        int budget;

        Task(Step step, JsonObject before, JsonObject extra, int budget,
             Runnable onDone, CompletableFuture<JsonObject> out) {
            this.step = step;
            this.before = before;
            this.extra = extra;
            this.budget = budget;
            this.onDone = onDone;
            this.out = out;
        }
    }

    private static final List<Task> TASKS = new ArrayList<>();

    private GameActions() {
    }

    /**
     * 挂一个动作。
     *
     * @param budgetTicks 上限，防止"永远做不完"的动作把回包吊死；到点强制收工并如实回包
     * @param onDone      收尾（松键、写结果），在取 after 快照之前跑
     */
    static void submit(JsonObject before, JsonObject extra, int budgetTicks,
                       Step step, Runnable onDone, CompletableFuture<JsonObject> out) {
        TASKS.add(new Task(step, before, extra, Math.max(1, budgetTicks), onDone, out));
    }

    static void tick(Minecraft mc) {
        if (TASKS.isEmpty()) {
            return;
        }
        for (Iterator<Task> it = TASKS.iterator(); it.hasNext(); ) {
            Task t = it.next();
            boolean done;
            try {
                done = t.step.tick(mc) || --t.budget <= 0;
            } catch (Throwable e) {
                it.remove();
                t.out.completeExceptionally(e);
                continue;
            }
            if (!done) {
                continue;
            }
            it.remove();
            try {
                if (t.onDone != null) {
                    t.onDone.run();
                }
            } catch (Throwable e) {
                t.out.completeExceptionally(e);
                continue;
            }
            t.out.complete(Observation.pair(t.before, Observation.of(mc), t.extra));
        }
    }

    static boolean busy() {
        return !TASKS.isEmpty();
    }

    /** 世界卸载/出意外时清场，别把键按着不放。 */
    static void abortAll(String why) {
        for (Task t : TASKS) {
            t.out.completeExceptionally(new IllegalStateException("动作中断：" + why));
        }
        TASKS.clear();
    }
}
