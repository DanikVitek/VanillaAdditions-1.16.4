package com.danikvitek.vanilla_additions.util;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.File;

public class Config {
    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;


    public static ForgeConfigSpec.IntValue COPPERED_GLOW_DURATION;
    public static ForgeConfigSpec.DoubleValue COPPERED_GLOWING_CHANCE;
    public static ForgeConfigSpec.IntValue COPPERED_NIGHT_VISION_DURATION;
    public static ForgeConfigSpec.DoubleValue COPPERED_NIGHT_VISION_CHANCE;

    public static ForgeConfigSpec.IntValue BLACKSTONE_FURNACE_LIGHT_LEVEL;

    public static ForgeConfigSpec.IntValue TICKS_PER_MILK_EFFECTS_REDUCE;
    public static ForgeConfigSpec.IntValue TICKS_PER_MILK_HEAL;
    public static ForgeConfigSpec.IntValue HALF_HEARTS_PER_MILK_HEAL;

    public static ForgeConfigSpec.DoubleValue CHANCE_BAOBAB_GROW_FROM_BONEMEAL;

    static {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        setConfigs(SERVER_BUILDER, CLIENT_BUILDER);

        SERVER_CONFIG = SERVER_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    public static void setConfigs(ForgeConfigSpec.Builder SERVER_BUILDER,
                                       ForgeConfigSpec.Builder CLIENT_BUILDER)
    {
        COPPERED_GLOW_DURATION = CLIENT_BUILDER
                .comment("How long the glowing lasts for Coppered Carrot (int ticks)")
                .defineInRange("coppered_glow_duration", 400, 0, Integer.MAX_VALUE);
        COPPERED_GLOWING_CHANCE = CLIENT_BUILDER
                .comment("Chance to become glowing (in decimals)")
                .defineInRange("coppered_glowing_chance", .333, 0., 1.);
        COPPERED_NIGHT_VISION_DURATION = CLIENT_BUILDER
                .comment("How long the night vision lasts for Coppered Carrot (int ticks)")
                .defineInRange("coppered_night_vision_duration", 2400, 0, Integer.MAX_VALUE);
        COPPERED_NIGHT_VISION_CHANCE = CLIENT_BUILDER
                .comment("Chance to get night vision (in decimals)")
                .defineInRange("coppered_night_vision_chance", 1., 0., 1.);

        BLACKSTONE_FURNACE_LIGHT_LEVEL = CLIENT_BUILDER
                .comment("How bright does the Blackstone Furnace shines when smelting")
                .defineInRange("blackstone_furnace_light_level", 10, 1, 13);

        TICKS_PER_MILK_EFFECTS_REDUCE = CLIENT_BUILDER
                .comment("How frequent will milk reduce effects amplifier by 1 (in ticks)")
                .defineInRange("ticks_per_milk_effects_reduce", 20, 0, Integer.MAX_VALUE);
        TICKS_PER_MILK_HEAL = CLIENT_BUILDER
                .comment("How frequent will milk heal (in ticks)")
                .defineInRange("ticks_per_milk_heal", 100, 0, Integer.MAX_VALUE);
        HALF_HEARTS_PER_MILK_HEAL = CLIENT_BUILDER
                .comment("How many half-hearts will milk regen")
                .defineInRange("half_hearts_per_milk_heal", 1, 0, 100);

        CHANCE_BAOBAB_GROW_FROM_BONEMEAL = CLIENT_BUILDER
                .comment("The chance for baobab to grow on bonemeal usage")
                .defineInRange("chance_baobab_grow_from_bonemeal", 0.333d, 0, 1);
    }

    public static void loadConfigFile(ForgeConfigSpec config, String path){
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path))
                .sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);
    }
}
