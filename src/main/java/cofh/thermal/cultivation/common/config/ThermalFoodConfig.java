package cofh.thermal.cultivation.common.config;

import cofh.core.common.config.IBaseConfig;
import cofh.thermal.cultivation.common.item.FortuneCookieItem;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.cultivation.init.registries.TCulIDs.ID_FORTUNE_COOKIE;

public class ThermalFoodConfig implements IBaseConfig {

    @Override
    public void apply(ForgeConfigSpec.Builder builder) {

        builder.push("Foods");

        builder.push("Fortune Cookie");

        fortuneCookieDuration = builder
                .comment("This sets the duration (in ticks) of the Fortune Revealed and Luck/Bad Luck effects provided by a Fortune Cookie.")
                .defineInRange("Effect Duration", 12000, 100, 72000);

        fortuneCookieBadLuckChance = builder
                .comment("This sets the odds of receiving a Bad Luck debuff from a Fortune Cookie. Odds are 1 in N, where N is configured here. Set to 0 to disable.")
                .defineInRange("Bad Luck Odds", 20, 0, 10000);

        fortuneCookieMaxLuck = builder
                .comment("This sets the maximum level of Luck a Fortune Cookie can provide.")
                .defineInRange("Maximum Luck", 3, 1, 10);

        fortuneCookieMaxBadLuck = builder
                .comment("This sets the maximum level of Bad Luck a Fortune Cookie can provide.")
                .defineInRange("Maximum Bad Luck", 2, 1, 10);

        builder.pop();

        builder.pop();
    }

    @Override
    public void refresh() {

        ((FortuneCookieItem) ITEMS.get(ID_FORTUNE_COOKIE)).setParameters(fortuneCookieDuration.get(), fortuneCookieBadLuckChance.get(), fortuneCookieMaxLuck.get(), fortuneCookieMaxBadLuck.get());
    }

    // region CONFIG VARIABLES
    private Supplier<Integer> fortuneCookieDuration;
    private Supplier<Integer> fortuneCookieBadLuckChance;
    private Supplier<Integer> fortuneCookieMaxLuck;
    private Supplier<Integer> fortuneCookieMaxBadLuck;
    // endregion
}
