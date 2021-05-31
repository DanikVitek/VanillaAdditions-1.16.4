package com.danikvitek.vanilla_additions.fluid;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;

public class ModFluids
{
    public static final ResourceLocation MILK_STILL_RL = new ResourceLocation(VanillaAdditionsMod.MOD_ID,
            "fluid/milk_still"
    );
    public static final ResourceLocation MILK_FLOWING_RL = new ResourceLocation(VanillaAdditionsMod.MOD_ID,
            "fluid/milk_flowing"
    );
    public static final ResourceLocation MILK_OVERLAY_RL = new ResourceLocation(VanillaAdditionsMod.MOD_ID,
            "fluid/milk_overlay"
    );

    public static final RegistryObject<FlowingFluid> MILK_FLUID =
            Registration.FLUIDS.register(
                    "milk_fluid",
                    () -> new ForgeFlowingFluid.Source(ModFluids.MILK_PROPERTIES)
            );
    public static final RegistryObject<FlowingFluid> MILK_FLOWING =
            Registration.FLUIDS.register(
                    "milk_flowing",
                    () -> new ForgeFlowingFluid.Flowing(ModFluids.MILK_PROPERTIES)
            );
    public static final ForgeFlowingFluid.Properties MILK_PROPERTIES = new ForgeFlowingFluid.Properties(
            MILK_FLUID,    // () -> MILK_FLUID.get(),
            MILK_FLOWING,  // () -> MILK_FLOWING.get(),
            FluidAttributes.builder(MILK_STILL_RL, MILK_FLOWING_RL)
                    .density(15)
                    .luminosity(2)
                    .rarity(Rarity.COMMON)
                    .sound(SoundEvents.BLOCK_WATER_AMBIENT)
                    .overlay(MILK_OVERLAY_RL)
                    .viscosity(5)
    )
            .slopeFindDistance(3)
            .explosionResistance(100f)
            .block(ModFluids.MILK_BLOCK)
            .bucket(() -> Items.MILK_BUCKET);

    public static final RegistryObject<FlowingFluidBlock> MILK_BLOCK = Registration.BLOCKS.register(
            "milk",
            () -> new MilkBlock(
                    ModFluids.MILK_FLUID,
                    AbstractBlock.Properties
                            .create(Material.WATER)
                            .doesNotBlockMovement()
                            .hardnessAndResistance(100f)
                            .noDrops()
            )
    );


    public static void register() { }
}
