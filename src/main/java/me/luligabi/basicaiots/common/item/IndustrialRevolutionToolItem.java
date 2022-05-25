package me.luligabi.basicaiots.common.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class IndustrialRevolutionToolItem extends AiotToolItem {

    public IndustrialRevolutionToolItem(float attackDamage, float attackSpeed, ToolMaterial material, Settings settings) {
        super(attackDamage, attackSpeed, material, settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.basicaiots.indrev.tooltip").formatted(Formatting.DARK_AQUA, Formatting.ITALIC));
    }
}
