package cofh.thermal.cultivation.item;

import cofh.core.item.BlockItemCoFH;
import cofh.core.util.ProxyUtils;
import cofh.lib.item.IColorableItem;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.PotionUtils;

import java.util.List;

import static cofh.lib.util.constants.NBTTags.TAG_BLOCK_ENTITY;
import static cofh.lib.util.constants.NBTTags.TAG_POTION;

public class PotionCakeBlockItem extends BlockItemCoFH implements IColorableItem {

    public PotionCakeBlockItem(Block blockIn, Properties builder) {

        super(blockIn, builder);

        ProxyUtils.registerColorable(this);
    }

    // region IColorableItem
    @Override
    public int getColor(ItemStack item, int colorIndex) {

        if (colorIndex == 1) {
            CompoundNBT blockTag = item.getTagElement(TAG_BLOCK_ENTITY);

            if (blockTag != null) {
                List<EffectInstance> effects = PotionUtils.getAllEffects(blockTag.getCompound(TAG_POTION));

                if (!effects.isEmpty()) {
                    return PotionUtils.getColor(effects);
                }
            }
            return 0xF800F8;
        }
        return 0xFFFFFF;
    }
    // endregion
}
