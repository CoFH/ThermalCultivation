package cofh.thermal.cultivation.loot;

import cofh.lib.util.WeightedRandomDrop;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandom;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import java.util.ArrayList;
import java.util.List;

import static cofh.thermal.core.ThermalCore.ITEMS;

public class GrassLootModifier extends LootModifier {

    private List<WeightedRandomDrop> seedDrops = new ArrayList<>();

    public GrassLootModifier(ILootCondition[] conditionsIn, List<String> seeds) {

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
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {

        List<ItemStack> newLoot = new ArrayList<>();
        for (ItemStack stack : generatedLoot) {
            if (stack.getItem() == Items.WHEAT_SEEDS) {
                WeightedRandomDrop se = WeightedRandom.getRandomItem(context.getRandom(), seedDrops);
                newLoot.add(se.toItemStack(stack.getCount()));
            } else {
                newLoot.add(stack);
            }
        }
        return newLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<GrassLootModifier> {

        @Override
        public GrassLootModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition) {

            List<String> seeds = new ArrayList<>();

            JsonArray seedlist = JSONUtils.getJsonArray(object, "seeds");
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
