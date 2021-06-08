package com.danikvitek.vanilla_additions.world.gen;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.trees.BaobabTree;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = VanillaAdditionsMod.MOD_ID)
public class ModTreeGeneration {

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event){
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(
                Registry.BIOME_KEY,
                Objects.requireNonNull(event.getName()));
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(types.contains(BiomeDictionary.Type.SAVANNA)){
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            base.add(() -> Feature.TREE.withConfiguration(BaobabTree.BAOBAB_TREE_CONFIG).
                    withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));
        }
    }

}
