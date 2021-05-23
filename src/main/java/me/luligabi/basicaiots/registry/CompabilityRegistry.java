package me.luligabi.basicaiots.registry;

import me.luligabi.basicaiots.BasicAiots;
import me.luligabi.basicaiots.CompatibleMod;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CompabilityRegistry {

    public static void init() {
        if(isModLoaded(CompatibleMod.INDUSTRIAL_REVOLUTION.getId())) {
            ToolRegistry.indrevRegister();
            BasicAiots.LOGGER.info("Industrial Revolution Found! Loading compatibility AIOTs...");
        }

        if(isModLoaded(CompatibleMod.TECHREBORN.getId())) {
            ToolRegistry.techrebornRegister();
            BasicAiots.LOGGER.info("Tech Reborn Found! Loading compatibility AIOTs...");
        }
        if(isModLoaded(CompatibleMod.INDUSTRIAL_REVOLUTION.getId()) || isModLoaded(CompatibleMod.TECHREBORN.getId())) {
            Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "bronze_aiot"), ToolRegistry.BRONZE_AIOT);
            BasicAiots.LOGGER.info("Bronze-compatible mod found! Loading Bronze AIOT...");
        }

        if(isModLoaded(CompatibleMod.INDUSTRIAL_REVOLUTION.getId()) || isModLoaded(CompatibleMod.BEWITCHMENT.getId())) {
            Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "silver_aiot"), ToolRegistry.SILVER_AIOT);
            BasicAiots.LOGGER.info("Silver-compatible mod found! Loading Silver AIOT...");
        }
    }

    private static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}
