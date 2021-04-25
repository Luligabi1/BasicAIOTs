package me.luligabi.vanillaaiots.registry;

import me.luligabi.vanillaaiots.AiotToolItem;
import me.luligabi.vanillaaiots.VanillaAiots;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ToolRegistry {

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(VanillaAiots.MOD_ID, "diamond_aiot"), DIAMOND_AIOT);
    }

    public static ToolItem DIAMOND_AIOT = new AiotToolItem(3, -2.4F, ToolMaterials.DIAMOND, EffectiveBlocksRegistry.effectiveBlocks, new Item.Settings().group(ItemGroup.TOOLS));
}
