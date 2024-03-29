package cofh.thermal.cultivation;

import cofh.thermal.cultivation.config.TCulToolConfig;
import cofh.thermal.cultivation.config.ThermalCropConfig;
import cofh.thermal.cultivation.init.TCulBlocks;
import cofh.thermal.cultivation.init.TCulItems;
import cofh.thermal.cultivation.init.TCulTileEntities;
import cofh.thermal.cultivation.loot.GrassLootModifier;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static cofh.lib.util.constants.ModIds.ID_THERMAL_CULTIVATION;
import static cofh.thermal.core.ThermalCore.*;
import static cofh.thermal.cultivation.init.TCulIDs.*;
import static cofh.thermal.lib.common.ThermalFlags.*;
import static cofh.thermal.lib.common.ThermalIDs.*;

@Mod (ID_THERMAL_CULTIVATION)
public class ThermalCultivation {

    public ThermalCultivation() {

        setFeatureFlags();

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CONFIG_MANAGER.register(modEventBus)
                .addServerConfig(new ThermalCropConfig())
                .addServerConfig(new TCulToolConfig());

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        TCulBlocks.register();
        TCulItems.register();

        TCulTileEntities.register();

        LOOT_SERIALIZERS.register("seeds_from_grass", () -> GrassLootModifier.CODEC);
    }

    private void setFeatureFlags() {

        setFlag(FLAG_RESOURCE_APATITE, true);

        setFlag(FLAG_AREA_AUGMENTS, true);

        setFlag(FLAG_BEEKEEPER_ARMOR, true);

        setFlag(FLAG_PHYTOGRO_EXPLOSIVES, true);

        setFlag(ID_DEVICE_HIVE_EXTRACTOR, true);
        setFlag(ID_DEVICE_TREE_EXTRACTOR, true);
        setFlag(ID_DEVICE_FISHER, true);
        setFlag(ID_DEVICE_COMPOSTER, true);
        setFlag(ID_DEVICE_SOIL_INFUSER, true);
    }

    // region INITIALIZATION
    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(TCulBlocks::setup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        event.enqueueWork(this::registerRenderLayers);
    }
    // endregion

    // region HELPERS
    private void registerRenderLayers() {

        RenderType cutout = RenderType.cutout();

        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_AMARANTH), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_BARLEY), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_CORN), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_FLAX), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_ONION), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_RADISH), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_RICE), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_SADIROOT), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_SPINACH), cutout);

        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_BELL_PEPPER), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_EGGPLANT), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_GREEN_BEAN), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_PEANUT), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_STRAWBERRY), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_TOMATO), cutout);

        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_COFFEE), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_TEA), cutout);

        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_GLOWSTONE_MUSHROOM), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_GUNPOWDER_MUSHROOM), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_REDSTONE_MUSHROOM), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_SLIME_MUSHROOM), cutout);

        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_FROST_MELON_STEM), cutout);
        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_FROST_MELON_STEM_ATTACHED), cutout);

        ItemBlockRenderTypes.setRenderLayer(BLOCKS.get(ID_POTION_CAKE), cutout);
    }
    // endregion
}
