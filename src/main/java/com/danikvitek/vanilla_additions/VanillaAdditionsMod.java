package com.danikvitek.vanilla_additions;

import com.danikvitek.vanilla_additions.block.ModBlocks;
import com.danikvitek.vanilla_additions.container.ModContainers;
import com.danikvitek.vanilla_additions.events.ModEvents;
import com.danikvitek.vanilla_additions.fluid.ModFluids;
import com.danikvitek.vanilla_additions.item.ModItems;
import com.danikvitek.vanilla_additions.stats.ModStats;
import com.danikvitek.vanilla_additions.tileentity.ModTileEntities;
import com.danikvitek.vanilla_additions.util.Config;
import com.danikvitek.vanilla_additions.util.Registration;
import com.danikvitek.vanilla_additions.util.setup.ClientProxy;
import com.danikvitek.vanilla_additions.util.setup.IProxy;
import com.danikvitek.vanilla_additions.util.setup.ServerProxy;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VanillaAdditionsMod.MOD_ID)
public class VanillaAdditionsMod
{
    public static final String MOD_ID = "vanilla_additions";

    public static final ItemGroup VANILLA_ADDITIONS_TAB = new ItemGroup("vanilla_additions_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.BLACKSTONE_FURNACE.get());
        }
    };

    public static IProxy proxy;

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public VanillaAdditionsMod()
    {
        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        registerModAdditions();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        registerConfigs();

        proxy.init();

        loadConfigs();
    }

    private void registerConfigs()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
    }

    private void loadConfigs()
    {
        Config.loadConfigFile(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("vanilla_additions-client.toml").toString());
        Config.loadConfigFile(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("vanilla_additions-server.toml").toString());
    }

    private void registerModAdditions()
    {
        //Inits the registration of our additions
        Registration.init();

        // registers items, blocks etc. added by our mod
        ModItems.register();
        ModBlocks.register();
        ModFluids.register();
        ModTileEntities.register();
        ModContainers.register();
        ModStats.register();

        // register mod events
        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }
}
