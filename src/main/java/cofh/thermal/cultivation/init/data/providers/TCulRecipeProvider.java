package cofh.thermal.cultivation.init.data.providers;

import cofh.lib.init.data.RecipeProviderCoFH;
import cofh.lib.init.tags.ItemTagsCoFH;
import cofh.thermal.cultivation.init.registries.TCulTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

import static cofh.lib.util.constants.ModIds.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.util.RegistrationHelper.*;
import static cofh.thermal.cultivation.init.registries.TCulIDs.*;
import static cofh.thermal.lib.util.ThermalIDs.ID_WRENCH;
import static net.minecraft.data.recipes.RecipeCategory.*;

public class TCulRecipeProvider extends RecipeProviderCoFH {

    public TCulRecipeProvider(PackOutput output) {

        super(output, ID_THERMAL);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        generateFoodRecipes(recipeOutput);

        var reg = ITEMS;

        ShapedRecipeBuilder.shaped(TOOLS, reg.get(ID_WATERING_CAN))
                .define('B', Items.BUCKET)
                .define('C', Tags.Items.INGOTS_COPPER)
                .pattern("C  ")
                .pattern("CBC")
                .pattern(" C ")
                .unlockedBy("has_bucket", has(Items.BUCKET))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(TOOLS, reg.get(ID_JAR), 8)
                .define('G', Tags.Items.GLASS)
                .define('P', ItemTags.PLANKS)
                .pattern("PP")
                .pattern("GG")
                .pattern("GG")
                .unlockedBy("has_glass", has(Tags.Items.GLASS))
                .save(recipeOutput, ID_THERMAL + ":jar_8");


        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, reg.get(ID_PHYTOSOIL))
                .define('C', Items.CHARCOAL)
                .define('P', reg.get("phytogro"))
                .define('X', Blocks.DIRT)
                .pattern("CPC")
                .pattern("PXP")
                .pattern("CPC")
                .unlockedBy("has_phytogro", has(reg.get("phytogro")))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(MISC, Items.STRING)
                .requires(reg.get(ID_FLAX))
                .unlockedBy("has_flax", has(reg.get(ID_FLAX)))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(FOOD, reg.get(seeds(ID_FROST_MELON)))
                .requires(reg.get(ID_FROST_MELON_SLICE))
                .unlockedBy("has_frost_melon", has(reg.get(ID_FROST_MELON_SLICE)))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(FOOD, reg.get(ID_FROST_MELON))
                .define('M', reg.get(ID_FROST_MELON_SLICE))
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .unlockedBy("has_frost_melon", has(reg.get(ID_FROST_MELON_SLICE)))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(MISC, reg.get(spores(ID_GLOWSTONE_MUSHROOM)))
                .requires(Items.RED_MUSHROOM)
                .requires(Tags.Items.DUSTS_GLOWSTONE)
                .requires(reg.get("phytogro"))
                .requires(Items.EXPERIENCE_BOTTLE)
                .unlockedBy("has_glowstone_dust", has(Tags.Items.DUSTS_GLOWSTONE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(MISC, reg.get(spores(ID_GUNPOWDER_MUSHROOM)))
                .requires(Items.BROWN_MUSHROOM)
                .requires(Items.GUNPOWDER)
                .requires(reg.get("phytogro"))
                .requires(Items.EXPERIENCE_BOTTLE)
                .unlockedBy("has_gunpowder", has(Items.GUNPOWDER))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(MISC, reg.get(spores(ID_REDSTONE_MUSHROOM)))
                .requires(Items.RED_MUSHROOM)
                .requires(Tags.Items.DUSTS_REDSTONE)
                .requires(reg.get("phytogro"))
                .requires(Items.EXPERIENCE_BOTTLE)
                .unlockedBy("has_redstone_dust", has(Tags.Items.DUSTS_REDSTONE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(MISC, reg.get(spores(ID_SLIME_MUSHROOM)))
                .requires(Items.BROWN_MUSHROOM)
                .requires(Tags.Items.SLIMEBALLS)
                .requires(reg.get("phytogro"))
                .requires(Items.EXPERIENCE_BOTTLE)
                .unlockedBy("has_slime_ball", has(Tags.Items.SLIMEBALLS))
                .save(recipeOutput);

        generateSmeltingRecipe(reg, recipeOutput, reg.get(spores(ID_GLOWSTONE_MUSHROOM)), Items.GLOWSTONE_DUST, 0.1F, "smelting", "_spores");
        generateSmeltingRecipe(reg, recipeOutput, reg.get(spores(ID_GUNPOWDER_MUSHROOM)), Items.GUNPOWDER, 0.1F, "smelting", "_spores");
        generateSmeltingRecipe(reg, recipeOutput, reg.get(spores(ID_REDSTONE_MUSHROOM)), Items.REDSTONE, 0.1F, "smelting", "_spores");
        generateSmeltingRecipe(reg, recipeOutput, reg.get(spores(ID_SLIME_MUSHROOM)), Items.SLIME_BALL, 0.1F, "smelting", "_spores");

        generateStorageRecipes(recipeOutput, reg.get(block(ID_AMARANTH)), reg.get(ID_AMARANTH), TCulTags.Items.CROPS_AMARANTH);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_BARLEY)), reg.get(ID_BARLEY), TCulTags.Items.CROPS_BARLEY);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_BELL_PEPPER)), reg.get(ID_BELL_PEPPER), TCulTags.Items.CROPS_BELL_PEPPER);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_COFFEE)), reg.get(ID_COFFEE), TCulTags.Items.CROPS_COFFEE);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_CORN)), reg.get(ID_CORN), TCulTags.Items.CROPS_CORN);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_EGGPLANT)), reg.get(ID_EGGPLANT), TCulTags.Items.CROPS_EGGPLANT);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_FLAX)), reg.get(ID_FLAX), TCulTags.Items.CROPS_FLAX);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_GREEN_BEAN)), reg.get(ID_GREEN_BEAN), TCulTags.Items.CROPS_GREEN_BEAN);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_HOPS)), reg.get(ID_HOPS), TCulTags.Items.CROPS_HOPS);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_ONION)), reg.get(ID_ONION), TCulTags.Items.CROPS_ONION);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_PEANUT)), reg.get(ID_PEANUT), TCulTags.Items.CROPS_PEANUT);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_RADISH)), reg.get(ID_RADISH), TCulTags.Items.CROPS_RADISH);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_RICE)), reg.get(ID_RICE), TCulTags.Items.CROPS_RICE);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_SADIROOT)), reg.get(ID_SADIROOT), TCulTags.Items.CROPS_SADIROOT);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_SPINACH)), reg.get(ID_SPINACH), TCulTags.Items.CROPS_SPINACH);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_STRAWBERRY)), reg.get(ID_STRAWBERRY), TCulTags.Items.CROPS_STRAWBERRY);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_TEA)), reg.get(ID_TEA), TCulTags.Items.CROPS_TEA);
        generateStorageRecipes(recipeOutput, reg.get(block(ID_TOMATO)), reg.get(ID_TOMATO), TCulTags.Items.CROPS_TOMATO);
    }

    // region HELPERS
    private void generateFoodRecipes(RecipeOutput consumer) {

        var reg = ITEMS;

        generateSmeltingAndCookingRecipes(reg, consumer, TCulTags.Items.DOUGH, "has_dough", Items.BREAD, 0.35F, "smelting");
        generateSmeltingAndCookingRecipes(reg, consumer, Tags.Items.MUSHROOMS, "has_mushroom", reg.get(ID_COOKED_MUSHROOM), 0.35F, "smelting");
        generateSmeltingAndCookingRecipes(reg, consumer, TCulTags.Items.CROPS_CORN, "has_corn", reg.get(ID_COOKED_CORN), 0.35F, "smelting");
        generateSmeltingAndCookingRecipes(reg, consumer, TCulTags.Items.CROPS_EGGPLANT, "has_eggplant", reg.get(ID_COOKED_EGGPLANT), 0.35F, "smelting");

        ShapelessRecipeBuilder.shapeless(FOOD, reg.get(ID_FLOUR))
                .requires(fromTags(Tags.Items.CROPS_WHEAT, TCulTags.Items.CROPS_AMARANTH, TCulTags.Items.CROPS_BARLEY))
                .requires(fromTags(Tags.Items.CROPS_WHEAT, TCulTags.Items.CROPS_AMARANTH, TCulTags.Items.CROPS_BARLEY))
                .requires(reg.get(ID_WRENCH))
                .unlockedBy("has_flour", has(TCulTags.Items.FLOUR))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(FOOD, reg.get(ID_DOUGH), 3)
                .requires(reg.get(ID_FLOUR))
                .requires(reg.get(ID_FLOUR))
                .requires(reg.get(ID_FLOUR))
                .requires(Ingredient.of(Items.WATER_BUCKET, Items.EGG))
                .unlockedBy("has_flour", has(TCulTags.Items.FLOUR))
                .save(consumer, ID_THERMAL + ":dough_3");

        ShapelessRecipeBuilder.shapeless(FOOD, ITEMS.get(ID_JELLY))
                .requires(TCulTags.Items.CROPS_STRAWBERRY)
                .requires(TCulTags.Items.CROPS_STRAWBERRY)
                .requires(TCulTags.Items.CROPS_STRAWBERRY)
                .requires(TCulTags.Items.CROPS_STRAWBERRY)
                .requires(TCulTags.Items.CROPS_STRAWBERRY)
                .requires(TCulTags.Items.CROPS_STRAWBERRY)
                .requires(ITEMS.get(ID_JAR))
                .unlockedBy("has_jar", has(reg.get(ID_JAR)))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(FOOD, ITEMS.get(ID_PEANUT_BUTTER))
                .requires(TCulTags.Items.CROPS_PEANUT)
                .requires(TCulTags.Items.CROPS_PEANUT)
                .requires(TCulTags.Items.CROPS_PEANUT)
                .requires(TCulTags.Items.CROPS_PEANUT)
                .requires(TCulTags.Items.CROPS_PEANUT)
                .requires(TCulTags.Items.CROPS_PEANUT)
                .requires(ITEMS.get(ID_JAR))
                .unlockedBy("has_jar", has(reg.get(ID_JAR)))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(FOOD, ITEMS.get(ID_TOMATO_SAUCE))
                .requires(TCulTags.Items.CROPS_TOMATO)
                .requires(TCulTags.Items.CROPS_TOMATO)
                .requires(TCulTags.Items.CROPS_TOMATO)
                .requires(TCulTags.Items.CROPS_TOMATO)
                .requires(TCulTags.Items.CROPS_TOMATO)
                .requires(TCulTags.Items.CROPS_TOMATO)
                .requires(ITEMS.get(ID_JAR))
                .unlockedBy("has_jar", has(reg.get(ID_JAR)))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(FOOD, reg.get(ID_CHEESE_WHEEL))
                .requires(Items.MILK_BUCKET)
                .requires(TCulTags.Items.CROPS_SADIROOT)
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(FOOD, reg.get(ID_CHEESE_WEDGE), 4)
                .requires(reg.get(ID_CHEESE_WHEEL))
                .unlockedBy("has_cheese_wheel", has(reg.get(ID_CHEESE_WHEEL)))
                .save(consumer, ID_THERMAL + ":cheese_wedge_from_wheel");

        ShapelessRecipeBuilder.shapeless(FOOD, reg.get(ID_FORTUNE_COOKIE), 4)
                .requires(TCulTags.Items.FLOUR)
                .requires(Items.PAPER)
                .requires(TCulTags.Items.FLOUR)
                .requires(Items.SUGAR)
                .requires(Tags.Items.EGGS)
                .requires(Items.SUGAR)
                .unlockedBy("has_flour", has(TCulTags.Items.FLOUR))
                .save(consumer, ID_THERMAL + ":fortune_cookie_4");

        ShapedRecipeBuilder.shaped(FOOD, reg.get(ID_GREEN_BEAN_PIE))
                .define('E', Items.EGG)
                .define('G', TCulTags.Items.CROPS_GREEN_BEAN)
                .define('O', TCulTags.Items.CROPS_ONION)
                .define('M', Items.BROWN_MUSHROOM)
                .define('W', Tags.Items.CROPS_WHEAT)
                .pattern("GMG")
                .pattern("OEO")
                .pattern(" W ")
                .unlockedBy("has_green_bean", has(TCulTags.Items.CROPS_GREEN_BEAN))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(FOOD, reg.get(ID_PBJ_SANDWICH), 2)
                .requires(Items.BREAD)
                .requires(ITEMS.get(ID_PEANUT_BUTTER))
                .requires(ITEMS.get(ID_JELLY))
                .unlockedBy("has_bread", has(Items.BREAD))
                .save(consumer, ID_THERMAL + ":pbj_sandwich_2");

        ShapedRecipeBuilder.shaped(FOOD, reg.get(ID_STUFFED_PEPPER))
                .define('C', ITEMS.get(ID_CHEESE_WEDGE))
                .define('M', ItemTagsCoFH.COOKED_MEAT)
                .define('O', TCulTags.Items.CROPS_ONION)
                .define('P', TCulTags.Items.CROPS_BELL_PEPPER)
                .define('R', TCulTags.Items.CROPS_RICE)
                .pattern(" C ")
                .pattern("OMR")
                .pattern(" P ")
                .unlockedBy("has_bell_pepper", has(TCulTags.Items.CROPS_BELL_PEPPER))
                .save(consumer);

        ShapedRecipeBuilder.shaped(FOOD, reg.get(ID_SUSHI_MAKI), 8)
                .define('F', ItemTagsCoFH.RAW_FISH)
                .define('R', TCulTags.Items.CROPS_RICE)
                .define('K', Items.DRIED_KELP)
                .pattern("FFF")
                .pattern("RRR")
                .pattern("KKK")
                .unlockedBy("has_rice", has(TCulTags.Items.CROPS_RICE))
                .save(consumer, ID_THERMAL + ":sushi_maki_8");

        ShapelessRecipeBuilder.shapeless(FOOD, reg.get(ID_SPRING_SALAD))
                .requires(TCulTags.Items.CROPS_CORN)
                .requires(TCulTags.Items.CROPS_GREEN_BEAN)
                .requires(TCulTags.Items.CROPS_RADISH)
                .requires(TCulTags.Items.CROPS_STRAWBERRY)
                .requires(TCulTags.Items.CROPS_SPINACH)
                .requires(Items.HONEY_BOTTLE)
                .requires(Items.BOWL)
                .unlockedBy("has_spinach", has(TCulTags.Items.CROPS_SPINACH))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(FOOD, reg.get(ID_HEARTY_STEW))
                .requires(Tags.Items.CROPS_CARROT)
                .requires(Tags.Items.CROPS_POTATO)
                .requires(TCulTags.Items.CROPS_BARLEY)
                .requires(TCulTags.Items.CROPS_ONION)
                .requires(TCulTags.Items.CROPS_RADISH)
                .requires(ITEMS.get(ID_TOMATO_SAUCE))
                .requires(Items.BOWL)
                .unlockedBy("has_radish", has(TCulTags.Items.CROPS_RADISH))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(FOOD, reg.get(ID_XP_STEW))
                .requires(TCulTags.Items.CROPS_BARLEY)
                .requires(TCulTags.Items.CROPS_BARLEY)
                .requires(TCulTags.Items.CROPS_EGGPLANT)
                .requires(TCulTags.Items.CROPS_SPINACH)
                .requires(TCulTags.Items.CROPS_SPINACH)
                .requires(Items.EXPERIENCE_BOTTLE)
                .requires(Items.BOWL)
                .unlockedBy("has_eggplant", has(TCulTags.Items.CROPS_EGGPLANT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(FOOD, reg.get(ID_STUFFED_PUMPKIN))
                .define('C', ItemTagsCoFH.PUMPKINS_CARVED)
                .define('M', ItemTagsCoFH.COOKED_MEAT)
                .define('O', TCulTags.Items.CROPS_ONION)
                .define('P', TCulTags.Items.CROPS_BELL_PEPPER)
                .define('R', TCulTags.Items.CROPS_RICE)
                .define('T', ITEMS.get(ID_TOMATO_SAUCE))
                .pattern("OTO")
                .pattern("RCR")
                .pattern("PMP")
                .unlockedBy("has_carved_pumpkin", has(ItemTagsCoFH.PUMPKINS_CARVED))
                .save(consumer);

        ShapedRecipeBuilder.shaped(FOOD, reg.get(ID_CARROT_CAKE))
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

        ShapedRecipeBuilder.shaped(FOOD, reg.get(ID_CHOCOLATE_CAKE))
                .define('A', Items.MILK_BUCKET)
                .define('B', Items.COCOA_BEANS)
                .define('C', Items.WHEAT)
                .define('D', TCulTags.Items.CROPS_STRAWBERRY)
                .define('E', Items.EGG)
                .pattern("ADA")
                .pattern("BEB")
                .pattern("CDC")
                .unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
                .save(consumer);

        // Handled via special recipe; this is used to create that recipe initially.
        //        ShapedRecipeBuilder.shaped(FOOD, reg.get(ID_POTION_CAKE))
        //                .define('A', Items.MILK_BUCKET)
        //                .define('B', Items.SUGAR)
        //                .define('C', TCulTags.Items.CROPS_AMARANTH)
        //                .define('D', Items.POTION)
        //                .define('E', Items.EGG)
        //                .pattern("ADA")
        //                .pattern("BEB")
        //                .pattern("CCC")
        //                .unlockedBy("has_amaranth", has(TCulTags.Items.CROPS_AMARANTH))
        //                .save(consumer);

        ShapedRecipeBuilder.shaped(FOOD, reg.get(ID_SPICE_CAKE))
                .define('A', Items.MILK_BUCKET)
                .define('B', Items.HONEY_BOTTLE)
                .define('C', Tags.Items.CROPS_WHEAT)
                .define('D', TCulTags.Items.CROPS_SADIROOT)
                .define('E', Items.EGG)
                .pattern("ADA")
                .pattern("BEB")
                .pattern("CDC")
                .unlockedBy("has_sadiroot", has(TCulTags.Items.CROPS_SADIROOT))
                .save(consumer);
    }
    // endregion
}
