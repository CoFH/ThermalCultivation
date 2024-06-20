package cofh.thermal.cultivation.common.item;

import cofh.core.common.item.ItemCoFH;
import cofh.core.util.ProxyUtils;
import cofh.lib.util.Utils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static cofh.thermal.cultivation.init.registries.TCulEffects.FORTUNE_REVEALED;

public class FortuneCookieItem extends ItemCoFH {

    private int duration = 12000;
    private int badLuckChance = 20;
    private int maxLuck = 3;
    private int maxBadLuck = 2;

    public FortuneCookieItem(Properties builder) {

        super(builder);
    }

    public void setParameters(int duration, int badLuckChance, int maxLuck, int maxBadLuck) {

        this.duration = duration;
        this.badLuckChance = badLuckChance;
        this.maxLuck = maxLuck;
        this.maxBadLuck = maxBadLuck;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entity) {

        super.finishUsingItem(stack, worldIn, entity);

        if (Utils.isServerWorld(worldIn) && !entity.hasEffect(FORTUNE_REVEALED.get()) && entity instanceof Player player) {
            if (badLuckChance > 0 && worldIn.random.nextInt(badLuckChance) == 0) {
                ProxyUtils.setOverlayMessage(player, Component.translatable("info.thermal.fortune_cookie_bad_luck." + worldIn.random.nextInt(5)));
                entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, duration, worldIn.random.nextInt(maxBadLuck), false, false));
            } else {
                ProxyUtils.setOverlayMessage(player, Component.translatable("info.thermal.fortune_cookie_luck." + worldIn.random.nextInt(5)));
                entity.addEffect(new MobEffectInstance(MobEffects.LUCK, duration, worldIn.random.nextInt(maxLuck), false, false));
            }
            entity.addEffect(new MobEffectInstance(FORTUNE_REVEALED.get(), duration, 0, false, false));

            player.getCooldowns().addCooldown(this, 20);
        }

        if (entity instanceof ServerPlayer player) {
            CriteriaTriggers.CONSUME_ITEM.trigger(player, stack);
            player.awardStat(Stats.ITEM_USED.get(this));
        }
        return stack;
    }

}
