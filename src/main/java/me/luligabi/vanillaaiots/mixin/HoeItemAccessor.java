package me.luligabi.vanillaaiots.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ShovelItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;
import java.util.Set;

@Mixin(HoeItem.class)
public interface HoeItemAccessor {

    @Accessor("EFFECTIVE_BLOCKS")
    public static Set<Block> getEffectiveBlocks() {
        throw new AssertionError();
    }

    @Accessor("TILLED_BLOCKS")
    public static Map<Block, BlockState> getTilledBlocks() {
        throw new AssertionError();
    }
}
