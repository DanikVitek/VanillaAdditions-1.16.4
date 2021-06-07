package com.danikvitek.vanilla_additions.data.recipes;

import com.danikvitek.vanilla_additions.util.Registration;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;

import java.util.LinkedList;
import java.util.List;

public class ModRecipeTypes {
    public static final RegistryObject<SawmillRecipe.Serializer> SAWMILL_SERIALIZIER
            = Registration.RECIPE_SERIALIZER.register("sawmill", SawmillRecipe.Serializer::new);

    public static IRecipeType<SawmillRecipe> SAWMILL_RECIPE = new SawmillRecipe.SawmillRecipeType();

    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_TYPE, SawmillRecipe.TYPE_ID, SAWMILL_RECIPE);
    }

    public static List<IRecipe<?>> getRecipes(IRecipeType<?> recipeType, RecipeManager manager) {
        List<IRecipe<?>> recipeList = new LinkedList<>();
        for (IRecipe<?> recipe : manager.getRecipes()) {

            if (recipe.getType().equals(recipeType)) {
                recipeList.add(recipe);
            }

        }
        return recipeList;
    }
}
