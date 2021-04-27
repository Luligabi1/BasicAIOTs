package me.luligabi.basicaiots;

import me.luligabi.basicaiots.mixin.AxeItemAccessor;
import me.luligabi.basicaiots.mixin.HoeItemAccessor;
import me.luligabi.basicaiots.mixin.ShovelItemAccessor;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

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
        super(attackDamage, attackSpeed, material, effectiveBlocks, settings);
    }

    @Override
    public boolean isEffectiveOn(BlockState state) {
        int miningLevel = this.getMaterial().getMiningLevel();
        if (!state.isOf(Blocks.OBSIDIAN) && !state.isOf(Blocks.CRYING_OBSIDIAN) && !state.isOf(Blocks.NETHERITE_BLOCK) && !state.isOf(Blocks.RESPAWN_ANCHOR) && !state.isOf(Blocks.ANCIENT_DEBRIS)) {
            if (!state.isOf(Blocks.DIAMOND_BLOCK) && !state.isOf(Blocks.DIAMOND_ORE) && !state.isOf(Blocks.EMERALD_ORE) && !state.isOf(Blocks.EMERALD_BLOCK) && !state.isOf(Blocks.GOLD_BLOCK) && !state.isOf(Blocks.GOLD_ORE) && !state.isOf(Blocks.REDSTONE_ORE)) {
                if (!state.isOf(Blocks.IRON_BLOCK) && !state.isOf(Blocks.IRON_ORE) && !state.isOf(Blocks.LAPIS_BLOCK) && !state.isOf(Blocks.LAPIS_ORE)) {
                    Material material = state.getMaterial();
                    return material == Material.STONE || material == Material.METAL || material == Material.REPAIR_STATION || state.isOf(Blocks.NETHER_GOLD_ORE) || state.isOf(Blocks.SNOW) || state.isOf(Blocks.SNOW_BLOCK) || state.isOf(Blocks.COBWEB);
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
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        Block block = blockState.getBlock();
        PlayerEntity playerEntity = context.getPlayer();

        if(strippedBlocks.containsKey(block)) { // Axe action (strip log)
            Block logBlock = strippedBlocks.get(blockState.getBlock());

            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isClient()) {
                world.setBlockState(blockPos, logBlock.getDefaultState().with(PillarBlock.AXIS, blockState.get(PillarBlock.AXIS)), 11);
                if (playerEntity != null) {
                    context.getStack().damage(1, (LivingEntity)playerEntity, ((p) -> p.sendToolBreakStatus(context.getHand())));
                }
            }
            return ActionResult.success(world.isClient());
        }
        if(playerEntity != null) {
            if (playerEntity.isSneaking()) {
                if(pathStates.containsKey(block)) { // Shovel actions (extinguish campfire/create path)
                    if (context.getSide() == Direction.DOWN) {
                        return ActionResult.PASS;
                    } else {
                        BlockState blockState2 = pathStates.get(blockState.getBlock());
                        BlockState blockState3 = null;
                        if (blockState2 != null && world.getBlockState(blockPos.up()).isAir()) {
                            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                            blockState3 = blockState2;
                        } else if (blockState.getBlock() instanceof CampfireBlock && blockState.get(CampfireBlock.LIT)) {
                            if (!world.isClient()) {
                                world.syncWorldEvent(null, 1009, blockPos, 0);
                            }
                            CampfireBlock.extinguish(world, blockPos, blockState);
                            blockState3 = blockState.with(CampfireBlock.LIT, false);
                        }

                        if (blockState3 != null) {
                            if (!world.isClient) {
                                world.setBlockState(blockPos, blockState3, 11);
                                context.getStack().damage(1, (LivingEntity)playerEntity, ((p) -> p.sendToolBreakStatus(context.getHand())));
                            }

                            return ActionResult.success(world.isClient());
                        } else {
                            return ActionResult.PASS;
                        }
                    }
                }
            } else {
                if (tilledBlocks.containsKey(block)) { // Hoe action (hoe dirt)
                    if (context.getSide() != Direction.DOWN && world.getBlockState(blockPos.up()).isAir()) {
                        BlockState hoeableBlocks = tilledBlocks.get(world.getBlockState(blockPos).getBlock());
                        if (hoeableBlocks != null) {
                            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                            if (!world.isClient()) {
                                world.setBlockState(blockPos, hoeableBlocks, 11);
                                context.getStack().damage(1, (LivingEntity) playerEntity, ((p) -> p.sendToolBreakStatus(context.getHand())));
                            }
                        }
                    }
                    return ActionResult.success(world.isClient());
                }
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        if(state.isOf(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return (material == Material.METAL || material == Material.REPAIR_STATION || material == Material.STONE) ||
                    woodenBlocks.contains(material) ? this.miningSpeed : super.getMiningSpeedMultiplier(stack, state);
        }
    }
}
