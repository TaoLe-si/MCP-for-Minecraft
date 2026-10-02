package dev.codex.mcmcp.e2e;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;

public final class ProbeWandItem extends Item {
    public ProbeWandItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        BlockState state = context.getLevel().getBlockState(pos);
        if (!state.is(E2EContent.PROBE_BLOCK.get())) return InteractionResult.PASS;

        if (!context.getLevel().isClientSide) {
            context.getLevel().setBlock(pos, state.setValue(ProbeBlock.ACTIVE, !state.getValue(ProbeBlock.ACTIVE)), 3);
        }
        return InteractionResult.SUCCESS;
    }
}
