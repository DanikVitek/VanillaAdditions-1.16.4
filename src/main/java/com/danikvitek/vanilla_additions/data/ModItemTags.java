package com.danikvitek.vanilla_additions.data;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import net.minecraft.item.Item;
import net.minecraft.tags.*;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class ModItemTags {
    protected static final TagRegistry<Item> collection = TagRegistryManager.create(new ResourceLocation(VanillaAdditionsMod.MOD_ID,"item"), ITagCollectionSupplier::getItemTags);
    public static final ITag.INamedTag<Item> BAOBAB_LOGS = makeWrapperTag("baobab_logs");
    public static final ITag.INamedTag<Item> BLACKSTONE_TOOLS = makeWrapperTag("blackstone_tools");
//    public static final ITag.INamedTag<Item> FENCE_GATES = makeWrapperTag("fence_gates");


    public static ITag.INamedTag<Item> makeWrapperTag(String id) {
        return collection.createTag(id);
    }

    public static net.minecraftforge.common.Tags.IOptionalNamedTag<Item> createOptional(ResourceLocation name) {
        return createOptional(name, null);
    }

    public static net.minecraftforge.common.Tags.IOptionalNamedTag<Item> createOptional(ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<Item>> defaults) {
        return collection.createOptional(name, defaults);
    }

    public static ITagCollection<Item> getCollection() {
        return collection.getCollection();
    }

    public static List<? extends ITag.INamedTag<Item>> getAllTags() {
        return collection.getTags();
    }
}
