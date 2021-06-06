package com.danikvitek.vanilla_additions.data.recipes;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.block.ModBlocks;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SawmillRecipe implements ISawmillRecipe {
    private final ResourceLocation id;
    private final ItemStack output;
    private final Ingredient inputs;

    public SawmillRecipe(ResourceLocation id, ItemStack output, Ingredient inputs)
    {
        this.id = id;
        this.output = output;
        this.inputs = inputs;

        System.out.println("RECIPE: " + inputs);
        System.out.println(output);
    }

    @Override
    public boolean matches(IInventory inv, World worldIn)
    {
        return ModRecipes.matches(inputs, inv);
    }

    @Override
    public ItemStack getCraftingResult(IInventory inv)
    {
        return output;
    }

    @Override
    public ItemStack getRecipeOutput()
    {
        return output.copy();
    }

    public ItemStack getIcon() {
        return new ItemStack(ModBlocks.SAWMILL.get());
    }

    @Override
    public ResourceLocation getId()
    {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer()
    {
        return ModRecipeTypes.SAWMILL_SERIALIZIER.get();
    }

    public static class SawmillRecipeType implements IRecipeType<SawmillRecipe>
    {
        @Override
        public String toString() {
            return SawmillRecipe.TYPE_ID.toString();
        }
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
            implements IRecipeSerializer<SawmillRecipe> {

        @Override
        public SawmillRecipe read(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "output"));
            JsonArray ingredients = JSONUtils.getJsonArray(json, "ingredients");
            List<Ingredient> inputs = new ArrayList<>();

            for (JsonElement jsonElement : ingredients) {
                inputs.add(Ingredient.deserialize(jsonElement));
            }

            return new SawmillRecipe(recipeId, output, inputs.get(0));
        }

        @Nullable
        @Override
        public SawmillRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            Ingredient[] inputs = new Ingredient[buffer.readInt()];

            for (int i = 0; i < inputs.length; i++) {
                inputs[i] = Ingredient.read(buffer);
            }

            ItemStack output = buffer.readItemStack();

            return new SawmillRecipe(recipeId, output, inputs[0]);
        }

        @Override
        public void write(PacketBuffer buffer, SawmillRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buffer);
            }
            buffer.writeItemStack(recipe.getRecipeOutput(), false);
        }
    }
}
