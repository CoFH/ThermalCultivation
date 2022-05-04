package cofh.thermal.cultivation.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

import static cofh.lib.util.constants.NBTTags.TAG_POTION;
import static cofh.thermal.cultivation.init.TCulReferences.POTION_CAKE_TILE;

public class PotionCakeTile extends BlockEntity {

    protected CompoundTag potionTag = new CompoundTag();
    protected List<MobEffectInstance> effects = Collections.emptyList();

    public PotionCakeTile(BlockPos pos, BlockState state) {

        super(POTION_CAKE_TILE, pos, state);
    }

    public void cacheEffects(CompoundTag nbt) {

        if (nbt != null) {
            potionTag = nbt.copy();
            effects = PotionUtils.getAllEffects(nbt);
        }
    }

    public void applyEffects(Player player) {

        for (MobEffectInstance effect : effects) {
            if (effect.getEffect().isInstantenous()) {
                effect.getEffect().applyInstantenousEffect(null, null, player, effect.getAmplifier(), 0.5D);
            } else {
                MobEffectInstance potion = new MobEffectInstance(effect.getEffect(), effect.getDuration() / 4, effect.getAmplifier(), effect.isAmbient(), effect.isVisible());
                player.addEffect(potion);
            }
        }
    }

    public int getColor() {

        return effects.isEmpty() ? 0xF800F8 : PotionUtils.getColor(effects);
    }

    public ItemStack createItemStackTag(ItemStack stack) {

        stack.setTag(potionTag.copy());

        return stack;
    }

    // region NETWORK
    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {

        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {

        return saveWithoutMetadata();
    }
    // endregion

    // region NBT
    @Override
    public void load(CompoundTag nbt) {

        super.load(nbt);

        cacheEffects(nbt.getCompound(TAG_POTION));
    }

    @Override
    public void saveAdditional(CompoundTag nbt) {

        super.saveAdditional(nbt);

        if (potionTag != null && !potionTag.isEmpty()) {
            nbt.put(TAG_POTION, potionTag);
        }
    }
    // endregion
}
