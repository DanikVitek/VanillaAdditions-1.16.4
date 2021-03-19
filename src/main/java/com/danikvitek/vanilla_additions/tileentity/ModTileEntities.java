package com.danikvitek.vanilla_additions.tileentity;

import com.danikvitek.vanilla_additions.block.ModBlocks;
import com.danikvitek.vanilla_additions.fluid.ModFluids;
import com.danikvitek.vanilla_additions.util.Registration;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntities
{
    public static final RegistryObject<TileEntityType<BlackstoneFurnaceTileEntity>> BLACKSTONE_FURNACE_TILE_ENTITY
            = Registration.TILE_ENTITY_TYPES.register(
            "blackstone_furnace_tile_entity",
            () -> TileEntityType.Builder.create(
                    BlackstoneFurnaceTileEntity::new,
                    ModBlocks.BLACKSTONE_FURNACE.get()
            ).build(null)
    );
    public static final RegistryObject<TileEntityType<MilkBlockTileEntity>> MILK_TILE_ENTITY
            = Registration.TILE_ENTITY_TYPES.register(
            "milk_tile_entity",
            () -> TileEntityType.Builder.create(
                    MilkBlockTileEntity::new,
                    ModFluids.MILK_BLOCK.get()
            ).build(null)
    );
    public static final RegistryObject<TileEntityType<SawmillTileEntity>> SAWMILL_TILE_ENTITY
            = Registration.TILE_ENTITY_TYPES.register(
                    "sawmill_tile_entity",
            () -> TileEntityType.Builder.create(
                    SawmillTileEntity::new,
                    ModBlocks.SAWMILL.get()
            ).build(null)
    );


    public static void register() { }
}
