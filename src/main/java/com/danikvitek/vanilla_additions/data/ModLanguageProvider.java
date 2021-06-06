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
                add(ModItems.BLACKSTONE_HOE.get(), "Чорнокам'яна сокира");
                add(ModItems.BLACKSTONE_SHOVEL.get(), "Чорнокам'яна лопата");
                add(ModItems.BLACKSTONE_SWORD.get(), "Чорнокам'яний меч");

                add("advancements.story.blackstone_tool.title", "Яскраво чорний!");
                add("advancements.story.blackstone_tool.description", "Здобудьте чорнокам'яний інструмент");
                add("advancements.story.blackstone_combat.title", "Борися зі стилем!");
                add("advancements.story.blackstone_combat.description", "Здобудьте чорнокам'яний меч");
                add("advancements.story.blackstone_cooking.title", "Красива кухня");
                add("advancements.story.blackstone_cooking.description", "Змайструй за розташуй Чорнокам'яну піч");

                add("container.vanilla_additions.blackstone_furnace", "Чорнокам'яна піч");
                add("screen.vanilla_additions.blackstone_furnace", "Чорнокам'яна піч");

                add("itemGroup.vanilla_additions_tab", "Ванильні доповнення");
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
                add(ModItems.BLACKSTONE_SWORD.get(), "Мечь из чернита");

                add("advancements.story.blackstone_tool.title", "Ярко чёрный!");
                add("advancements.story.blackstone_tool.description", "Получите инструмент из чернита");
                add("advancements.story.blackstone_combat.title", "Сражайся со стилем!");
                add("advancements.story.blackstone_combat.description", "Получите Мечь из чернита");
                add("advancements.story.blackstone_cooking.title", "Красивая кухня");
                add("advancements.story.blackstone_cooking.description", "Создай и размести Печь из чернита");

                add("container.vanilla_additions.blackstone_furnace", "Печь из чернита");
                add("screen.vanilla_additions.blackstone_furnace", "Печь из чернита");

                add("itemGroup.vanilla_additions_tab", "Ванильные дополнения");
                break;
            default:
                break;
        }
    }
}
