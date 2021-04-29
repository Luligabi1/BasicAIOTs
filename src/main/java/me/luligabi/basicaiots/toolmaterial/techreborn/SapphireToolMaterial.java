package me.luligabi.basicaiots.toolmaterial.techreborn;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SapphireToolMaterial implements ToolMaterial {

    public static SapphireToolMaterial INSTANCE = new SapphireToolMaterial();

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getDurability() {
        return 1000;
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
