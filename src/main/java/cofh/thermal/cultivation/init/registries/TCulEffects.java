package cofh.thermal.cultivation.init.registries;

import cofh.core.common.effect.NeutralMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.RegistryObject;

import static cofh.thermal.core.ThermalCore.EFFECTS;
import static cofh.thermal.cultivation.init.registries.TCulIDs.ID_EFFECT_FORTUNE_REVEALED;

public class TCulEffects {

    private TCulEffects() {

    }

    public static void register() {

    }

    public static final RegistryObject<MobEffect> FORTUNE_REVEALED = EFFECTS.register(ID_EFFECT_FORTUNE_REVEALED, () -> new NeutralMobEffect(MobEffectCategory.NEUTRAL, 0x888888));

}
