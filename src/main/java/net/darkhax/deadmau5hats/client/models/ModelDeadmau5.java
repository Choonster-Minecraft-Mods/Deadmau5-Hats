package net.darkhax.deadmau5hats.client.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

public class ModelDeadmau5 extends ModelBiped {
    
    ModelRenderer head;
    ModelRenderer earLeft;
    ModelRenderer earRight;
    
    public ModelDeadmau5() {
        
        textureWidth = 64;
        textureHeight = 32;
        
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        
        earLeft = new ModelRenderer(this, 38, 0);
        earLeft.addBox(0F, 0F, 0F, 8, 8, 1);
        earLeft.setRotationPoint(2F, -14F, 0F);
        earLeft.setTextureSize(64, 32);
        earLeft.mirror = true;
        setRotation(earLeft, 0F, 0F, 0F);
        head.addChild(earLeft);
        
        earRight = new ModelRenderer(this, 38, 0);
        earRight.addBox(0F, 0F, 0F, 8, 8, 1);
        earRight.setRotationPoint(-10F, -14F, 0F);
        earRight.setTextureSize(64, 32);
        earRight.mirror = true;
        setRotation(earRight, 0F, 0F, 0F);
        head.addChild(earRight);
    }
    
    @Override
    public void render (Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        
        bipedHeadwear.showModel = false;
        bipedHead = head;
        prepareForRender(entity);
        super.render(entity, f, f1, f2, f3, f4, f5);
    }
    
    private void setRotation (ModelRenderer model, float x, float y, float z) {
        
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void prepareForRender (Entity entity) {
        
        EntityLivingBase living = (EntityLivingBase) entity;
        isSneak = living != null ? living.isSneaking() : false;
        isChild = living != null ? living.isChild() : false;
        if (living != null && living instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) living;
            
            ItemStack itemstack = player.inventory.getCurrentItem();
            heldItemRight = itemstack != null ? 1 : 0;
            
            aimedBow = false;
            if (itemstack != null && player.getItemInUseCount() > 0) {
                EnumAction enumaction = itemstack.getItemUseAction();
                
                if (enumaction == EnumAction.BLOCK)
                    heldItemRight = 3;
                else if (enumaction == EnumAction.BOW)
                    aimedBow = true;
            }
        }
    }
}
