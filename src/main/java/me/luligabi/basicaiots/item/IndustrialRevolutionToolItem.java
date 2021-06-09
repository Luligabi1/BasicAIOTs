package me.luligabi.basicaiots.item;

import me.luligabi.basicaiots.AiotToolItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class IndustrialRevolutionToolItem extends AiotToolItem {

    public IndustrialRevolutionToolItem(float attackDamage, float attackSpeed, ToolMaterial material, Settings settings) {
        super(attackDamage, attackSpeed, material, settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.basicaiots.indrev.tooltip").formatted(Formatting.DARK_AQUA, Formatting.ITALIC, Formatting.BOLD));
    }
}
