package me.luligabi.basicaiots.registry;

import me.luligabi.basicaiots.AiotToolItem;
import me.luligabi.basicaiots.BasicAiots;
import me.luligabi.basicaiots.toolmaterial.*;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ToolRegistry {

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "wooden_aiot"), WOODEN_AIOT);
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "stone_aiot"), STONE_AIOT);
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "golden_aiot"), GOLDEN_AIOT);
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "iron_aiot"), IRON_AIOT);
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "diamond_aiot"), DIAMOND_AIOT);
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "netherite_aiot"), NETHERITE_AIOT);
    }

    // Register Industrial Revolution's AIOTs if the mod is present
    public static void indrevRegister() {
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "tin_aiot"), TIN_AIOT);
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "copper_aiot"), COPPER_AIOT);
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "silver_aiot"), SILVER_AIOT);
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "bronze_aiot"), BRONZE_AIOT);
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "steel_aiot"), STEEL_AIOT);
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "lead_aiot"), LEAD_AIOT);
    }

    // Vanilla
    public static ToolItem WOODEN_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.WOOD, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem STONE_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.STONE, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem GOLDEN_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.GOLD, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem IRON_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.IRON, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem DIAMOND_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.DIAMOND, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem NETHERITE_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.NETHERITE, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    // Industrial Revolution
    public static ToolItem TIN_AIOT = new AiotToolItem(3, -2.4F, TinToolMaterial.INSTANCE, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem COPPER_AIOT = new AiotToolItem(3, -2.4F, CopperToolMaterial.INSTANCE, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem SILVER_AIOT = new AiotToolItem(3, -2.4F, SilverToolMaterial.INSTANCE, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem BRONZE_AIOT = new AiotToolItem(3, -2.4F, BronzeToolMaterial.INSTANCE, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem STEEL_AIOT = new AiotToolItem(3, -2.4F, SteelToolMaterial.INSTANCE, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem LEAD_AIOT = new AiotToolItem(3, -2.4F, LeadToolMaterial.INSTANCE, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(BasicAiots.ITEM_GROUP));

}
