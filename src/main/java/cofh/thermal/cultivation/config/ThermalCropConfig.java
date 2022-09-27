package cofh.thermal.cultivation.config;

import cofh.core.config.IBaseConfig;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

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

    // region CONFIG VARIABLES
    public static Supplier<Boolean> glowstoneMushroomLight = () -> true;
    public static Supplier<Boolean> redstoneMushroomLight = () -> true;
    public static Supplier<Boolean> redstoneMushroomSignal = () -> true;
    // endregion
}
