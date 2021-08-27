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

        ShapedRecipeBuilder.shaped(reg.get(ID_CHOCOLATE_CAKE))
                .define('A', Items.MILK_BUCKET)
                .define('B', Items.COCOA_BEANS)
                .define('C', Items.WHEAT)
                .define('D', reg.get(ID_STRAWBERRY))
                .define('E', Items.EGG)
                .pattern("ADA")
                .pattern("BEB")
                .pattern("CDC")
                .unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(reg.get(ID_SPICE_CAKE))
                .define('A', Items.MILK_BUCKET)
                .define('B', Items.HONEY_BOTTLE)
                .define('C', Items.WHEAT)
                .define('D', reg.get(ID_SADIROOT))
                .define('E', Items.EGG)
                .pattern("ADA")
                .pattern("BEB")
                .pattern("CDC")
                .unlockedBy("has_sadiroot", has(reg.get(ID_SADIROOT)))
                .save(consumer);

        ShapedRecipeBuilder.shaped(reg.get(ID_XP_STEW))
                .define('A', reg.get(ID_BARLEY))
                .define('B', Items.BOWL)
                .define('C', reg.get(ID_SPINACH))
                .define('D', reg.get(ID_EGGPLANT))
                .define('E', Items.EXPERIENCE_BOTTLE)
                .pattern("CDC")
                .pattern("AEA")
                .pattern(" B ")
                .unlockedBy("has_eggplant", has(reg.get(ID_EGGPLANT)))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(spores(ID_GLOWSTONE_MUSHROOM)))
                .requires(Items.RED_MUSHROOM)
                .requires(Tags.Items.DUSTS_GLOWSTONE)
                .requires(reg.get("phytogro"))
                .requires(Items.EXPERIENCE_BOTTLE)
                .unlockedBy("has_frost_melon", has(Tags.Items.DUSTS_GLOWSTONE))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(spores(ID_GUNPOWDER_MUSHROOM)))
                .requires(Items.BROWN_MUSHROOM)
                .requires(Items.GUNPOWDER)
                .requires(reg.get("phytogro"))
                .requires(Items.EXPERIENCE_BOTTLE)
                .unlockedBy("has_frost_melon", has(Items.GUNPOWDER))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(spores(ID_REDSTONE_MUSHROOM)))
                .requires(Items.RED_MUSHROOM)
                .requires(Tags.Items.DUSTS_REDSTONE)
                .requires(reg.get("phytogro"))
                .requires(Items.EXPERIENCE_BOTTLE)
                .unlockedBy("has_frost_melon", has(Tags.Items.DUSTS_REDSTONE))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(reg.get(spores(ID_SLIME_MUSHROOM)))
                .requires(Items.BROWN_MUSHROOM)
                .requires(Tags.Items.SLIMEBALLS)
                .requires(reg.get("phytogro"))
                .requires(Items.EXPERIENCE_BOTTLE)
                .unlockedBy("has_slime_ball", has(Tags.Items.SLIMEBALLS))
                .save(consumer);

        generateStorageRecipes(consumer, reg.get(block(ID_AMARANTH)), reg.get(ID_AMARANTH), forgeTag("crops/amaranth"));
        generateStorageRecipes(consumer, reg.get(block(ID_BARLEY)), reg.get(ID_BARLEY), forgeTag("crops/barley"));
        generateStorageRecipes(consumer, reg.get(block(ID_BELL_PEPPER)), reg.get(ID_BELL_PEPPER), forgeTag("crops/bell_pepper"));
        generateStorageRecipes(consumer, reg.get(block(ID_COFFEE)), reg.get(ID_COFFEE), forgeTag("crops/coffee"));
        generateStorageRecipes(consumer, reg.get(block(ID_CORN)), reg.get(ID_CORN), forgeTag("crops/corn"));
        generateStorageRecipes(consumer, reg.get(block(ID_EGGPLANT)), reg.get(ID_EGGPLANT), forgeTag("crops/eggplant"));
        generateStorageRecipes(consumer, reg.get(block(ID_FLAX)), reg.get(ID_FLAX), forgeTag("crops/flax"));
        generateStorageRecipes(consumer, reg.get(block(ID_GREEN_BEAN)), reg.get(ID_GREEN_BEAN), forgeTag("crops/green_bean"));
        generateStorageRecipes(consumer, reg.get(block(ID_HOPS)), reg.get(ID_HOPS), forgeTag("crops/hops"));
        generateStorageRecipes(consumer, reg.get(block(ID_ONION)), reg.get(ID_ONION), forgeTag("crops/onion"));
        generateStorageRecipes(consumer, reg.get(block(ID_PEANUT)), reg.get(ID_PEANUT), forgeTag("crops/peanut"));
        generateStorageRecipes(consumer, reg.get(block(ID_RADISH)), reg.get(ID_RADISH), forgeTag("crops/radish"));
        generateStorageRecipes(consumer, reg.get(block(ID_RICE)), reg.get(ID_RICE), forgeTag("crops/rice"));
        generateStorageRecipes(consumer, reg.get(block(ID_SADIROOT)), reg.get(ID_SADIROOT), forgeTag("crops/sadiroot"));
        generateStorageRecipes(consumer, reg.get(block(ID_SPINACH)), reg.get(ID_SPINACH), forgeTag("crops/spinach"));
        generateStorageRecipes(consumer, reg.get(block(ID_STRAWBERRY)), reg.get(ID_STRAWBERRY), forgeTag("crops/strawberry"));
        generateStorageRecipes(consumer, reg.get(block(ID_TEA)), reg.get(ID_TEA), forgeTag("crops/tea"));
        generateStorageRecipes(consumer, reg.get(block(ID_TOMATO)), reg.get(ID_TOMATO), forgeTag("crops/tomato"));
    }

}
