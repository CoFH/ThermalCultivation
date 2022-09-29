package cofh.thermal.cultivation.config;

import cofh.core.config.IBaseConfig;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

import static cofh.lib.util.Constants.TRUE;

public class ThermalCropConfig implements IBaseConfig {

    @Override
    public void apply(ForgeConfigSpec.Builder builder) {

        builder.push("Crops");

        glowstoneMushroomLight = builder
                .comment("If TRUE, Glimmercap Mushrooms produce light when fully grown. Disabling this may improve performance.")
                .define("Glowstone Mushroom Light", glowstoneMushroomLight);

        redstoneMushroomLight = builder
                .comment("If TRUE, Fluxtooth Mushrooms produce light when fully grown. Disabling this may improve performance.")
                .define("Redstone Mushroom Light", redstoneMushroomLight);

        redstoneMushroomSignal = builder
                .comment("If TRUE, Fluxtooth Mushrooms emit a redstone signal when fully grown. Disabling this may improve performance.")
                .define("Redstone Mushroom Signal", redstoneMushroomSignal);

        builder.pop();
    }

    @Override
    public void refresh() {

    }

    // region CONFIG VARIABLES
    public static Supplier<Boolean> glowstoneMushroomLight = TRUE;
    public static Supplier<Boolean> redstoneMushroomLight = TRUE;
    public static Supplier<Boolean> redstoneMushroomSignal = TRUE;
    // endregion
}
