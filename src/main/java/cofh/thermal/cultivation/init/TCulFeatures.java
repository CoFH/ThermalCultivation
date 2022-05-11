package cofh.thermal.cultivation.init;

import cofh.thermal.lib.common.ThermalFeatures;

public class TCulFeatures {

    private TCulFeatures() {

    }

    public static void register() {

        ThermalFeatures.registerDefaultTriangleOreFeature("apatite_ore");
    }

}
