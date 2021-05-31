package com.danikvitek.vanilla_additions.trees;

import com.danikvitek.vanilla_additions.block.ModBlocks;
import net.minecraft.block.trees.BigTree;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.DarkOakFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.DarkOakTrunkPlacer;

import javax.annotation.Nullable;
import java.util.OptionalInt;
import java.util.Random;

public class BaobabTree extends BigTree {
    private static final int BASE_HEIGHT = 6;
    private static final int FIRST_RANDOM_HEIGHT = 2;
    private static final int SECOND_RANDOM_HEIGHT = 1;

    public static final BaseTreeFeatureConfig BAOBAB_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlocks.BAOBAB_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(ModBlocks.BAOBAB_LEAVES.get().getDefaultState()),
            new DarkOakFoliagePlacer(
                    FeatureSpread.func_242252_a(0),
                    FeatureSpread.func_242252_a(0)),
            new DarkOakTrunkPlacer(BASE_HEIGHT, FIRST_RANDOM_HEIGHT, SECOND_RANDOM_HEIGHT),
            new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty())
    )).build();

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        return null;
    }

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getHugeTreeFeature(Random rand) {
        return Feature.TREE.withConfiguration(BAOBAB_TREE_CONFIG);
    }
}
