package cofh.thermal.cultivation.init.data.providers;

import cofh.lib.init.tags.ItemTagsCoFH;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

import static cofh.lib.util.constants.ModIds.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.util.RegistrationHelper.block;
import static cofh.thermal.core.util.RegistrationHelper.seeds;
import static cofh.thermal.cultivation.init.registries.TCulIDs.*;

public class TCulTagsProvider {

    public static class Block extends BlockTagsProvider {

        public Block(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {

            super(output, lookupProvider, ID_THERMAL, existingFileHelper);
        }

        @SuppressWarnings ("unchecked")
        @Override
        protected void addTags(HolderLookup.Provider pProvider) {

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

            tag(BlockTags.CROPS).add(
                    BLOCKS.get(ID_AMARANTH),
                    BLOCKS.get(ID_BARLEY),
                    BLOCKS.get(ID_BELL_PEPPER),
                    BLOCKS.get(ID_COFFEE),
                    BLOCKS.get(ID_CORN),
                    BLOCKS.get(ID_EGGPLANT),
                    BLOCKS.get(ID_FLAX),
                    BLOCKS.get(ID_GREEN_BEAN),
                    // BLOCKS.get(ID_HOPS),
                    BLOCKS.get(ID_ONION),
                    BLOCKS.get(ID_PEANUT),
                    BLOCKS.get(ID_RADISH),
                    BLOCKS.get(ID_RICE),
                    BLOCKS.get(ID_SADIROOT),
                    BLOCKS.get(ID_SPINACH),
                    BLOCKS.get(ID_STRAWBERRY),
                    BLOCKS.get(ID_TEA),
                    BLOCKS.get(ID_TOMATO),
                    BLOCKS.get(ID_FROST_MELON_STEM)
            );

            tag(BlockTags.DIRT).add(BLOCKS.get(ID_PHYTOSOIL));
        }

    }

    public static class Item extends ItemTagsProvider {

        public Item(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagsProvider.TagLookup<net.minecraft.world.level.block.Block>> pBlockTags, ExistingFileHelper existingFileHelper) {

            super(pOutput, pLookupProvider, pBlockTags, ID_THERMAL, existingFileHelper);
        }

        @SuppressWarnings ("unchecked")
        @Override
        protected void addTags(HolderLookup.Provider pProvider) {

            tag(ItemTagsCoFH.CROPS_AMARANTH).add(ITEMS.get(ID_AMARANTH));
            tag(ItemTagsCoFH.CROPS_BARLEY).add(ITEMS.get(ID_BARLEY));
            tag(ItemTagsCoFH.CROPS_BELL_PEPPER).add(ITEMS.get(ID_BELL_PEPPER));
            tag(ItemTagsCoFH.CROPS_COFFEE).add(ITEMS.get(ID_COFFEE));
            tag(ItemTagsCoFH.CROPS_CORN).add(ITEMS.get(ID_CORN));
            tag(ItemTagsCoFH.CROPS_EGGPLANT).add(ITEMS.get(ID_EGGPLANT));
            tag(ItemTagsCoFH.CROPS_FLAX).add(ITEMS.get(ID_FLAX));
            tag(ItemTagsCoFH.CROPS_GREEN_BEAN).add(ITEMS.get(ID_GREEN_BEAN));
            tag(ItemTagsCoFH.CROPS_HOPS).add(ITEMS.get(ID_HOPS));
            tag(ItemTagsCoFH.CROPS_ONION).add(ITEMS.get(ID_ONION));
            tag(ItemTagsCoFH.CROPS_PEANUT).add(ITEMS.get(ID_PEANUT));
            tag(ItemTagsCoFH.CROPS_RADISH).add(ITEMS.get(ID_RADISH));
            tag(ItemTagsCoFH.CROPS_RICE).add(ITEMS.get(ID_RICE));
            tag(ItemTagsCoFH.CROPS_SADIROOT).add(ITEMS.get(ID_SADIROOT));
            tag(ItemTagsCoFH.CROPS_SPINACH).add(ITEMS.get(ID_SPINACH));
            tag(ItemTagsCoFH.CROPS_STRAWBERRY).add(ITEMS.get(ID_STRAWBERRY));
            tag(ItemTagsCoFH.CROPS_TEA).add(ITEMS.get(ID_TEA));
            tag(ItemTagsCoFH.CROPS_TOMATO).add(ITEMS.get(ID_TOMATO));

            tag(Tags.Items.CROPS).addTags(
                    ItemTagsCoFH.CROPS_AMARANTH,
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

            tag(ItemTagsCoFH.SEEDS_AMARANTH).add(ITEMS.get(seeds(ID_AMARANTH)));
            tag(ItemTagsCoFH.SEEDS_BARLEY).add(ITEMS.get(seeds(ID_BARLEY)));
            tag(ItemTagsCoFH.SEEDS_BELL_PEPPER).add(ITEMS.get(seeds(ID_BELL_PEPPER)));
            tag(ItemTagsCoFH.SEEDS_COFFEE).add(ITEMS.get(seeds(ID_COFFEE)));
            tag(ItemTagsCoFH.SEEDS_CORN).add(ITEMS.get(seeds(ID_CORN)));
            tag(ItemTagsCoFH.SEEDS_EGGPLANT).add(ITEMS.get(seeds(ID_EGGPLANT)));
            tag(ItemTagsCoFH.SEEDS_FLAX).add(ITEMS.get(seeds(ID_FLAX)));
            tag(ItemTagsCoFH.SEEDS_FROST_MELON).add(ITEMS.get(seeds(ID_FROST_MELON)));
            tag(ItemTagsCoFH.SEEDS_GREEN_BEAN).add(ITEMS.get(seeds(ID_GREEN_BEAN)));
            tag(ItemTagsCoFH.SEEDS_HOPS).add(ITEMS.get(seeds(ID_HOPS)));
            tag(ItemTagsCoFH.SEEDS_ONION).add(ITEMS.get(seeds(ID_ONION)));
            tag(ItemTagsCoFH.SEEDS_PEANUT).add(ITEMS.get(seeds(ID_PEANUT)));
            tag(ItemTagsCoFH.SEEDS_RADISH).add(ITEMS.get(seeds(ID_RADISH)));
            tag(ItemTagsCoFH.SEEDS_RICE).add(ITEMS.get(seeds(ID_RICE)));
            tag(ItemTagsCoFH.SEEDS_SADIROOT).add(ITEMS.get(seeds(ID_SADIROOT)));
            tag(ItemTagsCoFH.SEEDS_SPINACH).add(ITEMS.get(seeds(ID_SPINACH)));
            tag(ItemTagsCoFH.SEEDS_STRAWBERRY).add(ITEMS.get(seeds(ID_STRAWBERRY)));
            tag(ItemTagsCoFH.SEEDS_TEA).add(ITEMS.get(seeds(ID_TEA)));
            tag(ItemTagsCoFH.SEEDS_TOMATO).add(ITEMS.get(seeds(ID_TOMATO)));

            tag(Tags.Items.SEEDS).addTags(
                    ItemTagsCoFH.SEEDS_AMARANTH,
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

        public Fluid(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {

            super(output, lookupProvider, ID_THERMAL, existingFileHelper);
        }

        @SuppressWarnings ("unchecked")
        @Override
        protected void addTags(HolderLookup.Provider pProvider) {

        }

    }

}
