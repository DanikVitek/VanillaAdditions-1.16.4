package com.danikvitek.vanilla_additions.data.recipes;

import net.minecraft.block.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.SingleItemRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class WoodcuttingRecipe extends SingleItemRecipe {
    public WoodcuttingRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result) {
        super(IRecipeType.STONECUTTING, IRecipeSerializer.STONECUTTING, id, group, ingredient, result);
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return this.ingredient.test(inv.getStackInSlot(0));
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(Blocks.STONECUTTER);
    }
}
