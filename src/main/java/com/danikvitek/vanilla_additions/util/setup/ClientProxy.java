package com.danikvitek.vanilla_additions.util.setup;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.block.ModBlocks;
import com.danikvitek.vanilla_additions.container.ModContainers;
import com.danikvitek.vanilla_additions.screens.BlackstoneFurnaceScreen;
import com.danikvitek.vanilla_additions.screens.SawmillScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VanillaAdditionsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy implements IProxy{
    @Override
    public void init() {
        RenderTypeLookup.setRenderLayer(ModBlocks.GLASS_STAIRS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GLASS_SLAB.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BAOBAB_SAPLING.get(), RenderType.getCutout());

        ScreenManager.registerFactory(ModContainers.BLACKSTONE_FURNACE_CONTAINER.get(), BlackstoneFurnaceScreen::new);
        ScreenManager.registerFactory(ModContainers.SAWMILL_CONTAINER.get(), SawmillScreen::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
