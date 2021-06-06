package com.danikvitek.vanilla_additions.data.recipes;

import com.google.gson.JsonObject;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SingleItemRecipe;
import net.minecraft.item.crafting.StonecuttingRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import javax.annotation.Nullable;

public class ModRecipeSerializer implements IRecipeSerializer {
    IRecipeSerializer<StonecuttingRecipe> WOODCUTTING
            = register("woodcutting", new SingleItemRecipe.Serializer<>(WoodcuttingRecipe::new));


    @Override
    public IRecipe<?> read(ResourceLocation recipeId, JsonObject json) {
        return null;
    }

    @Nullable
    @Override
    public IRecipe<?> read(ResourceLocation recipeId, PacketBuffer buffer) {
        return null;
    }

    @Override
    public void write(PacketBuffer buffer, IRecipe recipe) {

    }

    @Override
    public Object setRegistryName(ResourceLocation name) {
        return null;
    }

    @Nullable
    @Override
    public ResourceLocation getRegistryName() {
        return null;
    }

    @Override
    public Class getRegistryType() {
        return null;
    }

    static <S extends IRecipeSerializer<T>, T extends IRecipe<?>> S register(String key, S recipeSerializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, key, recipeSerializer);
    }
}
