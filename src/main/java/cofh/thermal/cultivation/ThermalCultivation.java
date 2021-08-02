package cofh.thermal.cultivation;

import cofh.thermal.cultivation.init.TCulBlocks;
import cofh.thermal.cultivation.init.TCulItems;
import cofh.thermal.cultivation.loot.GrassLootModifier;
import net.minecraft.block.ComposterBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.HoeItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static cofh.lib.util.constants.Constants.ID_THERMAL_CULTIVATION;
import static cofh.thermal.core.ThermalCore.*;
import static cofh.thermal.core.init.TCoreIDs.*;
import static cofh.thermal.core.util.RegistrationHelper.seeds;
import static cofh.thermal.cultivation.init.TCulIDs.*;
import static cofh.thermal.lib.common.ThermalFlags.*;

@Mod(ID_THERMAL_CULTIVATION)
public class ThermalCultivation {

    public ThermalCultivation() {

        setFeatureFlags();

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        TCulBlocks.register();
        TCulItems.register();

        LOOT_SERIALIZERS.register("seeds_from_grass", GrassLootModifier.Serializer::new);
    }

    private void setFeatureFlags() {

        setFlag(FLAG_RESOURCE_APATITE, true);

        setFlag(FLAG_BEEKEEPER_ARMOR, true);

        setFlag(FLAG_PHYTOGRO_EXPLOSIVES, true);

        setFlag(ID_DEVICE_HIVE_EXTRACTOR, true);
        setFlag(ID_DEVICE_TREE_EXTRACTOR, true);
        setFlag(ID_DEVICE_FISHER, true);
        setFlag(ID_DEVICE_SOIL_INFUSER, true);
    }

    // region INITIALIZATION
    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            // CROPS
            {
                float chance = 0.65F;

                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_BARLEY));
                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_CORN));
                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_FLAX));
                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_ONION));
                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_RADISH));
                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_RICE));
                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_SADIROOT));
                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_SPINACH));

                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_BELL_PEPPER));
                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_EGGPLANT));
                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_GREEN_BEAN));
                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_PEANUT));
                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_STRAWBERRY));
                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_TOMATO));

                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_COFFEE));
                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_TEA));

                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_FROST_MELON));
            }
            {
                float chance = 0.5F;

                ComposterBlock.registerCompostable(chance, ITEMS.get(ID_FROST_MELON_SLICE));
            }
            // SEEDS
            {
                float chance = 0.3F;

                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_BARLEY)));
                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_CORN)));
                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_FLAX)));
                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_ONION)));
                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_RADISH)));
                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_RICE)));
                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_SADIROOT)));
                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_SPINACH)));

                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_BELL_PEPPER)));
                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_EGGPLANT)));
                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_GREEN_BEAN)));
                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_PEANUT)));
                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_STRAWBERRY)));
                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_TOMATO)));

                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_COFFEE)));
                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_TEA)));

                ComposterBlock.registerCompostable(chance, ITEMS.get(seeds(ID_FROST_MELON)));
            }
            HoeItem.HOE_LOOKUP.put(BLOCKS.get(ID_PHYTOSOIL), BLOCKS.get(ID_PHYTOSOIL_TILLED).getDefaultState());
        });
        event.enqueueWork(TCulBlocks::setup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        this.registerRenderLayers();
    }
    // endregion

    // region HELPERS
    private void registerRenderLayers() {

        RenderType cutout = RenderType.getCutout();

        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_BARLEY), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_CORN), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_FLAX), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_ONION), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_RADISH), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_RICE), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_SADIROOT), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_SPINACH), cutout);

        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_BELL_PEPPER), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_EGGPLANT), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_GREEN_BEAN), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_PEANUT), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_STRAWBERRY), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_TOMATO), cutout);

        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_COFFEE), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_TEA), cutout);

        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_GLOWSTONE_MUSHROOM), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_GUNPOWDER_MUSHROOM), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_REDSTONE_MUSHROOM), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_SLIME_MUSHROOM), cutout);

        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_FROST_MELON_STEM), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_FROST_MELON_STEM_ATTACHED), cutout);
    }
    // endregion
}
