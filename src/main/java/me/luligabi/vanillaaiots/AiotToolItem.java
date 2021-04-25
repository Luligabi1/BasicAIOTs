package me.luligabi.vanillaaiots;

import me.luligabi.vanillaaiots.mixin.AxeItemAccessor;
import me.luligabi.vanillaaiots.mixin.HoeItemAccessor;
import me.luligabi.vanillaaiots.mixin.ShovelItemAccessor;
import me.luligabi.vanillaaiots.registry.EffectiveBlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;

import java.util.Map;
import java.util.Set;

public class AiotToolItem extends MiningToolItem {

    // Axe
    private static final Set<Material> woodenBlocks = AxeItemAccessor.getWoodenBlocks();
    private static final Map<Block, Block> strippedBlocks = AxeItemAccessor.getStrippedBlocks();

    // Shovel
    private static final Map<Block, BlockState> pathStates = ShovelItemAccessor.getPathStates();

    // Hoe
    private static final Map<Block, BlockState> tilledBlocks = HoeItemAccessor.getTilledBlocks();

    public AiotToolItem(float attackDamage, float attackSpeed, ToolMaterial material, Set<Block> effectiveBlocks, Settings settings) {
        super(attackDamage, attackSpeed, material, EffectiveBlocksRegistry.effectiveBlocks, settings);
    }

    @Override
    public boolean isEffectiveOn(BlockState state) { //TODO: Add snow block and layer to effective list.
        int miningLevel = this.getMaterial().getMiningLevel();
        if (!state.isOf(Blocks.OBSIDIAN) && !state.isOf(Blocks.CRYING_OBSIDIAN) && !state.isOf(Blocks.NETHERITE_BLOCK) && !state.isOf(Blocks.RESPAWN_ANCHOR) && !state.isOf(Blocks.ANCIENT_DEBRIS)) {
            if (!state.isOf(Blocks.DIAMOND_BLOCK) && !state.isOf(Blocks.DIAMOND_ORE) && !state.isOf(Blocks.EMERALD_ORE) && !state.isOf(Blocks.EMERALD_BLOCK) && !state.isOf(Blocks.GOLD_BLOCK) && !state.isOf(Blocks.GOLD_ORE) && !state.isOf(Blocks.REDSTONE_ORE)) {
                if (!state.isOf(Blocks.IRON_BLOCK) && !state.isOf(Blocks.IRON_ORE) && !state.isOf(Blocks.LAPIS_BLOCK) && !state.isOf(Blocks.LAPIS_ORE)) {
                    Material material = state.getMaterial();
                    return material == Material.STONE || material == Material.METAL || material == Material.REPAIR_STATION || state.isOf(Blocks.NETHER_GOLD_ORE);
                } else {
                    return miningLevel >= 1;
                }
            } else {
                return miningLevel >= 2;
            }
        } else {
            return miningLevel >= 3;
        }
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        if(state.isOf(Blocks.COBWEB)) {
            return 15.0F;
        }
        return (material == Material.METAL || material == Material.REPAIR_STATION || material == Material.STONE) ||
                woodenBlocks.contains(material) ? this.miningSpeed : super.getMiningSpeedMultiplier(stack, state);
    }
}
