package com.taolesi.mcpforminecraft.test;

import com.taolesi.mcpforminecraft.McpForMinecraft;

import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

@GameTestHolder(McpForMinecraft.MOD_ID)
@PrefixGameTestTemplate(false)
public final class BridgeGameTests {
    private BridgeGameTests() { }

    @GameTest(template = "empty", templateNamespace = McpForMinecraft.MOD_ID, timeoutTicks = 20)
    public static void bridgeSmoke(GameTestHelper helper) {
        if (!BuiltInRegistries.BLOCK.containsKey(ResourceLocation.withDefaultNamespace("stone"))) {
            throw new AssertionError("Minecraft block registry was not initialized.");
        }
        helper.succeed();
    }
}
