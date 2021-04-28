package me.luligabi.basicaiots.toolmaterial;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TinToolMaterial implements ToolMaterial {

    public static TinToolMaterial INSTANCE = new TinToolMaterial();

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getDurability() {
        return 200;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4.0F;
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
    } //TODO: Add repair item
}
