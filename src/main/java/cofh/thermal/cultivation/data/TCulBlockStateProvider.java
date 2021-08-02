package cofh.thermal.cultivation.data;

import cofh.lib.data.BlockStateProviderCoFH;
import cofh.lib.util.DeferredRegisterCoFH;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.util.RegistrationHelper.block;
import static cofh.thermal.cultivation.init.TCulIDs.ID_BARLEY;
import static cofh.thermal.cultivation.init.TCulIDs.ID_FLAX;

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

        DeferredRegisterCoFH<Block> reg = BLOCKS;

        axisBlock(reg.getSup(block(ID_BARLEY)), "barley_block", STORAGE);
        axisBlock(reg.getSup(block(ID_FLAX)), "flax_block", STORAGE);
    }

}
