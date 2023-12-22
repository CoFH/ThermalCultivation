package cofh.thermal.cultivation.init.data.providers;

import cofh.thermal.cultivation.init.registries.TCulTags;
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

            tag(TCulTags.Blocks.STORAGE_BLOCKS_AMARANTH).add(BLOCKS.get(block(ID_AMARANTH)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_BARLEY).add(BLOCKS.get(block(ID_BARLEY)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_BELL_PEPPER).add(BLOCKS.get(block(ID_BELL_PEPPER)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_COFFEE).add(BLOCKS.get(block(ID_COFFEE)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_CORN).add(BLOCKS.get(block(ID_CORN)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_EGGPLANT).add(BLOCKS.get(block(ID_EGGPLANT)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_FLAX).add(BLOCKS.get(block(ID_FLAX)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_GREEN_BEAN).add(BLOCKS.get(block(ID_GREEN_BEAN)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_HOPS).add(BLOCKS.get(block(ID_HOPS)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_ONION).add(BLOCKS.get(block(ID_ONION)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_PEANUT).add(BLOCKS.get(block(ID_PEANUT)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_RADISH).add(BLOCKS.get(block(ID_RADISH)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_RICE).add(BLOCKS.get(block(ID_RICE)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_SADIROOT).add(BLOCKS.get(block(ID_SADIROOT)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_SPINACH).add(BLOCKS.get(block(ID_SPINACH)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_STRAWBERRY).add(BLOCKS.get(block(ID_STRAWBERRY)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_TEA).add(BLOCKS.get(block(ID_TEA)));
            tag(TCulTags.Blocks.STORAGE_BLOCKS_TOMATO).add(BLOCKS.get(block(ID_TOMATO)));

            tag(Tags.Blocks.STORAGE_BLOCKS).addTags(
                    TCulTags.Blocks.STORAGE_BLOCKS_AMARANTH,
                    TCulTags.Blocks.STORAGE_BLOCKS_BARLEY,
                    TCulTags.Blocks.STORAGE_BLOCKS_BELL_PEPPER,
                    TCulTags.Blocks.STORAGE_BLOCKS_COFFEE,
                    TCulTags.Blocks.STORAGE_BLOCKS_CORN,
                    TCulTags.Blocks.STORAGE_BLOCKS_EGGPLANT,
                    TCulTags.Blocks.STORAGE_BLOCKS_FLAX,
                    TCulTags.Blocks.STORAGE_BLOCKS_GREEN_BEAN,
                    TCulTags.Blocks.STORAGE_BLOCKS_HOPS,
                    TCulTags.Blocks.STORAGE_BLOCKS_ONION,
                    TCulTags.Blocks.STORAGE_BLOCKS_PEANUT,
                    TCulTags.Blocks.STORAGE_BLOCKS_RADISH,
                    TCulTags.Blocks.STORAGE_BLOCKS_RICE,
                    TCulTags.Blocks.STORAGE_BLOCKS_SADIROOT,
                    TCulTags.Blocks.STORAGE_BLOCKS_SPINACH,
                    TCulTags.Blocks.STORAGE_BLOCKS_STRAWBERRY,
                    TCulTags.Blocks.STORAGE_BLOCKS_TEA,
                    TCulTags.Blocks.STORAGE_BLOCKS_TOMATO
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

            copy(TCulTags.Blocks.STORAGE_BLOCKS_AMARANTH, TCulTags.Items.STORAGE_BLOCKS_AMARANTH);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_BARLEY, TCulTags.Items.STORAGE_BLOCKS_BARLEY);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_BELL_PEPPER, TCulTags.Items.STORAGE_BLOCKS_BELL_PEPPER);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_COFFEE, TCulTags.Items.STORAGE_BLOCKS_COFFEE);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_CORN, TCulTags.Items.STORAGE_BLOCKS_CORN);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_EGGPLANT, TCulTags.Items.STORAGE_BLOCKS_EGGPLANT);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_FLAX, TCulTags.Items.STORAGE_BLOCKS_FLAX);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_GREEN_BEAN, TCulTags.Items.STORAGE_BLOCKS_GREEN_BEAN);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_HOPS, TCulTags.Items.STORAGE_BLOCKS_HOPS);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_ONION, TCulTags.Items.STORAGE_BLOCKS_ONION);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_PEANUT, TCulTags.Items.STORAGE_BLOCKS_PEANUT);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_RADISH, TCulTags.Items.STORAGE_BLOCKS_RADISH);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_RICE, TCulTags.Items.STORAGE_BLOCKS_RICE);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_SADIROOT, TCulTags.Items.STORAGE_BLOCKS_SADIROOT);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_SPINACH, TCulTags.Items.STORAGE_BLOCKS_SPINACH);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_STRAWBERRY, TCulTags.Items.STORAGE_BLOCKS_STRAWBERRY);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_TEA, TCulTags.Items.STORAGE_BLOCKS_TEA);
            copy(TCulTags.Blocks.STORAGE_BLOCKS_TOMATO, TCulTags.Items.STORAGE_BLOCKS_TOMATO);

            tag(TCulTags.Items.CROPS_AMARANTH).add(ITEMS.get(ID_AMARANTH));
            tag(TCulTags.Items.CROPS_BARLEY).add(ITEMS.get(ID_BARLEY));
            tag(TCulTags.Items.CROPS_BELL_PEPPER).add(ITEMS.get(ID_BELL_PEPPER));
            tag(TCulTags.Items.CROPS_COFFEE).add(ITEMS.get(ID_COFFEE));
            tag(TCulTags.Items.CROPS_CORN).add(ITEMS.get(ID_CORN));
            tag(TCulTags.Items.CROPS_EGGPLANT).add(ITEMS.get(ID_EGGPLANT));
            tag(TCulTags.Items.CROPS_FLAX).add(ITEMS.get(ID_FLAX));
            tag(TCulTags.Items.CROPS_GREEN_BEAN).add(ITEMS.get(ID_GREEN_BEAN));
            tag(TCulTags.Items.CROPS_HOPS).add(ITEMS.get(ID_HOPS));
            tag(TCulTags.Items.CROPS_ONION).add(ITEMS.get(ID_ONION));
            tag(TCulTags.Items.CROPS_PEANUT).add(ITEMS.get(ID_PEANUT));
            tag(TCulTags.Items.CROPS_RADISH).add(ITEMS.get(ID_RADISH));
            tag(TCulTags.Items.CROPS_RICE).add(ITEMS.get(ID_RICE));
            tag(TCulTags.Items.CROPS_SADIROOT).add(ITEMS.get(ID_SADIROOT));
            tag(TCulTags.Items.CROPS_SPINACH).add(ITEMS.get(ID_SPINACH));
            tag(TCulTags.Items.CROPS_STRAWBERRY).add(ITEMS.get(ID_STRAWBERRY));
            tag(TCulTags.Items.CROPS_TEA).add(ITEMS.get(ID_TEA));
            tag(TCulTags.Items.CROPS_TOMATO).add(ITEMS.get(ID_TOMATO));

            tag(Tags.Items.CROPS).addTags(
                    TCulTags.Items.CROPS_AMARANTH,
                    TCulTags.Items.CROPS_BARLEY,
                    TCulTags.Items.CROPS_BELL_PEPPER,
                    TCulTags.Items.CROPS_COFFEE,
                    TCulTags.Items.CROPS_CORN,
                    TCulTags.Items.CROPS_EGGPLANT,
                    TCulTags.Items.CROPS_FLAX,
                    TCulTags.Items.CROPS_GREEN_BEAN,
                    TCulTags.Items.CROPS_HOPS,
                    TCulTags.Items.CROPS_ONION,
                    TCulTags.Items.CROPS_PEANUT,
                    TCulTags.Items.CROPS_RADISH,
                    TCulTags.Items.CROPS_RICE,
                    TCulTags.Items.CROPS_SADIROOT,
                    TCulTags.Items.CROPS_SPINACH,
                    TCulTags.Items.CROPS_STRAWBERRY,
                    TCulTags.Items.CROPS_TEA,
                    TCulTags.Items.CROPS_TOMATO
            );

            tag(TCulTags.Items.SEEDS_AMARANTH).add(ITEMS.get(seeds(ID_AMARANTH)));
            tag(TCulTags.Items.SEEDS_BARLEY).add(ITEMS.get(seeds(ID_BARLEY)));
            tag(TCulTags.Items.SEEDS_BELL_PEPPER).add(ITEMS.get(seeds(ID_BELL_PEPPER)));
            tag(TCulTags.Items.SEEDS_COFFEE).add(ITEMS.get(seeds(ID_COFFEE)));
            tag(TCulTags.Items.SEEDS_CORN).add(ITEMS.get(seeds(ID_CORN)));
            tag(TCulTags.Items.SEEDS_EGGPLANT).add(ITEMS.get(seeds(ID_EGGPLANT)));
            tag(TCulTags.Items.SEEDS_FLAX).add(ITEMS.get(seeds(ID_FLAX)));
            tag(TCulTags.Items.SEEDS_FROST_MELON).add(ITEMS.get(seeds(ID_FROST_MELON)));
            tag(TCulTags.Items.SEEDS_GREEN_BEAN).add(ITEMS.get(seeds(ID_GREEN_BEAN)));
            tag(TCulTags.Items.SEEDS_HOPS).add(ITEMS.get(seeds(ID_HOPS)));
            tag(TCulTags.Items.SEEDS_ONION).add(ITEMS.get(seeds(ID_ONION)));
            tag(TCulTags.Items.SEEDS_PEANUT).add(ITEMS.get(seeds(ID_PEANUT)));
            tag(TCulTags.Items.SEEDS_RADISH).add(ITEMS.get(seeds(ID_RADISH)));
            tag(TCulTags.Items.SEEDS_RICE).add(ITEMS.get(seeds(ID_RICE)));
            tag(TCulTags.Items.SEEDS_SADIROOT).add(ITEMS.get(seeds(ID_SADIROOT)));
            tag(TCulTags.Items.SEEDS_SPINACH).add(ITEMS.get(seeds(ID_SPINACH)));
            tag(TCulTags.Items.SEEDS_STRAWBERRY).add(ITEMS.get(seeds(ID_STRAWBERRY)));
            tag(TCulTags.Items.SEEDS_TEA).add(ITEMS.get(seeds(ID_TEA)));
            tag(TCulTags.Items.SEEDS_TOMATO).add(ITEMS.get(seeds(ID_TOMATO)));

            tag(Tags.Items.SEEDS).addTags(
                    TCulTags.Items.SEEDS_AMARANTH,
                    TCulTags.Items.SEEDS_BARLEY,
                    TCulTags.Items.SEEDS_BELL_PEPPER,
                    TCulTags.Items.SEEDS_COFFEE,
                    TCulTags.Items.SEEDS_CORN,
                    TCulTags.Items.SEEDS_EGGPLANT,
                    TCulTags.Items.SEEDS_FLAX,
                    TCulTags.Items.SEEDS_FROST_MELON,
                    TCulTags.Items.SEEDS_GREEN_BEAN,
                    TCulTags.Items.SEEDS_HOPS,
                    TCulTags.Items.SEEDS_ONION,
                    TCulTags.Items.SEEDS_PEANUT,
                    TCulTags.Items.SEEDS_RADISH,
                    TCulTags.Items.SEEDS_RICE,
                    TCulTags.Items.SEEDS_SADIROOT,
                    TCulTags.Items.SEEDS_SPINACH,
                    TCulTags.Items.SEEDS_STRAWBERRY,
                    TCulTags.Items.SEEDS_TEA,
                    TCulTags.Items.SEEDS_TOMATO
            );

            tag(Tags.Items.STORAGE_BLOCKS).addTags(
                    TCulTags.Items.STORAGE_BLOCKS_AMARANTH,
                    TCulTags.Items.STORAGE_BLOCKS_BARLEY,
                    TCulTags.Items.STORAGE_BLOCKS_BELL_PEPPER,
                    TCulTags.Items.STORAGE_BLOCKS_COFFEE,
                    TCulTags.Items.STORAGE_BLOCKS_CORN,
                    TCulTags.Items.STORAGE_BLOCKS_EGGPLANT,
                    TCulTags.Items.STORAGE_BLOCKS_FLAX,
                    TCulTags.Items.STORAGE_BLOCKS_GREEN_BEAN,
                    TCulTags.Items.STORAGE_BLOCKS_HOPS,
                    TCulTags.Items.STORAGE_BLOCKS_ONION,
                    TCulTags.Items.STORAGE_BLOCKS_PEANUT,
                    TCulTags.Items.STORAGE_BLOCKS_RADISH,
                    TCulTags.Items.STORAGE_BLOCKS_RICE,
                    TCulTags.Items.STORAGE_BLOCKS_SADIROOT,
                    TCulTags.Items.STORAGE_BLOCKS_SPINACH,
                    TCulTags.Items.STORAGE_BLOCKS_STRAWBERRY,
                    TCulTags.Items.STORAGE_BLOCKS_TEA,
                    TCulTags.Items.STORAGE_BLOCKS_TOMATO
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
