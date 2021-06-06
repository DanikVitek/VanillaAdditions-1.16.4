package com.danikvitek.vanilla_additions.data.recipes;

import com.danikvitek.vanilla_additions.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.SingleItemRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SawmillRecipe extends SingleItemRecipe {

    public static final ResourceLocation TYPE_ID = ;

    public SawmillRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result) {
        super(id, group, ingredient, result);
    }

    public boolean matches(IInventory inv, World worldIn) {
        return this.ingredient.test(inv.getStackInSlot(0));
    }

    public ItemStack getIcon() {
        return new ItemStack(ModBlocks.SAWMILL.get());
    }
}
