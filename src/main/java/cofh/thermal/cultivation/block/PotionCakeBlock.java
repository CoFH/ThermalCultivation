package cofh.thermal.cultivation.block;

import cofh.lib.block.CakeBlockCoFH;
import cofh.thermal.cultivation.tileentity.PotionCakeTile;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PotionCakeBlock extends CakeBlockCoFH implements EntityBlock {

    public PotionCakeBlock(Properties properties, @Nonnull FoodProperties food) {

        super(properties, food);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {

        return new PotionCakeTile(pos, state);
    }

    @Override
    public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {

        BlockEntity tile = worldIn.getBlockEntity(pos);
        if (tile instanceof PotionCakeTile) {
            ((PotionCakeTile) tile).cacheEffects(stack.getTag());
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {

        ItemStack stack = super.getCloneItemStack(worldIn, pos, state);
        BlockEntity tile = worldIn.getBlockEntity(pos);
        if (tile instanceof PotionCakeTile) {
            ((PotionCakeTile) tile).createItemStackTag(stack);
        }
        return stack;
    }

    @Override
    protected InteractionResult eatPiece(Level world, BlockPos pos, BlockState state, Player player) {

        if (!player.canEat(true)) {
            return InteractionResult.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(food.getNutrition(), food.getSaturationModifier());

            for (Pair<MobEffectInstance, Float> pair : this.food.getEffects()) {
                if (!world.isClientSide && pair.getFirst() != null && world.random.nextFloat() < pair.getSecond()) {
                    player.addEffect(new MobEffectInstance(pair.getFirst()));
                }
            }
            BlockEntity tile = world.getBlockEntity(pos);
            if (!world.isClientSide && tile instanceof PotionCakeTile) {
                ((PotionCakeTile) tile).applyEffects(player);
            }
            int i = state.getValue(BITES);
            if (i < 6) {
                world.setBlock(pos, state.setValue(BITES, i + 1), 3);
            } else {
                world.removeBlock(pos, false);
            }
            return InteractionResult.SUCCESS;
        }
    }

}
