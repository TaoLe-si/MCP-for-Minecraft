package com.taolesi.mcpforminecraft.client;

import com.google.gson.JsonObject;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * 观测快照 —— 协议里 `state` 以及每个动作的 `before`/`after` 都是这个形状。
 *
 * <p>只能在游戏线程上调用：读的全是玩家/世界的活状态。
 */
public final class Observation {
    private Observation() {
    }

    public static JsonObject of(Minecraft mc) {
        JsonObject o = new JsonObject();
        LocalPlayer player = mc.player;
        ClientLevel level = mc.level;
        boolean inWorld = player != null && level != null;

        o.addProperty("inWorld", inWorld);
        o.addProperty("tick", ClientHooks.ticks());
        o.addProperty("screen", mc.screen == null ? null : mc.screen.getClass().getSimpleName());
        if (!inWorld) {
            return o;
        }

        o.addProperty("dim", level.dimension().location().toString());

        JsonObject pos = new JsonObject();
        pos.addProperty("x", player.getX());
        pos.addProperty("y", player.getY());
        pos.addProperty("z", player.getZ());
        o.add("pos", pos);

        JsonObject rot = new JsonObject();
        rot.addProperty("yaw", player.getYRot());
        rot.addProperty("pitch", player.getXRot());
        o.add("rot", rot);

        Vec3 look = player.getLookAngle();
        JsonObject lookJson = new JsonObject();
        lookJson.addProperty("x", look.x);
        lookJson.addProperty("y", look.y);
        lookJson.addProperty("z", look.z);
        o.add("look", lookJson);

        o.addProperty("onGround", player.onGround());
        o.addProperty("sneaking", player.isShiftKeyDown());
        o.addProperty("sprinting", player.isSprinting());
        o.addProperty("health", player.getHealth());
        o.addProperty("food", player.getFoodData().getFoodLevel());
        o.addProperty("held",
                ForgeRegistries.ITEMS.getKey(player.getMainHandItem().getItem()).toString());
        return o;
    }

    /** 动作类 op 的回包：前后两帧 + 可选附加字段。 */
    public static JsonObject pair(JsonObject before, JsonObject after, JsonObject extra) {
        JsonObject o = new JsonObject();
        o.add("before", before);
        o.add("after", after);
        if (extra != null) {
            for (String key : extra.keySet()) {
                o.add(key, extra.get(key));
            }
        }
        return o;
    }
}
