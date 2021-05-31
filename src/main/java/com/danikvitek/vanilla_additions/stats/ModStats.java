package com.danikvitek.vanilla_additions.stats;

import net.minecraft.stats.IStatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class ModStats {
    public static final ResourceLocation INTERACT_WITH_SAWMILL = registerCustom("interact_with_sawmill", IStatFormatter.DEFAULT);

    private static ResourceLocation registerCustom(String key, IStatFormatter formatter) {
        ResourceLocation resourcelocation = new ResourceLocation(key);
        Registry.register(Registry.CUSTOM_STAT, key, resourcelocation);
        Stats.CUSTOM.get(resourcelocation, formatter);
        return resourcelocation;
    }

    public static void register() { }
}
