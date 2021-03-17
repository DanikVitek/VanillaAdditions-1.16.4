package com.danikvitek.vanilla_additions.util.setup;

import net.minecraft.world.World;

public interface IProxy
{
    void init();

    World getClientWorld();

}
