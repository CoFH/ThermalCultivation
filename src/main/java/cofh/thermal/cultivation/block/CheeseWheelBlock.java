package cofh.thermal.cultivation.block;

import cofh.lib.block.FeastBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;

import static cofh.lib.util.constants.BlockStatePropertiesCoFH.BITES_0_3;
import static cofh.lib.util.constants.BlockStatePropertiesCoFH.FACING_HORIZONTAL;

public class CheeseWheelBlock extends FeastBlock {

    protected static final VoxelShape PIECE_1 = Block.box(8.0D, 0.0D, 1.0D, 15.0D, 8.0D, 8.0D);
    protected static final VoxelShape PIECE_2 = Block.box(1.0D, 0.0D, 1.0D, 8.0D, 8.0D, 8.0D);
    protected static final VoxelShape PIECE_3 = Block.box(1.0D, 0.0D, 8.0D, 8.0D, 8.0D, 15.0D);
    protected static final VoxelShape PIECE_4 = Block.box(8.0D, 0.0D, 8.0D, 15.0D, 8.0D, 15.0D);

    protected static final VoxelShape[][] SHAPE_BY_BITE_AND_ROTATION = new VoxelShape[4][];

    static {
        SHAPE_BY_BITE_AND_ROTATION[0] = new VoxelShape[]{
                Shapes.or(PIECE_1, PIECE_2, PIECE_3, PIECE_4),
                Shapes.or(PIECE_2, PIECE_3, PIECE_4),
                Shapes.or(PIECE_3, PIECE_4),
                Shapes.or(PIECE_4)
        };
        SHAPE_BY_BITE_AND_ROTATION[1] = new VoxelShape[]{
                Shapes.or(PIECE_1, PIECE_2, PIECE_3, PIECE_4),
                Shapes.or(PIECE_1, PIECE_2, PIECE_4),
                Shapes.or(PIECE_1, PIECE_2),
                Shapes.or(PIECE_2)
        };
        SHAPE_BY_BITE_AND_ROTATION[2] = new VoxelShape[]{
                Shapes.or(PIECE_1, PIECE_2, PIECE_3, PIECE_4),
                Shapes.or(PIECE_1, PIECE_3, PIECE_4),
                Shapes.or(PIECE_1, PIECE_4),
                Shapes.or(PIECE_1)
        };
        SHAPE_BY_BITE_AND_ROTATION[3] = new VoxelShape[]{
                Shapes.or(PIECE_1, PIECE_2, PIECE_3, PIECE_4),
                Shapes.or(PIECE_1, PIECE_2, PIECE_3),
                Shapes.or(PIECE_2, PIECE_3),
                Shapes.or(PIECE_3),
        };
    }

    public CheeseWheelBlock(Properties properties, @Nonnull FoodProperties food) {

        super(properties, food);
    }

    @Override
    public IntegerProperty getBitesProperty() {

        return BITES_0_3;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {

        return SHAPE_BY_BITE_AND_ROTATION[state.getValue(FACING_HORIZONTAL).ordinal() - 2][state.getValue(getBitesProperty())];
    }

}
