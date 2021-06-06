package com.danikvitek.vanilla_additions.data;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.block.ModBlocks;
import com.danikvitek.vanilla_additions.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.PlacedBlockTrigger;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.function.Consumer;

public class ModStoryAdvancements implements Consumer<Consumer<FinishedAdvancement>> {

    @Override
    public void accept(Consumer<FinishedAdvancement> consumer) {
        FinishedAdvancement.Builder.builder()
                .advancement(Advancement.Builder.builder()
                .withParentId(new ResourceLocation("story/iron_tools"))
                .withDisplay(ModItems.BLACKSTONE_PICKAXE.get(),
                        new TranslationTextComponent("advancements.story.blackstone_tool.title"),
                        new TranslationTextComponent("advancements.story.blackstone_tool.description"),
                        null, FrameType.TASK, true, true, false)
                .withCriterion("blackstone_pickaxe",
                        InventoryChangeTrigger.Instance.forItems(
                                ItemPredicate.Builder.create().tag(ModItemTags.BLACKSTONE_TOOLS).build()
                        )))
                .build(consumer, new ResourceLocation(VanillaAdditionsMod.MOD_ID, "story/blackstone_tool"));

        FinishedAdvancement.Builder.builder()
                .advancement(Advancement.Builder.builder()
                        .withParentId(new ResourceLocation("story/iron_tools"))
                        .withDisplay(ModItems.BLACKSTONE_SWORD.get(),
                                new TranslationTextComponent("advancements.story.blackstone_combat.title"),
                                new TranslationTextComponent("advancements.story.blackstone_combat.description"),
                                null, FrameType.TASK, true, true, false)
                        .withCriterion("blackstone_sword",
                                InventoryChangeTrigger.Instance.forItems(ModItems.BLACKSTONE_SWORD.get())))
                .build(consumer, new ResourceLocation(VanillaAdditionsMod.MOD_ID, "story/blackstone_combat"));

        FinishedAdvancement.Builder.builder()
                .advancement(Advancement.Builder.builder()
                        .withParentId(new ResourceLocation("story/iron_tools"))
                        .withDisplay(ModBlocks.BLACKSTONE_FURNACE.get(),
                                new TranslationTextComponent("advancements.story.blackstone_cooking.title"),
                                new TranslationTextComponent("advancements.story.blackstone_cooking.description"),
                                null, FrameType.TASK, true, true, false)
                        .withCriterion("blackstone_furnace_get",
                                InventoryChangeTrigger.Instance.forItems(ModBlocks.BLACKSTONE_FURNACE.get()))
                        .withCriterion("blackstone_furnace_placed",
                                PlacedBlockTrigger.Instance.placedBlock(ModBlocks.BLACKSTONE_FURNACE.get())))
                .build(consumer, new ResourceLocation(VanillaAdditionsMod.MOD_ID, "story/blackstone_cooking"));
    }
}
