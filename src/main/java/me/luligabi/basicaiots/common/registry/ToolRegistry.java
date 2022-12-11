package me.luligabi.basicaiots.common.registry;

import me.luligabi.basicaiots.common.item.AiotToolItem;
import me.luligabi.basicaiots.common.BasicAiots;
import me.luligabi.basicaiots.common.item.IndustrialRevolutionTechRebornToolItem;
import me.luligabi.basicaiots.common.item.IndustrialRevolutionToolItem;
import me.luligabi.basicaiots.common.item.TechRebornToolItem;
import me.luligabi.basicaiots.common.toolmaterial.IndRevToolMaterials;
import me.luligabi.basicaiots.common.toolmaterial.TechRebornToolMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ToolRegistry {

    public static void register() {
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "wooden_aiot"), WOODEN_AIOT);
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "stone_aiot"), STONE_AIOT);
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "golden_aiot"), GOLDEN_AIOT);
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "iron_aiot"), IRON_AIOT);
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "diamond_aiot"), DIAMOND_AIOT);
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "netherite_aiot"), NETHERITE_AIOT);
    }

    // Register Industrial Revolution's AIOTs
    public static void indrevRegister() {
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "tin_aiot"), TIN_AIOT);
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "copper_aiot"), COPPER_AIOT);
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "silver_aiot"), SILVER_AIOT);
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "steel_aiot"), STEEL_AIOT);
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "lead_aiot"), LEAD_AIOT);
    }

    // Register Tech Reborn's AIOTs
    public static void techrebornRegister() {
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "ruby_aiot"), RUBY_AIOT);
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "sapphire_aiot"), SAPPHIRE_AIOT);
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "peridot_aiot"), PERIDOT_AIOT);
    }

    // Vanilla
    public static ToolItem WOODEN_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.WOOD, new FabricItemSettings());

    public static ToolItem STONE_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.STONE, new FabricItemSettings());

    public static ToolItem GOLDEN_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.GOLD, new FabricItemSettings());

    public static ToolItem IRON_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.IRON, new FabricItemSettings());

    public static ToolItem DIAMOND_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.DIAMOND, new FabricItemSettings());

    public static ToolItem NETHERITE_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.NETHERITE, new FabricItemSettings());

    // Industrial Revolution
    public static ToolItem TIN_AIOT = new IndustrialRevolutionToolItem(3, -2.4F, IndRevToolMaterials.TIN, new FabricItemSettings());

    public static ToolItem COPPER_AIOT = new IndustrialRevolutionToolItem(3, -2.4F, IndRevToolMaterials.COPPER, new FabricItemSettings());

    public static ToolItem STEEL_AIOT = new IndustrialRevolutionToolItem(3, -2.4F, IndRevToolMaterials.STEEL, new FabricItemSettings());

    public static ToolItem LEAD_AIOT = new IndustrialRevolutionToolItem(3, -2.4F, IndRevToolMaterials.LEAD, new FabricItemSettings());

    public static ToolItem SILVER_AIOT = new IndustrialRevolutionToolItem(3, -2.4F, IndRevToolMaterials.SILVER, new FabricItemSettings());

    // Tech Reborn
    public static ToolItem RUBY_AIOT = new TechRebornToolItem(3, -2.4F, TechRebornToolMaterials.RUBY, new FabricItemSettings());

    public static ToolItem SAPPHIRE_AIOT = new TechRebornToolItem(3, -2.4F, TechRebornToolMaterials.SAPPHIRE, new FabricItemSettings());

    public static ToolItem PERIDOT_AIOT = new TechRebornToolItem(3, -2.4F, TechRebornToolMaterials.PERIDOT, new FabricItemSettings());

    // Other
    public static ToolItem BRONZE_AIOT = new IndustrialRevolutionTechRebornToolItem(3, -2.4F, IndRevToolMaterials.BRONZE, new FabricItemSettings());

}