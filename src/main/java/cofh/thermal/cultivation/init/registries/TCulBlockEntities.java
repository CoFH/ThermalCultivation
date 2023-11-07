package cofh.thermal.cultivation.init.registries;

import cofh.thermal.cultivation.common.block.entity.PotionCakeBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.BLOCK_ENTITIES;
import static cofh.thermal.cultivation.init.registries.TCulIDs.ID_POTION_CAKE;

public class TCulBlockEntities {

    private TCulBlockEntities() {

    }

    public static void register() {

    }

    public static final RegistryObject<BlockEntityType<?>> POTION_CAKE_TILE = BLOCK_ENTITIES.register(ID_POTION_CAKE, () -> BlockEntityType.Builder.of(PotionCakeBlockEntity::new, BLOCKS.get(ID_POTION_CAKE)).build(null));

}
