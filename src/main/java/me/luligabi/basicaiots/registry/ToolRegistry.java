package me.luligabi.basicaiots.registry;

import me.luligabi.basicaiots.AiotToolItem;
import me.luligabi.basicaiots.BasicAiots;
import me.luligabi.basicaiots.toolmaterial.BronzeToolMaterial;
import me.luligabi.basicaiots.toolmaterial.indrev.*;
import me.luligabi.basicaiots.toolmaterial.techreborn.PeridotToolMaterial;
import me.luligabi.basicaiots.toolmaterial.techreborn.RubyToolMaterial;
import me.luligabi.basicaiots.toolmaterial.techreborn.SapphireToolMaterial;
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
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "steel_aiot"), STEEL_AIOT);
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "lead_aiot"), LEAD_AIOT);
    }

    // Register Tech Reborn's AIOTs if the mod is present
    public static void techrebornRegister() {
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "ruby_aiot"), RUBY_AIOT);
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "sapphire_aiot"), SAPPHIRE_AIOT);
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "peridot_aiot"), PERIDOT_AIOT);
    }

    // Vanilla
    public static ToolItem WOODEN_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.WOOD, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem STONE_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.STONE, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem GOLDEN_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.GOLD, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem IRON_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.IRON, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem DIAMOND_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.DIAMOND, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem NETHERITE_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.NETHERITE, new Item.Settings().group(BasicAiots.ITEM_GROUP).fireproof());

    // Industrial Revolution
    public static ToolItem TIN_AIOT = new AiotToolItem(3, -2.4F, TinToolMaterial.INSTANCE, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem COPPER_AIOT = new AiotToolItem(3, -2.4F, CopperToolMaterial.INSTANCE, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem SILVER_AIOT = new AiotToolItem(3, -2.4F, SilverToolMaterial.INSTANCE, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem STEEL_AIOT = new AiotToolItem(3, -2.4F, SteelToolMaterial.INSTANCE, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem LEAD_AIOT = new AiotToolItem(3, -2.4F, LeadToolMaterial.INSTANCE, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    // Tech Reborn
    public static ToolItem RUBY_AIOT = new AiotToolItem(3, -2.4F, RubyToolMaterial.INSTANCE, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem SAPPHIRE_AIOT = new AiotToolItem(3, -2.4F, SapphireToolMaterial.INSTANCE, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    public static ToolItem PERIDOT_AIOT = new AiotToolItem(3, -2.4F, PeridotToolMaterial.INSTANCE, new Item.Settings().group(BasicAiots.ITEM_GROUP));

    // Other
    public static ToolItem BRONZE_AIOT = new AiotToolItem(3, -2.4F, BronzeToolMaterial.INSTANCE, new Item.Settings().group(BasicAiots.ITEM_GROUP));

}
