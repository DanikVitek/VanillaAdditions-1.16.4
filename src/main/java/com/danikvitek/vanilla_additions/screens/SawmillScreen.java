package com.danikvitek.vanilla_additions.screens;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.container.SawmillContainer;
import com.danikvitek.vanilla_additions.data.recipes.SawmillRecipe;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import java.util.List;

public class SawmillScreen extends ContainerScreen<SawmillContainer> {
    private final ResourceLocation GUI = new ResourceLocation(VanillaAdditionsMod.MOD_ID,
            "textures/gui/container/sawmill.png");
    private float sliderProgress;
    private int recipeIndexOffset;
    private boolean hasItemsInInputSlot;

    public SawmillScreen(SawmillContainer container, PlayerInventory inv, ITextComponent name){
        super(container, inv, name);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        this.renderBackground(matrixStack);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);
        int k = (int)(41.0F * this.sliderProgress);
        this.blit(matrixStack, i + 119, j + 15 + k, 176 + (this.canScroll() ? 0 : 12), 0, 12, 15);
        int l = this.guiLeft + 52;
        int i1 = this.guiTop + 14;
        int j1 = this.recipeIndexOffset + 12;
        this.func_238853_b_(matrixStack, x, y, l, i1, j1);
        this.drawRecipesItems(l, i1, j1);
    }

    private boolean canScroll() {
        return this.hasItemsInInputSlot && this.container.getRecipeListSize() > 12;
    }

    private void func_238853_b_(MatrixStack matrixStack, int x, int y, int p_238853_4_, int p_238853_5_, int p_238853_6_) {
        for(int i = this.recipeIndexOffset; i < p_238853_6_ && i < this.container.getRecipeListSize(); ++i) {
            int j = i - this.recipeIndexOffset;
            int k = p_238853_4_ + j % 4 * 16;
            int l = j / 4;
            int i1 = p_238853_5_ + l * 18 + 2;
            int j1 = this.ySize;
            if (i == this.container.getSelectedRecipe()) {
                j1 += 18;
            } else if (x >= k && y >= i1 && x < k + 16 && y < i1 + 18) {
                j1 += 36;
            }

            this.blit(matrixStack, k, i1 - 1, 0, j1, 16, 18);
        }
    }

    private void drawRecipesItems(int left, int top, int recipeIndexOffsetMax) {
        List<SawmillRecipe> list = this.container.getRecipeList();

        for(int i = this.recipeIndexOffset; i < recipeIndexOffsetMax && i < this.container.getRecipeListSize(); ++i) {
            int j = i - this.recipeIndexOffset;
            int k = left + j % 4 * 16;
            int l = j / 4;
            int i1 = top + l * 18 + 2;
            assert this.minecraft != null;
            this.minecraft.getItemRenderer().renderItemAndEffectIntoGUI(list.get(i).getRecipeOutput(), k, i1);
        }
    }
}
