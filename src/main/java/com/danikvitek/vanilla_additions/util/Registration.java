package com.danikvitek.vanilla_additions.util;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.data.recipes.ModRecipeTypes;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.stats.StatType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, VanillaAdditionsMod.MOD_ID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VanillaAdditionsMod.MOD_ID);

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, VanillaAdditionsMod.MOD_ID);

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, VanillaAdditionsMod.MOD_ID);

    public static final DeferredRegister<ContainerType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, VanillaAdditionsMod.MOD_ID);

    public static final DeferredRegister<StatType<?>> STAT_TYPES =
            DeferredRegister.create(ForgeRegistries.STAT_TYPES, VanillaAdditionsMod.MOD_ID);

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER
            = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, VanillaAdditionsMod.MOD_ID);

    public static void init(){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        FLUIDS.register(eventBus);
        TILE_ENTITY_TYPES.register(eventBus);
        CONTAINERS.register(eventBus);
        STAT_TYPES.register(eventBus);
        RECIPE_SERIALIZER.register(eventBus);
        ModRecipeTypes.registerRecipes();
    }
}
