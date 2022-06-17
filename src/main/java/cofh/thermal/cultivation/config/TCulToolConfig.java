package cofh.thermal.cultivation.config;

import cofh.lib.config.IBaseConfig;
import cofh.thermal.cultivation.item.WateringCanItem;
import net.minecraftforge.common.ForgeConfigSpec;

import static cofh.thermal.cultivation.init.TCulReferences.WATERING_CAN_ITEM;

public class TCulToolConfig implements IBaseConfig {

    @Override
    public void apply(ForgeConfigSpec.Builder builder) {

        builder.push("Tools");

        builder.push("Watering Can");

        wateringCanCapacity = builder
                .comment("This sets the maximum base fluid capacity for the Watering Can.")
                .defineInRange("Base Capacity", 4000, 1000, 10000000);

        wateringCanFakePlayers = builder
                .comment("If TRUE, the Watering Can can be used by Fake Players.")
                .define("Allow Fake Players", WateringCanItem.allowFakePlayers);

        wateringCanSourceBlocks = builder
                .comment("If TRUE, the Watering Can consumes source blocks when refilling.")
                .define("Consume Source Blocks", WateringCanItem.removeSourceBlocks);

        builder.pop();

        builder.pop();
    }

    @Override
    public void refresh() {

        if (WATERING_CAN_ITEM == null) {
            return;
        }
        WATERING_CAN_ITEM.setFluidCapacity(wateringCanCapacity.get());

        WateringCanItem.allowFakePlayers = wateringCanFakePlayers.get();
        WateringCanItem.removeSourceBlocks = wateringCanSourceBlocks.get();
    }

    // region CONFIG VARIABLES
    private ForgeConfigSpec.IntValue wateringCanCapacity;
    private ForgeConfigSpec.BooleanValue wateringCanFakePlayers;
    private ForgeConfigSpec.BooleanValue wateringCanSourceBlocks;
    // endregion
}
