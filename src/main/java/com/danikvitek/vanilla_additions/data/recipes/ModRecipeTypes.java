package com.danikvitek.vanilla_additions.data.recipes;

import com.danikvitek.vanilla_additions.util.Registration;
import net.minecraft.item.crafting.IRecipeType;

public class ModRecipeTypes {
    RegistryObject<SawmillRecipe.Serializer> name
            = Registration.RECIPE_SERIALIZER.register("sawmill", SawmillRecipe.Serializer::new);

    public static IRecipeType<SawmillRecipe> SAWMILL_RECIPE = new SawmillRecipe.AltarRecipeType();
}
