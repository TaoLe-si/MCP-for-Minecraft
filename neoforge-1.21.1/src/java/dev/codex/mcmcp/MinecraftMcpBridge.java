package dev.codex.mcmcp;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = MinecraftMcpBridge.MOD_ID, dist = Dist.CLIENT)
public final class MinecraftMcpBridge {
    public static final String MOD_ID = "mcmcp";

    public MinecraftMcpBridge(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.addListener(this::onClientTick);
        modEventBus.addListener(BridgeHttpServer::onClientSetup);
        Runtime.getRuntime().addShutdownHook(new Thread(BridgeHttpServer::stop, "mcmcp-shutdown"));
    }

    private void onClientTick(ClientTickEvent.Post event) {
        Minecraft client = Minecraft.getInstance();
        PlayerControls.onClientTick(client);
        BridgeHttpServer.maybeCreateValidationWorld(client);
    }
}
