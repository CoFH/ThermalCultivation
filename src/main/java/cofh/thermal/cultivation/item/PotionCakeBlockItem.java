package cofh.thermal.cultivation.item;

import cofh.core.item.BlockItemCoFH;
import cofh.core.util.ProxyUtils;
import cofh.lib.api.item.IColorableItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;

import static cofh.core.util.helpers.FluidHelper.addPotionTooltip;

public class PotionCakeBlockItem extends BlockItemCoFH implements IColorableItem {

    public PotionCakeBlockItem(Block blockIn, Properties builder) {

        super(blockIn, builder);

        ProxyUtils.registerColorable(this);
    }

    @Override

    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {

        addPotionTooltip(PotionUtils.getMobEffects(stack), tooltip, 0.25F);
    }

    @Override

    public boolean isFoil(ItemStack stack) {

        return super.isFoil(stack) || !PotionUtils.getMobEffects(stack).isEmpty();
    }

    // region IColorableItem
    @Override
    public int getColor(ItemStack item, int colorIndex) {

        if (colorIndex == 1) {
            List<MobEffectInstance> effects = PotionUtils.getMobEffects(item);
            if (!effects.isEmpty()) {
                return PotionUtils.getColor(effects);
            }
            return 0xF800F8;
        }
        return 0xFFFFFF;
    }
    // endregion
}
