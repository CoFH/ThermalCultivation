package cofh.thermal.cultivation.item;

import cofh.core.item.ItemCoFH;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.cultivation.init.TCulIDs.ID_JAR;

public class JarredItem extends ItemCoFH {

    public JarredItem(Properties builder) {

        super(builder);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entity) {

        super.finishUsingItem(stack, worldIn, entity);

        if (entity instanceof ServerPlayer player) {
            CriteriaTriggers.CONSUME_ITEM.trigger(player, stack);
            player.awardStat(Stats.ITEM_USED.get(this));
        }
        if (stack.isEmpty()) {
            return new ItemStack(ITEMS.get(ID_JAR));
        } else {
            if (entity instanceof Player player && !((Player) entity).abilities.instabuild) {
                ItemStack itemstack = new ItemStack(ITEMS.get(ID_JAR));
                if (!player.inventory.add(itemstack)) {
                    player.drop(itemstack, false);
                }
            }
            return stack;
        }
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {

        return new ItemStack(ITEMS.get(ID_JAR));
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {

        return true;
    }

}
