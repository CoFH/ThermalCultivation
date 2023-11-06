package cofh.thermal.cultivation.init;

import cofh.thermal.cultivation.tileentity.PotionCakeTile;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.BLOCK_ENTITIES;
import static cofh.thermal.cultivation.init.TCulIDs.ID_POTION_CAKE;

public class TCulBlockEntities {

    private TCulBlockEntities() {

    }

    public static void register() {

    }

    public static final RegistryObject<BlockEntityType<?>> POTION_CAKE_TILE = BLOCK_ENTITIES.register(ID_POTION_CAKE, () -> BlockEntityType.Builder.of(PotionCakeTile::new, BLOCKS.get(ID_POTION_CAKE)).build(null));

}
