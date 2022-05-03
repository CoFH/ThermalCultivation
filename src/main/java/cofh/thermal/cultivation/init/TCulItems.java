package cofh.thermal.cultivation.init;

import cofh.core.item.BlockNamedItemCoFH;
import cofh.core.item.ItemCoFH;
import cofh.thermal.cultivation.item.JarredItem;
import cofh.thermal.cultivation.item.WateringCanItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import static cofh.lib.util.constants.Constants.ID_THERMAL_CULTIVATION;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.util.RegistrationHelper.*;
import static cofh.thermal.cultivation.init.TCulFoods.*;
import static cofh.thermal.cultivation.init.TCulIDs.*;
import static cofh.thermal.lib.common.ThermalItemGroups.THERMAL_FOODS;
import static cofh.thermal.lib.common.ThermalItemGroups.THERMAL_TOOLS;

public class TCulItems {

    private TCulItems() {

    }

    public static void register() {

        registerCrops();
        registerFoods();
        registerTools();
    }

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
        ITEMS.register(ID_HOPS, () -> new ItemCoFH(new Item.Properties().tab(THERMAL_FOODS)));
        ITEMS.register(seeds(ID_HOPS), () -> new ItemCoFH(new Item.Properties().tab(THERMAL_FOODS)));

        registerCropAndSeed(ID_TEA);

        registerSpores(ID_GLOWSTONE_MUSHROOM);
        registerSpores(ID_GUNPOWDER_MUSHROOM);
        registerSpores(ID_REDSTONE_MUSHROOM);
        registerSpores(ID_SLIME_MUSHROOM);

        // OTHER
        ITEMS.register(ID_FROST_MELON_SLICE, () -> new ItemCoFH(new Item.Properties().tab(THERMAL_FOODS).food(FROST_MELON_SLICE).rarity(Rarity.UNCOMMON)).setModId(ID_THERMAL_CULTIVATION));
        ITEMS.register(seeds(ID_FROST_MELON), () -> new BlockNamedItemCoFH(BLOCKS.get(ID_FROST_MELON_STEM), new Item.Properties().tab(THERMAL_FOODS).rarity(Rarity.UNCOMMON)).setModId(ID_THERMAL_CULTIVATION));
    }

    private static void registerFoods() {

        CreativeModeTab group = THERMAL_FOODS;

        //        ITEMS.register("butter", () -> new ItemCoFH(new Item.Properties().group(group)));
        //        ITEMS.register("dough", () -> new ItemCoFH(new Item.Properties().group(group).food(DOUGH)));
        //        ITEMS.register("flour", () -> new ItemCoFH(new Item.Properties().group(group)));

        //        ITEMS.register("coffee", () -> new ItemCoFH(new Item.Properties().group(group).food(COFFEE)));
        //        ITEMS.register("tea", () -> new ItemCoFH(new Item.Properties().group(group).food(TEA)));

        ITEMS.register(ID_JAR, () -> new ItemCoFH(new Item.Properties().tab(THERMAL_TOOLS)));
        ITEMS.register(ID_PEANUT_BUTTER, () -> new JarredItem(new Item.Properties().tab(group)));
        ITEMS.register(ID_JELLY, () -> new JarredItem(new Item.Properties().tab(group)));
        ITEMS.register(ID_TOMATO_SAUCE, () -> new JarredItem(new Item.Properties().tab(group)));

        ITEMS.register(ID_CHEESE_WEDGE, () -> new ItemCoFH(new Item.Properties().tab(group).food(CHEESE)));
        ITEMS.register(ID_GREEN_BEAN_PIE, () -> new ItemCoFH(new Item.Properties().tab(group).food(GREEN_BEAN_PIE)));
        ITEMS.register(ID_PBJ_SANDWICH, () -> new ItemCoFH(new Item.Properties().tab(group).food(PBJ_SANDWICH)));
        ITEMS.register(ID_STUFFED_PEPPER, () -> new ItemCoFH(new Item.Properties().tab(group).food(STUFFED_PEPPER)));
        ITEMS.register(ID_SUSHI_MAKI, () -> new ItemCoFH(new Item.Properties().tab(group).food(SUSHI)));

        ITEMS.register(ID_SPRING_SALAD, () -> new ItemCoFH(new Item.Properties().stacksTo(1).tab(group).food(SPRING_SALAD).rarity(Rarity.UNCOMMON)) {

            @Override
            public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {

                ItemStack itemstack = super.finishUsingItem(stack, worldIn, entityLiving);
                return entityLiving instanceof Player && ((Player) entityLiving).abilities.instabuild ? itemstack : new ItemStack(Items.BOWL);
            }
        }.setModId(ID_THERMAL_CULTIVATION));

        ITEMS.register(ID_HEARTY_STEW, () -> new ItemCoFH(new Item.Properties().stacksTo(1).tab(group).food(HEARTY_STEW).rarity(Rarity.UNCOMMON)) {

            @Override
            public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {

                ItemStack itemstack = super.finishUsingItem(stack, worldIn, entityLiving);
                return entityLiving instanceof Player && ((Player) entityLiving).abilities.instabuild ? itemstack : new ItemStack(Items.BOWL);
            }
        }.setModId(ID_THERMAL_CULTIVATION));

        ITEMS.register(ID_XP_STEW, () -> new ItemCoFH(new Item.Properties().stacksTo(1).tab(group).food(XP_STEW).rarity(Rarity.UNCOMMON)) {

            @Override
            public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {

                ItemStack itemstack = super.finishUsingItem(stack, worldIn, entityLiving);
                return entityLiving instanceof Player && ((Player) entityLiving).abilities.instabuild ? itemstack : new ItemStack(Items.BOWL);
            }
        }.setModId(ID_THERMAL_CULTIVATION));
    }

    private static void registerTools() {

        CreativeModeTab group = THERMAL_TOOLS;

        ITEMS.register(ID_WATERING_CAN, () -> new WateringCanItem(new Item.Properties().stacksTo(1).tab(group), 8000).setModId(ID_THERMAL_CULTIVATION));
    }

}
