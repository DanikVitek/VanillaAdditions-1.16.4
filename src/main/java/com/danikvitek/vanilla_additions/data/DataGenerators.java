package com.danikvitek.vanilla_additions.data;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = VanillaAdditionsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    private static final String[] LOCAL_CODES = new String[]{
      "en_us",
      "uk_ua",
      "ru_ru"
    };

    private DataGenerators() { }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        addLanguageProviders(generator);

        generator.addProvider(new ModBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(new ModItemModelProvider(generator, existingFileHelper));

        ModBlockTagsProvider modBlockTagsProvider = new ModBlockTagsProvider(generator, existingFileHelper);
        generator.addProvider(modBlockTagsProvider);
        generator.addProvider(new ModRecipeProvider(generator));
        generator.addProvider(new ModLootTableProvider(generator));
        generator.addProvider(new ModAdvancementProvider(generator));
        generator.addProvider(new ModItemTagsProvider(generator, modBlockTagsProvider, existingFileHelper));
    }

    private static void addLanguageProviders(DataGenerator generator){
        for(String locale: LOCAL_CODES)
            generator.addProvider(new ModLanguageProvider(generator, locale));
    }
}
