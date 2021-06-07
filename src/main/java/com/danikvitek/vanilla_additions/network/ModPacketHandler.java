package com.danikvitek.vanilla_additions.network;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class ModPacketHandler {

    private static final String PROTOCOL_VERSION = "1.0";
    //Network channel
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(VanillaAdditionsMod.MOD_ID, "packet"),
            () -> PROTOCOL_VERSION,
            s -> true,
            s -> true
    );
    private static int ID = 0;

    public static int nextPacketID() {return ID++;}

    //Register Packet
    public static void register() {
        INSTANCE.registerMessage(nextPacketID(), ItemMessage.class, ItemMessage::toBytes, ItemMessage::new, ItemMessage::handle);
    }

    // send a packet to all players near the pos withing a specific range
    public static void sendToPlayersInRange(World world, BlockPos pos, Object message, int range) {
        if (!world.isRemote) {
            ((ServerWorld) world).getChunkProvider().chunkManager.getTrackingPlayers(new ChunkPos(pos), false)
                    .filter(e -> e.getDistanceSq(pos.getX(), pos.getY(), pos.getZ()) < range * range)
                    .forEach(e -> INSTANCE.send(PacketDistributor.PLAYER.with(() -> e), message));
        }
    }
}