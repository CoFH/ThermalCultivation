package cofh.thermal.cultivation.item;

import cofh.core.item.FluidContainerItemAugmentable;
import cofh.core.util.ProxyUtils;
import cofh.core.util.helpers.ChatHelper;
import cofh.lib.item.IMultiModeItem;
import cofh.lib.util.RayTracer;
import cofh.lib.util.Utils;
import cofh.thermal.lib.common.ThermalConfig;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.block.*;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fluids.FluidStack;
import org.apache.commons.lang3.tuple.Triple;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

import static cofh.core.util.helpers.FluidHelper.IS_WATER;
import static cofh.core.util.helpers.FluidHelper.isWater;
import static cofh.lib.util.constants.Constants.BUCKET_VOLUME;
import static cofh.lib.util.constants.Constants.RGB_DURABILITY_WATER;
import static cofh.lib.util.constants.NBTTags.*;
import static cofh.lib.util.helpers.AugmentableHelper.getPropertyWithDefault;
import static cofh.lib.util.helpers.AugmentableHelper.setAttributeFromAugmentAdd;
import static cofh.thermal.lib.common.ThermalAugmentRules.createAllowValidator;
import static net.minecraftforge.fluids.capability.IFluidHandler.FluidAction.EXECUTE;

public class WateringCanItem extends FluidContainerItemAugmentable implements IMultiModeItem {

    private static final Set<Triple<BlockPos, BlockState, Block>> WATERED_BLOCKS = new ObjectOpenHashSet<>();

    protected static final int MB_PER_USE = 50;

    protected static boolean allowFakePlayers = false;
    protected static boolean removeSourceBlocks = true;

    protected static final Set<Block> EFFECTIVE_BLOCKS = new ObjectOpenHashSet<>();

    static {
        EFFECTIVE_BLOCKS.add(Blocks.MYCELIUM);
        EFFECTIVE_BLOCKS.add(Blocks.CHORUS_FLOWER);
    }

    public WateringCanItem(Properties builder, int fluidCapacity) {

        super(builder, fluidCapacity, IS_WATER);

        ProxyUtils.registerItemModelProperty(this, new ResourceLocation("filled"), (stack, world, entity) -> getFluidAmount(stack) > 0 ? 1F : 0F);
        ProxyUtils.registerItemModelProperty(this, new ResourceLocation("active"), (stack, world, entity) -> getFluidAmount(stack) > 0 && hasActiveTag(stack) ? 1F : 0F);

        numSlots = () -> ThermalConfig.toolAugments;
        augValidator = createAllowValidator(TAG_AUGMENT_TYPE_UPGRADE, TAG_AUGMENT_TYPE_FLUID, TAG_AUGMENT_TYPE_AREA_EFFECT);
    }

    @Override
    protected void tooltipDelegate(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        int radius = getMode(stack) * 2 + 1;
        if (radius <= 1) {
            tooltip.add(new TranslationTextComponent("info.cofh.single_block").mergeStyle(TextFormatting.ITALIC));
        } else {
            tooltip.add(new TranslationTextComponent("info.cofh.area").appendString(": " + radius + "x" + radius).mergeStyle(TextFormatting.ITALIC));
        }
        if (getNumModes(stack) > 1) {
            addIncrementModeChangeTooltip(stack, worldIn, tooltip, flagIn);
        }
        super.tooltipDelegate(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {

        return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged) && (slotChanged || getFluidAmount(oldStack) > 0 != getFluidAmount(newStack) > 0 || getFluidAmount(newStack) > 0 && hasActiveTag(oldStack) != hasActiveTag(newStack));
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {

        return RGB_DURABILITY_WATER;
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {

        World world = context.getWorld();
        BlockPos pos = context.getPos();
        PlayerEntity player = context.getPlayer();

        if (player == null || Utils.isFakePlayer(player) && !allowFakePlayers) {
            return ActionResultType.FAIL;
        }
        if (player.isSecondaryUseActive()) {
            BlockRayTraceResult traceResult = RayTracer.retrace(player, RayTraceContext.FluidMode.SOURCE_ONLY);
            if (traceResult.getType() != RayTraceResult.Type.MISS) {
                if (isWater(world.getBlockState(traceResult.getPos()))) {
                    return ActionResultType.PASS;
                }
            }
        }
        ItemStack stack = player.getHeldItem(context.getHand());
        BlockPos offsetPos = world.getBlockState(pos).isSolid() ? pos.offset(context.getFace()) : pos;

        if (getFluidAmount(stack) < getWaterPerUse(stack)) {
            return ActionResultType.FAIL;
        }
        setActive(stack, player);

        int radius = getMode(stack);
        int x = offsetPos.getX();
        int y = offsetPos.getY();
        int z = offsetPos.getZ();

        for (int i = x - radius; i <= x + radius; ++i) {
            for (int k = z - radius; k <= z + radius; ++k) {
                Utils.spawnParticles(world, ParticleTypes.FALLING_WATER, i + world.rand.nextDouble(), y - 1 + world.rand.nextDouble(), k + world.rand.nextDouble(), 1, 0, 0, 0, 0);
            }
        }
        Iterable<BlockPos> area = BlockPos.getAllInBoxMutable(offsetPos.add(-radius, -2, -radius), offsetPos.add(radius, 1, radius));
        for (BlockPos scan : area) {
            BlockState state = world.getBlockState(scan);
            if (state.getBlock() instanceof FarmlandBlock) {
                if (state.get(FarmlandBlock.MOISTURE) < 7) {
                    world.setBlockState(scan, state.with(FarmlandBlock.MOISTURE, 7));
                }
            }
        }
        if (Utils.isServerWorld(world)) {
            if (world.rand.nextFloat() < Math.max(getEffectiveness(stack), 0.05)) {
                for (BlockPos scan : area) {
                    BlockState plantState = world.getBlockState(scan);
                    Block plant = plantState.getBlock();
                    if (plant instanceof IGrowable || plant instanceof IPlantable || EFFECTIVE_BLOCKS.contains(plant)) {
                        WATERED_BLOCKS.add(Triple.of(new BlockPos(scan), plantState, plant));
                    }
                }
            }
            if (!player.abilities.isCreativeMode) {
                drain(stack, getWaterPerUse(stack) * (getMode(stack) + 1) * 2, EXECUTE);
            }
        }
        return ActionResultType.FAIL;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {

        BlockRayTraceResult traceResult = RayTracer.retrace(player, RayTraceContext.FluidMode.SOURCE_ONLY);
        ItemStack stack = player.getHeldItem(hand);

        if (traceResult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.resultPass(stack);
        }
        BlockPos tracePos = traceResult.getPos();

        if (!player.isSecondaryUseActive() || !world.isBlockModifiable(player, tracePos) || Utils.isFakePlayer(player) && !allowFakePlayers) {
            return ActionResult.resultFail(stack);
        }
        if (isWater(world.getBlockState(tracePos)) && getSpace(stack) > 0) {
            if (removeSourceBlocks) {
                world.setBlockState(tracePos, Blocks.AIR.getDefaultState(), 11);
            }
            fill(stack, new FluidStack(Fluids.WATER, BUCKET_VOLUME), EXECUTE);
            player.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);
            return ActionResult.resultSuccess(stack);
        }
        return ActionResult.resultPass(stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

        if (!hasActiveTag(stack)) {
            return;
        }
        long activeTime = stack.getOrCreateTag().getLong(TAG_ACTIVE);

        if (entityIn.world.getGameTime() > activeTime) {
            stack.getOrCreateTag().remove(TAG_ACTIVE);
        }
    }

    // region HELPERS
    @Override
    protected void setAttributesFromAugment(ItemStack container, CompoundNBT augmentData) {

        CompoundNBT subTag = container.getChildTag(TAG_PROPERTIES);
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

    // region IMultiModeItem
    @Override
    public int getNumModes(ItemStack stack) {

        return 1 + getRadius(stack);
    }

    @Override
    public void onModeChange(PlayerEntity player, ItemStack stack) {

        player.world.playSound(null, player.getPosition(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.PLAYERS, 0.6F, 1.0F - 0.1F * getMode(stack));
        int radius = getMode(stack) * 2 + 1;
        if (radius <= 1) {
            ChatHelper.sendIndexedChatMessageToPlayer(player, new TranslationTextComponent("info.cofh.single_block"));
        } else {
            ChatHelper.sendIndexedChatMessageToPlayer(player, new TranslationTextComponent("info.cofh.area").appendString(": " + radius + "x" + radius));
        }
    }
    // endregion

    public static void growPlants(World world) {

        if (WATERED_BLOCKS.isEmpty()) {
            return;
        }
        for (Triple<BlockPos, BlockState, Block> entry : WATERED_BLOCKS) {
            BlockPos pos = entry.getLeft();
            BlockState state = entry.getMiddle();
            Block block = entry.getRight();

            if (block.ticksRandomly(state)) {
                block.randomTick(state, (ServerWorld) world, pos, world.rand);
                world.notifyBlockUpdate(pos, state, state, 3);
            } else {
                world.getPendingBlockTicks().scheduleTick(pos, block, 0);
            }
        }
        WATERED_BLOCKS.clear();
    }

}
