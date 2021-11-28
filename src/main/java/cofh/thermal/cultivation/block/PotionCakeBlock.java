package cofh.thermal.cultivation.block;

import cofh.lib.block.impl.CakeBlockCoFH;
import cofh.thermal.cultivation.tileentity.PotionCakeTile;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class PotionCakeBlock extends CakeBlockCoFH {

    public PotionCakeBlock(Properties properties, @Nonnull Food food) {

        super(properties, food);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {

        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {

        return new PotionCakeTile();
    }

    @Override
    protected ActionResultType eatPiece(World world, BlockPos pos, BlockState state, PlayerEntity player) {

        if (!player.canEat(false)) {
            return ActionResultType.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(food.getNutrition(), food.getSaturationModifier());

            for (Pair<EffectInstance, Float> pair : this.food.getEffects()) {
                if (!world.isClientSide && pair.getFirst() != null && world.random.nextFloat() < pair.getSecond()) {
                    player.addEffect(new EffectInstance(pair.getFirst()));
                }
            }
            TileEntity tile = world.getBlockEntity(pos);
            if (!world.isClientSide && tile instanceof PotionCakeTile) {
                ((PotionCakeTile) tile).applyEffects(player);
            }
            int i = state.getValue(BITES);
            if (i < 6) {
                world.setBlock(pos, state.setValue(BITES, i + 1), 3);
            } else {
                world.removeBlock(pos, false);
            }
            return ActionResultType.SUCCESS;
        }
    }

}
