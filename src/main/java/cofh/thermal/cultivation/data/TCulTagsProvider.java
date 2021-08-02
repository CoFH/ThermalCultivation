package cofh.thermal.cultivation.data;

import cofh.lib.util.references.ItemTagsCoFH;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.ITEMS;
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
        protected void registerTags() {

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
        protected void registerTags() {

            getOrCreateBuilder(ItemTagsCoFH.CROPS_BARLEY).add(ITEMS.get(ID_BARLEY));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_BELL_PEPPER).add(ITEMS.get(ID_BELL_PEPPER));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_COFFEE).add(ITEMS.get(ID_COFFEE));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_CORN).add(ITEMS.get(ID_CORN));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_EGGPLANT).add(ITEMS.get(ID_EGGPLANT));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_FLAX).add(ITEMS.get(ID_FLAX));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_GREEN_BEAN).add(ITEMS.get(ID_GREEN_BEAN));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_HOPS).add(ITEMS.get(ID_HOPS));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_ONION).add(ITEMS.get(ID_ONION));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_PEANUT).add(ITEMS.get(ID_PEANUT));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_RADISH).add(ITEMS.get(ID_RADISH));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_RICE).add(ITEMS.get(ID_RICE));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_SADIROOT).add(ITEMS.get(ID_SADIROOT));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_SPINACH).add(ITEMS.get(ID_SPINACH));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_STRAWBERRY).add(ITEMS.get(ID_STRAWBERRY));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_TEA).add(ITEMS.get(ID_TEA));
            getOrCreateBuilder(ItemTagsCoFH.CROPS_TOMATO).add(ITEMS.get(ID_TOMATO));

            getOrCreateBuilder(Tags.Items.CROPS).addTags(
                    ItemTagsCoFH.CROPS_BARLEY,
                    ItemTagsCoFH.CROPS_BELL_PEPPER,
                    ItemTagsCoFH.CROPS_COFFEE,
                    ItemTagsCoFH.CROPS_CORN,
                    ItemTagsCoFH.CROPS_EGGPLANT,
                    ItemTagsCoFH.CROPS_FLAX,
                    ItemTagsCoFH.CROPS_GREEN_BEAN,
                    ItemTagsCoFH.CROPS_HOPS,
                    ItemTagsCoFH.CROPS_ONION,
                    ItemTagsCoFH.CROPS_PEANUT,
                    ItemTagsCoFH.CROPS_RADISH,
                    ItemTagsCoFH.CROPS_RICE,
                    ItemTagsCoFH.CROPS_SADIROOT,
                    ItemTagsCoFH.CROPS_SPINACH,
                    ItemTagsCoFH.CROPS_STRAWBERRY,
                    ItemTagsCoFH.CROPS_TEA,
                    ItemTagsCoFH.CROPS_TOMATO
            );

            getOrCreateBuilder(ItemTagsCoFH.SEEDS_BARLEY).add(ITEMS.get(seeds(ID_BARLEY)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_BELL_PEPPER).add(ITEMS.get(seeds(ID_BELL_PEPPER)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_COFFEE).add(ITEMS.get(seeds(ID_COFFEE)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_CORN).add(ITEMS.get(seeds(ID_CORN)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_EGGPLANT).add(ITEMS.get(seeds(ID_EGGPLANT)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_FLAX).add(ITEMS.get(seeds(ID_FLAX)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_FROST_MELON).add(ITEMS.get(seeds(ID_FROST_MELON)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_GREEN_BEAN).add(ITEMS.get(seeds(ID_GREEN_BEAN)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_HOPS).add(ITEMS.get(seeds(ID_HOPS)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_ONION).add(ITEMS.get(seeds(ID_ONION)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_PEANUT).add(ITEMS.get(seeds(ID_PEANUT)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_RADISH).add(ITEMS.get(seeds(ID_RADISH)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_RICE).add(ITEMS.get(seeds(ID_RICE)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_SADIROOT).add(ITEMS.get(seeds(ID_SADIROOT)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_SPINACH).add(ITEMS.get(seeds(ID_SPINACH)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_STRAWBERRY).add(ITEMS.get(seeds(ID_STRAWBERRY)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_TEA).add(ITEMS.get(seeds(ID_TEA)));
            getOrCreateBuilder(ItemTagsCoFH.SEEDS_TOMATO).add(ITEMS.get(seeds(ID_TOMATO)));

            getOrCreateBuilder(Tags.Items.SEEDS).addTags(
                    ItemTagsCoFH.SEEDS_BARLEY,
                    ItemTagsCoFH.SEEDS_BELL_PEPPER,
                    ItemTagsCoFH.SEEDS_COFFEE,
                    ItemTagsCoFH.SEEDS_CORN,
                    ItemTagsCoFH.SEEDS_EGGPLANT,
                    ItemTagsCoFH.SEEDS_FLAX,
                    ItemTagsCoFH.SEEDS_FROST_MELON,
                    ItemTagsCoFH.SEEDS_GREEN_BEAN,
                    ItemTagsCoFH.SEEDS_HOPS,
                    ItemTagsCoFH.SEEDS_ONION,
                    ItemTagsCoFH.SEEDS_PEANUT,
                    ItemTagsCoFH.SEEDS_RADISH,
                    ItemTagsCoFH.SEEDS_RICE,
                    ItemTagsCoFH.SEEDS_SADIROOT,
                    ItemTagsCoFH.SEEDS_SPINACH,
                    ItemTagsCoFH.SEEDS_STRAWBERRY,
                    ItemTagsCoFH.SEEDS_TEA,
                    ItemTagsCoFH.SEEDS_TOMATO
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
        protected void registerTags() {

        }

    }

}
