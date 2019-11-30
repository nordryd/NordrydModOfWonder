package com.nordryd.nmow;

import static com.nordryd.nmow.init.ModRecipes.initSmeltingRecipes;
import static com.nordryd.nmow.registry.RegistryHandler.preInitRegistries;
import static com.nordryd.nmow.util.ModReference.CLIENT_PROXY_CLASS;
import static com.nordryd.nmow.util.ModReference.COMMON_PROXY_CLASS;
import static com.nordryd.nmow.util.ModReference.MODID;
import static com.nordryd.nmow.util.ModReference.NAME;
import static com.nordryd.nmow.util.ModReference.VERSION;

import com.nordryd.nmow.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class Main {
    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        preInitRegistries();
    }

    @EventHandler
    public void init(final FMLInitializationEvent event) {
        initSmeltingRecipes();
    }

    @EventHandler
    public void postInit(final FMLPostInitializationEvent event) {}
}
