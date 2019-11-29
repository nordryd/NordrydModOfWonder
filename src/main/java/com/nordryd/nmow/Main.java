package com.nordryd.nmow;

import static com.nordryd.nmow.util.Reference.CLIENT_PROXY_CLASS;
import static com.nordryd.nmow.util.Reference.COMMON_PROXY_CLASS;
import static com.nordryd.nmow.util.Reference.MODID;
import static com.nordryd.nmow.util.Reference.NAME;
import static com.nordryd.nmow.util.Reference.VERSION;

import com.nordryd.nmow.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class Main {
    @Instance
    public static Main instance;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {}

    @EventHandler
    public void init(FMLInitializationEvent event) {}

    @EventHandler
    public void postInit(final FMLPostInitializationEvent event) {}
}
