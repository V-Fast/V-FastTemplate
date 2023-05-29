package org.vfast.template.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.vfast.template.TemplateMod;

import java.util.List;

public class ModItems {
    public static Item registerItem(String name, Item item, ItemGroup group) {
        Item newItem = Registry.register(Registries.ITEM, new Identifier(TemplateMod.ID, name), item);

        // put in item group
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
            content.add(newItem);
        });

        return newItem;
    }

    // can be used for new 1.19.3+ creative inventory system
    private static Item registerItem(String name, Item item, List<ItemGroup> tabs) {
        Item newItem = Registry.register(Registries.ITEM, new Identifier(TemplateMod.ID, name), item);

        // put in item group
        for (int i = 0; i < tabs.size(); i++) {
            ItemGroupEvents.modifyEntriesEvent(tabs.get(i)).register(content -> {
                content.add(newItem);
            });
        }
        return newItem;
    }
}
