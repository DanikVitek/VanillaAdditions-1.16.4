package com.danikvitek.vanilla_additions.block;


import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.trees.BaobabTree;
import com.danikvitek.vanilla_additions.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.MinecraftGame;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> BLACKSTONE_FURNACE = register(
            "blackstone_furnace",
            BlackstoneFurnace::new,
            VanillaAdditionsMod.VANILLA_ADDITIONS_TAB
    );
    public static final RegistryObject<Block> GLASS_STAIRS = register(
            "glass_stairs",
            () -> new StairsBlock(Blocks.GLASS::getDefaultState, AbstractBlock.Properties
                    .create(Material.GLASS)
                    .sound(SoundType.GLASS)
                    .hardnessAndResistance(.3f)
                    .notSolid()
            ),
            VanillaAdditionsMod.VANILLA_ADDITIONS_TAB
    );
    public static final RegistryObject<Block> GLASS_SLAB = register(
            "glass_slab",
            () -> new SlabBlock(AbstractBlock.Properties
                    .create(Material.GLASS)
                    .sound(SoundType.GLASS)
                    .hardnessAndResistance(.3f)
                    .notSolid()
            ),
            VanillaAdditionsMod.VANILLA_ADDITIONS_TAB
    );
    public static final RegistryObject<Block> SAWMILL = register(
            "sawmill",
            () -> new Sawmill(AbstractBlock.Properties
                    .create(Material.ROCK)
                    .harvestTool(ToolType.PICKAXE)
                    .sound(SoundType.STONE)
                    .setRequiresTool()
                    .hardnessAndResistance(3.5f)
            ),
            VanillaAdditionsMod.VANILLA_ADDITIONS_TAB
    );

    public static final RegistryObject<Block> BAOBAB_PLANKS = register(
            "baobab_planks",
            () -> new Block(AbstractBlock.Properties
                    .from(Blocks.OAK_PLANKS)
                    .hardnessAndResistance(.5f)
                    .harvestLevel(Blocks.DIRT.getHarvestLevel(Blocks.DIRT.getDefaultState()))
            ),
            VanillaAdditionsMod.VANILLA_ADDITIONS_TAB
    );
    public static final RegistryObject<Block> BAOBAB_LOG = register(
            "baobab_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties
                    .from(Blocks.OAK_LOG)
            ),
            VanillaAdditionsMod.VANILLA_ADDITIONS_TAB
    );
    public static final RegistryObject<Block> BAOBAB_WOOD = register(
            "baobab_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties
                    .from(Blocks.OAK_WOOD)
            ),
            VanillaAdditionsMod.VANILLA_ADDITIONS_TAB
    );
    public static final RegistryObject<Block> STRIPPED_BAOBAB_LOG = register(
            "stripped_baobab_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties
                    .from(Blocks.STRIPPED_OAK_LOG)
                    .hardnessAndResistance(.5f)
                    .harvestLevel(Blocks.DIRT.getHarvestLevel(Blocks.DIRT.getDefaultState()))
            ),
            VanillaAdditionsMod.VANILLA_ADDITIONS_TAB
    );
    public static final RegistryObject<Block> STRIPPED_BAOBAB_WOOD = register(
            "stripped_baobab_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties
                    .from(ModBlocks.STRIPPED_BAOBAB_LOG.get())
            ),
            VanillaAdditionsMod.VANILLA_ADDITIONS_TAB
    );
    public static final RegistryObject<Block> BAOBAB_LEAVES = register(
            "baobab_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties
                    .from(Blocks.OAK_LEAVES)
            ),
            VanillaAdditionsMod.VANILLA_ADDITIONS_TAB
    );
    public static final RegistryObject<Block> BAOBAB_SAPLING = register(
            "baobab_sapling",
            () -> new BaobabSapling(
                    BaobabTree::new,
                    AbstractBlock.Properties.from(Blocks.OAK_SAPLING)
            ),
            VanillaAdditionsMod.VANILLA_ADDITIONS_TAB
    );

    public static void register() {}

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block, ItemGroup itemGroup){
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(
                name,
                () -> new BlockItem(
                    toReturn.get(),
                    new Item.Properties().group(itemGroup)
                )
        );
        return toReturn;
    }
}
