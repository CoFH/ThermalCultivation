package cofh.thermal.cultivation.item;

import cofh.core.item.BlockItemCoFH;
import cofh.core.util.ProxyUtils;
import cofh.lib.item.IColorableItem;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

import static cofh.core.util.helpers.FluidHelper.addPotionTooltip;

public class PotionCakeBlockItem extends BlockItemCoFH implements IColorableItem {

    public PotionCakeBlockItem(Block blockIn, Properties builder) {

        super(blockIn, builder);

        ProxyUtils.registerColorable(this);
    }

    @Override
    @OnlyIn (Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        addPotionTooltip(PotionUtils.getMobEffects(stack), tooltip, 0.25F);
    }

    @Override
    @OnlyIn (Dist.CLIENT)
    public boolean isFoil(ItemStack stack) {

        return super.isFoil(stack) || !PotionUtils.getMobEffects(stack).isEmpty();
    }

    // region IColorableItem
    @Override
    public int getColor(ItemStack item, int colorIndex) {

        if (colorIndex == 1) {
            List<EffectInstance> effects = PotionUtils.getMobEffects(item);
            if (!effects.isEmpty()) {
                return PotionUtils.getColor(effects);
            }
            return 0xF800F8;
        }
        return 0xFFFFFF;
    }
    // endregion
}
