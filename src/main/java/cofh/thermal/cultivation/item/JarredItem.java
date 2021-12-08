package cofh.thermal.cultivation.item;

import cofh.core.item.ItemCoFH;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

import static cofh.thermal.cultivation.init.TCulReferences.JAR_ITEM;

public class JarredItem extends ItemCoFH {

    public JarredItem(Properties builder) {

        super(builder);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entity) {

        super.finishUsingItem(stack, worldIn, entity);

        if (entity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
            serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
        }
        if (stack.isEmpty()) {
            return new ItemStack(JAR_ITEM);
        } else {
            if (entity instanceof PlayerEntity && !((PlayerEntity) entity).abilities.instabuild) {
                ItemStack itemstack = new ItemStack(JAR_ITEM);
                PlayerEntity playerentity = (PlayerEntity) entity;
                if (!playerentity.inventory.add(itemstack)) {
                    playerentity.drop(itemstack, false);
                }
            }
            return stack;
        }
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {

        return new ItemStack(JAR_ITEM);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {

        return true;
    }

}
