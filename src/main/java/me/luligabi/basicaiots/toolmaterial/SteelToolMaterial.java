package me.luligabi.basicaiots.toolmaterial;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SteelToolMaterial implements ToolMaterial {

    public static SteelToolMaterial INSTANCE = new SteelToolMaterial();

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getDurability() {
        return 1500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4.4F;
    }

    @Override
    public float getAttackDamage() {
        return 1.0F;
    }

    @Override
    public int getEnchantability() {
        return 14;
    }

    @Override
    public Ingredient getRepairIngredient() { //TODO: Add repair item
        return null;
    }
}
