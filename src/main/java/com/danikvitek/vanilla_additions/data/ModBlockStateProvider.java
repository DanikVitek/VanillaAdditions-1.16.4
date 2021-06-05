package com.danikvitek.vanilla_additions.data;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.block.ModBlocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {


    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, VanillaAdditionsMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.BAOBAB_LEAVES.get());
        simpleBlock(ModBlocks.BAOBAB_PLANKS.get());
        logBlock((RotatedPillarBlock) ModBlocks.BAOBAB_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_BAOBAB_LOG.get());

    }
}
