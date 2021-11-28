package cofh.thermal.cultivation.data;

import cofh.lib.data.RecipeProviderCoFH;
import cofh.lib.util.DeferredRegisterCoFH;
import cofh.lib.util.references.ItemTagsCoFH;
import cofh.thermal.lib.common.ThermalFlags;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
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
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

        DeferredRegisterCoFH<Item> reg = ITEMS;

        ShapedRecipeBuilder.shaped(reg.get("watering_can"))
                .define('B', Items.BUCKET)
                .define('C', ItemTagsCoFH.INGOTS_COPPER)
                .pattern("C  ")
                .pattern("CBC")
                .pattern(" C ")
                .unlockedBy("has_bucket", has(Items.BUCKET))
                .save(consumer);

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
                .define('D', ItemTagsCoFH.CROPS_STRAWBERRY)
                .define('E', Items.EGG)
                .pattern("ADA")
                .pattern("BEB")
                .pattern("CDC")
                .unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(reg.get(ID_SPICE_CAKE))
                .define('A', Items.MILK_BUCKET)
                .define('B', Items.HONEY_BOTTLE)
                .define('C', Tags.Items.CROPS_WHEAT)
                .define('D', ItemTagsCoFH.CROPS_SADIROOT)
                .define('E', Items.EGG)
                .pattern("ADA")
                .pattern("BEB")
                .pattern("CDC")
                .unlockedBy("has_sadiroot", has(ItemTagsCoFH.CROPS_SADIROOT))
                .save(consumer);

        //        ShapedRecipeBuilder.shaped(reg.get(ID_RATATOUILLE))
        //                .define('B', ItemTagsCoFH.CROPS_BELL_PEPPER)
        //                .define('E', ItemTagsCoFH.CROPS_EGGPLANT)
        //                .define('O', ItemTagsCoFH.CROPS_ONION)
        //                .define('S', ItemTagsCoFH.CROPS_SPINACH)
        //                .define('T', ItemTagsCoFH.CROPS_TOMATO)
        //                .define('Y', Items.BOWL)
        //                .pattern("BSB")
        //                .pattern("EOT")
        //                .pattern(" Y ")
        //                .unlockedBy("has_onion", has(ItemTagsCoFH.CROPS_BELL_PEPPER))
        //                .save(consumer);

        ShapedRecipeBuilder.shaped(reg.get(ID_XP_STEW))
                .define('B', ItemTagsCoFH.CROPS_BARLEY)
                .define('E', ItemTagsCoFH.CROPS_EGGPLANT)
                .define('S', ItemTagsCoFH.CROPS_SPINACH)
                .define('X', Items.EXPERIENCE_BOTTLE)
                .define('Y', Items.BOWL)
                .pattern("SES")
                .pattern("BXB")
                .pattern(" Y ")
                .unlockedBy("has_eggplant", has(ItemTagsCoFH.CROPS_EGGPLANT))
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

        generateStorageRecipes(consumer, reg.get(block(ID_AMARANTH)), reg.get(ID_AMARANTH), ItemTagsCoFH.CROPS_AMARANTH);
        generateStorageRecipes(consumer, reg.get(block(ID_BARLEY)), reg.get(ID_BARLEY), ItemTagsCoFH.CROPS_BARLEY);
        generateStorageRecipes(consumer, reg.get(block(ID_BELL_PEPPER)), reg.get(ID_BELL_PEPPER), ItemTagsCoFH.CROPS_BELL_PEPPER);
        generateStorageRecipes(consumer, reg.get(block(ID_COFFEE)), reg.get(ID_COFFEE), ItemTagsCoFH.CROPS_COFFEE);
        generateStorageRecipes(consumer, reg.get(block(ID_CORN)), reg.get(ID_CORN), ItemTagsCoFH.CROPS_CORN);
        generateStorageRecipes(consumer, reg.get(block(ID_EGGPLANT)), reg.get(ID_EGGPLANT), ItemTagsCoFH.CROPS_EGGPLANT);
        generateStorageRecipes(consumer, reg.get(block(ID_FLAX)), reg.get(ID_FLAX), ItemTagsCoFH.CROPS_FLAX);
        generateStorageRecipes(consumer, reg.get(block(ID_GREEN_BEAN)), reg.get(ID_GREEN_BEAN), ItemTagsCoFH.CROPS_GREEN_BEAN);
        generateStorageRecipes(consumer, reg.get(block(ID_HOPS)), reg.get(ID_HOPS), ItemTagsCoFH.CROPS_HOPS);
        generateStorageRecipes(consumer, reg.get(block(ID_ONION)), reg.get(ID_ONION), ItemTagsCoFH.CROPS_ONION);
        generateStorageRecipes(consumer, reg.get(block(ID_PEANUT)), reg.get(ID_PEANUT), ItemTagsCoFH.CROPS_PEANUT);
        generateStorageRecipes(consumer, reg.get(block(ID_RADISH)), reg.get(ID_RADISH), ItemTagsCoFH.CROPS_RADISH);
        generateStorageRecipes(consumer, reg.get(block(ID_RICE)), reg.get(ID_RICE), ItemTagsCoFH.CROPS_RICE);
        generateStorageRecipes(consumer, reg.get(block(ID_SADIROOT)), reg.get(ID_SADIROOT), ItemTagsCoFH.CROPS_SADIROOT);
        generateStorageRecipes(consumer, reg.get(block(ID_SPINACH)), reg.get(ID_SPINACH), ItemTagsCoFH.CROPS_SPINACH);
        generateStorageRecipes(consumer, reg.get(block(ID_STRAWBERRY)), reg.get(ID_STRAWBERRY), ItemTagsCoFH.CROPS_STRAWBERRY);
        generateStorageRecipes(consumer, reg.get(block(ID_TEA)), reg.get(ID_TEA), ItemTagsCoFH.CROPS_TEA);
        generateStorageRecipes(consumer, reg.get(block(ID_TOMATO)), reg.get(ID_TOMATO), ItemTagsCoFH.CROPS_TOMATO);
    }

}
