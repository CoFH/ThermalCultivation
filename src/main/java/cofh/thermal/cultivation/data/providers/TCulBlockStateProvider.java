package cofh.thermal.cultivation.data.providers;

import cofh.lib.data.BlockStateProviderCoFH;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

import static cofh.lib.util.constants.ModIds.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.util.RegistrationHelper.block;
import static cofh.thermal.cultivation.init.TCulIDs.*;

public class TCulBlockStateProvider extends BlockStateProviderCoFH {

    public TCulBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {

        super(output, ID_THERMAL, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        var reg = BLOCKS;

        axisBlock(reg.getSup(block(ID_AMARANTH)), "amaranth_block");
        axisBlock(reg.getSup(block(ID_BARLEY)), "barley_block");
        axisBlock(reg.getSup(block(ID_FLAX)), "flax_block");
    }

}
