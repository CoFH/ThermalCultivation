package cofh.thermal.cultivation.data;

import cofh.lib.util.references.CoFHTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.util.RegistrationHelper.block;
import static cofh.thermal.core.util.RegistrationHelper.seeds;
import static cofh.thermal.cultivation.init.TCulIDs.*;

public class TCulTagsProvider {

    public static class Block extends BlockTagsProvider {

        public Block(DataGenerator gen, ExistingFileHelper existingFileHelper) {

            super(gen, ID_THERMAL, existingFileHelper);
        }

        @Override
        public String getName() {

            return "Thermal Cultivation: Block Tags";
        }

        @Override
        protected void addTags() {

            tag(BlockTags.MINEABLE_WITH_AXE).add(BLOCKS.get(block(ID_AMARANTH)));
            tag(BlockTags.MINEABLE_WITH_HOE).add(BLOCKS.get(block(ID_BARLEY)));
            tag(BlockTags.MINEABLE_WITH_AXE).add(BLOCKS.get(block(ID_BELL_PEPPER)));
            tag(BlockTags.MINEABLE_WITH_AXE).add(BLOCKS.get(block(ID_CORN)));
            tag(BlockTags.MINEABLE_WITH_AXE).add(BLOCKS.get(block(ID_EGGPLANT)));
            tag(BlockTags.MINEABLE_WITH_HOE).add(BLOCKS.get(block(ID_FLAX)));
            tag(BlockTags.MINEABLE_WITH_AXE).add(BLOCKS.get(block(ID_GREEN_BEAN)));
            tag(BlockTags.MINEABLE_WITH_AXE).add(BLOCKS.get(block(ID_HOPS)));
            tag(BlockTags.MINEABLE_WITH_AXE).add(BLOCKS.get(block(ID_ONION)));
            tag(BlockTags.MINEABLE_WITH_AXE).add(BLOCKS.get(block(ID_RADISH)));
            tag(BlockTags.MINEABLE_WITH_AXE).add(BLOCKS.get(block(ID_SADIROOT)));
            tag(BlockTags.MINEABLE_WITH_AXE).add(BLOCKS.get(block(ID_SPINACH)));
            tag(BlockTags.MINEABLE_WITH_AXE).add(BLOCKS.get(block(ID_STRAWBERRY)));
            tag(BlockTags.MINEABLE_WITH_AXE).add(BLOCKS.get(block(ID_TOMATO)));

            tag(BlockTags.MINEABLE_WITH_AXE).add(BLOCKS.get(ID_FROST_MELON));

            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(BLOCKS.get(ID_PHYTOSOIL));
            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(BLOCKS.get(ID_PHYTOSOIL_TILLED));
        }

    }

    public static class Item extends ItemTagsProvider {

        public Item(DataGenerator gen, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {

            super(gen, blockTagProvider, ID_THERMAL, existingFileHelper);
        }

        @Override
        public String getName() {

            return "Thermal Cultivation: Item Tags";
        }

        @Override
        protected void addTags() {

            tag(CoFHTags.Items.CROPS_AMARANTH).add(ITEMS.get(ID_AMARANTH));
            tag(CoFHTags.Items.CROPS_BARLEY).add(ITEMS.get(ID_BARLEY));
            tag(CoFHTags.Items.CROPS_BELL_PEPPER).add(ITEMS.get(ID_BELL_PEPPER));
            tag(CoFHTags.Items.CROPS_COFFEE).add(ITEMS.get(ID_COFFEE));
            tag(CoFHTags.Items.CROPS_CORN).add(ITEMS.get(ID_CORN));
            tag(CoFHTags.Items.CROPS_EGGPLANT).add(ITEMS.get(ID_EGGPLANT));
            tag(CoFHTags.Items.CROPS_FLAX).add(ITEMS.get(ID_FLAX));
            tag(CoFHTags.Items.CROPS_GREEN_BEAN).add(ITEMS.get(ID_GREEN_BEAN));
            tag(CoFHTags.Items.CROPS_HOPS).add(ITEMS.get(ID_HOPS));
            tag(CoFHTags.Items.CROPS_ONION).add(ITEMS.get(ID_ONION));
            tag(CoFHTags.Items.CROPS_PEANUT).add(ITEMS.get(ID_PEANUT));
            tag(CoFHTags.Items.CROPS_RADISH).add(ITEMS.get(ID_RADISH));
            tag(CoFHTags.Items.CROPS_RICE).add(ITEMS.get(ID_RICE));
            tag(CoFHTags.Items.CROPS_SADIROOT).add(ITEMS.get(ID_SADIROOT));
            tag(CoFHTags.Items.CROPS_SPINACH).add(ITEMS.get(ID_SPINACH));
            tag(CoFHTags.Items.CROPS_STRAWBERRY).add(ITEMS.get(ID_STRAWBERRY));
            tag(CoFHTags.Items.CROPS_TEA).add(ITEMS.get(ID_TEA));
            tag(CoFHTags.Items.CROPS_TOMATO).add(ITEMS.get(ID_TOMATO));

            tag(Tags.Items.CROPS).addTags(
                    CoFHTags.Items.CROPS_AMARANTH,
                    CoFHTags.Items.CROPS_BARLEY,
                    CoFHTags.Items.CROPS_BELL_PEPPER,
                    CoFHTags.Items.CROPS_COFFEE,
                    CoFHTags.Items.CROPS_CORN,
                    CoFHTags.Items.CROPS_EGGPLANT,
                    CoFHTags.Items.CROPS_FLAX,
                    CoFHTags.Items.CROPS_GREEN_BEAN,
                    CoFHTags.Items.CROPS_HOPS,
                    CoFHTags.Items.CROPS_ONION,
                    CoFHTags.Items.CROPS_PEANUT,
                    CoFHTags.Items.CROPS_RADISH,
                    CoFHTags.Items.CROPS_RICE,
                    CoFHTags.Items.CROPS_SADIROOT,
                    CoFHTags.Items.CROPS_SPINACH,
                    CoFHTags.Items.CROPS_STRAWBERRY,
                    CoFHTags.Items.CROPS_TEA,
                    CoFHTags.Items.CROPS_TOMATO
            );

            tag(CoFHTags.Items.SEEDS_AMARANTH).add(ITEMS.get(seeds(ID_AMARANTH)));
            tag(CoFHTags.Items.SEEDS_BARLEY).add(ITEMS.get(seeds(ID_BARLEY)));
            tag(CoFHTags.Items.SEEDS_BELL_PEPPER).add(ITEMS.get(seeds(ID_BELL_PEPPER)));
            tag(CoFHTags.Items.SEEDS_COFFEE).add(ITEMS.get(seeds(ID_COFFEE)));
            tag(CoFHTags.Items.SEEDS_CORN).add(ITEMS.get(seeds(ID_CORN)));
            tag(CoFHTags.Items.SEEDS_EGGPLANT).add(ITEMS.get(seeds(ID_EGGPLANT)));
            tag(CoFHTags.Items.SEEDS_FLAX).add(ITEMS.get(seeds(ID_FLAX)));
            tag(CoFHTags.Items.SEEDS_FROST_MELON).add(ITEMS.get(seeds(ID_FROST_MELON)));
            tag(CoFHTags.Items.SEEDS_GREEN_BEAN).add(ITEMS.get(seeds(ID_GREEN_BEAN)));
            tag(CoFHTags.Items.SEEDS_HOPS).add(ITEMS.get(seeds(ID_HOPS)));
            tag(CoFHTags.Items.SEEDS_ONION).add(ITEMS.get(seeds(ID_ONION)));
            tag(CoFHTags.Items.SEEDS_PEANUT).add(ITEMS.get(seeds(ID_PEANUT)));
            tag(CoFHTags.Items.SEEDS_RADISH).add(ITEMS.get(seeds(ID_RADISH)));
            tag(CoFHTags.Items.SEEDS_RICE).add(ITEMS.get(seeds(ID_RICE)));
            tag(CoFHTags.Items.SEEDS_SADIROOT).add(ITEMS.get(seeds(ID_SADIROOT)));
            tag(CoFHTags.Items.SEEDS_SPINACH).add(ITEMS.get(seeds(ID_SPINACH)));
            tag(CoFHTags.Items.SEEDS_STRAWBERRY).add(ITEMS.get(seeds(ID_STRAWBERRY)));
            tag(CoFHTags.Items.SEEDS_TEA).add(ITEMS.get(seeds(ID_TEA)));
            tag(CoFHTags.Items.SEEDS_TOMATO).add(ITEMS.get(seeds(ID_TOMATO)));

            tag(Tags.Items.SEEDS).addTags(
                    CoFHTags.Items.SEEDS_AMARANTH,
                    CoFHTags.Items.SEEDS_BARLEY,
                    CoFHTags.Items.SEEDS_BELL_PEPPER,
                    CoFHTags.Items.SEEDS_COFFEE,
                    CoFHTags.Items.SEEDS_CORN,
                    CoFHTags.Items.SEEDS_EGGPLANT,
                    CoFHTags.Items.SEEDS_FLAX,
                    CoFHTags.Items.SEEDS_FROST_MELON,
                    CoFHTags.Items.SEEDS_GREEN_BEAN,
                    CoFHTags.Items.SEEDS_HOPS,
                    CoFHTags.Items.SEEDS_ONION,
                    CoFHTags.Items.SEEDS_PEANUT,
                    CoFHTags.Items.SEEDS_RADISH,
                    CoFHTags.Items.SEEDS_RICE,
                    CoFHTags.Items.SEEDS_SADIROOT,
                    CoFHTags.Items.SEEDS_SPINACH,
                    CoFHTags.Items.SEEDS_STRAWBERRY,
                    CoFHTags.Items.SEEDS_TEA,
                    CoFHTags.Items.SEEDS_TOMATO
            );
        }

    }

    public static class Fluid extends FluidTagsProvider {

        public Fluid(DataGenerator gen, ExistingFileHelper existingFileHelper) {

            super(gen, ID_THERMAL, existingFileHelper);
        }

        @Override
        public String getName() {

            return "Thermal Cultivation: Fluid Tags";
        }

        @Override
        protected void addTags() {

        }

    }

}
