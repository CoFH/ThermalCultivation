package cofh.thermal.cultivation.init.registries;

import cofh.core.common.item.BlockNamedItemCoFH;
import cofh.core.common.item.ItemCoFH;
import cofh.thermal.cultivation.common.item.JarredItem;
import cofh.thermal.cultivation.common.item.WateringCanItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import static cofh.lib.util.constants.ModIds.ID_THERMAL_CULTIVATION;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.init.registries.ThermalCreativeTabs.foodsTab;
import static cofh.thermal.core.init.registries.ThermalCreativeTabs.toolsTab;
import static cofh.thermal.core.util.RegistrationHelper.*;
import static cofh.thermal.cultivation.init.registries.TCulFoods.*;
import static cofh.thermal.cultivation.init.registries.TCulIDs.*;

public class TCulItems {

    private TCulItems() {

    }

    public static void register() {

        registerCrops();
        registerFoods();
        registerTools();
    }

    // region HELPERS
    private static void registerCrops() {

        // ANNUAL
        registerCropAndSeed(ID_AMARANTH);
        registerCropAndSeed(ID_BARLEY);
        registerCropAndSeed(ID_CORN, CORN);
        registerCropAndSeed(ID_FLAX);
        registerCropAndSeed(ID_ONION, ONION);
        registerCropAndSeed(ID_RADISH, RADISH);
        registerCropAndSeed(ID_RICE);
        registerCropAndSeed(ID_SADIROOT);
        registerCropAndSeed(ID_SPINACH, SPINACH);

        // PERENNIAL
        registerCropAndSeed(ID_BELL_PEPPER, BELL_PEPPER);
        registerCropAndSeed(ID_EGGPLANT, EGGPLANT);
        registerCropAndSeed(ID_GREEN_BEAN, GREEN_BEAN);
        registerCropAndSeed(ID_PEANUT, PEANUT);
        registerCropAndSeed(ID_STRAWBERRY, STRAWBERRY);
        registerCropAndSeed(ID_TOMATO, TOMATO);

        // BREWING
        registerCropAndSeed(ID_COFFEE, COFFEE_CHERRY);

        // TODO: Implement Hops
        // registerCropAndSeed(ID_HOPS);
        foodsTab(registerItem(ID_HOPS, () -> new ItemCoFH(new Item.Properties()).setModId(ID_THERMAL_CULTIVATION)));
        foodsTab(registerItem(seeds(ID_HOPS), () -> new ItemCoFH(new Item.Properties()).setModId(ID_THERMAL_CULTIVATION)));

        registerCropAndSeed(ID_TEA);

        registerSpores(ID_GLOWSTONE_MUSHROOM);
        registerSpores(ID_GUNPOWDER_MUSHROOM);
        registerSpores(ID_REDSTONE_MUSHROOM);
        registerSpores(ID_SLIME_MUSHROOM);

        // OTHER
        foodsTab(registerItem(ID_FROST_MELON_SLICE, () -> new ItemCoFH(new Item.Properties().food(FROST_MELON_SLICE).rarity(Rarity.UNCOMMON)).setModId(ID_THERMAL_CULTIVATION)));
        foodsTab(registerItem(seeds(ID_FROST_MELON), () -> new BlockNamedItemCoFH(BLOCKS.get(ID_FROST_MELON_STEM), new Item.Properties().rarity(Rarity.UNCOMMON)).setModId(ID_THERMAL_CULTIVATION)));
    }

    private static void registerFoods() {

        //        ITEMS.register("butter", () -> new ItemCoFH(new Item.Properties().group(group)));
        //        ITEMS.register("dough", () -> new ItemCoFH(new Item.Properties().group(group).food(DOUGH)));
        //        ITEMS.register("flour", () -> new ItemCoFH(new Item.Properties().group(group)));

        //        ITEMS.register("coffee", () -> new ItemCoFH(new Item.Properties().group(group).food(COFFEE)));
        //        ITEMS.register("tea", () -> new ItemCoFH(new Item.Properties().group(group).food(TEA)));

        foodsTab(registerItem(ID_JAR, () -> new ItemCoFH(new Item.Properties()).setModId(ID_THERMAL_CULTIVATION)));
        foodsTab(registerItem(ID_PEANUT_BUTTER, () -> new JarredItem(new Item.Properties()).setModId(ID_THERMAL_CULTIVATION)));
        foodsTab(registerItem(ID_JELLY, () -> new JarredItem(new Item.Properties()).setModId(ID_THERMAL_CULTIVATION)));
        foodsTab(registerItem(ID_TOMATO_SAUCE, () -> new JarredItem(new Item.Properties()).setModId(ID_THERMAL_CULTIVATION)));

        foodsTab(registerItem(ID_COOKED_MUSHROOM, () -> new ItemCoFH(new Item.Properties().food(COOKED_MUSHROOM)).setModId(ID_THERMAL_CULTIVATION)));
        foodsTab(registerItem(ID_COOKED_CORN, () -> new ItemCoFH(new Item.Properties().food(COOKED_CORN)).setModId(ID_THERMAL_CULTIVATION)));
        foodsTab(registerItem(ID_COOKED_EGGPLANT, () -> new ItemCoFH(new Item.Properties().food(COOKED_EGGPLANT)).setModId(ID_THERMAL_CULTIVATION)));

        foodsTab(registerItem(ID_CHEESE_WEDGE, () -> new ItemCoFH(new Item.Properties().food(CHEESE)).setModId(ID_THERMAL_CULTIVATION)));
        foodsTab(registerItem(ID_GREEN_BEAN_PIE, () -> new ItemCoFH(new Item.Properties().food(GREEN_BEAN_PIE)).setModId(ID_THERMAL_CULTIVATION)));
        foodsTab(registerItem(ID_PBJ_SANDWICH, () -> new ItemCoFH(new Item.Properties().food(PBJ_SANDWICH)).setModId(ID_THERMAL_CULTIVATION)));
        foodsTab(registerItem(ID_STUFFED_PEPPER, () -> new ItemCoFH(new Item.Properties().food(STUFFED_PEPPER)).setModId(ID_THERMAL_CULTIVATION)));
        foodsTab(registerItem(ID_SUSHI_MAKI, () -> new ItemCoFH(new Item.Properties().food(SUSHI)).setModId(ID_THERMAL_CULTIVATION)));

        registerBowlFoodItem(ID_SPRING_SALAD, SPRING_SALAD, Rarity.UNCOMMON);
        registerBowlFoodItem(ID_HEARTY_STEW, HEARTY_STEW, Rarity.UNCOMMON);
        registerBowlFoodItem(ID_XP_STEW, XP_STEW, Rarity.UNCOMMON);
    }

    private static void registerTools() {

        toolsTab(registerItem(ID_WATERING_CAN, () -> new WateringCanItem(new Item.Properties().stacksTo(1), 8000).setModId(ID_THERMAL_CULTIVATION)));
    }
    // endregion
}
