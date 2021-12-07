package cofh.thermal.cultivation.init;

import cofh.lib.block.impl.*;
import cofh.lib.block.impl.crops.AttachedStemBlockCoFH;
import cofh.lib.block.impl.crops.CropsBlockCoFH;
import cofh.lib.block.impl.crops.CropsBlockMushroom;
import cofh.lib.block.impl.crops.StemBlockCoFH;
import cofh.thermal.cultivation.block.*;
import cofh.thermal.cultivation.item.PotionCakeBlockItem;
import cofh.thermal.cultivation.tileentity.PotionCakeTile;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import static cofh.lib.util.constants.Constants.*;
import static cofh.thermal.core.ThermalCore.*;
import static cofh.thermal.core.util.RegistrationHelper.*;
import static cofh.thermal.cultivation.init.TCulFoods.*;
import static cofh.thermal.cultivation.init.TCulIDs.*;
import static cofh.thermal.cultivation.init.TCulReferences.POTION_CAKE_BLOCK;
import static cofh.thermal.lib.common.ThermalItemGroups.THERMAL_CROPS;
import static net.minecraft.block.AbstractBlock.Properties.of;

public class TCulBlocks {

    private TCulBlocks() {

    }

    public static void register() {

        registerPlants();
        registerFoods();
        registerStorage();
        registerMisc();
        registerTileEntities();
    }

    public static void setup() {

        FireBlock fire = (FireBlock) Blocks.FIRE;

        fire.setFlammable(BLOCKS.get(block(ID_AMARANTH)), 60, 20);
        fire.setFlammable(BLOCKS.get(block(ID_BARLEY)), 60, 20);
        fire.setFlammable(BLOCKS.get(block(ID_FLAX)), 60, 20);

        // CROPS
        {
            float chance = 0.65F;

            ComposterBlock.add(chance, ITEMS.get(ID_AMARANTH));
            ComposterBlock.add(chance, ITEMS.get(ID_BARLEY));
            ComposterBlock.add(chance, ITEMS.get(ID_CORN));
            ComposterBlock.add(chance, ITEMS.get(ID_FLAX));
            ComposterBlock.add(chance, ITEMS.get(ID_ONION));
            ComposterBlock.add(chance, ITEMS.get(ID_RADISH));
            ComposterBlock.add(chance, ITEMS.get(ID_RICE));
            ComposterBlock.add(chance, ITEMS.get(ID_SADIROOT));
            ComposterBlock.add(chance, ITEMS.get(ID_SPINACH));

            ComposterBlock.add(chance, ITEMS.get(ID_BELL_PEPPER));
            ComposterBlock.add(chance, ITEMS.get(ID_EGGPLANT));
            ComposterBlock.add(chance, ITEMS.get(ID_GREEN_BEAN));
            ComposterBlock.add(chance, ITEMS.get(ID_PEANUT));
            ComposterBlock.add(chance, ITEMS.get(ID_STRAWBERRY));
            ComposterBlock.add(chance, ITEMS.get(ID_TOMATO));

            ComposterBlock.add(chance, ITEMS.get(ID_COFFEE));
            ComposterBlock.add(chance, ITEMS.get(ID_TEA));

            ComposterBlock.add(chance, ITEMS.get(ID_FROST_MELON));
        }
        {
            float chance = 0.5F;

            ComposterBlock.add(chance, ITEMS.get(ID_FROST_MELON_SLICE));
        }
        // SEEDS
        {
            float chance = 0.3F;

            ComposterBlock.add(chance, ITEMS.get(seeds(ID_AMARANTH)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_BARLEY)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_CORN)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_FLAX)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_ONION)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_RADISH)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_RICE)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_SADIROOT)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_SPINACH)));

            ComposterBlock.add(chance, ITEMS.get(seeds(ID_BELL_PEPPER)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_EGGPLANT)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_GREEN_BEAN)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_PEANUT)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_STRAWBERRY)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_TOMATO)));

            ComposterBlock.add(chance, ITEMS.get(seeds(ID_COFFEE)));
            ComposterBlock.add(chance, ITEMS.get(seeds(ID_TEA)));

            ComposterBlock.add(chance, ITEMS.get(seeds(ID_FROST_MELON)));
        }
        HoeItem.TILLABLES.put(BLOCKS.get(ID_PHYTOSOIL), BLOCKS.get(ID_PHYTOSOIL_TILLED).defaultBlockState());
    }

    public static DamageSource SADIROOT_DAMAGE = new DamageSource("sadiroot");

    // region HELPERS
    private static void registerPlants() {

        // ANNUAL
        registerAmaranth(ID_AMARANTH);
        registerAnnual(ID_BARLEY);
        registerTallAnnual(ID_CORN);
        registerFlax(ID_FLAX);
        registerAnnual(ID_ONION);
        registerAnnual(ID_RADISH);
        registerAnnual(ID_RICE);
        // registerAnnual(ID_SADIROOT);
        // Sadiroot is a thistle!
        BLOCKS.register(ID_SADIROOT, () -> new CropsBlockCoFH(of(Material.PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.CROP)) {

            @Override
            public void entityInside(BlockState state, World world, BlockPos pos, Entity entity) {

                if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
                    entity.makeStuckInBlock(state, new Vector3d(0.8F, 0.75D, 0.8F));
                    if (!world.isClientSide && state.getValue(getAgeProperty()) > 4 && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
                        double d0 = Math.abs(entity.getX() - entity.xOld);
                        double d1 = Math.abs(entity.getZ() - entity.zOld);
                        if (d0 >= (double) 0.003F || d1 >= (double) 0.003F) {
                            entity.hurt(SADIROOT_DAMAGE, 1.0F);
                        }
                    }
                }
                super.entityInside(state, world, pos, entity);
            }
        }.crop(ITEMS.getSup(ID_SADIROOT)).seed(ITEMS.getSup(seeds(ID_SADIROOT))));

        registerAnnual(ID_SPINACH);

        // PERENNIAL
        registerPerennial(ID_BELL_PEPPER);
        registerPerennial(ID_EGGPLANT);
        registerPerennial(ID_GREEN_BEAN);
        registerPerennial(ID_PEANUT);
        registerPerennial(ID_STRAWBERRY);
        registerPerennial(ID_TOMATO);

        registerPerennial(ID_COFFEE, 6);
        // registerTallPerennial(ID_HOPS);
        registerPerennial(ID_TEA);

        BLOCKS.register(ID_GLOWSTONE_MUSHROOM, () -> new CropsBlockMushroom(of(Material.PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.NETHER_WART).lightLevel((state) -> state.getValue(AGE_0_4) == 4 ? 12 : 0)).seed(ITEMS.getSup(spores(ID_GLOWSTONE_MUSHROOM))));
        registerMushroom(ID_GUNPOWDER_MUSHROOM);
        BLOCKS.register(ID_REDSTONE_MUSHROOM, () -> new CropsBlockMushroom(of(Material.PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.NETHER_WART).lightLevel((state) -> state.getValue(AGE_0_4) == 4 ? 7 : 0)) {

            @Override
            public boolean isSignalSource(BlockState state) {

                return true;
            }

            @Override
            public int getSignal(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {

                return blockState.getValue(AGE_0_4) == 4 ? 7 : 0;
            }
        }.seed(ITEMS.getSup(spores(ID_REDSTONE_MUSHROOM))));
        registerMushroom(ID_SLIME_MUSHROOM);

        // STEM
        registerBlock(ID_FROST_MELON, () -> new FrostMelonBlock(of(Material.VEGETABLE, MaterialColor.COLOR_CYAN).randomTicks().strength(1.0F).harvestTool(ToolType.AXE).sound(SoundType.SNOW)), THERMAL_CROPS, Rarity.UNCOMMON, ID_THERMAL_CULTIVATION);
        registerBlockOnly(ID_FROST_MELON_STEM, () -> new StemBlockCoFH(of(Material.PLANT).randomTicks().noCollission().strength(0.0F).sound(SoundType.WOOD)).crop(BLOCKS.getSup(ID_FROST_MELON)).seed(ITEMS.getSup(seeds(ID_FROST_MELON))));
        registerBlockOnly(ID_FROST_MELON_STEM_ATTACHED, () -> new AttachedStemBlockCoFH(of(Material.PLANT).noCollission().strength(0.0F).sound(SoundType.HARD_CROP)).crop(BLOCKS.getSup(ID_FROST_MELON)).seed(ITEMS.getSup(seeds(ID_FROST_MELON))));
    }

    private static void registerFoods() {

        registerBlock(ID_CHEESE_WHEEL, () -> new CheeseWheelBlock(of(Material.CAKE).strength(1.0F).sound(SoundType.SHROOMLIGHT), CHEESE).serving(ITEMS.getSup(ID_CHEESE_WEDGE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(ID_STUFFED_PUMPKIN, () -> new FeastBlock(of(Material.PLANT).strength(0.5F).sound(SoundType.WOOD), STUFFED_PUMPKIN), THERMAL_CROPS, ID_THERMAL_CULTIVATION);

        registerBlock(ID_CARROT_CAKE, () -> new CakeBlockCoFH(of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL), CARROT_CAKE).setTall(), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(ID_CHOCOLATE_CAKE, () -> new CakeBlockCoFH(of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL), CHOCOLATE_CAKE), THERMAL_CROPS, ID_THERMAL_CULTIVATION);

        registerBlockAndItem(ID_POTION_CAKE,
                () -> new PotionCakeBlock(of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL), POTION_CAKE),
                () -> new PotionCakeBlockItem(BLOCKS.get(ID_POTION_CAKE), new Item.Properties().tab(THERMAL_CROPS)).setModId(ID_THERMAL_CULTIVATION));

        registerBlock(ID_SPICE_CAKE, () -> new CakeBlockCoFH(of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL), SPICE_CAKE), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
    }

    private static void registerStorage() {

        registerBlock(block(ID_AMARANTH), () -> new HayBlock(of(Material.GRASS, MaterialColor.COLOR_RED).strength(0.5F).sound(SoundType.GRASS).harvestTool(ToolType.HOE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_BARLEY), () -> new HayBlock(of(Material.GRASS, MaterialColor.GOLD).strength(0.5F).sound(SoundType.GRASS).harvestTool(ToolType.HOE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_CORN), () -> new Block(of(Material.WOOD, MaterialColor.COLOR_YELLOW).strength(1.5F).sound(SoundType.SCAFFOLDING).harvestTool(ToolType.AXE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_FLAX), () -> new HayBlock(of(Material.GRASS, MaterialColor.COLOR_PURPLE).strength(0.5F).sound(SoundType.GRASS).harvestTool(ToolType.HOE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_ONION), () -> new Block(of(Material.WOOD, MaterialColor.TERRACOTTA_WHITE).strength(1.5F).sound(SoundType.SCAFFOLDING).harvestTool(ToolType.AXE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_RADISH), () -> new Block(of(Material.WOOD, MaterialColor.TERRACOTTA_RED).strength(1.5F).sound(SoundType.SCAFFOLDING).harvestTool(ToolType.AXE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_SADIROOT), () -> new Block(of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).strength(1.5F).sound(SoundType.SCAFFOLDING).harvestTool(ToolType.AXE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_SPINACH), () -> new Block(of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(1.5F).sound(SoundType.SCAFFOLDING).harvestTool(ToolType.AXE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);

        registerBlock(block(ID_BELL_PEPPER), () -> new Block(of(Material.WOOD, MaterialColor.TERRACOTTA_RED).strength(1.5F).sound(SoundType.SCAFFOLDING).harvestTool(ToolType.AXE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_EGGPLANT), () -> new Block(of(Material.WOOD, MaterialColor.TERRACOTTA_PURPLE).strength(1.5F).sound(SoundType.SCAFFOLDING).harvestTool(ToolType.AXE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_GREEN_BEAN), () -> new Block(of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(1.5F).sound(SoundType.SCAFFOLDING).harvestTool(ToolType.AXE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_HOPS), () -> new Block(of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(1.5F).sound(SoundType.SCAFFOLDING).harvestTool(ToolType.AXE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_STRAWBERRY), () -> new Block(of(Material.WOOD, MaterialColor.TERRACOTTA_RED).strength(1.5F).sound(SoundType.SCAFFOLDING).harvestTool(ToolType.AXE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_TOMATO), () -> new Block(of(Material.WOOD, MaterialColor.COLOR_RED).strength(1.5F).sound(SoundType.SCAFFOLDING).harvestTool(ToolType.AXE)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);

        registerBlock(block(ID_RICE), () -> new DirectionalBlock4Way(of(Material.WOOL, MaterialColor.TERRACOTTA_WHITE).strength(0.5F).sound(SoundType.WART_BLOCK)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_PEANUT), () -> new DirectionalBlock4Way(of(Material.WOOL, MaterialColor.TERRACOTTA_BROWN).strength(0.5F).sound(SoundType.WART_BLOCK)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);

        registerBlock(block(ID_COFFEE), () -> new DirectionalBlock4Way(of(Material.WOOL, MaterialColor.TERRACOTTA_RED).strength(0.5F).sound(SoundType.WART_BLOCK)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
        registerBlock(block(ID_TEA), () -> new DirectionalBlock4Way(of(Material.WOOL, MaterialColor.TERRACOTTA_GREEN).strength(0.5F).sound(SoundType.WART_BLOCK)), THERMAL_CROPS, ID_THERMAL_CULTIVATION);
    }

    private static void registerMisc() {

        registerBlock(ID_PHYTOSOIL, () -> new SoilBlock(of(Material.DIRT).randomTicks().strength(0.8F).harvestTool(ToolType.SHOVEL).sound(SoundType.GRAVEL).lightLevel((state) -> state.getValue(CHARGED) > 0 ? 7 : 0)), ID_THERMAL_CULTIVATION);
        registerBlock(ID_PHYTOSOIL_TILLED, () -> new TilledSoilBlock(of(Material.DIRT).randomTicks().strength(0.8F).harvestTool(ToolType.SHOVEL).sound(SoundType.GRAVEL).lightLevel((state) -> state.getValue(CHARGED) > 0 ? 7 : 0)).dirt(BLOCKS.getSup(ID_PHYTOSOIL)), ID_THERMAL_CULTIVATION);
    }

    private static void registerAmaranth(String id) {

        BLOCKS.register(id, () -> new AmaranthCrop(of(Material.PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.CROP)).crop(ITEMS.getSup(id)).seed(ITEMS.getSup(seeds(id))));
    }

    private static void registerFlax(String id) {

        BLOCKS.register(id, () -> new FlaxCrop(of(Material.PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.CROP)).crop(ITEMS.getSup(id)).seed(ITEMS.getSup(seeds(id))));
    }

    private static void registerMushroom(String id) {

        BLOCKS.register(id, () -> new CropsBlockMushroom(of(Material.PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.NETHER_WART)).seed(ITEMS.getSup(spores(id))));
    }

    private static void registerTileEntities() {

        TILE_ENTITIES.register(ID_POTION_CAKE, () -> TileEntityType.Builder.of(PotionCakeTile::new, POTION_CAKE_BLOCK).build(null));
    }
    // endregion
}
