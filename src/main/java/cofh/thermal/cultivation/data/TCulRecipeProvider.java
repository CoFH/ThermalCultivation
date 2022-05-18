package cofh.thermal.cultivation.data;

import cofh.lib.data.RecipeProviderCoFH;
import cofh.lib.util.references.CoFHTags;
import cofh.thermal.lib.common.ThermalFlags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.util.RegistrationHelper.*;
import static cofh.thermal.cultivation.init.TCulIDs.*;

public class TCulRecipeProvider extends RecipeProviderCoFH {

    public TCulRecipeProvider(DataGenerator generatorIn) {

        super(generatorIn, ID_THERMAL);
        manager = ThermalFlags.manager();
    }

    @Override
    public String getName() {

        return "Thermal Cultivation: Recipes";
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        generateFoodRecipes(consumer);

        var reg = ITEMS;

        ShapedRecipeBuilder.shaped(reg.get(ID_WATERING_CAN))
                .define('B', Items.BUCKET)
                .define('C', Tags.Items.INGOTS_COPPER)
                .pattern("C  ")
                .pattern("CBC")
                .pattern(" C ")
                .unlockedBy("has_bucket", has(Items.BUCKET))
                .save(consumer);

        ShapedRecipeBuilder.shaped(reg.get(ID_JAR), 8)
                .define('G', Tags.Items.GLASS)
                .define('P', ItemTags.PLANKS)
                .pattern("PP")
                .pattern("GG")
                .pattern("GG")
                .unlockedBy("has_glass", has(Tags.Items.GLASS))
                .save(consumer, ID_THERMAL + ":jar_4");


        ShapedRecipeBuilder.shaped(reg.get(ID_PHYTOSOIL))
                .define('C', Items.CHARCOAL)
                .define('P', reg.get("phytogro"))
                .define('X', Blocks.DIRT)
                .pattern("CPC")
                .pattern("PXP")
                .pattern("CPC")
                .unlockedBy("has_phytogro", has(reg.get("phytogro")))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(Items.STRING)
                .requires(reg.get(ID_FLAX))
                .unlockedBy("has_flax", has(reg.get(ID_FLAX)))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(seeds(ID_FROST_MELON)))
                .requires(reg.get(ID_FROST_MELON_SLICE))
                .unlockedBy("has_frost_melon", has(reg.get(ID_FROST_MELON_SLICE)))
                .save(consumer);

        ShapedRecipeBuilder.shaped(reg.get(ID_FROST_MELON))
                .define('M', reg.get(ID_FROST_MELON_SLICE))
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .unlockedBy("has_frost_melon", has(reg.get(ID_FROST_MELON_SLICE)))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(spores(ID_GLOWSTONE_MUSHROOM)))
                .requires(Items.RED_MUSHROOM)
                .requires(Tags.Items.DUSTS_GLOWSTONE)
                .requires(reg.get("phytogro"))
                .requires(Items.EXPERIENCE_BOTTLE)
                .unlockedBy("has_glowstone_dust", has(Tags.Items.DUSTS_GLOWSTONE))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(spores(ID_GUNPOWDER_MUSHROOM)))
                .requires(Items.BROWN_MUSHROOM)
                .requires(Items.GUNPOWDER)
                .requires(reg.get("phytogro"))
                .requires(Items.EXPERIENCE_BOTTLE)
                .unlockedBy("has_gunpowder", has(Items.GUNPOWDER))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(spores(ID_REDSTONE_MUSHROOM)))
                .requires(Items.RED_MUSHROOM)
                .requires(Tags.Items.DUSTS_REDSTONE)
                .requires(reg.get("phytogro"))
                .requires(Items.EXPERIENCE_BOTTLE)
                .unlockedBy("has_redstone_dust", has(Tags.Items.DUSTS_REDSTONE))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(spores(ID_SLIME_MUSHROOM)))
                .requires(Items.BROWN_MUSHROOM)
                .requires(Tags.Items.SLIMEBALLS)
                .requires(reg.get("phytogro"))
                .requires(Items.EXPERIENCE_BOTTLE)
                .unlockedBy("has_slime_ball", has(Tags.Items.SLIMEBALLS))
                .save(consumer);

        generateSmeltingRecipe(reg, consumer, reg.get(spores(ID_GLOWSTONE_MUSHROOM)), Items.GLOWSTONE_DUST, 0.1F, "smelting", "_spores");
        generateSmeltingRecipe(reg, consumer, reg.get(spores(ID_GUNPOWDER_MUSHROOM)), Items.GUNPOWDER, 0.1F, "smelting", "_spores");
        generateSmeltingRecipe(reg, consumer, reg.get(spores(ID_REDSTONE_MUSHROOM)), Items.REDSTONE, 0.1F, "smelting", "_spores");
        generateSmeltingRecipe(reg, consumer, reg.get(spores(ID_SLIME_MUSHROOM)), Items.SLIME_BALL, 0.1F, "smelting", "_spores");

        generateStorageRecipes(consumer, reg.get(block(ID_AMARANTH)), reg.get(ID_AMARANTH), CoFHTags.Items.CROPS_AMARANTH);
        generateStorageRecipes(consumer, reg.get(block(ID_BARLEY)), reg.get(ID_BARLEY), CoFHTags.Items.CROPS_BARLEY);
        generateStorageRecipes(consumer, reg.get(block(ID_BELL_PEPPER)), reg.get(ID_BELL_PEPPER), CoFHTags.Items.CROPS_BELL_PEPPER);
        generateStorageRecipes(consumer, reg.get(block(ID_COFFEE)), reg.get(ID_COFFEE), CoFHTags.Items.CROPS_COFFEE);
        generateStorageRecipes(consumer, reg.get(block(ID_CORN)), reg.get(ID_CORN), CoFHTags.Items.CROPS_CORN);
        generateStorageRecipes(consumer, reg.get(block(ID_EGGPLANT)), reg.get(ID_EGGPLANT), CoFHTags.Items.CROPS_EGGPLANT);
        generateStorageRecipes(consumer, reg.get(block(ID_FLAX)), reg.get(ID_FLAX), CoFHTags.Items.CROPS_FLAX);
        generateStorageRecipes(consumer, reg.get(block(ID_GREEN_BEAN)), reg.get(ID_GREEN_BEAN), CoFHTags.Items.CROPS_GREEN_BEAN);
        generateStorageRecipes(consumer, reg.get(block(ID_HOPS)), reg.get(ID_HOPS), CoFHTags.Items.CROPS_HOPS);
        generateStorageRecipes(consumer, reg.get(block(ID_ONION)), reg.get(ID_ONION), CoFHTags.Items.CROPS_ONION);
        generateStorageRecipes(consumer, reg.get(block(ID_PEANUT)), reg.get(ID_PEANUT), CoFHTags.Items.CROPS_PEANUT);
        generateStorageRecipes(consumer, reg.get(block(ID_RADISH)), reg.get(ID_RADISH), CoFHTags.Items.CROPS_RADISH);
        generateStorageRecipes(consumer, reg.get(block(ID_RICE)), reg.get(ID_RICE), CoFHTags.Items.CROPS_RICE);
        generateStorageRecipes(consumer, reg.get(block(ID_SADIROOT)), reg.get(ID_SADIROOT), CoFHTags.Items.CROPS_SADIROOT);
        generateStorageRecipes(consumer, reg.get(block(ID_SPINACH)), reg.get(ID_SPINACH), CoFHTags.Items.CROPS_SPINACH);
        generateStorageRecipes(consumer, reg.get(block(ID_STRAWBERRY)), reg.get(ID_STRAWBERRY), CoFHTags.Items.CROPS_STRAWBERRY);
        generateStorageRecipes(consumer, reg.get(block(ID_TEA)), reg.get(ID_TEA), CoFHTags.Items.CROPS_TEA);
        generateStorageRecipes(consumer, reg.get(block(ID_TOMATO)), reg.get(ID_TOMATO), CoFHTags.Items.CROPS_TOMATO);
    }

    // region HELPERS
    private void generateFoodRecipes(Consumer<FinishedRecipe> consumer) {

        var reg = ITEMS;

        ShapelessRecipeBuilder.shapeless(ITEMS.get(ID_JELLY))
                .requires(CoFHTags.Items.CROPS_STRAWBERRY)
                .requires(CoFHTags.Items.CROPS_STRAWBERRY)
                .requires(CoFHTags.Items.CROPS_STRAWBERRY)
                .requires(CoFHTags.Items.CROPS_STRAWBERRY)
                .requires(CoFHTags.Items.CROPS_STRAWBERRY)
                .requires(CoFHTags.Items.CROPS_STRAWBERRY)
                .requires(ITEMS.get(ID_JAR))
                .unlockedBy("has_jar", has(reg.get(ID_JAR)))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ITEMS.get(ID_PEANUT_BUTTER))
                .requires(CoFHTags.Items.CROPS_PEANUT)
                .requires(CoFHTags.Items.CROPS_PEANUT)
                .requires(CoFHTags.Items.CROPS_PEANUT)
                .requires(CoFHTags.Items.CROPS_PEANUT)
                .requires(CoFHTags.Items.CROPS_PEANUT)
                .requires(CoFHTags.Items.CROPS_PEANUT)
                .requires(ITEMS.get(ID_JAR))
                .unlockedBy("has_jar", has(reg.get(ID_JAR)))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ITEMS.get(ID_TOMATO_SAUCE))
                .requires(CoFHTags.Items.CROPS_TOMATO)
                .requires(CoFHTags.Items.CROPS_TOMATO)
                .requires(CoFHTags.Items.CROPS_TOMATO)
                .requires(CoFHTags.Items.CROPS_TOMATO)
                .requires(CoFHTags.Items.CROPS_TOMATO)
                .requires(CoFHTags.Items.CROPS_TOMATO)
                .requires(ITEMS.get(ID_JAR))
                .unlockedBy("has_jar", has(reg.get(ID_JAR)))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(ID_CHEESE_WHEEL))
                .requires(Items.MILK_BUCKET)
                .requires(CoFHTags.Items.CROPS_SADIROOT)
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(ID_CHEESE_WEDGE), 4)
                .requires(reg.get(ID_CHEESE_WHEEL))
                .unlockedBy("has_cheese_wheel", has(reg.get(ID_CHEESE_WHEEL)))
                .save(consumer, ID_THERMAL + ":cheese_wedge_from_wheel");

        ShapedRecipeBuilder.shaped(reg.get(ID_GREEN_BEAN_PIE))
                .define('E', Items.EGG)
                .define('G', CoFHTags.Items.CROPS_GREEN_BEAN)
                .define('O', CoFHTags.Items.CROPS_ONION)
                .define('M', Items.BROWN_MUSHROOM)
                .define('W', Tags.Items.CROPS_WHEAT)
                .pattern("GMG")
                .pattern("OEO")
                .pattern(" W ")
                .unlockedBy("has_green_bean", has(CoFHTags.Items.CROPS_GREEN_BEAN))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(ID_PBJ_SANDWICH), 2)
                .requires(Items.BREAD)
                .requires(ITEMS.get(ID_PEANUT_BUTTER))
                .requires(ITEMS.get(ID_JELLY))
                .unlockedBy("has_bread", has(Items.BREAD))
                .save(consumer, ID_THERMAL + ":pbj_sandwich_2");

        ShapedRecipeBuilder.shaped(reg.get(ID_STUFFED_PEPPER))
                .define('C', ITEMS.get(ID_CHEESE_WEDGE))
                .define('M', CoFHTags.Items.COOKED_MEAT)
                .define('O', CoFHTags.Items.CROPS_ONION)
                .define('P', CoFHTags.Items.CROPS_BELL_PEPPER)
                .define('R', CoFHTags.Items.CROPS_RICE)
                .pattern(" C ")
                .pattern("OMR")
                .pattern(" P ")
                .unlockedBy("has_bell_pepper", has(CoFHTags.Items.CROPS_BELL_PEPPER))
                .save(consumer);

        ShapedRecipeBuilder.shaped(reg.get(ID_SUSHI_MAKI), 8)
                .define('F', CoFHTags.Items.RAW_FISH)
                .define('R', CoFHTags.Items.CROPS_RICE)
                .define('K', Items.DRIED_KELP)
                .pattern("FFF")
                .pattern("RRR")
                .pattern("KKK")
                .unlockedBy("has_rice", has(CoFHTags.Items.CROPS_RICE))
                .save(consumer, ID_THERMAL + ":sushi_maki_8");

        ShapelessRecipeBuilder.shapeless(reg.get(ID_SPRING_SALAD))
                .requires(CoFHTags.Items.CROPS_CORN)
                .requires(CoFHTags.Items.CROPS_GREEN_BEAN)
                .requires(CoFHTags.Items.CROPS_RADISH)
                .requires(CoFHTags.Items.CROPS_STRAWBERRY)
                .requires(CoFHTags.Items.CROPS_SPINACH)
                .requires(Items.HONEY_BOTTLE)
                .requires(Items.BOWL)
                .unlockedBy("has_spinach", has(CoFHTags.Items.CROPS_SPINACH))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(ID_HEARTY_STEW))
                .requires(Tags.Items.CROPS_CARROT)
                .requires(Tags.Items.CROPS_POTATO)
                .requires(CoFHTags.Items.CROPS_BARLEY)
                .requires(CoFHTags.Items.CROPS_ONION)
                .requires(CoFHTags.Items.CROPS_RADISH)
                .requires(ITEMS.get(ID_TOMATO_SAUCE))
                .requires(Items.BOWL)
                .unlockedBy("has_radish", has(CoFHTags.Items.CROPS_RADISH))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(ID_XP_STEW))
                .requires(CoFHTags.Items.CROPS_BARLEY)
                .requires(CoFHTags.Items.CROPS_BARLEY)
                .requires(CoFHTags.Items.CROPS_EGGPLANT)
                .requires(CoFHTags.Items.CROPS_SPINACH)
                .requires(CoFHTags.Items.CROPS_SPINACH)
                .requires(Items.EXPERIENCE_BOTTLE)
                .requires(Items.BOWL)
                .unlockedBy("has_eggplant", has(CoFHTags.Items.CROPS_EGGPLANT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(reg.get(ID_STUFFED_PUMPKIN))
                .define('C', CoFHTags.Items.PUMPKINS_CARVED)
                .define('M', CoFHTags.Items.COOKED_MEAT)
                .define('O', CoFHTags.Items.CROPS_ONION)
                .define('P', CoFHTags.Items.CROPS_BELL_PEPPER)
                .define('R', CoFHTags.Items.CROPS_RICE)
                .define('T', ITEMS.get(ID_TOMATO_SAUCE))
                .pattern("OTO")
                .pattern("RCR")
                .pattern("PMP")
                .unlockedBy("has_carved_pumpkin", has(CoFHTags.Items.PUMPKINS_CARVED))
                .save(consumer);

        ShapedRecipeBuilder.shaped(reg.get(ID_CARROT_CAKE))
                .define('A', Items.MILK_BUCKET)
                .define('B', Items.SUGAR)
                .define('C', Items.WHEAT)
                .define('D', Tags.Items.CROPS_CARROT)
                .define('E', Items.EGG)
                .pattern("ADA")
                .pattern("BEB")
                .pattern("CDC")
                .unlockedBy("has_carrot", has(Tags.Items.CROPS_CARROT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(reg.get(ID_CHOCOLATE_CAKE))
                .define('A', Items.MILK_BUCKET)
                .define('B', Items.COCOA_BEANS)
                .define('C', Items.WHEAT)
                .define('D', CoFHTags.Items.CROPS_STRAWBERRY)
                .define('E', Items.EGG)
                .pattern("ADA")
                .pattern("BEB")
                .pattern("CDC")
                .unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
                .save(consumer);

        // Handled via special recipe; this is used to create that recipe initially.
        //        ShapedRecipeBuilder.shaped(reg.get(ID_POTION_CAKE))
        //                .define('A', Items.MILK_BUCKET)
        //                .define('B', Items.SUGAR)
        //                .define('C', ItemTagsCoFH.CROPS_AMARANTH)
        //                .define('D', Items.POTION)
        //                .define('E', Items.EGG)
        //                .pattern("ADA")
        //                .pattern("BEB")
        //                .pattern("CCC")
        //                .unlockedBy("has_amaranth", has(ItemTagsCoFH.CROPS_AMARANTH))
        //                .save(consumer);

        ShapedRecipeBuilder.shaped(reg.get(ID_SPICE_CAKE))
                .define('A', Items.MILK_BUCKET)
                .define('B', Items.HONEY_BOTTLE)
                .define('C', Tags.Items.CROPS_WHEAT)
                .define('D', CoFHTags.Items.CROPS_SADIROOT)
                .define('E', Items.EGG)
                .pattern("ADA")
                .pattern("BEB")
                .pattern("CDC")
                .unlockedBy("has_sadiroot", has(CoFHTags.Items.CROPS_SADIROOT))
                .save(consumer);
    }
    // endregion
}
