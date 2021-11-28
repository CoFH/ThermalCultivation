package cofh.thermal.cultivation.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.PotionUtils;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

import static cofh.lib.util.constants.NBTTags.TAG_POTION;
import static cofh.thermal.cultivation.init.TCulReferences.POTION_CAKE_TILE;

public class PotionCakeTile extends TileEntity {

    protected CompoundNBT potionTag = new CompoundNBT();
    protected List<EffectInstance> effects = Collections.emptyList();

    public PotionCakeTile() {

        super(POTION_CAKE_TILE);
    }

    public void cacheEffects(CompoundNBT nbt) {

        effects = PotionUtils.getAllEffects(nbt);
    }

    public void applyEffects(PlayerEntity player) {

        for (EffectInstance effect : effects) {
            if (effect.getEffect().isInstantenous()) {
                effect.getEffect().applyInstantenousEffect(null, null, player, effect.getAmplifier(), 0.5D);
            } else {
                EffectInstance potion = new EffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible());
                player.addEffect(potion);
            }
        }
    }

    public int getColor() {


        return effects.isEmpty() ? 0xF800F8 : PotionUtils.getColor(effects);
    }

    // region NETWORK
    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {

        return new SUpdateTileEntityPacket(worldPosition, 0, getUpdateTag());
    }

    @Override
    public CompoundNBT getUpdateTag() {

        return this.save(new CompoundNBT());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {

        load(this.blockState, pkt.getTag());
    }
    // endregion

    // region NBT
    @Override
    public void load(BlockState state, CompoundNBT nbt) {

        super.load(state, nbt);

        potionTag = nbt.getCompound(TAG_POTION);
        cacheEffects(potionTag);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {

        super.save(nbt);

        if (potionTag != null && !potionTag.isEmpty()) {
            nbt.put(TAG_POTION, potionTag);
        }
        return nbt;
    }
    // endregion
}
