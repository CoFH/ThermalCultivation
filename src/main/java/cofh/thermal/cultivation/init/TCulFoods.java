package cofh.thermal.cultivation.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

import static cofh.core.init.CoreMobEffects.CLARITY;
import static cofh.core.init.CoreMobEffects.PANACEA;
import static net.minecraft.world.effect.MobEffects.*;

public class TCulFoods {

    private TCulFoods() {

    }

    // CROPS
    public static final FoodProperties BELL_PEPPER = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties COFFEE_CHERRY = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).fast().build();
    public static final FoodProperties CORN = new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).build();
    public static final FoodProperties EGGPLANT = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build();
    public static final FoodProperties FROST_MELON_SLICE = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(FIRE_RESISTANCE, 200, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties GREEN_BEAN = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties ONION = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).build();
    public static final FoodProperties PEANUT = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).fast().build();
    public static final FoodProperties RADISH = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).build();
    public static final FoodProperties SPINACH = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).build();
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build();

    // INGREDIENTS
    public static final FoodProperties CHEESE = new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).build();
    //    public static final FoodProperties JELLY = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build();
    //    public static final FoodProperties PEANUT_BUTTER = new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).build();
    //    public static final FoodProperties TOMATO_SAUCE = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).build();

    // DRINKS
    public static final FoodProperties COFFEE = new FoodProperties.Builder().nutrition(0).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MOVEMENT_SPEED, 200, 0), 1.0F)
            .alwaysEat()
            .build();
    //    public static final FoodProperties TEA = new FoodProperties.Builder().nutrition(0).saturationMod(0.2F)
    //            .effect(() -> new EffectInstance(MOVEMENT_SPEED, 200, 0), 1.0F)
    //            .alwaysEat()
    //            .build();

    // MEALS
    public static final FoodProperties COOKED_EGGPLANT = new FoodProperties.Builder().nutrition(4).saturationMod(0.5F).build();
    public static final FoodProperties COOKED_MUSHROOM = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build();

    public static final FoodProperties GREEN_BEAN_PIE = new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).build();
    public static final FoodProperties PBJ_SANDWICH = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build();
    public static final FoodProperties STUFFED_PEPPER = new FoodProperties.Builder().nutrition(9).saturationMod(0.8F).build();
    public static final FoodProperties SUSHI = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).fast().build();

    public static final FoodProperties SPRING_SALAD = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(JUMP, 3600, 0), 1.0F)
            .alwaysEat()
            .build();

    public static final FoodProperties HEARTY_STEW = new FoodProperties.Builder().nutrition(8).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(HEALTH_BOOST, 3600, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties XP_STEW = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(CLARITY.get(), 3600, 0), 1.0F)
            .alwaysEat()
            .build();

    // PLACEABLE
    public static final FoodProperties CARROT_CAKE = new FoodProperties.Builder().nutrition(2).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(NIGHT_VISION, 1800, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties CHOCOLATE_CAKE = new FoodProperties.Builder().nutrition(2).saturationMod(0.2F).build();
    public static final FoodProperties POTION_CAKE = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).alwaysEat().build();
    public static final FoodProperties SPICE_CAKE = new FoodProperties.Builder().nutrition(2).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(PANACEA.get(), 100, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties STUFFED_PUMPKIN = new FoodProperties.Builder().nutrition(9).saturationMod(0.8F).build();

}
