package cofh.thermal.cultivation.common.loot;

import cofh.lib.util.random.WeightedRandomDrop;
import cofh.thermal.cultivation.common.config.ThermalCropConfig;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.random.WeightedRandom;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import java.util.ArrayList;
import java.util.List;

import static cofh.thermal.core.ThermalCore.ITEMS;

public class GrassLootModifier extends LootModifier {

    public static final Codec<GrassLootModifier> CODEC = RecordCodecBuilder.create(inst -> LootModifier.codecStart(inst).and(
                    Codec.STRING.listOf().fieldOf("seeds").forGetter(m -> m.seeds))
            .apply(inst, GrassLootModifier::new));

    private final List<String> seeds;
    private final List<WeightedRandomDrop> seedDrops = new ArrayList<>();

    public GrassLootModifier(LootItemCondition[] conditionsIn, List<String> seeds) {

        super(conditionsIn);
        this.seeds = seeds;

        addEntry(Items.WHEAT_SEEDS, 160);

        for (String seed : this.seeds) {
            addEntry(seed, 20);
        }
    }

    public void addEntry(Item seed, int weight) {

        seedDrops.add(new WeightedRandomDrop(seed, weight));
    }

    public void addEntry(String seed, int weight) {

        seedDrops.add(new WeightedRandomDrop(ITEMS.get(seed), weight));
    }

    /**
     * if minecraft:wheat_seeds drop from grass, re-roll what kind of seeds they really are,
     * based on the weighted chances from the loot_modifier json.
     */
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {

        if (!ThermalCropConfig.dropSeedsFromGrass.get()) {
            return generatedLoot;
        }
        ObjectArrayList<ItemStack> newLoot = new ObjectArrayList<>();
        for (ItemStack stack : generatedLoot) {
            if (stack.getItem() == Items.WHEAT_SEEDS) {
                WeightedRandom.getRandomItem(context.getRandom(), seedDrops).ifPresent((e) -> newLoot.add(e.toItemStack(stack.getCount())));
            } else {
                newLoot.add(stack);
            }
        }
        return newLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {

        return CODEC;
    }

}
