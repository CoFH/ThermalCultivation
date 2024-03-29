package cofh.thermal.cultivation.data;

import cofh.lib.data.BlockStateProviderCoFH;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import static cofh.lib.util.constants.ModIds.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.util.RegistrationHelper.block;
import static cofh.thermal.cultivation.init.TCulIDs.*;

public class TCulBlockStateProvider extends BlockStateProviderCoFH {

    public TCulBlockStateProvider(DataGenerator gen, ExistingFileHelper existingFileHelper) {

        super(gen, ID_THERMAL, existingFileHelper);
    }

    @Override
    public String getName() {

        return "Thermal Cultivation: BlockStates";
    }

    @Override
    protected void registerStatesAndModels() {

        var reg = BLOCKS;

        axisBlock(reg.getSup(block(ID_AMARANTH)), "amaranth_block");
        axisBlock(reg.getSup(block(ID_BARLEY)), "barley_block");
        axisBlock(reg.getSup(block(ID_FLAX)), "flax_block");
    }

}
