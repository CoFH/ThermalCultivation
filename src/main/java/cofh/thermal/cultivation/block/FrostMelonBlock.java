package cofh.thermal.cultivation.block;

import cofh.lib.block.impl.crops.AttachedStemBlockCoFH;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

import static cofh.thermal.cultivation.init.TCulReferences.FROST_MELON_STEM;
import static cofh.thermal.cultivation.init.TCulReferences.FROST_MELON_STEM_ATTACHED;

public class FrostMelonBlock extends StemGrownBlock {

    public FrostMelonBlock(BlockBehaviour.Properties builder) {

        super(builder);
    }

    public StemBlock getStem() {

        return (StemBlock) FROST_MELON_STEM;
    }

    public AttachedStemBlock getAttachedStem() {

        return (AttachedStemBlockCoFH) FROST_MELON_STEM_ATTACHED;
    }

    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {

        if (!worldIn.isAreaLoaded(pos, 1)) {
            return;
        }
        BlockPos above = pos.above();
        if (worldIn.isEmptyBlock(above)) {
            worldIn.setBlock(above, Blocks.SNOW.defaultBlockState(), 2);
        }
    }

}