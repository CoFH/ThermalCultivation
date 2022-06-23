package cofh.thermal.cultivation.loot;

import cofh.lib.util.random.WeightedRandomDrop;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedRandom;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import java.util.ArrayList;
import java.util.List;

import static cofh.thermal.core.ThermalCore.ITEMS;
import static net.minecraft.util.GsonHelper.getAsJsonArray;

public class GrassLootModifier extends LootModifier {

    private final List<WeightedRandomDrop> seedDrops = new ArrayList<>();

    public GrassLootModifier(LootItemCondition[] conditionsIn, List<String> seeds) {

        super(conditionsIn);

        addEntry(Items.WHEAT_SEEDS, 160);

        for (String seed : seeds) {
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

    public static class Serializer extends GlobalLootModifierSerializer<GrassLootModifier> {

        @Override
        public GrassLootModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition) {

            List<String> seeds = new ArrayList<>();

            JsonArray seedlist = getAsJsonArray(object, "seeds");
            for (JsonElement je : seedlist) {
                seeds.add(je.getAsString());
            }
            return new GrassLootModifier(ailootcondition, seeds);
        }

        @Override
        public JsonObject write(GrassLootModifier instance) {

            return makeConditions(instance.conditions);
        }

    }

}
