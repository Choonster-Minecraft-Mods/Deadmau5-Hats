package net.darkhax.deadmau5hats.item;

import java.util.List;

import net.darkhax.deadmau5hats.client.models.ModelDeadmau5;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDeadmau5Helmet extends ItemArmor {
    
    public static final ArmorMaterial deadmau5 = EnumHelper.addArmorMaterial("DEADMAU5", "deadmau5", 50, new int[] { 1, 2, 3, 4 }, 25);
    public static final String[] variants = new String[] { "Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "LightGray", "Gray", "Pink", "Lime", "Yellow", "LightBlue", "Magenta", "Orange", "White" };
    
    public ItemDeadmau5Helmet() {
        
        super(deadmau5, 4, 0);
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setUnlocalizedName("deadmau5hat");
        this.hasSubtypes = true;
    }
    
    @Override
    public String getArmorTexture (ItemStack stack, Entity entity, int slot, String type) {
        
        return "deadmau5hats:textures/entity/player/armor/armor_deadmau5.png";
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel (EntityLivingBase entityLiving, ItemStack stack, int armorSlot) {
        
        return new ModelDeadmau5();
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems (Item item, CreativeTabs tab, List<ItemStack> subItems) {
        
        for (String varient : variants)
            subItems.add(createStack(varient));
    }
    
    public static String getVarient (ItemStack stack) {
        
        if (stack != null && stack.hasTagCompound() && stack.getTagCompound().hasKey("design"))
            return stack.getTagCompound().getString("design");
            
        return "null";
    }
    
    public ItemStack createStack (String design) {
        
        ItemStack stack = new ItemStack(this);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("design", design);
        stack.setTagCompound(tag);
        return stack;
    }
}