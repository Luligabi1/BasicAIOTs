package me.luligabi.vanillaaiots.registry;

import me.luligabi.vanillaaiots.AiotToolItem;
import me.luligabi.vanillaaiots.VanillaAiots;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ToolRegistry {

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(VanillaAiots.MOD_ID, "wooden_aiot"), WOODEN_AIOT);
        Registry.register(Registry.ITEM, new Identifier(VanillaAiots.MOD_ID, "stone_aiot"), STONE_AIOT);
        Registry.register(Registry.ITEM, new Identifier(VanillaAiots.MOD_ID, "golden_aiot"), GOLDEN_AIOT);
        Registry.register(Registry.ITEM, new Identifier(VanillaAiots.MOD_ID, "iron_aiot"), IRON_AIOT);
        Registry.register(Registry.ITEM, new Identifier(VanillaAiots.MOD_ID, "diamond_aiot"), DIAMOND_AIOT);
        Registry.register(Registry.ITEM, new Identifier(VanillaAiots.MOD_ID, "netherite_aiot"), NETHERITE_AIOT);
    }

    public static ToolItem WOODEN_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.WOOD, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(VanillaAiots.ITEM_GROUP));

    public static ToolItem STONE_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.STONE, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(VanillaAiots.ITEM_GROUP));

    public static ToolItem GOLDEN_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.GOLD, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(VanillaAiots.ITEM_GROUP));

    public static ToolItem IRON_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.IRON, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(VanillaAiots.ITEM_GROUP));

    public static ToolItem DIAMOND_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.DIAMOND, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(VanillaAiots.ITEM_GROUP));

    public static ToolItem NETHERITE_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.NETHERITE, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(VanillaAiots.ITEM_GROUP));

}
