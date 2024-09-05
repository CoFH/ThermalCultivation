package cofh.thermal.cultivation.init.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static cofh.lib.util.constants.ModIds.ID_THERMAL;

public class TCulTags {

    private TCulTags() {

    }

    public static class Blocks {

        public static final TagKey<Block> STORAGE_BLOCKS_AMARANTH = commonTag("storage_blocks/amaranth");
        public static final TagKey<Block> STORAGE_BLOCKS_BARLEY = commonTag("storage_blocks/barley");
        public static final TagKey<Block> STORAGE_BLOCKS_BELL_PEPPER = commonTag("storage_blocks/bell_pepper");
        public static final TagKey<Block> STORAGE_BLOCKS_COFFEE = commonTag("storage_blocks/coffee");
        public static final TagKey<Block> STORAGE_BLOCKS_CORN = commonTag("storage_blocks/corn");
        public static final TagKey<Block> STORAGE_BLOCKS_EGGPLANT = commonTag("storage_blocks/eggplant");
        public static final TagKey<Block> STORAGE_BLOCKS_FLAX = commonTag("storage_blocks/flax");
        public static final TagKey<Block> STORAGE_BLOCKS_GREEN_BEAN = commonTag("storage_blocks/green_bean");
        public static final TagKey<Block> STORAGE_BLOCKS_HOPS = commonTag("storage_blocks/hops");
        public static final TagKey<Block> STORAGE_BLOCKS_ONION = commonTag("storage_blocks/onion");
        public static final TagKey<Block> STORAGE_BLOCKS_PEANUT = commonTag("storage_blocks/peanut");
        public static final TagKey<Block> STORAGE_BLOCKS_RADISH = commonTag("storage_blocks/radish");
        public static final TagKey<Block> STORAGE_BLOCKS_RICE = commonTag("storage_blocks/rice");
        public static final TagKey<Block> STORAGE_BLOCKS_SADIROOT = commonTag("storage_blocks/sadiroot");
        public static final TagKey<Block> STORAGE_BLOCKS_SPINACH = commonTag("storage_blocks/spinach");
        public static final TagKey<Block> STORAGE_BLOCKS_STRAWBERRY = commonTag("storage_blocks/strawberry");
        public static final TagKey<Block> STORAGE_BLOCKS_TEA = commonTag("storage_blocks/tea");
        public static final TagKey<Block> STORAGE_BLOCKS_TOMATO = commonTag("storage_blocks/tomato");

        // region HELPERS
        private static TagKey<Block> thermalTag(String name) {

            return BlockTags.create(new ResourceLocation(ID_THERMAL, name));
        }

        private static TagKey<Block> commonTag(String name) {

            return BlockTags.create(new ResourceLocation("c", name));
        }
        // endregion
    }

    public static class Items {

        public static final TagKey<Item> DOUGH = commonTag("dough");
        public static final TagKey<Item> FLOUR = commonTag("flour");

        public static final TagKey<Item> CROPS_AMARANTH = commonTag("crops/amaranth");
        public static final TagKey<Item> CROPS_BARLEY = commonTag("crops/barley");
        public static final TagKey<Item> CROPS_BELL_PEPPER = commonTag("crops/bell_pepper");
        public static final TagKey<Item> CROPS_COFFEE = commonTag("crops/coffee");
        public static final TagKey<Item> CROPS_CORN = commonTag("crops/corn");
        public static final TagKey<Item> CROPS_EGGPLANT = commonTag("crops/eggplant");
        public static final TagKey<Item> CROPS_FLAX = commonTag("crops/flax");
        public static final TagKey<Item> CROPS_GREEN_BEAN = commonTag("crops/green_bean");
        public static final TagKey<Item> CROPS_HOPS = commonTag("crops/hops");
        public static final TagKey<Item> CROPS_ONION = commonTag("crops/onion");
        public static final TagKey<Item> CROPS_PEANUT = commonTag("crops/peanut");
        public static final TagKey<Item> CROPS_RADISH = commonTag("crops/radish");
        public static final TagKey<Item> CROPS_RICE = commonTag("crops/rice");
        public static final TagKey<Item> CROPS_SADIROOT = commonTag("crops/sadiroot");
        public static final TagKey<Item> CROPS_SPINACH = commonTag("crops/spinach");
        public static final TagKey<Item> CROPS_STRAWBERRY = commonTag("crops/strawberry");
        public static final TagKey<Item> CROPS_TEA = commonTag("crops/tea");
        public static final TagKey<Item> CROPS_TOMATO = commonTag("crops/tomato");

        public static final TagKey<Item> SEEDS_AMARANTH = commonTag("seeds/amaranth");
        public static final TagKey<Item> SEEDS_BARLEY = commonTag("seeds/barley");
        public static final TagKey<Item> SEEDS_BELL_PEPPER = commonTag("seeds/bell_pepper");
        public static final TagKey<Item> SEEDS_COFFEE = commonTag("seeds/coffee");
        public static final TagKey<Item> SEEDS_CORN = commonTag("seeds/corn");
        public static final TagKey<Item> SEEDS_FROST_MELON = commonTag("seeds/frost_melon");
        public static final TagKey<Item> SEEDS_EGGPLANT = commonTag("seeds/eggplant");
        public static final TagKey<Item> SEEDS_FLAX = commonTag("seeds/flax");
        public static final TagKey<Item> SEEDS_GREEN_BEAN = commonTag("seeds/green_bean");
        public static final TagKey<Item> SEEDS_HOPS = commonTag("seeds/hops");
        public static final TagKey<Item> SEEDS_ONION = commonTag("seeds/onion");
        public static final TagKey<Item> SEEDS_PEANUT = commonTag("seeds/peanut");
        public static final TagKey<Item> SEEDS_RADISH = commonTag("seeds/radish");
        public static final TagKey<Item> SEEDS_RICE = commonTag("seeds/rice");
        public static final TagKey<Item> SEEDS_SADIROOT = commonTag("seeds/sadiroot");
        public static final TagKey<Item> SEEDS_SPINACH = commonTag("seeds/spinach");
        public static final TagKey<Item> SEEDS_STRAWBERRY = commonTag("seeds/strawberry");
        public static final TagKey<Item> SEEDS_TEA = commonTag("seeds/tea");
        public static final TagKey<Item> SEEDS_TOMATO = commonTag("seeds/tomato");

        public static final TagKey<Item> STORAGE_BLOCKS_AMARANTH = commonTag("storage_blocks/amaranth");
        public static final TagKey<Item> STORAGE_BLOCKS_BARLEY = commonTag("storage_blocks/barley");
        public static final TagKey<Item> STORAGE_BLOCKS_BELL_PEPPER = commonTag("storage_blocks/bell_pepper");
        public static final TagKey<Item> STORAGE_BLOCKS_COFFEE = commonTag("storage_blocks/coffee");
        public static final TagKey<Item> STORAGE_BLOCKS_CORN = commonTag("storage_blocks/corn");
        public static final TagKey<Item> STORAGE_BLOCKS_EGGPLANT = commonTag("storage_blocks/eggplant");
        public static final TagKey<Item> STORAGE_BLOCKS_FLAX = commonTag("storage_blocks/flax");
        public static final TagKey<Item> STORAGE_BLOCKS_GREEN_BEAN = commonTag("storage_blocks/green_bean");
        public static final TagKey<Item> STORAGE_BLOCKS_HOPS = commonTag("storage_blocks/hops");
        public static final TagKey<Item> STORAGE_BLOCKS_ONION = commonTag("storage_blocks/onion");
        public static final TagKey<Item> STORAGE_BLOCKS_PEANUT = commonTag("storage_blocks/peanut");
        public static final TagKey<Item> STORAGE_BLOCKS_RADISH = commonTag("storage_blocks/radish");
        public static final TagKey<Item> STORAGE_BLOCKS_RICE = commonTag("storage_blocks/rice");
        public static final TagKey<Item> STORAGE_BLOCKS_SADIROOT = commonTag("storage_blocks/sadiroot");
        public static final TagKey<Item> STORAGE_BLOCKS_SPINACH = commonTag("storage_blocks/spinach");
        public static final TagKey<Item> STORAGE_BLOCKS_STRAWBERRY = commonTag("storage_blocks/strawberry");
        public static final TagKey<Item> STORAGE_BLOCKS_TEA = commonTag("storage_blocks/tea");
        public static final TagKey<Item> STORAGE_BLOCKS_TOMATO = commonTag("storage_blocks/tomato");

        // region HELPERS
        private static TagKey<Item> thermalTag(String name) {

            return ItemTags.create(new ResourceLocation(ID_THERMAL, name));
        }

        private static TagKey<Item> commonTag(String name) {

            return ItemTags.create(new ResourceLocation("c", name));
        }
        // endregion
    }

}
