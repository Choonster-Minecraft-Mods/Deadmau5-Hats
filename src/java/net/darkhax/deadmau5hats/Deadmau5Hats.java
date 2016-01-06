package net.darkhax.deadmau5hats;

import net.darkhax.deadmau5hats.common.ProxyCommon;
import net.darkhax.deadmau5hats.libs.Constants;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.VERSION_NUMBER, acceptedMinecraftVersions = Constants.MCVERSION)
public class Deadmau5Hats {
    
    @SidedProxy(clientSide = Constants.CLIENT_PROXY_CLASS, serverSide = Constants.SERVER_PROXY_CLASS)
    public static ProxyCommon proxy;
    
    @Mod.Instance(Constants.MOD_ID)
    public static Deadmau5Hats instance;
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent pre) {
    
    }
}