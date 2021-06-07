package com.danikvitek.vanilla_additions.network;

import com.danikvitek.vanilla_additions.tileentity.SawmillTileEntity;
import com.danikvitek.vanilla_additions.util.setup.ClientProxy;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class ItemMessage {

    public ItemStack item;
    public BlockPos pos;
    public int index;

    //Read msg from buf
    public ItemMessage(PacketBuffer buf) {
        item = buf.readItemStack();
        pos = buf.readBlockPos();
        index = buf.readInt();

    }

    //constructor
    public ItemMessage(ItemStack item, BlockPos pos, int index) {
        this.item = item;
        this.pos = pos;
        this.index = index;
    }

    //Save msg to buf
    public void toBytes(PacketBuffer buf) {
        buf.writeItemStack(item);
        buf.writeBlockPos(pos);
        buf.writeInt(index);
    }

    //handle package data
    public void handle(Supplier<NetworkEvent.Context> ctx) {

        World world = new ClientProxy().getClientWorld();

        ctx.get().enqueueWork(() -> {
            //Set the items for the client !!! be careful to give it the right location

            if (world.getTileEntity(pos) instanceof SawmillTileEntity) {
                SawmillTileEntity tile = (SawmillTileEntity) world.getTileEntity(pos);
                tile.setItem(index, item);
            }

        });
        ctx.get().setPacketHandled(true);
    }
}