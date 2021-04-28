package me.luligabi.basicaiots.toolmaterial;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class LeadToolMaterial implements ToolMaterial {

    public static LeadToolMaterial INSTANCE = new LeadToolMaterial();

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getDurability() {
        return 900;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 3.0F;
    }

    @Override
    public float getAttackDamage() {
        return 2.0F;
    }

    @Override
    public int getEnchantability() {
        return 8;
    }

    @Override
    public Ingredient getRepairIngredient() { //TODO: Add repair item
        return null;
    }
}
