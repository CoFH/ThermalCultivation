package cofh.thermal.cultivation.common.event;

import cofh.thermal.cultivation.common.item.WateringCanItem;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cofh.lib.util.constants.ModIds.ID_THERMAL_CULTIVATION;

@Mod.EventBusSubscriber (modid = ID_THERMAL_CULTIVATION)
public class TCulCommonEvents {

    @SubscribeEvent
    public static void handleTickEndEvent(TickEvent.LevelTickEvent event) {

        if (event.side.isServer() && event.phase == TickEvent.Phase.END) {
            WateringCanItem.growPlants(event.level);
        }
    }

}
