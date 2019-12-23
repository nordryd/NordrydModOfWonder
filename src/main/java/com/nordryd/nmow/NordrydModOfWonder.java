package com.nordryd.nmow;

import static org.apache.logging.log4j.LogManager.getLogger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Logger;

@Mod("nmow")
public class NordrydModOfWonder {
    public static final String MODID = "nmow";
    public static final Logger LOGGER = getLogger();

    public NordrydModOfWonder() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientStarting);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM PREINIT");
    }

    private void onClientStarting(final FMLClientSetupEvent event) {
        LOGGER.info("client registries registered");
    }

    @SubscribeEvent
    public void onServerStarting(final FMLServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}
