package cofh.thermal.cultivation.config;

import cofh.lib.config.IBaseConfig;
import net.minecraftforge.common.ForgeConfigSpec;

public class ThermalCropConfig implements IBaseConfig {

    @Override
    public void apply(ForgeConfigSpec.Builder builder) {

        builder.push("Crops");

        glowstoneMushroomLight = builder
                .comment("If TRUE, Glimmercap Mushrooms produce light when fully grown. Disabling this may improve performance.")
                .define("Glowstone Mushroom Light", true);

        redstoneMushroomLight = builder
                .comment("If TRUE, Fluxtooth Mushrooms produce light when fully grown. Disabling this may improve performance.")
                .define("Redstone Mushroom Light", true);

        redstoneMushroomSignal = builder
                .comment("If TRUE, Fluxtooth Mushrooms emit a redstone signal when fully grown. Disabling this may improve performance.")
                .define("Redstone Mushroom Signal", true);

        builder.pop();
    }

    @Override
    public void refresh() {

    }

    public static boolean glowstoneMushroomLight() {

        return glowstoneMushroomLight == null || glowstoneMushroomLight.get();
    }

    public static boolean redstoneMushroomLight() {

        return redstoneMushroomLight == null || redstoneMushroomLight.get();
    }

    public static boolean redstoneMushroomSignal() {

        return redstoneMushroomSignal == null || redstoneMushroomSignal.get();
    }

    // region CONFIG VARIABLES
    private static ForgeConfigSpec.BooleanValue glowstoneMushroomLight;

    private static ForgeConfigSpec.BooleanValue redstoneMushroomLight;
    private static ForgeConfigSpec.BooleanValue redstoneMushroomSignal;
    // endregion
}
