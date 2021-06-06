package com.danikvitek.vanilla_additions.data;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import net.minecraft.block.Block;
import net.minecraft.tags.*;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public final class ModBlockTags {
    protected static final TagRegistry<Block> collection = TagRegistryManager.create(new ResourceLocation(VanillaAdditionsMod.MOD_ID,"block"), ITagCollectionSupplier::getBlockTags);
    public static final ITag.INamedTag<Block> BAOBAB_LOGS = makeWrapperTag("baobab_logs");


    public static ITag.INamedTag<Block> makeWrapperTag(String id) {
        return collection.createTag(id);
    }

    public static net.minecraftforge.common.Tags.IOptionalNamedTag<Block> createOptional(ResourceLocation name) {
        return createOptional(name, null);
    }

    public static net.minecraftforge.common.Tags.IOptionalNamedTag<Block> createOptional(ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<Block>> defaults) {
        return collection.createOptional(name, defaults);
    }

    public static ITagCollection<Block> getCollection() {
        return collection.getCollection();
    }

    public static List<? extends ITag.INamedTag<Block>> getAllTags() {
        return collection.getTags();
    }
}
