package com.taolesi.mcpforminecraft.client;

import com.taolesi.mcpforminecraft.control.Journal;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * 把游戏里发生的事抄进流水账（{@link Journal}），供 {@code chatlog} / {@code events} 取用。
 *
 * <p>只挑"驱动游戏的人需要知道"的那几类：聊天、死亡、换维度、进出世界。
 * 全都往原版的事件总线上挂，不改任何原版行为。
 */
public final class ClientEvents {
    private ClientEvents() {
    }

    @SubscribeEvent
    public static void onChat(ClientChatReceivedEvent event) {
        Journal.chat(event.getMessage().getString());
    }

    @SubscribeEvent
    public static void onDeath(LivingDeathEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null && event.getEntity() == mc.player) {
            Journal.event("death", "玩家死了：" + event.getSource().getLocalizedDeathMessage(mc.player).getString());
        }
    }

    @SubscribeEvent
    public static void onDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        Journal.event("dim", "换维度 → " + event.getTo().location());
    }

    @SubscribeEvent
    public static void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Journal.event("join", "进入世界：" + event.getEntity().getName().getString());
    }

    @SubscribeEvent
    public static void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Journal.event("respawn", "复活了");
    }
}
