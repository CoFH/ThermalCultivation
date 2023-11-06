package cofh.thermal.cultivation.data.tables;

import cofh.lib.data.loot.BlockLootSubProviderCoFH;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import static cofh.lib.util.constants.BlockStatePropertiesCoFH.*;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.util.RegistrationHelper.*;
import static cofh.thermal.cultivation.init.TCulIDs.*;

public class TCulBlockLootTables extends BlockLootSubProviderCoFH {

    @Override
    protected void generate() {

        var regBlocks = BLOCKS;
        var regItems = ITEMS;

        createTallCropAltTable(ID_AMARANTH);
        createCropTable(ID_BARLEY);
        createTallCropTable(ID_CORN);
        createTallCropAltTable(ID_FLAX);
        createCropTable(ID_ONION);
        createCropTable(ID_RADISH);
        createCropTable(ID_RICE);
        createCropTable(ID_SADIROOT);
        createCropTable(ID_SPINACH);

        createPerennialCropTable(ID_BELL_PEPPER);
        createPerennialCropTable(ID_EGGPLANT);
        createPerennialCropTable(ID_GREEN_BEAN);
        createPerennialCropTable(ID_PEANUT);
        createPerennialCropTable(ID_STRAWBERRY);
        createPerennialCropTable(ID_TOMATO);

        createPerennialCropTable(ID_COFFEE);
        // createTallCropTable(ID_HOPS);
        createPerennialCropTable(ID_TEA);

        createMushroomTable(ID_GLOWSTONE_MUSHROOM);
        createMushroomTable(ID_GUNPOWDER_MUSHROOM);
        createMushroomTable(ID_REDSTONE_MUSHROOM);
        createMushroomTable(ID_SLIME_MUSHROOM);

        add(regBlocks.get(ID_FROST_MELON),
                createSilkTouchDispatchTable(regBlocks.get(ID_FROST_MELON),
                        applyExplosionDecay(regBlocks.get(ID_FROST_MELON),
                                LootItem.lootTableItem(regItems.get(ID_FROST_MELON_SLICE))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                                        .apply(LimitCount.limitCount(IntRange.upperBound(9))))));

        add(regBlocks.get(ID_FROST_MELON_STEM),
                createStemDrops(regBlocks.get(ID_FROST_MELON_STEM),
                        regItems.get(seeds(ID_FROST_MELON))));

        add(regBlocks.get(ID_FROST_MELON_STEM_ATTACHED),
                createAttachedStemDrops(regBlocks.get(ID_FROST_MELON_STEM),
                        regItems.get(seeds(ID_FROST_MELON))));

        add(regBlocks.get(ID_PHYTOSOIL), getSimpleDropTable(regBlocks.get(ID_PHYTOSOIL)));
        add(regBlocks.get(ID_PHYTOSOIL_TILLED), getSimpleDropTable(regBlocks.get(ID_PHYTOSOIL)));

        createSimpleDropTable(regBlocks.get(block(ID_AMARANTH)));
        createSimpleDropTable(regBlocks.get(block(ID_BARLEY)));
        createSimpleDropTable(regBlocks.get(block(ID_BELL_PEPPER)));
        createSimpleDropTable(regBlocks.get(block(ID_COFFEE)));
        createSimpleDropTable(regBlocks.get(block(ID_CORN)));
        createSimpleDropTable(regBlocks.get(block(ID_EGGPLANT)));
        createSimpleDropTable(regBlocks.get(block(ID_FLAX)));
        createSimpleDropTable(regBlocks.get(block(ID_GREEN_BEAN)));
        createSimpleDropTable(regBlocks.get(block(ID_HOPS)));
        createSimpleDropTable(regBlocks.get(block(ID_ONION)));
        createSimpleDropTable(regBlocks.get(block(ID_PEANUT)));
        createSimpleDropTable(regBlocks.get(block(ID_RADISH)));
        createSimpleDropTable(regBlocks.get(block(ID_RICE)));
        createSimpleDropTable(regBlocks.get(block(ID_SADIROOT)));
        createSimpleDropTable(regBlocks.get(block(ID_SPINACH)));
        createSimpleDropTable(regBlocks.get(block(ID_STRAWBERRY)));
        createSimpleDropTable(regBlocks.get(block(ID_TEA)));
        createSimpleDropTable(regBlocks.get(block(ID_TOMATO)));

        add(regBlocks.get(ID_CARROT_CAKE), getEmptyTable());
        add(regBlocks.get(ID_CHEESE_WHEEL), getEmptyTable());
        add(regBlocks.get(ID_CHOCOLATE_CAKE), getEmptyTable());
        add(regBlocks.get(ID_POTION_CAKE), getEmptyTable());
        add(regBlocks.get(ID_SPICE_CAKE), getEmptyTable());
        add(regBlocks.get(ID_STUFFED_PUMPKIN), getEmptyTable());
    }

    protected void createCropTable(String id) {

        add(BLOCKS.get(id), getCropTable(BLOCKS.get(id), ITEMS.get(id), ITEMS.get(seeds(id)), AGE_0_7, 7));
    }

    protected void createTallCropAltTable(String id) {

        add(BLOCKS.get(id), getCropTable(BLOCKS.get(id), ITEMS.get(id), ITEMS.get(seeds(id)), AGE_0_6, 6));
    }

    protected void createMushroomTable(String id) {

        add(BLOCKS.get(id), getMushroomTable(BLOCKS.get(id), ITEMS.get(spores(id)), AGE_0_4, 4));
    }

    protected void createTallCropTable(String id) {

        add(BLOCKS.get(id), getCropTable(BLOCKS.get(id), ITEMS.get(id), ITEMS.get(seeds(id)), AGE_0_9, 9));
    }

    protected void createPerennialCropTable(String id) {

        add(BLOCKS.get(id), getCropTable(BLOCKS.get(id), ITEMS.get(id), ITEMS.get(seeds(id)), AGE_0_10, 10));
    }

    protected LootTable.Builder getMushroomTable(Block block, Item crop, IntegerProperty ageProp, int age) {

        LootItemCondition.Builder harvestAge = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ageProp, age));

        return LootTable.lootTable()
                .withPool(applyExplosionDecay(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(crop)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))
                                        .when(harvestAge))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)
                                        .when(harvestAge))
                        )
                ));
    }

}
