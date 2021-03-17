package com.danikvitek.vanilla_additions.screens;

import net.minecraft.client.gui.screen.inventory.FurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.util.text.ITextComponent;

public class BlackstoneFurnaceScreen extends FurnaceScreen {
    public BlackstoneFurnaceScreen(FurnaceContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, playerInventory, title);
    }
}
