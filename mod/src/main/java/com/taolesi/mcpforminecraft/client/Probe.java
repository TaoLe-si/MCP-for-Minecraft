package com.taolesi.mcpforminecraft.client;

import com.google.gson.JsonObject;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.phys.Vec3;

/**
 * 内脏探针：把"为什么不听使唤"这件事需要的内部状态一次全打出来。
 *
 * <p>为什么单独做一个 op 而不是塞进 {@code state}：{@code state} 是给"游戏世界"用的
 * 观测（位置、血量…），这里看的是**客户端自己**的状态（窗口焦点、暂停标志、
 * 按键是否真的处于按下、输入冲量）。两者混在一起会让 {@code state} 变得又大又难读。
 *
 * <p>做它的原因很实际：出现过"包送到了、tick 也走了 40 个、人就是不动"的情况，
 * 光看 `state` 只能看到"位置没变"这个结果，看不出是哪一环断的。有了这个探针，
 * 一眼就能定位是"按键没按上"（isDown=false）还是"世界没在 tick"（pause=true）
 * 还是"输入没被读到"（forwardImpulse=0）。
 */
public final class Probe {
    private Probe() {
    }

    static JsonObject of(Minecraft mc) {
        JsonObject o = new JsonObject();
        o.addProperty("windowActive", mc.isWindowActive());
        o.addProperty("mouseGrabbed", mc.mouseHandler.isMouseGrabbed());
        o.addProperty("pauseOnLostFocus", mc.options.pauseOnLostFocus);
        o.addProperty("paused", mc.isPaused());
        o.addProperty("screen", mc.screen == null ? null : mc.screen.getClass().getName());
        o.addProperty("overlay", mc.getOverlay() == null
                ? null : mc.getOverlay().getClass().getName());
        o.addProperty("singleplayer", mc.hasSingleplayerServer());
        o.addProperty("localServer", mc.isLocalServer());

        o.addProperty("keyUpDown", mc.options.keyUp.isDown());
        o.addProperty("keyUpRaw", mc.options.keyUp.isDown());
        o.addProperty("keyJumpDown", mc.options.keyJump.isDown());
        o.addProperty("keyShiftDown", mc.options.keyShift.isDown());
        o.addProperty("keySprintDown", mc.options.keySprint.isDown());
        o.addProperty("keyAttackDown", mc.options.keyAttack.isDown());

        LocalPlayer player = mc.player;
        if (player == null) {
            o.addProperty("inWorld", false);
            return o;
        }
        o.addProperty("inWorld", true);
        o.addProperty("forwardImpulse", player.input.forwardImpulse);
        o.addProperty("leftImpulse", player.input.leftImpulse);
        o.addProperty("inputUp", player.input.up);
        o.addProperty("inputJumping", player.input.jumping);
        o.addProperty("inputShift", player.input.shiftKeyDown);
        o.addProperty("onGround", player.onGround());
        o.addProperty("sprinting", player.isSprinting());
        o.addProperty("sneaking", player.isShiftKeyDown());
        o.addProperty("gameTime", mc.level == null ? -1L : mc.level.getGameTime());
        Vec3 motion = player.getDeltaMovement();
        JsonObject move = new JsonObject();
        move.addProperty("x", motion.x);
        move.addProperty("y", motion.y);
        move.addProperty("z", motion.z);
        o.add("motion", move);
        o.addProperty("speedAttr", player.getSpeed());
        return o;
    }
}
