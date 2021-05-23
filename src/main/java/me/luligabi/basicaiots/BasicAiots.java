package me.luligabi.basicaiots;

import me.luligabi.basicaiots.registry.CompabilityRegistry;
import me.luligabi.basicaiots.registry.EffectiveBlocksRegistry;
import me.luligabi.basicaiots.registry.ToolRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicAiots implements ModInitializer {

    public static final String MOD_ID = "basicaiots";
    public static final Logger LOGGER = LogManager.getLogger("Basic AIOTs");

    //TODO: Fix error when mod is not installed (recipe)
    @Override
    public void onInitialize() {
        EffectiveBlocksRegistry.init();
        ToolRegistry.init();
        CompabilityRegistry.init();

        LOGGER.info("Basic AIOTs initialized successfully.");
    }

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "item_group"))
            .icon(() -> new ItemStack(ToolRegistry.DIAMOND_AIOT))
            .build();
}
