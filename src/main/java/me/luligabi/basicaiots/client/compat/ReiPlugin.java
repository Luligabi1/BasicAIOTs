package me.luligabi.basicaiots.client.compat;

import me.luligabi.basicaiots.common.BasicAiots;
import me.luligabi.basicaiots.common.registry.ToolRegistry;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class ReiPlugin implements REIClientPlugin {

    @Override
    public void registerEntries(EntryRegistry registry) {
        if(!BasicAiots.isModLoaded("indrev")) {
            registry.removeEntry(EntryStacks.of(ToolRegistry.TIN_AIOT));
            registry.removeEntry(EntryStacks.of(ToolRegistry.COPPER_AIOT));
            registry.removeEntry(EntryStacks.of(ToolRegistry.SILVER_AIOT));
            registry.removeEntry(EntryStacks.of(ToolRegistry.STEEL_AIOT));
            registry.removeEntry(EntryStacks.of(ToolRegistry.LEAD_AIOT));
        }

        // Tech Reborn
        if(!BasicAiots.isModLoaded("techreborn")) {
            registry.removeEntry(EntryStacks.of(ToolRegistry.RUBY_AIOT));
            registry.removeEntry(EntryStacks.of(ToolRegistry.SAPPHIRE_AIOT));
            registry.removeEntry(EntryStacks.of(ToolRegistry.PERIDOT_AIOT));
        }

        // Bronze AIOT (either Industrial Revolution or Tech Reborn)
        if(!BasicAiots.isModLoaded("indrev") || !BasicAiots.isModLoaded("techreborn")) {
            registry.removeEntry(EntryStacks.of(ToolRegistry.BRONZE_AIOT));
        }
    }
}