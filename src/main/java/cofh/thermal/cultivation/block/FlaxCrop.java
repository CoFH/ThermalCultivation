package cofh.thermal.cultivation.block;

import cofh.lib.block.impl.crops.CropsBlockTall;
import cofh.lib.util.helpers.MathHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;

import static cofh.lib.util.constants.Constants.AGE_0_6;
import static cofh.lib.util.constants.Constants.TALL_CROPS_BY_AGE_ALT;

public class FlaxCrop extends CropsBlockTall {

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
        return TALL_CROPS_BY_AGE_ALT[MathHelper.clamp(age, 0, TALL_CROPS_BY_AGE_ALT.length - 1)];
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
