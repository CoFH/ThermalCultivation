package cofh.thermal.cultivation.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import static cofh.lib.util.constants.ModIds.ID_THERMAL_CULTIVATION;

@Mod.EventBusSubscriber (bus = Mod.EventBusSubscriber.Bus.MOD, modid = ID_THERMAL_CULTIVATION)
public class TCulDataGen {

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {

        DataGenerator gen = event.getGenerator();
        ExistingFileHelper exFileHelper = event.getExistingFileHelper();

        TCulTagsProvider.Block blockTags = new TCulTagsProvider.Block(gen, exFileHelper);

        gen.addProvider(event.includeServer(), blockTags);
        gen.addProvider(event.includeServer(), new TCulTagsProvider.Item(gen, blockTags, exFileHelper));
        gen.addProvider(event.includeServer(), new TCulTagsProvider.Fluid(gen, exFileHelper));

        gen.addProvider(event.includeServer(), new TCulLootTableProvider(gen));
        gen.addProvider(event.includeServer(), new TCulRecipeProvider(gen));

        gen.addProvider(event.includeClient(), new TCulBlockStateProvider(gen, exFileHelper));
        gen.addProvider(event.includeClient(), new TCulItemModelProvider(gen, exFileHelper));
    }

}
