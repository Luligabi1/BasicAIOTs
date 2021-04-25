package me.luligabi.vanillaaiots;

import me.luligabi.vanillaaiots.registry.EffectiveBlocksRegistry;
import me.luligabi.vanillaaiots.registry.ToolRegistry;
import net.fabricmc.api.ModInitializer;

public class VanillaAiots implements ModInitializer {

    public static final String MOD_ID = "vanillaaiots";

    @Override
    public void onInitialize() {
        EffectiveBlocksRegistry.register();
        ToolRegistry.register();
    }
}
