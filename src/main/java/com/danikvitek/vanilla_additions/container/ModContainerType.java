package com.danikvitek.vanilla_additions.container;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.registry.Registry;

public class ModContainerType extends ContainerType {
    public ModContainerType(IFactory factory) {
        super(factory);
    }

    private static <T extends Container> ContainerType<T> register(String key, ContainerType.IFactory<T> factory) {
        return Registry.register(Registry.MENU, key, new ContainerType<>(factory));
    }
}
