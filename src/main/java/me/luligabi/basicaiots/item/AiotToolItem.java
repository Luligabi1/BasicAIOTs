package me.luligabi.basicaiots.item;

import com.google.common.collect.BiMap;
import com.mojang.datafixers.util.Pair;
import me.luligabi.basicaiots.mixin.AxeItemAccessor;
import me.luligabi.basicaiots.mixin.HoeItemAccessor;
import me.luligabi.basicaiots.mixin.ShovelItemAccessor;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class AiotToolItem extends MiningToolItem {
    
    private static final Map<Block, Block> strippedBlocks = AxeItemAccessor.getStrippedBlocks();
    private static final Map<Block, BlockState> pathStates = ShovelItemAccessor.getPathStates();
    private static final Map<Block, Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>> tilledBlocks = HoeItemAccessor.getTillingActions();

    public AiotToolItem(float attackDamage, float attackSpeed, ToolMaterial material, Settings settings) {
        super(attackDamage, attackSpeed, material, BlockTags.PICKAXE_MINEABLE, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        Block block = blockState.getBlock();
        PlayerEntity playerEntity = context.getPlayer();

        Optional<BlockState> optional = getStrippedState(blockState);
        Optional<BlockState> optional2 = Oxidizable.getDecreasedOxidationState(blockState);
        Optional<BlockState> optional3 = Optional.ofNullable((Block)((BiMap) HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get()).get(blockState.getBlock())).map((waxedBlock) -> waxedBlock.getStateWithProperties(blockState));
        ItemStack itemStack = context.getStack();
        Optional<BlockState> optional4 = Optional.empty();
        if (optional.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            optional4 = optional;
        } else if (optional2.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.syncWorldEvent(playerEntity, 3005, blockPos, 0);
            optional4 = optional2;
        } else if (optional3.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.syncWorldEvent(playerEntity, 3004, blockPos, 0);
            optional4 = optional3;
        }

        if (optional4.isPresent()) {
            if (playerEntity instanceof ServerPlayerEntity) {
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)playerEntity, blockPos, itemStack);
            }

            world.setBlockState(blockPos, optional4.get(), 11);
            if (playerEntity != null) {
                itemStack.damage(1, playerEntity, (p) -> p.sendToolBreakStatus(context.getHand()));
            }

            return ActionResult.success(world.isClient);
        }
        if(playerEntity != null) {
            if (playerEntity.isSneaking()) {
                if (pathStates.containsKey(block)) { // Shovel actions (extinguish campfire/create path)
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
                            CampfireBlock.extinguish(playerEntity, world, blockPos, blockState);
                            blockState3 = blockState.with(CampfireBlock.LIT, false);
                        }

                        if (blockState3 != null) {
                            if (!world.isClient) {
                                world.setBlockState(blockPos, blockState3, 11);
                                context.getStack().damage(1, (LivingEntity) playerEntity, ((p) -> p.sendToolBreakStatus(context.getHand())));
                            }

                            return ActionResult.success(world.isClient());
                        } else {
                            return ActionResult.PASS;
                        }
                    }
                }
            } else {
                Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>> pair = tilledBlocks.get(world.getBlockState(blockPos).getBlock());
                if (pair != null) {
                    Predicate<ItemUsageContext> predicate = pair.getFirst();
                    Consumer<ItemUsageContext> consumer = pair.getSecond();
                    if (predicate.test(context)) {
                        world.playSound(playerEntity, blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        if (!world.isClient) {
                            consumer.accept(context);
                            context.getStack().damage(1, (LivingEntity) playerEntity, ((p) -> p.sendToolBreakStatus(context.getHand())));
                        }
                        return ActionResult.success(world.isClient);
                    }
                    return ActionResult.PASS;
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
            return (material == Material.METAL || material == Material.REPAIR_STATION || material == Material.STONE) ? this.miningSpeed : super.getMiningSpeedMultiplier(stack, state);
        }
    }

    private Optional<BlockState> getStrippedState(BlockState state) {
        return Optional.ofNullable(strippedBlocks.get(state.getBlock())).map((block) -> block.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS)));
    }
}