package me.luligabi.basicaiots.common;

import me.luligabi.basicaiots.common.registry.ToolRegistry;
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
    private static final Logger LOGGER = LogManager.getLogger("Basic AIOTs");

    @Override
    public void onInitialize() {
        ToolRegistry.register();
        ToolRegistry.indrevRegister();
        ToolRegistry.techrebornRegister();
        Registry.register(Registry.ITEM, new Identifier(BasicAiots.MOD_ID, "bronze_aiot"), ToolRegistry.BRONZE_AIOT);

        LOGGER.info("Basic AIOTs initialized successfully.");
    }

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "item_group"))
            .icon(() -> new ItemStack(ToolRegistry.DIAMOND_AIOT))
            .appendItems(stacks -> {
                // Vanilla
                stacks.add(new ItemStack(ToolRegistry.WOODEN_AIOT));
                stacks.add(new ItemStack(ToolRegistry.STONE_AIOT));
                stacks.add(new ItemStack(ToolRegistry.GOLDEN_AIOT));
                stacks.add(new ItemStack(ToolRegistry.IRON_AIOT));
                stacks.add(new ItemStack(ToolRegistry.DIAMOND_AIOT));
                stacks.add(new ItemStack(ToolRegistry.NETHERITE_AIOT));

                // Industrial Revolution
                if(isModLoaded("indrev")) {
                    stacks.add(new ItemStack(ToolRegistry.TIN_AIOT));
                    stacks.add(new ItemStack(ToolRegistry.COPPER_AIOT));
                    stacks.add(new ItemStack(ToolRegistry.SILVER_AIOT));
                    stacks.add(new ItemStack(ToolRegistry.STEEL_AIOT));
                    stacks.add(new ItemStack(ToolRegistry.LEAD_AIOT));
                }

                // Tech Reborn
                if(isModLoaded("techreborn")) {
                    stacks.add(new ItemStack(ToolRegistry.RUBY_AIOT));
                    stacks.add(new ItemStack(ToolRegistry.SAPPHIRE_AIOT));
                    stacks.add(new ItemStack(ToolRegistry.PERIDOT_AIOT));
                }

                // Bronze AIOT (either Industrial Revolution or Tech Reborn)
                if(isModLoaded("indrev") || isModLoaded("techreborn")) {
                    stacks.add(new ItemStack(ToolRegistry.BRONZE_AIOT));
                }
            })
            .build();

    public static boolean isModLoaded(String modid) {
        return FabricLoader.getInstance().isModLoaded(modid);
    }
}
