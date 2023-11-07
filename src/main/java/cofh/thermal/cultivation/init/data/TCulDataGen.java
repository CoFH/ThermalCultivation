package cofh.thermal.cultivation.init.data;

import cofh.thermal.cultivation.init.data.providers.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cofh.lib.util.constants.ModIds.ID_THERMAL_CULTIVATION;

@Mod.EventBusSubscriber (bus = Mod.EventBusSubscriber.Bus.MOD, modid = ID_THERMAL_CULTIVATION)
public class TCulDataGen {

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {

        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper exFileHelper = event.getExistingFileHelper();

        TCulTagsProvider.Block blockTags = new TCulTagsProvider.Block(output, event.getLookupProvider(), exFileHelper);
        gen.addProvider(event.includeServer(), blockTags);
        gen.addProvider(event.includeServer(), new TCulTagsProvider.Item(output, event.getLookupProvider(), blockTags.contentsGetter(), exFileHelper));
        gen.addProvider(event.includeServer(), new TCulTagsProvider.Fluid(output, event.getLookupProvider(), exFileHelper));

        gen.addProvider(event.includeServer(), new TCulLootTableProvider(output));
        gen.addProvider(event.includeServer(), new TCulRecipeProvider(output));

        gen.addProvider(event.includeClient(), new TCulBlockStateProvider(output, exFileHelper));
        gen.addProvider(event.includeClient(), new TCulItemModelProvider(output, exFileHelper));
    }

}
