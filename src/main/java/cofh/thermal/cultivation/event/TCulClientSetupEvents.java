package cofh.thermal.cultivation.event;

import cofh.core.util.ProxyUtils;
import cofh.thermal.cultivation.tileentity.PotionCakeTile;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cofh.lib.util.constants.ModIds.ID_THERMAL_CULTIVATION;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.cultivation.init.TCulIDs.*;

@Mod.EventBusSubscriber (value = Dist.CLIENT, modid = ID_THERMAL_CULTIVATION, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TCulClientSetupEvents {

    private TCulClientSetupEvents() {

    }

    @SubscribeEvent
    public static void colorSetupBlock(final ColorHandlerEvent.Block event) {

        BlockColors colors = event.getBlockColors();

        colors.register((state, reader, pos, tintIndex) -> 0x96DCF8, BLOCKS.get(ID_FROST_MELON_STEM_ATTACHED));
        colors.register((state, reader, pos, tintIndex) -> {
            int age = state.getValue(StemBlock.AGE);
            int r = 80 + age * 10;
            int g = 255 - age * 5;
            int b = 80 + age * 24;
            return r << 16 | g << 8 | b;
        }, BLOCKS.get(ID_FROST_MELON_STEM));

        colors.register((state, reader, pos, tintIndex) -> {
            if (pos != null) {
                BlockEntity tile = ProxyUtils.getClientWorld().getBlockEntity(pos);
                if (tile instanceof PotionCakeTile) {
                    return ((PotionCakeTile) tile).getColor();
                }
            }
            return 0xF800F8;
        }, BLOCKS.get(ID_POTION_CAKE));
    }

}
