package me.luligabi.basicaiots.common;

import me.luligabi.basicaiots.common.registry.ToolRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicAiots implements ModInitializer {

    public static final String MOD_ID = "basicaiots";
    private static final Logger LOGGER = LogManager.getLogger("Basic AIOTs");

    @Override
    public void onInitialize() {
        ToolRegistry.register();
        ToolRegistry.indrevRegister();
        ToolRegistry.techrebornRegister();
        Registry.register(Registries.ITEM, new Identifier(BasicAiots.MOD_ID, "bronze_aiot"), ToolRegistry.BRONZE_AIOT);

        LOGGER.info("Basic AIOTs initialized successfully.");
    }

    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "item_group"))
            .displayName(Text.translatable("itemGroup.basicaiots.item_group"))
            .icon(() -> new ItemStack(ToolRegistry.DIAMOND_AIOT))
            .entries((enabledFeatures, entries, operatorEnabled) -> {
                // Vanilla
                entries.add(new ItemStack(ToolRegistry.WOODEN_AIOT));
                entries.add(new ItemStack(ToolRegistry.STONE_AIOT));
                entries.add(new ItemStack(ToolRegistry.GOLDEN_AIOT));
                entries.add(new ItemStack(ToolRegistry.IRON_AIOT));
                entries.add(new ItemStack(ToolRegistry.DIAMOND_AIOT));
                entries.add(new ItemStack(ToolRegistry.NETHERITE_AIOT));

                // Industrial Revolution
                if(isModLoaded("indrev")) {
                    entries.add(new ItemStack(ToolRegistry.TIN_AIOT));
                    entries.add(new ItemStack(ToolRegistry.COPPER_AIOT));
                    entries.add(new ItemStack(ToolRegistry.SILVER_AIOT));
                    entries.add(new ItemStack(ToolRegistry.STEEL_AIOT));
                    entries.add(new ItemStack(ToolRegistry.LEAD_AIOT));
                }

                // Tech Reborn
                if(isModLoaded("techreborn")) {
                    entries.add(new ItemStack(ToolRegistry.RUBY_AIOT));
                    entries.add(new ItemStack(ToolRegistry.SAPPHIRE_AIOT));
                    entries.add(new ItemStack(ToolRegistry.PERIDOT_AIOT));
                }

                // Bronze AIOT (either Industrial Revolution or Tech Reborn)
                if(isModLoaded("indrev") || isModLoaded("techreborn")) {
                    entries.add(new ItemStack(ToolRegistry.BRONZE_AIOT));
                }
            })
            .build();

    public static boolean isModLoaded(String modid) {
        return FabricLoader.getInstance().isModLoaded(modid);
    }
}
