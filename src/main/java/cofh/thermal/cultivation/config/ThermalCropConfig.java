package cofh.thermal.cultivation.config;

import cofh.core.config.IBaseConfig;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

import static cofh.lib.util.Constants.TRUE;

public class ThermalCropConfig implements IBaseConfig {

    // region CONFIG VARIABLES
    public static Supplier<Boolean> dropSeedsFromGrass = TRUE;
    public static Supplier<Boolean> glowstoneMushroomLight = TRUE;
    public static Supplier<Boolean> redstoneMushroomLight = TRUE;
    public static Supplier<Boolean> redstoneMushroomSignal = TRUE;

    @Override
    public void apply(ForgeConfigSpec.Builder builder) {

        builder.push("Crops");

        dropSeedsFromGrass = builder
                .comment("If TRUE, some Thermal Cultivation seeds will be able to drop from grass. Disabling this will ignore any datapack setting using Thermal's 'seeds_from_grass' Global Loot Modifier.")
                .define("Drop Seeds From Grass", dropSeedsFromGrass);

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
    // endregion
}
