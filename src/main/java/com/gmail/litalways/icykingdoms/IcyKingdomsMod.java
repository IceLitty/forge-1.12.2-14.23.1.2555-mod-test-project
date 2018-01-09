package com.gmail.litalways.icykingdoms;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = IcyKingdomsMod.MODID, name = IcyKingdomsMod.NAME, version = IcyKingdomsMod.VERSION, dependencies = "required-after:forge@[14.23.1.2555,);")
public class IcyKingdomsMod {
    public static final String MODID = "icykingdoms";
    public static final String NAME = "Icy Kingdoms";
    public static final String VERSION = "${version}";
    private static final String CLIENT_PROXY_CLASS = "com.gmail.litalways.icykingdoms.ClientProxy";
    private static final String SERVER_PROXY_CLASS = "com.gmail.litalways.icykingdoms.CommonProxy";

    @Mod.Instance(MODID)
    public static IcyKingdomsMod instance;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit();
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }
}
