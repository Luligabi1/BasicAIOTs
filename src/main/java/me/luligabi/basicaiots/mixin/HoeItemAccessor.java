package me.luligabi.basicaiots.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.HoeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(HoeItem.class)
public interface HoeItemAccessor {

    @Accessor("TILLED_BLOCKS")
    static Map<Block, BlockState> getTilledBlocks() {
        throw new AssertionError();
    }
}