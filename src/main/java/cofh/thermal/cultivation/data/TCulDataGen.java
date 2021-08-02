package cofh.thermal.cultivation.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import static cofh.lib.util.constants.Constants.ID_THERMAL_CULTIVATION;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = ID_THERMAL_CULTIVATION)
public class TCulDataGen {

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {

        if (event.includeServer()) {
            registerServerProviders(event);
        }
        if (event.includeClient()) {
            registerClientProviders(event);
        }
    }

    private static void registerServerProviders(GatherDataEvent event) {

        DataGenerator gen = event.getGenerator();
        ExistingFileHelper exFileHelper = event.getExistingFileHelper();

        TCulTagsProvider.Block blockTags = new TCulTagsProvider.Block(gen, exFileHelper);

        gen.addProvider(blockTags);
        gen.addProvider(new TCulTagsProvider.Item(gen, blockTags, exFileHelper));
        gen.addProvider(new TCulTagsProvider.Fluid(gen, exFileHelper));

        gen.addProvider(new TCulLootTableProvider(gen));
        gen.addProvider(new TCulRecipeProvider(gen));
    }

    private static void registerClientProviders(GatherDataEvent event) {

        DataGenerator gen = event.getGenerator();
        ExistingFileHelper exFileHelper = event.getExistingFileHelper();

        gen.addProvider(new TCulBlockStateProvider(gen, exFileHelper));
        gen.addProvider(new TCulItemModelProvider(gen, exFileHelper));
    }

}
