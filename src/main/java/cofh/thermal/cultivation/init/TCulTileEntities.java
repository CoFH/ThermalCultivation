package cofh.thermal.cultivation.init;

import cofh.thermal.cultivation.tileentity.PotionCakeTile;
import net.minecraft.world.level.block.entity.BlockEntityType;

import static cofh.thermal.core.ThermalCore.TILE_ENTITIES;
import static cofh.thermal.cultivation.init.TCulIDs.ID_POTION_CAKE;
import static cofh.thermal.cultivation.init.TCulReferences.POTION_CAKE_BLOCK;

public class TCulTileEntities {

    private TCulTileEntities() {

    }

    public static void register() {

        TILE_ENTITIES.register(ID_POTION_CAKE, () -> BlockEntityType.Builder.of(PotionCakeTile::new, POTION_CAKE_BLOCK).build(null));
    }

}
