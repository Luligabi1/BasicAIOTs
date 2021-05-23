package me.luligabi.basicaiots.registry;

import me.luligabi.basicaiots.mixin.AxeItemAccessor;
import me.luligabi.basicaiots.mixin.HoeItemAccessor;
import me.luligabi.basicaiots.mixin.PickaxeItemAccessor;
import me.luligabi.basicaiots.mixin.ShovelItemAccessor;
import net.minecraft.block.Block;

import java.util.HashSet;
import java.util.Set;

public class EffectiveBlocksRegistry {

    public static Set<Block> effectiveBlocks = new HashSet<>();

    public static void init() { //this is extra messy, but I couldn't find a better alternative
        effectiveBlocks.addAll(pickaxeEffectiveBlocks);
        effectiveBlocks.addAll(axeEffectiveBlocks);
        effectiveBlocks.addAll(shovelEffectiveBlocks);
        effectiveBlocks.addAll(hoeEffectiveBlocks);
    }

    private static final Set<Block> pickaxeEffectiveBlocks = PickaxeItemAccessor.getEffectiveBlocks();

    private static final Set<Block> axeEffectiveBlocks = AxeItemAccessor.getEffectiveBlocks();

    private static final Set<Block> shovelEffectiveBlocks = ShovelItemAccessor.getEffectiveBlocks();

    private static final Set<Block> hoeEffectiveBlocks = HoeItemAccessor.getEffectiveBlocks();
}
