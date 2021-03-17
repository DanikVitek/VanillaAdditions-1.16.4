package com.danikvitek.vanilla_additions.tileentity;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.IIntArray;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class BlackstoneFurnaceTileEntity extends AbstractFurnaceTileEntity
{
    public BlackstoneFurnaceTileEntity() {
        super(ModTileEntities.BLACKSTONE_FURNACE_TILE_ENTITY.get(), IRecipeType.SMELTING);
    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.vanilla_additions.blackstone_furnace");
    }

    protected Container createMenu(int id, PlayerInventory player) {
        return new FurnaceContainer(id, player, this, this.furnaceData);
    }

    public IIntArray getData() {
        return this.furnaceData;
    }
}
