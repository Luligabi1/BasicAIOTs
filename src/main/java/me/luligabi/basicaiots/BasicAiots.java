package me.luligabi.basicaiots;

import me.luligabi.basicaiots.registry.EffectiveBlocksRegistry;
import me.luligabi.basicaiots.registry.ToolRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicAiots implements ModInitializer {

    public static final String MOD_ID = "basicaiots";
    private static final Logger LOGGER = LogManager.getLogger("Basic AIOT's");

    @Override
    public void onInitialize() {
        EffectiveBlocksRegistry.register();
        ToolRegistry.register();

        if(FabricLoader.getInstance().isModLoaded("indrev")) {
            ToolRegistry.indrevRegister();
            LOGGER.info("Industrial Revolution Found! Loading compatibility AIOTs...");
        }
        if(FabricLoader.getInstance().isModLoaded("techreborn")) {
            ToolRegistry.techrebornRegister();
            LOGGER.info("Tech Reborn Found! Loading compatibility AIOTs...");
        }
        if(FabricLoader.getInstance().isModLoaded("indrev") || FabricLoader.getInstance().isModLoaded("techreborn")) {
            Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "bronze_aiot"), ToolRegistry.BRONZE_AIOT);
            LOGGER.info("Bronze-compatible mod found! Loading Bronze AIOT...");
        }
        LOGGER.info("Basic AIOTs initialized successfully.");
    }

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "item_group"))
            .icon(() -> new ItemStack(ToolRegistry.DIAMOND_AIOT))
            .build();
}
