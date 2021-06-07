package com.danikvitek.vanilla_additions.data;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.block.ModBlocks;
import com.danikvitek.vanilla_additions.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(DataGenerator gen, String locale) {
        super(gen, VanillaAdditionsMod.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        String locale = this.getName().replace("Languages: ", "");
        switch (locale){
            case "en_us":
                add(ModBlocks.BLACKSTONE_FURNACE.get(), "Blackstone Furnace");
                add(ModBlocks.GLASS_STAIRS.get(), "Glass Stairs");
                add(ModBlocks.GLASS_SLAB.get(), "Glass SLab");
                add(ModBlocks.SAWMILL.get(), "Sawmill");
                add(ModBlocks.BAOBAB_LOG.get(), "Baobab Log");
                add(ModBlocks.BAOBAB_WOOD.get(), "Baobab Wood");
                add(ModBlocks.STRIPPED_BAOBAB_LOG.get(), "Stripped Baobab Log");
                add(ModBlocks.STRIPPED_BAOBAB_WOOD.get(), "Stripped Baobab Wood");
                add(ModBlocks.BAOBAB_PLANKS.get(), "Baobab Planks");
                add(ModBlocks.BAOBAB_LEAVES.get(), "Baobab Leaves");
                add(ModBlocks.BAOBAB_SAPLING.get(), "Baobab Sapling");

                add(ModItems.BLACKSTONE_PICKAXE.get(), "Blackstone Pickaxe");
                add(ModItems.BLACKSTONE_AXE.get(), "Blackstone Axe");
                add(ModItems.BLACKSTONE_HOE.get(), "Blackstone Hoe");
                add(ModItems.BLACKSTONE_SHOVEL.get(), "Blackstone Shovel");
                add(ModItems.BLACKSTONE_SWORD.get(), "Blackstone Sword");

                add("advancements.story.blackstone_tool.title", "Pretty Black!");
                add("advancements.story.blackstone_tool.description", "Acquire Blackstone Tool");
                add("advancements.story.blackstone_combat.title", "Fight with style!");
                add("advancements.story.blackstone_combat.description", "Acquire Blackstone Sword");
                add("advancements.story.blackstone_cooking.title", "Stylish Furniture");
                add("advancements.story.blackstone_cooking.description", "Craft and place the Blackstone Furnace");

                add("container.vanilla_additions.blackstone_furnace", "Blackstone Furnace");
                add("screen.vanilla_additions.blackstone_furnace", "Blackstone Furnace");

                add("itemGroup.vanilla_additions_tab", "Vanilla Additions");
                break;
            default:
                break;
        }
    }
}
