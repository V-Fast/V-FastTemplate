package org.vfast.template.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.vfast.template.TemplateMod;

import java.util.List;

public class ModBlocks {
    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(TemplateMod.ID, name), block);
    }

    private static Block registerBlock(String name, Block block, List<ItemGroup> tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(TemplateMod.ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        Item item = Registry.register(Registries.ITEM, new Identifier(TemplateMod.ID, name),
                new BlockItem(block, new FabricItemSettings()));

        // put in item group
        ItemGroupEvents.modifyEntriesEvent(tab).register(content -> content.add(item));

        return item;
    }

    // can be used for new 1.19.3+ creative inventory system
    private static Item registerBlockItem(String name, Block block, List<ItemGroup> tabs) {
        Item item = Registry.register(Registries.ITEM, new Identifier(TemplateMod.ID, name),
                new BlockItem(block, new FabricItemSettings()));

        // put in item group
        for (int i = 0; i < tabs.size(); i++) {
            ItemGroup tab = tabs.get(i);
            ItemGroupEvents.modifyEntriesEvent(tab).register(content -> content.add(item));
        }
        return item;
    }
}
