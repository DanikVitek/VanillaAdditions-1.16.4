package com.danikvitek.vanilla_additions.container;

import com.danikvitek.vanilla_additions.util.Registration;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;

public class ModContainers
{
    public static final RegistryObject<ContainerType<FurnaceContainer>> BLACKSTONE_FURNACE_CONTAINER =
            Registration.CONTAINERS.register(
                    "blackstone_furnace_container",
                    () -> IForgeContainerType.create(
                            (windowId, inv, data) -> new FurnaceContainer(windowId, inv)
                    )
            );
    public static final RegistryObject<ContainerType<SawmillContainer>> SAWMILL_CONTAINER =
            Registration.CONTAINERS.register(
                    "sawmill_container",
                    () -> IForgeContainerType.create(
                            (windowId, inv, data) -> {
                                BlockPos pos = data.readBlockPos();
                                World world = inv.player.getEntityWorld();
                                return new SawmillContainer(windowId, world, pos, inv, inv.player);
                            }
                    )
            );

    public static void register() { }
}
