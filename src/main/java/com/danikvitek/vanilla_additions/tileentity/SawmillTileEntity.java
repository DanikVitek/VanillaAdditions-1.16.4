package com.danikvitek.vanilla_additions.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class SawmillTileEntity extends TileEntity {


    public SawmillTileEntity(TileEntityType<?> tileEntityTypeIn) { super(tileEntityTypeIn); }
    public SawmillTileEntity() { this(ModTileEntities.SAWMILL_TILE_ENTITY.get()); }


}
