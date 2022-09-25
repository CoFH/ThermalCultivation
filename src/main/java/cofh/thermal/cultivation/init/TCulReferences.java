package cofh.thermal.cultivation.init;

import cofh.thermal.cultivation.item.WateringCanItem;
import cofh.thermal.cultivation.tileentity.PotionCakeTile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ObjectHolder;

import static cofh.lib.util.constants.ModIds.ID_THERMAL;
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

    @ObjectHolder (ID_WATERING_CAN)
    public static final WateringCanItem WATERING_CAN_ITEM = null;
    // endregion

    // region FOODS
    @ObjectHolder (ID_POTION_CAKE)
    public static final Block POTION_CAKE_BLOCK = null;
    @ObjectHolder (ID_POTION_CAKE)
    public static final BlockEntityType<PotionCakeTile> POTION_CAKE_TILE = null;
    // endregion
}
