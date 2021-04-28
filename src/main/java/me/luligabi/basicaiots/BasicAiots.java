package me.luligabi.basicaiots;

import me.luligabi.basicaiots.registry.EffectiveBlocksRegistry;
import me.luligabi.basicaiots.registry.ToolRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class BasicAiots implements ModInitializer {

    public static final String MOD_ID = "basicaiots";

    @Override
    public void onInitialize() {
        EffectiveBlocksRegistry.register();
        ToolRegistry.register();

        if(FabricLoader.getInstance().isModLoaded("indrev")) {
            ToolRegistry.indrevRegister();
        }
    }

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "item_group"))
            .icon(() -> new ItemStack(ToolRegistry.DIAMOND_AIOT))
            .build();
}
