package com.taolesi.mcpforminecraft.client;

import com.taolesi.mcpforminecraft.McpForMinecraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelSettings;
import net.minecraft.world.level.WorldDataConfiguration;
import net.minecraft.world.level.levelgen.WorldDimensions;
import net.minecraft.world.level.levelgen.WorldOptions;
import net.minecraft.world.level.levelgen.presets.WorldPresets;
import net.minecraftforge.client.gui.LoadingErrorScreen;

/**
 * 无人值守用的开机动作：自动进一个超平坦世界。
 *
 * <p>由 {@code -Dmcpforminecraft.autoworld=<世界名>} 武装（build.gradle 里
 * {@code runClientAuto} 任务已经带上了）。为什么要它：dev 客户端默认停在主菜单，
 * "往前走"这件事**必须在世界里**才谈得上，自动建世界才能让整条链路无人值守地跑通。
 *
 * <p>选超平坦而不是默认地形：地面平、生成快、没有地形起伏掺进位移判据里 ——
 * 测"走了多远"的时候，噪声越少越好。
 */
public final class AutoWorld {
    private static String name = "";
    private static String spawn = "";
    private static boolean spawned;
    private static String lastScreen = "";
    private static int stuckTicks;
    private static boolean armed;
    private static boolean done;

    private AutoWorld() {
    }

    /** 自动化跑的时候（clientAuto）为真：此时可以替人类做掉一些"要人点一下"的事。 */
    public static boolean armed() {
        return armed;
    }

    public static void init() {
        name = System.getProperty("mcpforminecraft.autoworld", "").trim();
        armed = !name.isEmpty();
        spawn = System.getProperty("mcpforminecraft.spawn", "").trim();
        if (armed) {
            McpForMinecraft.LOG.info("已武装自动进世界：{}{}", name,
                    spawn.isEmpty() ? "" : "，进世界后传送到 " + spawn);
        }
    }

    static void tick(Minecraft mc) {
        if (!armed) {
            return;
        }
        // 进世界之前先清障；进世界之后只剩"暂停界面"还要照看。
        // 无人值守时这些"要人点一下"的界面等于把整条流水线掐死：
        //   LoadingErrorScreen            —— 加载警告（比如资源包少了 pack.mcmeta）
        //   AccessibilityOnboardingScreen —— 首次启动的无障碍引导
        //   PauseScreen                   —— 失焦暂停（GameRenderer.java:896）或误触 ESC
        // 给 3 秒让人类看得见（人工跑的时候不至于一闪而过），然后自己处理掉。
        if (mc.screen instanceof LoadingErrorScreen
                || mc.screen instanceof AccessibilityOnboardingScreen
                || mc.screen instanceof PauseScreen) {
            if (++stuckTicks > 60) {
                McpForMinecraft.LOG.warn(
                        "自动化：跳过挡路的界面 {}（窗口有焦点={} 失焦暂停={}）"
                                + "—— 这两个值能定位它是不是失焦暂停造成的",
                        mc.screen.getClass().getSimpleName(), mc.isWindowActive(),
                        mc.options.pauseOnLostFocus);
                mc.setScreen(null);
                ClientHooks.keepMouseFree(mc);
                stuckTicks = 0;
            }
            return;
        }
        stuckTicks = 0;

        if (done) {
            // 进世界之后还有一件事要做一次：站到固定起点。
            // 为什么非要固定：自动化要可复现 —— 上次跑完人可能停在很远的地方，
            // 而那一片区块是临场生成的，重新载入时客户端会为它忙上几十秒（实测卡过）。
            // 传送到出生点附近（世界加载时就已经生成好）代价最低。
            if (!spawned && mc.level != null && mc.player != null && !spawn.isEmpty()) {
                spawned = true;
                String[] xyz = spawn.split("[, ]+");
                if (xyz.length == 3 && mc.getConnection() != null) {
                    McpForMinecraft.LOG.info("站到固定起点 {}", spawn);
                    mc.getConnection().sendCommand("tp @s " + xyz[0] + " " + xyz[1]
                            + " " + xyz[2] + " 0 0");
                }
            }
            return;
        }
        if (mc.level != null) {
            done = true;
            McpForMinecraft.LOG.info("已进入世界 {}，自动进世界收工", name);
            return;
        }
        String screen = mc.screen == null ? "null" : mc.screen.getClass().getSimpleName();
        if (!screen.equals(lastScreen)) {
            lastScreen = screen;
            McpForMinecraft.LOG.info("自动进世界待命中，当前界面：{}", screen);
        }

        // 等主菜单出来再动手：世界数据要在资源/数据包加载完之后才能建
        if (!(mc.screen instanceof TitleScreen)) {
            return;
        }
        done = true;
        try {
            enter(mc);
        } catch (Throwable t) {
            McpForMinecraft.LOG.error("自动进世界失败", t);
        }
    }

    private static void enter(Minecraft mc) {
        boolean exists = mc.getLevelSource().levelExists(name);
        if (exists) {
            // 建过就直接进，省得每次验证都重新生成一遍
            McpForMinecraft.LOG.info("世界 {} 已存在，直接载入", name);
            mc.createWorldOpenFlows().loadLevel(null, name);
            return;
        }
        LevelSettings settings = new LevelSettings(name, GameType.SURVIVAL, false,
                Difficulty.PEACEFUL, true, new GameRules(), WorldDataConfiguration.DEFAULT);
        WorldOptions options = new WorldOptions(0L, false, false);
        McpForMinecraft.LOG.info("建超平坦世界 {}（生存/和平/允许作弊）", name);
        mc.createWorldOpenFlows().createFreshLevel(name, settings, options, AutoWorld::flat);
    }

    /** 取 "flat" 这个世界预设的维度表。跟原版 {@code WorldPresets::createNormalWorldDimensions} 一个路子。 */
    private static WorldDimensions flat(RegistryAccess access) {
        return access.registryOrThrow(Registries.WORLD_PRESET)
                .getHolderOrThrow(WorldPresets.FLAT).value().createWorldDimensions();
    }
}
