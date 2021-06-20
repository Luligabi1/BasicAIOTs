package me.luligabi.basicaiots.toolmaterial;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum IndRevToolMaterials implements ToolMaterial {

    TIN(1, 200, 4.0F, 1.0F, 14, () -> Ingredient.EMPTY),
    COPPER(2, 300, 4.5F, 1.0F, 14, () -> Ingredient.EMPTY),
    STEEL(3, 600, 4.5f, 2.0f, 14, () -> Ingredient.EMPTY),
    LEAD(2, 900, 3.0f, 2.0f, 8, () -> Ingredient.EMPTY),
    SILVER(2, 500, 5.0f, 1.0f, 24, () -> Ingredient.EMPTY),

    BRONZE(2, 500, 3.5f, 2.5f, 12, () -> Ingredient.EMPTY);

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    IndRevToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}