package com.danikvitek.vanilla_additions.data.recipes;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public interface ISawmillRecipe extends IRecipe<IInventory> {

    ResourceLocation TYPE_ID = new ResourceLocation(VanillaAdditionsMod.MOD_ID, "sawmill");

    @Override
    default IRecipeType<?> getType(){
        return Registry.RECIPE_TYPE.getOptional(TYPE_ID).get();
    }

    @Override
    default boolean canFit(int width, int height) {
        return true;
    }

    @Override
    default boolean isDynamic(){
        return true;
    }
}
