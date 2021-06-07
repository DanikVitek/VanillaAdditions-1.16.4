package com.danikvitek.vanilla_additions.data.recipes;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import java.util.LinkedList;
import java.util.List;

public class ModRecipes {
    //Inefficient item match method, but better than nothing!
    public static boolean matches(Ingredient ingredient, IInventory inv) {
        //Copy the inventory in a separate place just so that I can remove stuff from it
        List<ItemStack> stacks = new LinkedList<>();
        for (int j = 0; j < inv.getSizeInventory(); j++) {
            stacks.add(inv.getStackInSlot(j));
        }

        List<Ingredient> copy = new LinkedList<>();
        copy.add(ingredient);
        for (ItemStack stack : stacks) {
            if (!stack.isEmpty() && ingredient.test(stack)) {
                copy.remove(ingredient);
                stacks.remove(stack);
                break;
            }
        }
        return copy.isEmpty();
    }
}
