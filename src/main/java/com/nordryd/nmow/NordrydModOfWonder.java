package com.nordryd.nmow;

import static com.nordryd.nmow.config.NMOWConfig.loadConfig;
import static org.apache.logging.log4j.LogManager.getLogger;

import com.nordryd.nmow.config.NMOWConfig;
import com.nordryd.nmow.world.OreGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.Logger;

@Mod(NordrydModOfWonder.MODID)
public class NordrydModOfWonder {
    public static final String MODID = "nmow";
    public static final Logger LOGGER = getLogger();

    public NordrydModOfWonder() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, NMOWConfig.server_config);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientStarting);

        loadConfig(NMOWConfig.server_config, FMLPaths.CONFIGDIR.get().resolve("nmow-server.toml").toString());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("preinit");
        OreGenerator.setup();
    }

    private void onClientStarting(final FMLClientSetupEvent event) {
        LOGGER.info("client registries registered");
    }

    @SubscribeEvent
    public void onServerStarting(final FMLServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}
