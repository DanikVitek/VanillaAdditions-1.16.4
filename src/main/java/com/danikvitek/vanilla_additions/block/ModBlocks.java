package com.danikvitek.vanilla_additions.block;


import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> COPPER_BLOCK = register(
            "copper_block",
            () -> new CopperBlock(AbstractBlock.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(3f, 6f)
                    .sound(SoundType.METAL)
                    .harvestLevel(2)
                    .setRequiresTool()
                    .harvestTool(ToolType.PICKAXE)
            ),
            VanillaAdditionsMod.COURSE_TAB
    );
    public static final RegistryObject<Block> COPPER_ORE = register(
            "copper_ore",
            () -> new CopperOre(AbstractBlock.Properties
                    .create(Material.ROCK)
                    .hardnessAndResistance(3f)
                    .sound(SoundType.STONE)
                    .harvestLevel(2)
                    .setRequiresTool()
                    .harvestTool(ToolType.PICKAXE)
            ),
            VanillaAdditionsMod.COURSE_TAB
    );
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
