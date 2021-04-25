package me.luligabi.vanillaaiots;

import me.luligabi.vanillaaiots.registry.EffectiveBlocksRegistry;
import me.luligabi.vanillaaiots.registry.ToolRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class VanillaAiots implements ModInitializer {

    public static final String MOD_ID = "vanillaaiots";

    @Override
    public void onInitialize() {
        EffectiveBlocksRegistry.register();
        ToolRegistry.register();
    }

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "item_group"))
            .icon(() -> new ItemStack(ToolRegistry.DIAMOND_AIOT))
            .build();
}
