package cofh.thermal.cultivation.common.item;

import cofh.core.common.item.IMultiModeItem;
import cofh.core.util.ProxyUtils;
import cofh.lib.api.item.IColorableItem;
import cofh.lib.util.Utils;
import cofh.lib.util.raytracer.RayTracer;
import cofh.thermal.core.common.config.ThermalCoreConfig;
import cofh.thermal.lib.common.item.FluidContainerItemAugmentable;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fluids.FluidStack;
import org.apache.commons.lang3.tuple.Triple;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

import static cofh.core.util.helpers.AugmentableHelper.getPropertyWithDefault;
import static cofh.core.util.helpers.AugmentableHelper.setAttributeFromAugmentAdd;
import static cofh.core.util.helpers.FluidHelper.IS_WATER;
import static cofh.core.util.helpers.FluidHelper.isWater;
import static cofh.lib.util.Constants.BUCKET_VOLUME;
import static cofh.lib.util.Constants.RGB_DURABILITY_WATER;
import static cofh.lib.util.constants.NBTTags.*;
import static cofh.thermal.lib.util.ThermalAugmentRules.createAllowValidator;
import static net.minecraftforge.fluids.capability.IFluidHandler.FluidAction.EXECUTE;

public class WateringCanItem extends FluidContainerItemAugmentable implements IColorableItem, DyeableLeatherItem, IMultiModeItem {

    private static final Set<Triple<BlockPos, BlockState, Block>> WATERED_BLOCKS = new ObjectOpenHashSet<>();

    protected static final int MB_PER_USE = 50;

    public static boolean allowFakePlayers = false;
    public static boolean removeSourceBlocks = true;

    protected static final Set<Block> EFFECTIVE_BLOCKS = new ObjectOpenHashSet<>();

    static {
        EFFECTIVE_BLOCKS.add(Blocks.MYCELIUM);
        EFFECTIVE_BLOCKS.add(Blocks.CHORUS_FLOWER);
    }

    public WateringCanItem(Properties builder, int fluidCapacity) {

        super(builder, fluidCapacity, IS_WATER);

        ProxyUtils.registerItemModelProperty(this, new ResourceLocation("color"), (stack, world, entity, seed) -> (hasCustomColor(stack) ? 1.0F : 0));
        ProxyUtils.registerItemModelProperty(this, new ResourceLocation("state"), (stack, world, entity, seed) -> (getFluidAmount(stack) > 0 ? 0.5F : 0) + (hasActiveTag(stack) ? 0.25F : 0));
        ProxyUtils.registerColorable(this);

        numSlots = () -> ThermalCoreConfig.toolAugments;
        augValidator = createAllowValidator(TAG_AUGMENT_TYPE_UPGRADE, TAG_AUGMENT_TYPE_FLUID, TAG_AUGMENT_TYPE_AREA_EFFECT);
    }

    @Override
    protected void tooltipDelegate(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {

        int radius = getMode(stack) * 2 + 1;
        if (radius <= 1) {
            tooltip.add(Component.translatable("info.cofh.single_block").withStyle(ChatFormatting.ITALIC));
        } else {
            tooltip.add(Component.translatable("info.cofh.area").append(": " + radius + "x" + radius).withStyle(ChatFormatting.ITALIC));
        }
        if (getNumModes(stack) > 1) {
            addModeChangeTooltip(this, stack, worldIn, tooltip, flagIn);
        }
        super.tooltipDelegate(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {

        return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged) && (slotChanged || getFluidAmount(oldStack) > 0 != getFluidAmount(newStack) > 0 || getFluidAmount(newStack) > 0 && hasActiveTag(oldStack) != hasActiveTag(newStack));
    }

    @Override
    public int getBarColor(ItemStack stack) {

        return RGB_DURABILITY_WATER;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        if (player == null || Utils.isFakePlayer(player) && !allowFakePlayers) {
            return InteractionResult.FAIL;
        }
        if (player.isSecondaryUseActive()) {
            BlockHitResult traceResult = RayTracer.retrace(player, ClipContext.Fluid.SOURCE_ONLY);
            if (traceResult.getType() != HitResult.Type.MISS) {
                if (isWater(world.getBlockState(traceResult.getBlockPos()))) {
                    return InteractionResult.PASS;
                }
            }
        }
        ItemStack stack = player.getItemInHand(context.getHand());
        BlockPos offsetPos = world.getBlockState(pos).canOcclude() ? pos.relative(context.getClickedFace()) : pos;

        if (getFluidAmount(stack) < getWaterPerUse(stack)) {
            return InteractionResult.FAIL;
        }
        setActive(stack, player);

        int radius = getMode(stack);
        int x = offsetPos.getX();
        int y = offsetPos.getY();
        int z = offsetPos.getZ();

        for (int i = x - radius; i <= x + radius; ++i) {
            for (int k = z - radius; k <= z + radius; ++k) {
                Utils.spawnParticles(world, ParticleTypes.FALLING_WATER, i + world.random.nextDouble(), y - 1 + world.random.nextDouble(), k + world.random.nextDouble(), 1, 0, 0, 0, 0);
            }
        }
        Iterable<BlockPos> area = BlockPos.betweenClosed(offsetPos.offset(-radius, -2, -radius), offsetPos.offset(radius, 1, radius));
        for (BlockPos scan : area) {
            BlockState state = world.getBlockState(scan);
            if (state.getBlock() instanceof FarmBlock) {
                if (state.getValue(FarmBlock.MOISTURE) < 7) {
                    world.setBlockAndUpdate(scan, state.setValue(FarmBlock.MOISTURE, 7));
                }
            }
        }
        if (Utils.isServerWorld(world)) {
            if (world.random.nextFloat() < Math.max(getEffectiveness(stack), 0.05)) {
                for (BlockPos scan : area) {
                    BlockState plantState = world.getBlockState(scan);
                    Block plant = plantState.getBlock();
                    if (plant instanceof BonemealableBlock || plant instanceof IPlantable || EFFECTIVE_BLOCKS.contains(plant)) {
                        WATERED_BLOCKS.add(Triple.of(new BlockPos(scan), plantState, plant));
                    }
                }
            }
            if (!player.abilities.instabuild) {
                drain(stack, getWaterPerUse(stack) * (getMode(stack) + 1) * 2, EXECUTE);
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {

        BlockHitResult traceResult = RayTracer.retrace(player, ClipContext.Fluid.SOURCE_ONLY);
        ItemStack stack = player.getItemInHand(hand);

        if (traceResult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(stack);
        }
        BlockPos tracePos = traceResult.getBlockPos();

        if (!player.isSecondaryUseActive() || !world.mayInteract(player, tracePos) || Utils.isFakePlayer(player) && !allowFakePlayers) {
            return InteractionResultHolder.fail(stack);
        }
        if (isWater(world.getBlockState(tracePos)) && getSpace(stack) > 0) {
            if (removeSourceBlocks) {
                world.setBlock(tracePos, Blocks.AIR.defaultBlockState(), 11);
            }
            fill(stack, new FluidStack(Fluids.WATER, BUCKET_VOLUME), EXECUTE);
            player.playSound(SoundEvents.BUCKET_FILL, 1.0F, 1.0F);
            return InteractionResultHolder.success(stack);
        }
        return InteractionResultHolder.pass(stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

        if (!hasActiveTag(stack)) {
            return;
        }
        long activeTime = stack.getOrCreateTag().getLong(TAG_ACTIVE);

        if (entityIn.level.getGameTime() > activeTime) {
            stack.getOrCreateTag().remove(TAG_ACTIVE);
        }
    }

    // region HELPERS
    @Override
    protected void setAttributesFromAugment(ItemStack container, CompoundTag augmentData) {

        CompoundTag subTag = container.getTagElement(TAG_PROPERTIES);
        if (subTag == null) {
            return;
        }
        setAttributeFromAugmentAdd(subTag, augmentData, TAG_AUGMENT_RADIUS);

        super.setAttributesFromAugment(container, augmentData);
    }

    protected float getEffectiveness(ItemStack stack) {

        return 0.40F * getBaseMod(stack) - 0.05F * getMode(stack);
    }

    protected int getRadius(ItemStack stack) {

        return (int) getPropertyWithDefault(stack, TAG_AUGMENT_RADIUS, 0.0F) + 1;
    }

    protected int getWaterPerUse(ItemStack stack) {

        return MB_PER_USE;
    }
    // endregion

    // region IAugmentableItem
    @Override
    public void updateAugmentState(ItemStack container, List<ItemStack> augments) {

        super.updateAugmentState(container, augments);

        if (getMode(container) >= getNumModes(container)) {
            setMode(container, getNumModes(container) - 1);
        }
    }
    // endregion

    // region IColorableItem
    @Override
    public int getColor(ItemStack item, int colorIndex) {

        if (colorIndex == 0) {
            CompoundTag nbt = item.getTagElement("display");
            return nbt != null && nbt.contains("color", 99) ? nbt.getInt("color") : 0xFFFFFF;
        }
        return 0xFFFFFF;
    }
    // endregion

    // region IMultiModeItem
    @Override
    public int getNumModes(ItemStack stack) {

        return 1 + getRadius(stack);
    }

    @Override
    public void onModeChange(Player player, ItemStack stack) {

        player.level.playSound(null, player.blockPosition(), SoundEvents.BUCKET_EMPTY, SoundSource.PLAYERS, 0.6F, 1.0F - 0.1F * getMode(stack));
        int radius = getMode(stack) * 2 + 1;
        if (radius <= 1) {
            ProxyUtils.setOverlayMessage(player, Component.translatable("info.cofh.single_block"));
        } else {
            ProxyUtils.setOverlayMessage(player, Component.translatable("info.cofh.area").append(": " + radius + "x" + radius));
        }
    }
    // endregion

    public static void growPlants(Level world) {

        if (WATERED_BLOCKS.isEmpty()) {
            return;
        }
        for (Triple<BlockPos, BlockState, Block> entry : WATERED_BLOCKS) {
            BlockPos pos = entry.getLeft();
            BlockState state = entry.getMiddle();
            Block block = entry.getRight();

            if (block.isRandomlyTicking(state)) {
                block.randomTick(state, (ServerLevel) world, pos, world.random);
                world.sendBlockUpdated(pos, state, state, 3);
            } else {
                world.scheduleTick(pos, block, 0);
            }
        }
        WATERED_BLOCKS.clear();
    }

}
