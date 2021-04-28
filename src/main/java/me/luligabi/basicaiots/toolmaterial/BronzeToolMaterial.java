package me.luligabi.basicaiots.toolmaterial;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BronzeToolMaterial implements ToolMaterial {

    public static BronzeToolMaterial INSTANCE = new BronzeToolMaterial();

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 3.5F;
    }

    @Override
    public float getAttackDamage() {
        return 2.5F;
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
