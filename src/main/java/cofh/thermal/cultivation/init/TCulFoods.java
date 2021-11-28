package cofh.thermal.cultivation.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;

import static cofh.lib.util.references.CoreReferences.CLARITY;
import static cofh.lib.util.references.CoreReferences.PANACEA;
import static net.minecraft.potion.Effects.*;

public class TCulFoods {

    private TCulFoods() {

    }

    // RAW
    public static final Food BELL_PEPPER = new Food.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final Food COFFEE_CHERRY = new Food.Builder().nutrition(1).saturationMod(0.1F).fast().build();
    public static final Food CORN = new Food.Builder().nutrition(3).saturationMod(0.6F).build();
    public static final Food EGGPLANT = new Food.Builder().nutrition(2).saturationMod(0.3F).build();
    public static final Food FROST_MELON_SLICE = new Food.Builder().nutrition(2).saturationMod(0.3F)
            .effect(() -> new EffectInstance(FIRE_RESISTANCE, 200, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final Food GREEN_BEAN = new Food.Builder().nutrition(1).saturationMod(0.3F).build();
    public static final Food ONION = new Food.Builder().nutrition(1).saturationMod(0.3F).build();
    public static final Food PEANUT = new Food.Builder().nutrition(2).saturationMod(0.3F).fast().build();
    public static final Food RADISH = new Food.Builder().nutrition(1).saturationMod(0.3F).build();
    public static final Food SPINACH = new Food.Builder().nutrition(1).saturationMod(0.3F).build();
    public static final Food STRAWBERRY = new Food.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final Food TOMATO = new Food.Builder().nutrition(2).saturationMod(0.3F).build();

    // DRINKS
    public static final Food COFFEE = new Food.Builder().nutrition(0).saturationMod(0.2F)
            .effect(() -> new EffectInstance(MOVEMENT_SPEED, 200, 0), 1.0F)
            .alwaysEat()
            .build();
    //    public static final Food TEA = new Food.Builder().nutrition(0).saturationMod(0.2F)
    //            .effect(() -> new EffectInstance(MOVEMENT_SPEED, 200, 0), 1.0F)
    //            .alwaysEat()
    //            .build();

    // MEALS
    public static final Food CARROT_CAKE = new Food.Builder().nutrition(2).saturationMod(0.2F)
            .effect(() -> new EffectInstance(NIGHT_VISION, 1200, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final Food CHOCOLATE_CAKE = new Food.Builder().nutrition(2).saturationMod(0.2F).build();
    public static final Food POTION_CAKE = new Food.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final Food SPICE_CAKE = new Food.Builder().nutrition(2).saturationMod(0.2F)
            .effect(() -> new EffectInstance(PANACEA, 100, 0), 1.0F)
            .alwaysEat()
            .build();
    //    public static final Food RATATOUILLE = new Food.Builder().nutrition(8).saturationMod(0.6F)
    //            .effect(() -> new EffectInstance(REGENERATION, 80), 1.0F)
    //            .alwaysEat()
    //            .build();
    public static final Food XP_STEW = new Food.Builder().nutrition(6).saturationMod(0.6F)
            .effect(() -> new EffectInstance(CLARITY, 1200, 0), 1.0F)
            .alwaysEat()
            .build();

}
