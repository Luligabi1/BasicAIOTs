package me.luligabi.basicaiots.toolmaterial.indrev;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SilverToolMaterial implements ToolMaterial {

    public static SilverToolMaterial INSTANCE = new SilverToolMaterial();

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.0F;
    }

    @Override
    public float getAttackDamage() {
        return 1.0F;
    }

    @Override
    public int getEnchantability() {
        return 24;
    }

    @Override
    public Ingredient getRepairIngredient() { //TODO: Add repair item
        return null;
    }
}
