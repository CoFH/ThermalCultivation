package cofh.thermal.cultivation.init;

import net.minecraft.block.Block;
import net.minecraftforge.registries.ObjectHolder;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.cultivation.init.TCulIDs.ID_FROST_MELON_STEM;
import static cofh.thermal.cultivation.init.TCulIDs.ID_FROST_MELON_STEM_ATTACHED;

@ObjectHolder(ID_THERMAL)
public class TCulReferences {

    private TCulReferences() {

    }

    // region CROPS
    @ObjectHolder(ID_FROST_MELON_STEM)
    public static final Block FROST_MELON_STEM = null;
    @ObjectHolder(ID_FROST_MELON_STEM_ATTACHED)
    public static final Block FROST_MELON_STEM_ATTACHED = null;
    // endregion
}
