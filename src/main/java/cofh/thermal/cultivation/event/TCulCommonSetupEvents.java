package cofh.thermal.cultivation.event;

import cofh.thermal.lib.common.ThermalConfig;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

import static cofh.lib.util.constants.Constants.ID_THERMAL_CULTIVATION;
import static cofh.lib.util.helpers.ItemHelper.cloneStack;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.util.RegistrationHelper.seeds;
import static cofh.thermal.cultivation.init.TCulIDs.*;

@Mod.EventBusSubscriber (modid = ID_THERMAL_CULTIVATION)
public class TCulCommonSetupEvents {

    private TCulCommonSetupEvents() {

    }

    @SubscribeEvent
    public static void setupVillagerTrades(final VillagerTradesEvent event) {

        if (!ThermalConfig.enableVillagerTrades.get()) {
            return;
        }
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            List<VillagerTrades.ItemListing> noviceTrades = trades.get(1);
            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_AMARANTH), 20), cloneStack(Items.EMERALD), 16, 2, 0.05F));
            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_BARLEY), 20), cloneStack(Items.EMERALD), 16, 2, 0.05F));
            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_CORN), 22), cloneStack(Items.EMERALD), 16, 2, 0.05F));
            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_ONION), 24), cloneStack(Items.EMERALD), 16, 2, 0.05F));
            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_RADISH), 22), cloneStack(Items.EMERALD), 16, 2, 0.05F));
            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_RICE), 20), cloneStack(Items.EMERALD), 16, 2, 0.05F));
            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_SADIROOT), 12), cloneStack(Items.EMERALD), 16, 2, 0.05F));
            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_SPINACH), 15), cloneStack(Items.EMERALD), 16, 2, 0.05F));

            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_BELL_PEPPER), 23), cloneStack(Items.EMERALD), 16, 2, 0.05F));
            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_EGGPLANT), 20), cloneStack(Items.EMERALD), 16, 2, 0.05F));
            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_GREEN_BEAN), 22), cloneStack(Items.EMERALD), 16, 2, 0.05F));
            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_PEANUT), 18), cloneStack(Items.EMERALD), 16, 2, 0.05F));
            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_STRAWBERRY), 24), cloneStack(Items.EMERALD), 16, 2, 0.05F));
            noviceTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_TOMATO), 22), cloneStack(Items.EMERALD), 16, 2, 0.05F));

            List<VillagerTrades.ItemListing> apprenticeTrades = trades.get(2);
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_AMARANTH)), 2), 12, 5, 0.05F));
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_BARLEY)), 2), 12, 5, 0.05F));
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_CORN)), 2), 12, 5, 0.05F));
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_FLAX)), 2), 12, 5, 0.05F));
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_ONION)), 2), 12, 5, 0.05F));
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_RADISH)), 2), 12, 5, 0.05F));
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_RICE)), 2), 12, 5, 0.05F));
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_SADIROOT)), 2), 12, 5, 0.05F));
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_SPINACH)), 2), 12, 5, 0.05F));

            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_BELL_PEPPER)), 2), 12, 5, 0.05F));
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_EGGPLANT)), 2), 12, 5, 0.05F));
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_GREEN_BEAN)), 2), 12, 5, 0.05F));
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_PEANUT)), 2), 12, 5, 0.05F));
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_STRAWBERRY)), 2), 12, 5, 0.05F));
            apprenticeTrades.add(new BasicItemListing(cloneStack(Items.EMERALD), cloneStack(ITEMS.get(seeds(ID_TOMATO)), 2), 12, 5, 0.05F));

            List<VillagerTrades.ItemListing> journeymanTrades = trades.get(3);
            journeymanTrades.add(new BasicItemListing(cloneStack(ITEMS.get(ID_FROST_MELON), 3), cloneStack(Items.EMERALD, 1), 12, 20, 0.05F));

            List<VillagerTrades.ItemListing> expertTrades = trades.get(4);
            expertTrades.add(new BasicItemListing(cloneStack(Items.MELON_SEEDS, 2), cloneStack(Items.EMERALD, 4), cloneStack(ITEMS.get(seeds(ID_FROST_MELON)), 2), 8, 15, 0.05F));
        }
    }

    //    @SubscribeEvent
    //    public static void setupWandererTrades(final WandererTradesEvent event) {
    //
    //        if (!ThermalConfig.enableWandererTrades.get()) {
    //            return;
    //        }
    //        event.getRareTrades().add(new BasicTrade(cloneStack(Items.EMERALD, 8), cloneStack(ITEMS.get(ID_RUBBERWOOD_SAPLING)), 8, 1, 0.05F));
    //    }

}
