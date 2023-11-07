package cofh.thermal.cultivation.common.block;

import cofh.lib.common.block.CropBlockTall;
import cofh.lib.util.helpers.MathHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;

import static cofh.lib.util.constants.BlockStatePropertiesCoFH.AGE_0_6;

public class FlaxCrop extends CropBlockTall {

    public static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public FlaxCrop(Properties builder, PlantType type, int growLight, float growMod) {

        super(builder, type, growLight, growMod);
    }

    public FlaxCrop(Properties builder, int growLight, float growMod) {

        super(builder, PlantType.CROP, growLight, growMod);
    }

    public FlaxCrop(Properties builder) {

        super(builder, 9, 1.25F);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {

        int age = state.getValue(getAgeProperty()) - (isTop(state) ? 2 : 0);
        return SHAPE_BY_AGE[MathHelper.clamp(age, 0, SHAPE_BY_AGE.length - 1)];
    }

    @Override
    public IntegerProperty getAgeProperty() {

        return AGE_0_6;
    }

    @Override
    public int getMaxAge() {

        return 6;
    }

    @Override
    protected int getTallAge() {

        return 2;
    }

}
