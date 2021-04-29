package me.luligabi.basicaiots.toolmaterial.techreborn;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RubyToolMaterial implements ToolMaterial {

    public static RubyToolMaterial INSTANCE = new RubyToolMaterial();

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getDurability() {
        return 750;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6.0F;
    }

    @Override
    public float getAttackDamage() {
        return 1.5F;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() { //TODO: Add repair item
        return null;
    }
}
