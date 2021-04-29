package me.luligabi.basicaiots.toolmaterial.techreborn;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PeridotToolMaterial implements ToolMaterial {

    public static PeridotToolMaterial INSTANCE = new PeridotToolMaterial();

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
        return 7.0F;
    }

    @Override
    public float getAttackDamage() {
        return 1.5F;
    }

    @Override
    public int getEnchantability() {
        return 12;
    }

    @Override
    public Ingredient getRepairIngredient() { //TODO: Add repair item
        return null;
    }
}
