package net.darkhax.deadmau5hats.client.renderer;

import net.darkhax.deadmau5hats.item.ItemDeadmau5Helmet;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;

public class Deadmau5MeshDefinition implements ItemMeshDefinition {
    
    @Override
    public ModelResourceLocation getModelLocation (ItemStack stack) {
        
        return new ModelResourceLocation("deadmau5hats:deadmau5hat_" + ItemDeadmau5Helmet.getVarient(stack));
    }
    
}
