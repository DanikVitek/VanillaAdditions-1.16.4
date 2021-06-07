package com.danikvitek.vanilla_additions.data;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.item.ModItems;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, VanillaAdditionsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        this.copy(ModBlockTags.BAOBAB_LOGS, ModItemTags.BAOBAB_LOGS);
        getOrCreateBuilder(ItemTags.LOGS_THAT_BURN).addTag(ModItemTags.BAOBAB_LOGS);
        getOrCreateBuilder(ModItemTags.BLACKSTONE_TOOLS).add(
                ModItems.BLACKSTONE_PICKAXE.get(),
                ModItems.BLACKSTONE_AXE.get(),
                ModItems.BLACKSTONE_SHOVEL.get(),
                ModItems.BLACKSTONE_HOE.get()
        );
        this.copy(BlockTags.FENCE_GATES, ModItemTags.FENCE_GATES);

        super.registerTags();
    }
}
