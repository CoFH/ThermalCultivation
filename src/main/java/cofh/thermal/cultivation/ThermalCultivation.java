package cofh.thermal.cultivation;

import cofh.thermal.cultivation.init.TCulBlocks;
import cofh.thermal.cultivation.init.TCulItems;
import cofh.thermal.cultivation.loot.GrassLootModifier;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static cofh.lib.util.constants.Constants.ID_THERMAL_CULTIVATION;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.LOOT_SERIALIZERS;
import static cofh.thermal.cultivation.init.TCulIDs.*;
import static cofh.thermal.lib.common.ThermalFlags.*;
import static cofh.thermal.lib.common.ThermalIDs.*;

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

        event.enqueueWork(TCulBlocks::setup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        this.registerRenderLayers();
    }
    // endregion

    // region HELPERS
    private void registerRenderLayers() {

        RenderType cutout = RenderType.getCutout();

        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_AMARANTH), cutout);
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
