package com.danikvitek.vanilla_additions.data.recipes;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;

public interface ISawmillRecipe extends IRecipe<IInventory> {
    @Override
    default IRecipeType<?> getType(){
        return ModRecipeTypes.SAWMILL_RECIPE;
    }

    default boolean canCraftInDimensions(){
        return true;
    }

    default boolean isSpecial(){
        return true;
    }
}
