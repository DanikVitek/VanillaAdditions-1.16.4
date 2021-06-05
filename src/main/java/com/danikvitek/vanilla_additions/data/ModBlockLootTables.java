package com.danikvitek.vanilla_additions.data;

import com.danikvitek.vanilla_additions.block.ModBlocks;
import com.danikvitek.vanilla_additions.util.Registration;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.state.properties.SlabType;
import net.minecraftforge.fml.RegistryObject;

public class ModBlockLootTables extends BlockLootTables {
    private static final ILootCondition.IBuilder SILK_TOUCH = MatchTool.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))));

    @Override
    protected void addTables() {
        this.registerDropSelfLootTable(ModBlocks.BAOBAB_WOOD.get());
        this.registerDropSelfLootTable(ModBlocks.BAOBAB_PLANKS.get());
        this.registerDropSelfLootTable(ModBlocks.BAOBAB_LOG.get());
        this.registerDropSelfLootTable(ModBlocks.BAOBAB_SAPLING.get());
        this.registerDropSelfLootTable(ModBlocks.BLACKSTONE_FURNACE.get());
        this.registerDropSelfLootTable(ModBlocks.SAWMILL.get());
        this.registerDropSelfLootTable(ModBlocks.STRIPPED_BAOBAB_WOOD.get());
        this.registerDropSelfLootTable(ModBlocks.STRIPPED_BAOBAB_LOG.get());

        this.registerLootTable(ModBlocks.GLASS_STAIRS.get(),
                (block) -> droppingWithSilkTouch(ModBlocks.GLASS_STAIRS.get(), Blocks.AIR));

        this.registerLootTable(ModBlocks.BAOBAB_LEAVES.get(), (block) ->
                droppingWithChancesAndSticks(ModBlocks.BAOBAB_LEAVES.get(), ModBlocks.BAOBAB_SAPLING.get(),
                        0.05f, .0625f, .083333336f, .1f));

        this.registerLootTable(ModBlocks.GLASS_SLAB.get(), (slab) ->
                LootTable.builder().addLootPool(LootPool.builder().acceptCondition(SILK_TOUCH).rolls(ConstantRange.of(1)).addEntry(withExplosionDecay(slab, ItemLootEntry.builder(slab).acceptFunction(SetCount.builder(ConstantRange.of(2)).acceptCondition(BlockStateProperty.builder(slab).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withProp(SlabBlock.TYPE, SlabType.DOUBLE))))))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
