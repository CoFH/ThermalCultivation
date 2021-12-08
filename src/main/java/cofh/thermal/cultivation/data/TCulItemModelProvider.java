package cofh.thermal.cultivation.data;

import cofh.lib.data.ItemModelProviderCoFH;
import cofh.lib.util.DeferredRegisterCoFH;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.util.RegistrationHelper.*;
import static cofh.thermal.cultivation.init.TCulIDs.*;

public class TCulItemModelProvider extends ItemModelProviderCoFH {

    public TCulItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {

        super(generator, ID_THERMAL, existingFileHelper);
    }

    @Override
    public String getName() {

        return "Thermal Cultivation: Item Models";
    }

    @Override
    protected void registerModels() {

        registerBlockItemModels();

        DeferredRegisterCoFH<Item> reg = ITEMS;

        // CROPS
        generated(reg.getSup(ID_AMARANTH));
        generated(reg.getSup(ID_BARLEY));
        generated(reg.getSup(ID_BELL_PEPPER));
        generated(reg.getSup(ID_COFFEE));
        generated(reg.getSup(ID_CORN));
        generated(reg.getSup(ID_EGGPLANT));
        generated(reg.getSup(ID_FLAX));
        generated(reg.getSup(ID_GREEN_BEAN));
        generated(reg.getSup(ID_HOPS));
        generated(reg.getSup(ID_ONION));
        generated(reg.getSup(ID_PEANUT));
        generated(reg.getSup(ID_RADISH));
        generated(reg.getSup(ID_RICE));
        generated(reg.getSup(ID_SADIROOT));
        generated(reg.getSup(ID_SPINACH));
        generated(reg.getSup(ID_STRAWBERRY));
        generated(reg.getSup(ID_TEA));
        generated(reg.getSup(ID_TOMATO));

        // SEEDS
        generated(reg.getSup(seeds(ID_AMARANTH)));
        generated(reg.getSup(seeds(ID_BARLEY)));
        generated(reg.getSup(seeds(ID_BELL_PEPPER)));
        generated(reg.getSup(seeds(ID_COFFEE)));
        generated(reg.getSup(seeds(ID_CORN)));
        generated(reg.getSup(seeds(ID_EGGPLANT)));
        generated(reg.getSup(seeds(ID_FLAX)));
        generated(reg.getSup(seeds(ID_FROST_MELON)));
        generated(reg.getSup(seeds(ID_GREEN_BEAN)));
        generated(reg.getSup(seeds(ID_HOPS)));
        generated(reg.getSup(seeds(ID_ONION)));
        generated(reg.getSup(seeds(ID_PEANUT)));
        generated(reg.getSup(seeds(ID_RADISH)));
        generated(reg.getSup(seeds(ID_RICE)));
        generated(reg.getSup(seeds(ID_SADIROOT)));
        generated(reg.getSup(seeds(ID_SPINACH)));
        generated(reg.getSup(seeds(ID_STRAWBERRY)));
        generated(reg.getSup(seeds(ID_TEA)));
        generated(reg.getSup(seeds(ID_TOMATO)));

        // MUSHROOMS
        generated(reg.getSup(spores(ID_GLOWSTONE_MUSHROOM)));
        generated(reg.getSup(spores(ID_GUNPOWDER_MUSHROOM)));
        generated(reg.getSup(spores(ID_REDSTONE_MUSHROOM)));
        generated(reg.getSup(spores(ID_SLIME_MUSHROOM)));

        // generated(reg.getSup("dough"));
        // generated(reg.getSup("flour"));

        generated(reg.getSup(ID_JAR));
        generated(reg.getSup(ID_PEANUT_BUTTER));
        generated(reg.getSup(ID_JELLY));
        generated(reg.getSup(ID_TOMATO_SAUCE));

        // FOODS
        generated(reg.getSup(ID_CHEESE_WEDGE));
        generated(reg.getSup(ID_FROST_MELON_SLICE));
        generated(reg.getSup(ID_GREEN_BEAN_PIE));
        generated(reg.getSup(ID_PBJ_SANDWICH));
        generated(reg.getSup(ID_STUFFED_PEPPER));
        generated(reg.getSup(ID_SUSHI_MAKI));

        generated(reg.getSup(ID_SPRING_SALAD));
        generated(reg.getSup(ID_HEARTY_STEW));
        generated(reg.getSup(ID_XP_STEW));

        generated(reg.getSup(ID_CARROT_CAKE));
        generated(reg.getSup(ID_CHEESE_WHEEL));
        generated(reg.getSup(ID_CHOCOLATE_CAKE));
        generated(reg.getSup(ID_POTION_CAKE));
        generated(reg.getSup(ID_SPICE_CAKE));
        generated(reg.getSup(ID_STUFFED_PUMPKIN));
    }

    private void registerBlockItemModels() {

        DeferredRegisterCoFH<Block> reg = BLOCKS;

        blockItem(reg.getSup(block(ID_AMARANTH)));
        blockItem(reg.getSup(block(ID_BARLEY)));
        blockItem(reg.getSup(block(ID_BELL_PEPPER)));
        blockItem(reg.getSup(block(ID_COFFEE)));
        blockItem(reg.getSup(block(ID_CORN)));
        blockItem(reg.getSup(block(ID_EGGPLANT)));
        blockItem(reg.getSup(block(ID_FLAX)));
        blockItem(reg.getSup(block(ID_GREEN_BEAN)));
        blockItem(reg.getSup(block(ID_HOPS)));
        blockItem(reg.getSup(block(ID_ONION)));
        blockItem(reg.getSup(block(ID_PEANUT)));
        blockItem(reg.getSup(block(ID_RADISH)));
        blockItem(reg.getSup(block(ID_RICE)));
        blockItem(reg.getSup(block(ID_SADIROOT)));
        blockItem(reg.getSup(block(ID_SPINACH)));
        blockItem(reg.getSup(block(ID_STRAWBERRY)));
        blockItem(reg.getSup(block(ID_TEA)));
        blockItem(reg.getSup(block(ID_TOMATO)));
    }

}
