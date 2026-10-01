package com.taolesi.mcpforminecraft.control;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import net.minecraftforge.server.ServerLifecycleHooks;

/**
 * 把活儿投递到"游戏线程"上执行。
 *
 * <p>为什么非投递不可：TCP 线程碰到 LocalPlayer / ClientLevel 会立刻炸（原版这些状态
 * 只在主线程上动）。所以规矩是**收包线程只收发，改游戏状态一律排队到主线程**。
 *
 * <p>客户端的主线程（1.20.1 里同时也是渲染线程）由 {@code ClientHooks} 在第一个
 * tick 时装上；专用服务端没有客户端线程，退回 {@code MinecraftServer#execute}。
 */
public final class GameThread {
    private static volatile Executor executor;

    private GameThread() {
    }

    /** 客户端启动时装上 {@code Minecraft::execute}。 */
    public static void install(Executor gameExecutor) {
        executor = gameExecutor;
    }

    private static Executor pick() {
        Executor e = executor;
        if (e != null) {
            return e;
        }
        var server = ServerLifecycleHooks.getCurrentServer();
        return server == null ? null : server::execute;
    }

    /**
     * 在游戏线程上跑 task 并等它返回。
     *
     * <p>调用方是 TCP 线程。task 必须**短**：它占着游戏线程，跑久了就是掉帧甚至卡死。
     * 要"按住 N tick"的动作不能这么写，那得靠 {@code InputOverride} 挂账等 tick。
     */
    public static <T> T call(Callable<T> task, long timeout, TimeUnit unit) throws Exception {
        Executor exec = pick();
        if (exec == null) {
            throw new IllegalStateException("游戏还没进主循环，暂不接受操作");
        }
        CompletableFuture<T> future = new CompletableFuture<>();
        exec.execute(() -> {
            try {
                future.complete(task.call());
            } catch (Throwable t) {
                future.completeExceptionally(t);
            }
        });
        return future.get(timeout, unit);
    }
}
