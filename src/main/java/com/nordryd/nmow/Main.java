package com.nordryd.nmow;

import org.apache.logging.log4j.Logger;

import com.nordryd.nmow.proxy.CommonProxy;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main
{
	@Instance
	public static Main instance;
	
    public static final String MODID = "nmow";
    public static final String NAME = "Nordryd's Mod of Wonder";
    public static final String VERSION = "1.0";

    public static final String CLIENT_PROXY_CLASS = "com.nordryd.nmow.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.nordryd.nmow.proxy.CommonProxy";
    
    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
    
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
