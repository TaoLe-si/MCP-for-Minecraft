package dev.codex.mcmcp.e2e;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class E2EContent {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(McmcpE2E.MOD_ID);
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(McmcpE2E.MOD_ID);

    public static final DeferredBlock<ProbeBlock> PROBE_BLOCK = BLOCKS.register(
            "probe_block", () -> new ProbeBlock(BlockBehaviour.Properties.of().strength(1.5F)));
    public static final DeferredItem<BlockItem> PROBE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("probe_block", PROBE_BLOCK);
    public static final DeferredItem<ProbeWandItem> PROBE_WAND = ITEMS.register(
            "probe_wand", () -> new ProbeWandItem(new Item.Properties()));

    private E2EContent() { }

    static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }
}
