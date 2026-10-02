package com.taolesi.mcpforminecraft.e2e;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(McmcpE2E.MOD_ID)
public final class McmcpE2E {
    public static final String MOD_ID = "mcmcp_e2e";

    public McmcpE2E(IEventBus modEventBus) {
        E2EContent.register(modEventBus);
    }
}
