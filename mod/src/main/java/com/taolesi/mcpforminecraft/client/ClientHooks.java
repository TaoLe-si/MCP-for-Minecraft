package com.taolesi.mcpforminecraft.client;

import com.google.gson.JsonObject;
import com.taolesi.mcpforminecraft.McpForMinecraft;
import com.taolesi.mcpforminecraft.control.GameThread;
import com.taolesi.mcpforminecraft.control.Journal;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;

/**
 * 客户端侧的钩子：接管游戏线程、驱动"挂账动作"、抄界面变迁、必要时自动进世界。
 *
 * <p>装填时机故意拖到**第一个客户端 tick**：模组构造那会儿 {@code Minecraft} 还在
 * 自己的构造函数里，`options`、主循环都未必就绪，早拿一手只会拿到半成品。
 */
public final class ClientHooks {
    private static volatile int ticks;
    private static volatile boolean inWorld;
    private static volatile boolean windowActive;
    private static volatile boolean pauseOnLostFocus;
    private static volatile boolean mouseGrabbed;
    private static boolean installed;
    private static boolean releasedOnce;
    private static String lastScreen = "";

    private ClientHooks() {
    }

    public static void init() {
        MinecraftForge.EVENT_BUS.addListener(ClientHooks::onClientTick);
        // 聊天/死亡/换维度 → 流水账（events / chatlog 两个 op 的数据源）
        MinecraftForge.EVENT_BUS.register(ClientEvents.class);
        // 声音 / 首领条 → 感官缓冲（sounds / bossBars 两个 op 的数据源）
        MinecraftForge.EVENT_BUS.register(Senses.class);
        AutoWorld.init();
    }

    private static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }
        Minecraft mc = Minecraft.getInstance();
        if (!installed) {
            installed = true;
            GameThread.install(mc::execute);
            // 无人值守的关键：单机时窗口一失焦就暂停，暂停了 tick 就不走，
            // 按键倒计时和位移全停摆。搞自动化必须关掉它。
            mc.options.pauseOnLostFocus = false;
            // 首次启动的无障碍引导页会挡在标题画面前面（Minecraft.java:600 建的），
            // 关了它下次启动就不再出现
            mc.options.onboardAccessibility = false;
            McpForMinecraft.LOG.info("客户端钩子就位（游戏线程已接管，失焦不暂停）");
        }

        ticks++;
        boolean nowInWorld = mc.level != null && mc.player != null;
        if (inWorld && !nowInWorld) {
            // 世界没了（退回主菜单/断开），别把键按着不放、也别让挂账的动作吊死
            InputOverride.releaseAll();
            GameActions.abortAll("已经离开世界");
        }
        inWorld = nowInWorld;

        // 每 tick 复述"失焦不暂停"。GameRenderer.java:896 那条路只在
        // pauseOnLostFocus 为真时动手，而它一旦暂停，tick 就停、什么都做不了 ——
        // 无人值守时这是最贵的故障，所以每 tick 压一次，不指望"设过一次就永久生效"。
        if (AutoWorld.armed()) {
            mc.options.pauseOnLostFocus = false;
            keepMouseFree(mc);
        }

        String screen = mc.screen == null ? "" : mc.screen.getClass().getSimpleName();
        if (!screen.equals(lastScreen)) {
            Journal.event("screen", lastScreen.isEmpty()
                    ? "打开 " + screen : "关闭 " + lastScreen + "，打开 " + screen);
            lastScreen = screen;
        }

        windowActive = mc.isWindowActive();
        pauseOnLostFocus = mc.options.pauseOnLostFocus;
        mouseGrabbed = mc.mouseHandler.isMouseGrabbed();

        InputOverride.tick(mc);   // 复述按住的键
        GameActions.tick(mc);     // 推进挂账动作，到点回包
        AutoWorld.tick(mc);

        // 心跳：光看"钩子就位"那一行分不清 tick 是还在走还是只走了一次
        if (ticks == 200 || ticks % 2400 == 0) {
            McpForMinecraft.LOG.info("客户端 tick {}（在世界里={}）", ticks, inWorld);
        }
    }

    /**
     * 把真机鼠标还给用户。
     *
     * <p>原版在"没有界面 + 窗口有焦点"时会 {@code MouseHandler.grabMouse()}，
     * 那是 `InputConstants.grabOrReleaseMouse(window, 212995, …)` —— 212995 就是
     * {@code GLFW_CURSOR_DISABLED}：**真机光标会被隐藏并锁进游戏窗口**。
     * 一次自动化跑下来，人的电脑就没法用了。
     *
     * <p>我们不需要鼠标：转视角走 {@code Entity#setYRot/setXRot}，点按钮走
     * {@code Screen#mouseClicked(控件坐标)}，按键走 {@code KeyMapping}。
     * 所以自动化（`clientAuto`）时每 tick 放掉一次；人自己跑的 {@code runClient}
     * 不碰这个，保持原版手感。
     */
    public static void keepMouseFree(Minecraft mc) {
        if (mc.mouseHandler.isMouseGrabbed()) {
            mc.mouseHandler.releaseMouse();
            if (!releasedOnce) {
                releasedOnce = true;
                McpForMinecraft.LOG.info("已放开真机鼠标（自动化不抓光标；人正常玩不受影响）");
            }
        }
    }

    public static int ticks() {
        return ticks;
    }

    public static boolean inWorld() {
        return inWorld;
    }

    /**
     * 给 {@code Dispatcher#ping} 用的跨线程快照：只读 volatile，不碰游戏对象。
     * 收包线程直接摸 {@code mc.level} 是不行的。
     *
     * <p>把"窗口有没有焦点""失焦会不会暂停"也带上：tick 不涨的时候，
     * 这两个就是头号嫌疑，能直接看到就不用猜。
     */
    public static JsonObject status() {
        JsonObject o = new JsonObject();
        o.addProperty("tick", ticks);
        o.addProperty("inWorld", inWorld);
        o.addProperty("windowActive", windowActive);
        o.addProperty("pauseOnLostFocus", pauseOnLostFocus);
        o.addProperty("mouseGrabbed", mouseGrabbed);
        return o;
    }
}
