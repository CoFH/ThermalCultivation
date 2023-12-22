package cofh.thermal.cultivation.init.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static cofh.lib.util.constants.ModIds.ID_FORGE;
import static cofh.lib.util.constants.ModIds.ID_THERMAL;

public class TCulTags {

    private TCulTags() {

    }

    public static class Blocks {

        public static final TagKey<Block> STORAGE_BLOCKS_AMARANTH = forgeTag("storage_blocks/amaranth");
        public static final TagKey<Block> STORAGE_BLOCKS_BARLEY = forgeTag("storage_blocks/barley");
        public static final TagKey<Block> STORAGE_BLOCKS_BELL_PEPPER = forgeTag("storage_blocks/bell_pepper");
        public static final TagKey<Block> STORAGE_BLOCKS_COFFEE = forgeTag("storage_blocks/coffee");
        public static final TagKey<Block> STORAGE_BLOCKS_CORN = forgeTag("storage_blocks/corn");
        public static final TagKey<Block> STORAGE_BLOCKS_EGGPLANT = forgeTag("storage_blocks/eggplant");
        public static final TagKey<Block> STORAGE_BLOCKS_FLAX = forgeTag("storage_blocks/flax");
        public static final TagKey<Block> STORAGE_BLOCKS_GREEN_BEAN = forgeTag("storage_blocks/green_bean");
        public static final TagKey<Block> STORAGE_BLOCKS_HOPS = forgeTag("storage_blocks/hops");
        public static final TagKey<Block> STORAGE_BLOCKS_ONION = forgeTag("storage_blocks/onion");
        public static final TagKey<Block> STORAGE_BLOCKS_PEANUT = forgeTag("storage_blocks/peanut");
        public static final TagKey<Block> STORAGE_BLOCKS_RADISH = forgeTag("storage_blocks/radish");
        public static final TagKey<Block> STORAGE_BLOCKS_RICE = forgeTag("storage_blocks/rice");
        public static final TagKey<Block> STORAGE_BLOCKS_SADIROOT = forgeTag("storage_blocks/sadiroot");
        public static final TagKey<Block> STORAGE_BLOCKS_SPINACH = forgeTag("storage_blocks/spinach");
        public static final TagKey<Block> STORAGE_BLOCKS_STRAWBERRY = forgeTag("storage_blocks/strawberry");
        public static final TagKey<Block> STORAGE_BLOCKS_TEA = forgeTag("storage_blocks/tea");
        public static final TagKey<Block> STORAGE_BLOCKS_TOMATO = forgeTag("storage_blocks/tomato");

        // region HELPERS
        private static TagKey<Block> thermalTag(String name) {

            return BlockTags.create(new ResourceLocation(ID_THERMAL, name));
        }

        private static TagKey<Block> forgeTag(String name) {

            return BlockTags.create(new ResourceLocation(ID_FORGE, name));
        }
        // endregion
    }

    public static class Items {

        public static final TagKey<Item> CROPS_AMARANTH = forgeTag("crops/amaranth");
        public static final TagKey<Item> CROPS_BARLEY = forgeTag("crops/barley");
        public static final TagKey<Item> CROPS_BELL_PEPPER = forgeTag("crops/bell_pepper");
        public static final TagKey<Item> CROPS_COFFEE = forgeTag("crops/coffee");
        public static final TagKey<Item> CROPS_CORN = forgeTag("crops/corn");
        public static final TagKey<Item> CROPS_EGGPLANT = forgeTag("crops/eggplant");
        public static final TagKey<Item> CROPS_FLAX = forgeTag("crops/flax");
        public static final TagKey<Item> CROPS_GREEN_BEAN = forgeTag("crops/green_bean");
        public static final TagKey<Item> CROPS_HOPS = forgeTag("crops/hops");
        public static final TagKey<Item> CROPS_ONION = forgeTag("crops/onion");
        public static final TagKey<Item> CROPS_PEANUT = forgeTag("crops/peanut");
        public static final TagKey<Item> CROPS_RADISH = forgeTag("crops/radish");
        public static final TagKey<Item> CROPS_RICE = forgeTag("crops/rice");
        public static final TagKey<Item> CROPS_SADIROOT = forgeTag("crops/sadiroot");
        public static final TagKey<Item> CROPS_SPINACH = forgeTag("crops/spinach");
        public static final TagKey<Item> CROPS_STRAWBERRY = forgeTag("crops/strawberry");
        public static final TagKey<Item> CROPS_TEA = forgeTag("crops/tea");
        public static final TagKey<Item> CROPS_TOMATO = forgeTag("crops/tomato");

        public static final TagKey<Item> SEEDS_AMARANTH = forgeTag("seeds/amaranth");
        public static final TagKey<Item> SEEDS_BARLEY = forgeTag("seeds/barley");
        public static final TagKey<Item> SEEDS_BELL_PEPPER = forgeTag("seeds/bell_pepper");
        public static final TagKey<Item> SEEDS_COFFEE = forgeTag("seeds/coffee");
        public static final TagKey<Item> SEEDS_CORN = forgeTag("seeds/corn");
        public static final TagKey<Item> SEEDS_FROST_MELON = forgeTag("seeds/frost_melon");
        public static final TagKey<Item> SEEDS_EGGPLANT = forgeTag("seeds/eggplant");
        public static final TagKey<Item> SEEDS_FLAX = forgeTag("seeds/flax");
        public static final TagKey<Item> SEEDS_GREEN_BEAN = forgeTag("seeds/green_bean");
        public static final TagKey<Item> SEEDS_HOPS = forgeTag("seeds/hops");
        public static final TagKey<Item> SEEDS_ONION = forgeTag("seeds/onion");
        public static final TagKey<Item> SEEDS_PEANUT = forgeTag("seeds/peanut");
        public static final TagKey<Item> SEEDS_RADISH = forgeTag("seeds/radish");
        public static final TagKey<Item> SEEDS_RICE = forgeTag("seeds/rice");
        public static final TagKey<Item> SEEDS_SADIROOT = forgeTag("seeds/sadiroot");
        public static final TagKey<Item> SEEDS_SPINACH = forgeTag("seeds/spinach");
        public static final TagKey<Item> SEEDS_STRAWBERRY = forgeTag("seeds/strawberry");
        public static final TagKey<Item> SEEDS_TEA = forgeTag("seeds/tea");
        public static final TagKey<Item> SEEDS_TOMATO = forgeTag("seeds/tomato");

        public static final TagKey<Item> STORAGE_BLOCKS_AMARANTH = forgeTag("storage_blocks/amaranth");
        public static final TagKey<Item> STORAGE_BLOCKS_BARLEY = forgeTag("storage_blocks/barley");
        public static final TagKey<Item> STORAGE_BLOCKS_BELL_PEPPER = forgeTag("storage_blocks/bell_pepper");
        public static final TagKey<Item> STORAGE_BLOCKS_COFFEE = forgeTag("storage_blocks/coffee");
        public static final TagKey<Item> STORAGE_BLOCKS_CORN = forgeTag("storage_blocks/corn");
        public static final TagKey<Item> STORAGE_BLOCKS_EGGPLANT = forgeTag("storage_blocks/eggplant");
        public static final TagKey<Item> STORAGE_BLOCKS_FLAX = forgeTag("storage_blocks/flax");
        public static final TagKey<Item> STORAGE_BLOCKS_GREEN_BEAN = forgeTag("storage_blocks/green_bean");
        public static final TagKey<Item> STORAGE_BLOCKS_HOPS = forgeTag("storage_blocks/hops");
        public static final TagKey<Item> STORAGE_BLOCKS_ONION = forgeTag("storage_blocks/onion");
        public static final TagKey<Item> STORAGE_BLOCKS_PEANUT = forgeTag("storage_blocks/peanut");
        public static final TagKey<Item> STORAGE_BLOCKS_RADISH = forgeTag("storage_blocks/radish");
        public static final TagKey<Item> STORAGE_BLOCKS_RICE = forgeTag("storage_blocks/rice");
        public static final TagKey<Item> STORAGE_BLOCKS_SADIROOT = forgeTag("storage_blocks/sadiroot");
        public static final TagKey<Item> STORAGE_BLOCKS_SPINACH = forgeTag("storage_blocks/spinach");
        public static final TagKey<Item> STORAGE_BLOCKS_STRAWBERRY = forgeTag("storage_blocks/strawberry");
        public static final TagKey<Item> STORAGE_BLOCKS_TEA = forgeTag("storage_blocks/tea");
        public static final TagKey<Item> STORAGE_BLOCKS_TOMATO = forgeTag("storage_blocks/tomato");

        // region HELPERS
        private static TagKey<Item> thermalTag(String name) {

            return ItemTags.create(new ResourceLocation(ID_THERMAL, name));
        }

        private static TagKey<Item> forgeTag(String name) {

            return ItemTags.create(new ResourceLocation(ID_FORGE, name));
        }
        // endregion
    }

}
