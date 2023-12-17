package cofh.thermal.cultivation.init.data.providers;

import cofh.lib.init.data.LootTableProviderCoFH;
import cofh.thermal.cultivation.init.data.tables.TCulBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;

public class TCulLootTableProvider extends LootTableProviderCoFH {

    public TCulLootTableProvider(PackOutput output) {

        super(output, List.of(
                new SubProviderEntry(TCulBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }

}