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

                add("itemGroup.vanillaAdditions_tab", "Vanilla Additions");

                add("container.vanilla_additions.blackstone_furnace", "Blackstone Furnace");
                add("screen.vanilla_additions.blackstone_furnace", "Blackstone Furnace");
                break;
            case "uk_ua":
                add(ModBlocks.BLACKSTONE_FURNACE.get(), "Чорнокам'яна піч");
                add(ModBlocks.GLASS_STAIRS.get(), "Скляні сходи");
                add(ModBlocks.GLASS_SLAB.get(), "Скляна плита");
                add(ModBlocks.SAWMILL.get(), "Лісопилка");
                add(ModBlocks.BAOBAB_LOG.get(), "Баобабова колода");
                add(ModBlocks.BAOBAB_WOOD.get(), "Баобабова деревина");
                add(ModBlocks.STRIPPED_BAOBAB_LOG.get(), "Обтёсана баобабова колода");
                add(ModBlocks.STRIPPED_BAOBAB_WOOD.get(), "Обтёсана баобабова деревина");
                add(ModBlocks.BAOBAB_PLANKS.get(), "Баобабові дошки");
                add(ModBlocks.BAOBAB_LEAVES.get(), "Баобабове листя");
                add(ModBlocks.BAOBAB_SAPLING.get(), "Саджанець баобабу");

                add(ModItems.BLACKSTONE_PICKAXE.get(), "Чорнокам'яне кайло");
                add(ModItems.BLACKSTONE_AXE.get(), "Чорнокам'яна сокира");
                add(ModItems.BLACKSTONE_HOE.get(), "Чорнокам'яна мотика");
                add(ModItems.BLACKSTONE_SHOVEL.get(), "Чорнокам'яна лопата");
                add(ModItems.BLACKSTONE_SWORD.get(), "Чорнокам'яний меч");

                add("itemGroup.vanillaAdditions_tab", "Ванильні доповнення");

                add("container.vanilla_additions.blackstone_furnace", "Чорнокам'яна піч");
                add("screen.vanilla_additions.blackstone_furnace", "Чорнокам'яна піч");
                break;
            case "ru_ru":
                add(ModBlocks.BLACKSTONE_FURNACE.get(), "Печь из чернита");
                add(ModBlocks.GLASS_STAIRS.get(), "Стеклянные ступеньки");
                add(ModBlocks.GLASS_SLAB.get(), "Стеклянная плита");
                add(ModBlocks.SAWMILL.get(), "Лесопилка");
                add(ModBlocks.BAOBAB_LOG.get(), "Бревно баобаба");
                add(ModBlocks.BAOBAB_WOOD.get(), "Древесина баобаба");
                add(ModBlocks.STRIPPED_BAOBAB_LOG.get(), "Обтёсанное бревно баобаба");
                add(ModBlocks.STRIPPED_BAOBAB_WOOD.get(), "Обтёсанная древесина баобаба");
                add(ModBlocks.BAOBAB_PLANKS.get(), "Доски из баобаба");
                add(ModBlocks.BAOBAB_LEAVES.get(), "Листва баобаба");
                add(ModBlocks.BAOBAB_SAPLING.get(), "Саженец баобаба");

                add(ModItems.BLACKSTONE_PICKAXE.get(), "Кирка из чернита");
                add(ModItems.BLACKSTONE_AXE.get(), "Топор из чернита");
                add(ModItems.BLACKSTONE_HOE.get(), "Мотыга из чернита");
                add(ModItems.BLACKSTONE_SHOVEL.get(), "Лопата из чернита");
                add(ModItems.BLACKSTONE_SWORD.get(), "Меч из чернита");

                add("itemGroup.vanillaAdditions_tab", "Ванильные дополнения");

                add("container.vanilla_additions.blackstone_furnace", "Печь из чернита");
                add("screen.vanilla_additions.blackstone_furnace", "Печь из чернита");
                break;
            default:
                break;
        }
    }
}
