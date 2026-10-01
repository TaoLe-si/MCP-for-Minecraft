package com.taolesi.mcpforminecraft.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonObject;
import com.taolesi.mcpforminecraft.control.Journal;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.ToggleKeyMapping;
import net.minecraft.client.player.LocalPlayer;

/**
 * 按键层：把原版 {@code KeyMapping} 按下去/松开，让游戏以为人在操作。
 *
 * <p>走原版输入链路（不是直接改坐标）的好处：服务端照样收移动包、照样算碰撞、
 * 别的模组也照样看得见 —— 屏幕上就是"人在走"。
 *
 * <p>三个从 1.20.1 源码里读出来、必须照做的点：
 * <ol>
 *   <li>{@code KeyboardInput.tick()} 只读 {@code KeyMapping#isDown()}，所以 setDown 有效；</li>
 *   <li>{@code Minecraft#setScreen()} 里会调 {@code KeyMapping.releaseAll()}、失焦也会清，
 *       所以按住的键**每 tick 都要复述一次**；</li>
 *   <li>{@code keyShift}/{@code keySprint} 是 {@link ToggleKeyMapping}，玩家开了"切换"选项时
 *       {@code setDown(true)} 是**取反**语义、{@code setDown(false)} 是空操作，必须"状态不符才按一次"。</li>
 * </ol>
 *
 * <p>还有一条容易被忽略的：{@code setDown} **不增加** {@code clickCount}，
 * 而"开背包/丢弃/切视角/快捷栏 1-9"这些是走 {@code consumeClick()} 的
 * （见 {@code Minecraft#handleKeybinds}）。所以"敲一下"必须同时补一次
 * {@code KeyMapping.click(...)}，光 setDown 是叫不动的。
 *
 * <p>线程：全部只在客户端游戏线程上被调用。
 */
public final class InputOverride {
    /** 当前被按住的键（只是"要一直按着"的集合，倒计时在 GameActions 那边）。 */
    private static final Map<KeyMapping, Boolean> HELD = new LinkedHashMap<>();

    private InputOverride() {
    }

    static void start(Minecraft mc, String op, JsonObject args, CompletableFuture<JsonObject> out) {
        // 按键类动作要"能玩"而不只是"在世界里"：单机开着界面时游戏是暂停的，
        // 按键进去也不会被 tick 读到 —— 与其假装能动，不如直接说清楚。
        LocalPlayer player = requirePlayable(mc);
        JsonObject before = Observation.of(mc);
        int ticks = Math.max(1, args.has("ticks") ? args.get("ticks").getAsInt() : 20);

        if ("move".equals(op) && args.has("yaw")) {
            float pitch = args.has("pitch") ? args.get("pitch").getAsFloat() : player.getXRot();
            setRotation(player, args.get("yaw").getAsFloat(), pitch);
        }

        // press = 敲一下：既要"按下"（isDown 型的行为），也要"计一次点击"（consumeClick 型的行为）
        boolean click = "press".equals(op)
                || (args.has("click") && args.get("click").getAsBoolean());

        Map<String, Boolean> wanted = resolve(args, op);
        JsonObject applied = new JsonObject();
        List<KeyMapping> touched = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : wanted.entrySet()) {
            KeyMapping mapping = mapping(mc, entry.getKey());
            if (click && entry.getValue()) {
                KeyMapping.click(mapping.getKey());
            }
            force(mapping, entry.getValue());
            applied.addProperty(entry.getKey(), entry.getValue());
            touched.add(mapping);
            if (entry.getValue()) {
                HELD.put(mapping, Boolean.TRUE);
            } else {
                HELD.remove(mapping);
            }
        }

        JsonObject extra = new JsonObject();
        extra.add("applied", applied);
        Journal.event("op", op + " " + args + " → 按住 " + ticks + " tick");
        if ("move".equals(op)) {
            extra.add("beforeRot", before.get("rot").deepCopy());
        }

        // 倒计时要被 lambda 改，用数组兜着（lambda 捕获的局部变量必须是 effectively final）
        int[] remaining = {ticks};
        GameActions.submit(before, extra, ticks + 200,
                m -> --remaining[0] <= 0,
                () -> {
                    for (KeyMapping mapping : touched) {
                        force(mapping, false);
                        HELD.remove(mapping);
                    }
                },
                out);
    }

    /** 每客户端 tick 复述一次按住的键 —— 开界面/失焦都会把 isDown 清掉。 */
    static void tick(Minecraft mc) {
        for (KeyMapping mapping : HELD.keySet()) {
            force(mapping, true);
        }
    }

    /** 直接把朝向拧过去（不经过鼠标；客户端会正常把转身发给服务端）。 */
    static void look(Minecraft mc, JsonObject args) {
        LocalPlayer player = requireWorld(mc);
        float yaw = args.has("yaw") ? args.get("yaw").getAsFloat() : player.getYRot();
        float pitch = args.has("pitch") ? args.get("pitch").getAsFloat() : player.getXRot();
        setRotation(player, yaw, pitch);
    }

    /** 看向某个坐标：算出 yaw/pitch 再拧过去。 */
    static void lookAt(Minecraft mc, JsonObject args) {
        LocalPlayer player = requireWorld(mc);
        double dx = args.get("x").getAsDouble() - player.getX();
        double dy = args.get("y").getAsDouble() - (player.getY() + player.getEyeHeight());
        double dz = args.get("z").getAsDouble() - player.getZ();
        double horizontal = Math.sqrt(dx * dx + dz * dz);
        float yaw = (float) (Math.toDegrees(Math.atan2(dz, dx)) - 90.0);
        float pitch = (float) (-Math.toDegrees(Math.atan2(dy, horizontal)));
        setRotation(player, yaw, pitch);
    }

    private static void setRotation(LocalPlayer player, float yaw, float pitch) {
        player.setYRot(yaw);
        player.setXRot(pitch);
        player.yRotO = yaw;
        player.xRotO = pitch;
        player.setYHeadRot(yaw);
    }

    private static Map<String, Boolean> resolve(JsonObject args, String op) {
        Map<String, Boolean> keys = new LinkedHashMap<>();
        switch (op) {
            case "move" -> keys.put("forward",
                    !args.has("forward") || args.get("forward").getAsFloat() != 0.0F);
            case "jump" -> keys.put("jump", true);
            case "press" -> {
                String key = args.has("key") ? args.get("key").getAsString() : "";
                if (key.isBlank()) {
                    throw new IllegalArgumentException("press 要指定 key，例如 {\"key\":\"inventory\"}");
                }
                keys.put(key, true);
            }
            case "key" -> {
                JsonObject in = args.has("keys") && args.get("keys").isJsonObject()
                        ? args.getAsJsonObject("keys") : new JsonObject();
                if (in.size() == 0) {
                    throw new IllegalArgumentException("key 要指定 keys，例如 {\"keys\":{\"forward\":true}}");
                }
                for (String name : in.keySet()) {
                    keys.put(name, in.get(name).getAsBoolean());
                }
            }
            default -> throw new IllegalArgumentException("不是按键类 op：" + op);
        }
        return keys;
    }

    /** 名字 → 原版按键。名字跟 {@code Options} 里的字段一一对应，掰不弯。 */
    private static KeyMapping mapping(Minecraft mc, String name) {
        Options o = mc.options;
        return switch (name) {
            case "forward" -> o.keyUp;
            case "back" -> o.keyDown;
            case "left" -> o.keyLeft;
            case "right" -> o.keyRight;
            case "jump" -> o.keyJump;
            case "sneak" -> o.keyShift;
            case "sprint" -> o.keySprint;
            case "attack" -> o.keyAttack;
            case "use" -> o.keyUse;
            case "inventory" -> o.keyInventory;
            case "drop" -> o.keyDrop;
            case "chat" -> o.keyChat;
            case "command" -> o.keyCommand;
            case "playerList" -> o.keyPlayerList;
            case "pickItem" -> o.keyPickItem;
            case "swapOffhand" -> o.keySwapOffhand;
            case "togglePerspective" -> o.keyTogglePerspective;
            case "smoothCamera" -> o.keySmoothCamera;
            case "fullscreen" -> o.keyFullscreen;
            case "advancements" -> o.keyAdvancements;
            case "screenshot" -> o.keyScreenshot;
            case "socialInteractions" -> o.keySocialInteractions;
            case "spectatorOutlines" -> o.keySpectatorOutlines;
            case "saveHotbar" -> o.keySaveHotbarActivator;
            case "loadHotbar" -> o.keyLoadHotbarActivator;
            case "hotbarSlot1" -> o.keyHotbarSlots[0];
            case "hotbarSlot2" -> o.keyHotbarSlots[1];
            case "hotbarSlot3" -> o.keyHotbarSlots[2];
            case "hotbarSlot4" -> o.keyHotbarSlots[3];
            case "hotbarSlot5" -> o.keyHotbarSlots[4];
            case "hotbarSlot6" -> o.keyHotbarSlots[5];
            case "hotbarSlot7" -> o.keyHotbarSlots[6];
            case "hotbarSlot8" -> o.keyHotbarSlots[7];
            case "hotbarSlot9" -> o.keyHotbarSlots[8];
            default -> throw new IllegalArgumentException("未知按键：" + name
                    + "（见 skills/minecraft-api/SKILL.md 的按键全表）");
        };
    }

    /**
     * 把键按到目标状态。
     *
     * <p>{@link ToggleKeyMapping} 在"切换"选项打开时 {@code setDown(true)} 是取反、
     * {@code setDown(false)} 是空操作 —— 所以要按"当前状态与目标不符才按一次"来用。
     */
    private static void force(KeyMapping mapping, boolean wanted) {
        if (mapping instanceof ToggleKeyMapping) {
            if (mapping.isDown() != wanted) {
                mapping.setDown(true);
            }
        } else {
            mapping.setDown(wanted);
        }
    }

    static LocalPlayer requireWorld(Minecraft mc) {
        LocalPlayer player = mc.player;
        if (player == null || mc.level == null) {
            throw new IllegalStateException("还没进世界，动不了");
        }
        return player;
    }

    /** 按键/移动类动作用这个：除了要求在世界里，还要求"现在真的是能操作的状态"。 */
    static LocalPlayer requirePlayable(Minecraft mc) {
        LocalPlayer player = requireWorld(mc);
        if (mc.screen != null) {
            throw new IllegalStateException("现在开着界面（" + mc.screen.getClass().getSimpleName()
                    + "），按键不生效；要操作界面请用 screen / clickButton，要恢复操作请用 closeScreen");
        }
        return player;
    }

    static void releaseAll() {
        for (KeyMapping mapping : HELD.keySet()) {
            force(mapping, false);
        }
        HELD.clear();
    }
}
