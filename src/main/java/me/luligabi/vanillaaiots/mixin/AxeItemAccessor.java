package me.luligabi.vanillaaiots.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.AxeItem;
import net.minecraft.item.PickaxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;
import java.util.Set;

@Mixin(AxeItem.class)
public interface AxeItemAccessor {

    @Accessor("EFFECTIVE_BLOCKS")
    public static Set<Block> getEffectiveBlocks() {
        throw new AssertionError();
    }

    @Accessor("field_23139")
    public static Set<Material> getWoodenBlocks() {
        throw new AssertionError();
    }

    @Accessor("STRIPPED_BLOCKS")
    public static Map<Block, Block> getStrippedBlocks() {
        throw new AssertionError();
    }
}
