package com.danikvitek.vanilla_additions.screens;

import net.minecraft.client.gui.screen.inventory.StonecutterScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.StonecutterContainer;
import net.minecraft.util.text.ITextComponent;

public class SawmillScreen extends StonecutterScreen {
    public SawmillScreen(StonecutterContainer containerIn, PlayerInventory playerInv, ITextComponent titleIn) {
        super(containerIn, playerInv, titleIn);
    }
}
