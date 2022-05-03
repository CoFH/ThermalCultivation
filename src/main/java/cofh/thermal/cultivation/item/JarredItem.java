package cofh.thermal.cultivation.item;

import cofh.core.item.ItemCoFH;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static cofh.thermal.cultivation.init.TCulReferences.JAR_ITEM;

public class JarredItem extends ItemCoFH {

    public JarredItem(Properties builder) {

        super(builder);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entity) {

        super.finishUsingItem(stack, worldIn, entity);

        if (entity instanceof ServerPlayer) {
            ServerPlayer serverplayerentity = (ServerPlayer) entity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
            serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
        }
        if (stack.isEmpty()) {
            return new ItemStack(JAR_ITEM);
        } else {
            if (entity instanceof Player && !((Player) entity).abilities.instabuild) {
                ItemStack itemstack = new ItemStack(JAR_ITEM);
                Player playerentity = (Player) entity;
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
