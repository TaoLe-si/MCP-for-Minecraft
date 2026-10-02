package dev.codex.mcmcp.e2e;

import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

@GameTestHolder(McmcpE2E.MOD_ID)
@PrefixGameTestTemplate(false)
public final class ProbeGameTests {
    private ProbeGameTests() { }

    @GameTest(template = "empty", templateNamespace = "minecraft", timeoutTicks = 20)
    public static void probeWandTogglesProbeBlock(GameTestHelper helper) {
        BlockPos pos = new BlockPos(1, 1, 1);
        helper.setBlock(pos, E2EContent.PROBE_BLOCK.get());

        Player player = helper.makeMockPlayer(GameType.CREATIVE);
        player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(E2EContent.PROBE_WAND.get()));
        helper.useBlock(pos, player);

        helper.assertBlockState(pos,
                state -> state.getBlock() == E2EContent.PROBE_BLOCK.get() && state.getValue(ProbeBlock.ACTIVE),
                () -> "probe wand did not set mcmcp_e2e:probe_block[active=true]");
        helper.succeed();
    }
}
