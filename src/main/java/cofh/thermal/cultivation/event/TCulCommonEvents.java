package cofh.thermal.cultivation.event;

import cofh.thermal.cultivation.item.WateringCanItem;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cofh.lib.util.constants.Constants.ID_THERMAL_CULTIVATION;

@Mod.EventBusSubscriber(modid = ID_THERMAL_CULTIVATION)
public class TCulCommonEvents {

    @SubscribeEvent
    public static void handleTickEndEvent(TickEvent.WorldTickEvent event) {

        if (event.phase == TickEvent.Phase.END) {
            WateringCanItem.growPlants(event.world);
        }
    }

}
