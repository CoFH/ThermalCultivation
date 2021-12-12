package cofh.thermal.cultivation.init;

import cofh.thermal.cultivation.tileentity.PotionCakeTile;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.cultivation.init.TCulIDs.*;

@ObjectHolder (ID_THERMAL)
public class TCulReferences {

    private TCulReferences() {

    }

    // region CROPS
    @ObjectHolder (ID_FROST_MELON_STEM)
    public static final Block FROST_MELON_STEM = null;
    @ObjectHolder (ID_FROST_MELON_STEM_ATTACHED)
    public static final Block FROST_MELON_STEM_ATTACHED = null;
    // endregion

    // region ITEMS
    @ObjectHolder (ID_JAR)
    public static final Item JAR_ITEM = null;
    // endregion

    // region FOODS
    @ObjectHolder (ID_POTION_CAKE)
    public static final Block POTION_CAKE_BLOCK = null;
    @ObjectHolder (ID_POTION_CAKE)
    public static final TileEntityType<PotionCakeTile> POTION_CAKE_TILE = null;
    // endregion
}
