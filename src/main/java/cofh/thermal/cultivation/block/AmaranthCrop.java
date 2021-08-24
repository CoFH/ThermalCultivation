package cofh.thermal.cultivation.block;

import cofh.lib.block.impl.crops.CropsBlockTall;
import cofh.lib.util.helpers.MathHelper;
import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.PlantType;

import static cofh.lib.util.constants.Constants.AGE_0_6;
import static cofh.lib.util.constants.Constants.TALL_CROPS_BY_AGE;

public class AmaranthCrop extends CropsBlockTall {

    public AmaranthCrop(Properties builder, PlantType type, int growLight, float growMod) {

        super(builder, type, growLight, growMod);
    }

    public AmaranthCrop(Properties builder, int growLight, float growMod) {

        super(builder, PlantType.CROP, growLight, growMod);
    }

    public AmaranthCrop(Properties builder) {

        super(builder, 9, 1.25F);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        int age = state.get(getAgeProperty()) - (isTop(state) ? 3 : 0);
        return TALL_CROPS_BY_AGE[MathHelper.clamp(age, 0, TALL_CROPS_BY_AGE.length - 1)];
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

        return 4;
    }

}
