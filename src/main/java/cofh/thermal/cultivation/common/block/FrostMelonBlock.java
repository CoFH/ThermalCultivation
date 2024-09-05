package cofh.thermal.cultivation.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class FrostMelonBlock extends Block {

    public FrostMelonBlock(BlockBehaviour.Properties builder) {

        super(builder);
    }

    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {

        if (!worldIn.isAreaLoaded(pos, 1)) {
            return;
        }
        BlockPos above = pos.above();
        if (worldIn.isEmptyBlock(above)) {
            worldIn.setBlock(above, Blocks.SNOW.defaultBlockState(), 2);
        }
    }

}