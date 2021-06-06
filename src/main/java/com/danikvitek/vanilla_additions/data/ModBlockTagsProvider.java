package com.danikvitek.vanilla_additions.data;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.block.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {


        super(generatorIn, VanillaAdditionsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        getOrCreateBuilder(BlockTags.PLANKS).add(ModBlocks.BAOBAB_PLANKS.get());
        getOrCreateBuilder(BlockTags.SAPLINGS).add(ModBlocks.BAOBAB_SAPLING.get());
        getOrCreateBuilder(ModBlockTags.BAOBAB_LOGS).add(
                ModBlocks.BAOBAB_LOG.get(),
                ModBlocks.BAOBAB_WOOD.get(),
                ModBlocks.STRIPPED_BAOBAB_LOG.get(),
                ModBlocks.STRIPPED_BAOBAB_WOOD.get());
        getOrCreateBuilder(BlockTags.LOGS_THAT_BURN).addTag(ModBlockTags.BAOBAB_LOGS);

        super.registerTags();
    }
}
