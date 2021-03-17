package com.danikvitek.vanilla_additions.tileentity;

import com.danikvitek.vanilla_additions.util.Config;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class MilkBlockTileEntity extends TileEntity implements ITickableTileEntity {
    private static int ticks = 0;
    public static final int MAX_TICKS_COUNTER =
            Config.TICKS_PER_MILK_EFFECTS_REDUCE.get() + Config.TICKS_PER_MILK_HEAL.get();

    public MilkBlockTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public MilkBlockTileEntity() {
        this(ModTileEntities.MILK_TILE_ENTITY.get());
    }

    @Override
    public void tick() {
        if (MAX_TICKS_COUNTER > 0)
            ticks = (++ticks)%MAX_TICKS_COUNTER;
    }

    public static int getTicks() {
        return ticks;
    }
}
