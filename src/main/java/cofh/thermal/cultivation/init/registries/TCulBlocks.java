package cofh.thermal.cultivation.init.registries;

import cofh.lib.common.block.*;
import cofh.thermal.core.common.block.ChargedSoilBlock;
import cofh.thermal.core.common.block.TilledChargedSoilBlock;
import cofh.thermal.cultivation.common.block.*;
import cofh.thermal.cultivation.common.item.PotionCakeBlockItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.Vec3;

import static cofh.lib.util.constants.BlockStatePropertiesCoFH.AGE_0_4;
import static cofh.lib.util.constants.ModIds.ID_THERMAL;
import static cofh.lib.util.constants.ModIds.ID_THERMAL_CULTIVATION;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.common.block.ChargedSoilBlock.CHARGED;
import static cofh.thermal.core.init.registries.ThermalCreativeTabs.blocksTab;
import static cofh.thermal.core.init.registries.ThermalCreativeTabs.foodsTab;
import static cofh.thermal.core.util.RegistrationHelper.*;
import static cofh.thermal.cultivation.common.config.ThermalCropConfig.*;
import static cofh.thermal.cultivation.init.registries.TCulFoods.*;
import static cofh.thermal.cultivation.init.registries.TCulIDs.*;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.of;
import static net.minecraft.world.level.material.MapColor.*;

public class TCulBlocks {

    private TCulBlocks() {

    }

    public static void register() {

        registerPlants();
        registerFoods();
        registerStorage();
        registerMisc();
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
    }

    protected static final ResourceKey<DamageType> SADIROOT_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ID_THERMAL, "sadiroot"));

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
        BLOCKS.register(ID_SADIROOT, () -> new CropBlockCoFH(of().mapColor(PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.CROP)) {

            @Override
            public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {

                if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
                    entity.makeStuckInBlock(state, new Vec3(0.8F, 0.75D, 0.8F));
                    if (!world.isClientSide && state.getValue(getAgeProperty()) > 4 && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
                        double d0 = Math.abs(entity.getX() - entity.xOld);
                        double d1 = Math.abs(entity.getZ() - entity.zOld);
                        if (d0 >= (double) 0.003F || d1 >= (double) 0.003F) {
                            entity.hurt(entity.level.damageSources().source(SADIROOT_DAMAGE), 1.0F);
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

        BLOCKS.register(ID_GLOWSTONE_MUSHROOM, () -> new CropBlockMushroom(of().mapColor(PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.NETHER_WART).lightLevel((state) -> state.getValue(AGE_0_4) == 4 ? 12 : 0)) {

            @Override
            public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {

                return glowstoneMushroomLight.get() ? state.getLightEmission() : 0;
            }
        }.seed(ITEMS.getSup(spores(ID_GLOWSTONE_MUSHROOM))));
        registerMushroom(ID_GUNPOWDER_MUSHROOM);
        BLOCKS.register(ID_REDSTONE_MUSHROOM, () -> new CropBlockMushroom(of().mapColor(PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.NETHER_WART).lightLevel((state) -> state.getValue(AGE_0_4) == 4 ? 7 : 0)) {

            @Override
            public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {

                return redstoneMushroomLight.get() ? state.getLightEmission() : 0;
            }

            @Override
            public boolean isSignalSource(BlockState state) {

                return redstoneMushroomSignal.get();
            }

            @Override
            public int getSignal(BlockState blockState, BlockGetter blockAccess, BlockPos pos, Direction side) {

                return redstoneMushroomSignal.get() && blockState.getValue(AGE_0_4) == 4 ? 7 : 0;
            }
        }.seed(ITEMS.getSup(spores(ID_REDSTONE_MUSHROOM))));
        registerMushroom(ID_SLIME_MUSHROOM);

        // STEM
        registerBlock(ID_FROST_MELON, () -> new FrostMelonBlock(of().mapColor(COLOR_CYAN).randomTicks().strength(1.0F).sound(SoundType.SNOW)), Rarity.UNCOMMON, ID_THERMAL_CULTIVATION);
        registerBlockOnly(ID_FROST_MELON_STEM, () -> new StemBlockCoFH(of().mapColor(PLANT).randomTicks().noCollission().strength(0.0F).sound(SoundType.WOOD), ITEMS.getSup(seeds(ID_FROST_MELON))).crop(BLOCKS.getSup(ID_FROST_MELON)));
        registerBlockOnly(ID_FROST_MELON_STEM_ATTACHED, () -> new AttachedStemBlockCoFH(of().mapColor(PLANT).noCollission().strength(0.0F).sound(SoundType.HARD_CROP), ITEMS.getSup(seeds(ID_FROST_MELON))).crop(BLOCKS.getSup(ID_FROST_MELON)));
    }

    private static void registerFoods() {

        foodsTab(500, registerBlock(ID_CHEESE_WHEEL, () -> new CheeseWheelBlock(of().forceSolidOn().strength(1.0F).sound(SoundType.WOOL), CHEESE).serving(ITEMS.getSup(ID_CHEESE_WEDGE)), ID_THERMAL_CULTIVATION));
        foodsTab(500, registerBlock(ID_STUFFED_PUMPKIN, () -> new FeastBlock(of().mapColor(PLANT).forceSolidOn().strength(0.5F).sound(SoundType.WOOD), STUFFED_PUMPKIN), ID_THERMAL_CULTIVATION));

        foodsTab(500, registerBlock(ID_CARROT_CAKE, () -> new CakeBlockCoFH(of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL), CARROT_CAKE).setTall(), ID_THERMAL_CULTIVATION));
        foodsTab(500, registerBlock(ID_CHOCOLATE_CAKE, () -> new CakeBlockCoFH(of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL), CHOCOLATE_CAKE), ID_THERMAL_CULTIVATION));

        foodsTab(500, registerBlock(ID_POTION_CAKE,
                () -> new PotionCakeBlock(of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY), POTION_CAKE),
                () -> new PotionCakeBlockItem(BLOCKS.get(ID_POTION_CAKE), new Item.Properties()).setModId(ID_THERMAL_CULTIVATION)));

        foodsTab(500, registerBlock(ID_SPICE_CAKE, () -> new CakeBlockCoFH(of().strength(0.5F).sound(SoundType.WOOL), SPICE_CAKE), ID_THERMAL_CULTIVATION));
    }

    private static void registerStorage() {

        foodsTab(1000, registerBlock(block(ID_AMARANTH), () -> new HayBlock(of().mapColor(COLOR_RED).strength(0.5F).sound(SoundType.GRASS)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_BARLEY), () -> new HayBlock(of().mapColor(GOLD).strength(0.5F).sound(SoundType.GRASS)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_CORN), () -> new Block(of().mapColor(COLOR_YELLOW).strength(1.5F).sound(SoundType.SCAFFOLDING)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_FLAX), () -> new HayBlock(of().mapColor(COLOR_PURPLE).strength(0.5F).sound(SoundType.GRASS)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_ONION), () -> new Block(of().mapColor(TERRACOTTA_WHITE).strength(1.5F).sound(SoundType.SCAFFOLDING)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_RADISH), () -> new Block(of().mapColor(TERRACOTTA_RED).strength(1.5F).sound(SoundType.SCAFFOLDING)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_SADIROOT), () -> new Block(of().mapColor(TERRACOTTA_GREEN).strength(1.5F).sound(SoundType.SCAFFOLDING)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_SPINACH), () -> new Block(of().mapColor(COLOR_GREEN).strength(1.5F).sound(SoundType.SCAFFOLDING)), ID_THERMAL_CULTIVATION));

        foodsTab(1000, registerBlock(block(ID_BELL_PEPPER), () -> new Block(of().mapColor(TERRACOTTA_RED).strength(1.5F).sound(SoundType.SCAFFOLDING)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_EGGPLANT), () -> new Block(of().mapColor(TERRACOTTA_PURPLE).strength(1.5F).sound(SoundType.SCAFFOLDING)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_GREEN_BEAN), () -> new Block(of().mapColor(COLOR_GREEN).strength(1.5F).sound(SoundType.SCAFFOLDING)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_HOPS), () -> new Block(of().mapColor(COLOR_GREEN).strength(1.5F).sound(SoundType.SCAFFOLDING)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_STRAWBERRY), () -> new Block(of().mapColor(TERRACOTTA_RED).strength(1.5F).sound(SoundType.SCAFFOLDING)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_TOMATO), () -> new Block(of().mapColor(COLOR_RED).strength(1.5F).sound(SoundType.SCAFFOLDING)), ID_THERMAL_CULTIVATION));

        foodsTab(1000, registerBlock(block(ID_RICE), () -> new DirectionalBlock4Way(of().mapColor(TERRACOTTA_WHITE).strength(0.5F).sound(SoundType.WART_BLOCK)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_PEANUT), () -> new DirectionalBlock4Way(of().mapColor(TERRACOTTA_BROWN).strength(0.5F).sound(SoundType.WART_BLOCK)), ID_THERMAL_CULTIVATION));

        foodsTab(1000, registerBlock(block(ID_COFFEE), () -> new DirectionalBlock4Way(of().mapColor(TERRACOTTA_RED).strength(0.5F).sound(SoundType.WART_BLOCK)), ID_THERMAL_CULTIVATION));
        foodsTab(1000, registerBlock(block(ID_TEA), () -> new DirectionalBlock4Way(of().mapColor(TERRACOTTA_GREEN).strength(0.5F).sound(SoundType.WART_BLOCK)), ID_THERMAL_CULTIVATION));
    }

    private static void registerMisc() {

        blocksTab(50, registerBlock(ID_PHYTOSOIL, () -> new ChargedSoilBlock(of().randomTicks().strength(0.8F).sound(SoundType.GRAVEL).lightLevel((state) -> state.getValue(CHARGED) > 0 ? 7 : 0)).otherBlock(BLOCKS.getSup(ID_PHYTOSOIL_TILLED)), ID_THERMAL_CULTIVATION));
        blocksTab(50, registerBlock(ID_PHYTOSOIL_TILLED, () -> new TilledChargedSoilBlock(of().randomTicks().strength(0.8F).sound(SoundType.GRAVEL).lightLevel((state) -> state.getValue(CHARGED) > 0 ? 7 : 0)).otherBlock(BLOCKS.getSup(ID_PHYTOSOIL)), ID_THERMAL_CULTIVATION));
    }

    private static void registerAmaranth(String id) {

        BLOCKS.register(id, () -> new AmaranthCrop(of().mapColor(PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.CROP)).crop(ITEMS.getSup(id)).seed(ITEMS.getSup(seeds(id))));
    }

    public static void registerAnnual(String id) {

        BLOCKS.register(id, () -> new CropBlockCoFH(of().mapColor(MapColor.PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.CROP)).crop(ITEMS.getSup(id)).seed(ITEMS.getSup(seeds(id))));
    }

    private static void registerTallAnnual(String id) {

        BLOCKS.register(id, () -> new CropBlockTall(of().mapColor(MapColor.PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.CROP)).crop(ITEMS.getSup(id)).seed(ITEMS.getSup(seeds(id))));
    }

    private static void registerFlax(String id) {

        BLOCKS.register(id, () -> new FlaxCrop(of().mapColor(PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.CROP)).crop(ITEMS.getSup(id)).seed(ITEMS.getSup(seeds(id))));
    }

    private static void registerMushroom(String id) {

        BLOCKS.register(id, () -> new CropBlockMushroom(of().mapColor(PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.NETHER_WART)).seed(ITEMS.getSup(spores(id))));
    }

    private static void registerPerennial(String id) {

        registerPerennial(id, CropBlockPerennial.DEFAULT_POST_HARVEST_AGE);
    }

    private static void registerPerennial(String id, int postHarvestAge) {

        BLOCKS.register(id, () -> new CropBlockPerennial(of().mapColor(MapColor.PLANT).noCollission().randomTicks().strength(0.0F, 0.0F).sound(SoundType.CROP)).postHarvestAge(postHarvestAge).crop(ITEMS.getSup(id)).seed(ITEMS.getSup(seeds(id))));
    }
    // endregion
}
