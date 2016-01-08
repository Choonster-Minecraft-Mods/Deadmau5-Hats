package net.darkhax.deadmau5hats;

import java.util.ArrayList;
import java.util.List;

import net.darkhax.deadmau5hats.client.renderer.Deadmau5MeshDefinition;
import net.darkhax.deadmau5hats.common.ProxyCommon;
import net.darkhax.deadmau5hats.item.ItemDeadmau5Helmet;
import net.darkhax.deadmau5hats.libs.Constants;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.VERSION_NUMBER, acceptedMinecraftVersions = Constants.MCVERSION)
public class Deadmau5Hats {
    
    @SidedProxy(clientSide = Constants.CLIENT_PROXY_CLASS, serverSide = Constants.SERVER_PROXY_CLASS)
    public static ProxyCommon proxy;
    
    @Mod.Instance(Constants.MOD_ID)
    public static Deadmau5Hats instance;
    
    public static Item item;
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        
        item = new ItemDeadmau5Helmet();
        GameRegistry.registerItem(item, "deadmau5hat");

        if (event.getSide().equals(Side.CLIENT)) {
            List<ModelResourceLocation> models = new ArrayList<ModelResourceLocation>();
            
            for (String varient : ItemDeadmau5Helmet.variants)
                models.add(new ModelResourceLocation("deadmau5hats:deadmau5hat_" + varient, "inventory"));

            ModelLoader.registerItemVariants(item, models.toArray(new ModelResourceLocation[models.size()]));
            ModelLoader.setCustomMeshDefinition(item, new Deadmau5MeshDefinition());
        }
    }
    
    @EventHandler
    public void init (FMLInitializationEvent event) {

    }
}