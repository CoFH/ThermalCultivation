package cofh.thermal.cultivation.block;

import cofh.lib.block.impl.FeastBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Food;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

import static cofh.lib.util.constants.Constants.BITES_0_3;
import static cofh.lib.util.constants.Constants.FACING_HORIZONTAL;

public class CheeseWheelBlock extends FeastBlock {

    protected static final VoxelShape PIECE_1 = Block.box(8.0D, 0.0D, 1.0D, 15.0D, 8.0D, 8.0D);
    protected static final VoxelShape PIECE_2 = Block.box(1.0D, 0.0D, 1.0D, 8.0D, 8.0D, 8.0D);
    protected static final VoxelShape PIECE_3 = Block.box(1.0D, 0.0D, 8.0D, 8.0D, 8.0D, 15.0D);
    protected static final VoxelShape PIECE_4 = Block.box(8.0D, 0.0D, 8.0D, 15.0D, 8.0D, 15.0D);

    protected static final VoxelShape[][] SHAPE_BY_BITE_AND_ROTATION = new VoxelShape[4][];

    static {
        SHAPE_BY_BITE_AND_ROTATION[0] = new VoxelShape[]{
                VoxelShapes.or(PIECE_1, PIECE_2, PIECE_3, PIECE_4),
                VoxelShapes.or(PIECE_2, PIECE_3, PIECE_4),
                VoxelShapes.or(PIECE_3, PIECE_4),
                VoxelShapes.or(PIECE_4)
        };
        SHAPE_BY_BITE_AND_ROTATION[1] = new VoxelShape[]{
                VoxelShapes.or(PIECE_1, PIECE_2, PIECE_3, PIECE_4),
                VoxelShapes.or(PIECE_1, PIECE_2, PIECE_4),
                VoxelShapes.or(PIECE_1, PIECE_2),
                VoxelShapes.or(PIECE_2)
        };
        SHAPE_BY_BITE_AND_ROTATION[2] = new VoxelShape[]{
                VoxelShapes.or(PIECE_1, PIECE_2, PIECE_3, PIECE_4),
                VoxelShapes.or(PIECE_1, PIECE_3, PIECE_4),
                VoxelShapes.or(PIECE_1, PIECE_4),
                VoxelShapes.or(PIECE_1)
        };
        SHAPE_BY_BITE_AND_ROTATION[3] = new VoxelShape[]{
                VoxelShapes.or(PIECE_1, PIECE_2, PIECE_3, PIECE_4),
                VoxelShapes.or(PIECE_1, PIECE_2, PIECE_3),
                VoxelShapes.or(PIECE_2, PIECE_3),
                VoxelShapes.or(PIECE_3),
        };
    }

    public CheeseWheelBlock(Properties properties, @Nonnull Food food) {

        super(properties, food);
    }

    @Override
    public IntegerProperty getBitesProperty() {

        return BITES_0_3;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {

        return SHAPE_BY_BITE_AND_ROTATION[state.getValue(FACING_HORIZONTAL).ordinal() - 2][state.getValue(getBitesProperty())];
    }

}
