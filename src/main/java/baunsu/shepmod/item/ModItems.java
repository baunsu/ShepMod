package baunsu.shepmod.item;

import baunsu.shepmod.ShepMod;
import baunsu.shepmod.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SHEP = registerItem("shep", new Item(new FabricItemSettings().food(ModFoodComponents.SHEP)));
    public static final Item SHEP_SPAWN_EGG = registerItem("shep_spawn_egg", new SpawnEggItem(ModEntities.SHEP, 0xffffff, 0x000000, new FabricItemSettings()));

    private static void addItemsToFoodAndDrinkItemGroup(FabricItemGroupEntries entries) {
        entries.add(SHEP);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ShepMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ShepMod.LOGGER.info("Registering Items.");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodAndDrinkItemGroup);
    }
}
