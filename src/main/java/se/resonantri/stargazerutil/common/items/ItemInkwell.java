package se.resonantri.stargazerutil.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import se.resonantri.stargazerutil.StargazerUtil;
import se.resonantri.stargazerutil.utils.Constants;
import se.resonantri.stargazerutil.utils.CreativeTab;

public class ItemInkwell extends Item{

    public ItemInkwell(){
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.stargazerUtils);
        setUnlocalizedName(Constants.MODID + ".iteminkwell");
        setRegistryName(new ResourceLocation(Constants.MODID, "iteminkwell"));
    }

    public void initModel(){
        StargazerUtil.proxy.registerItemRenderer(this, 0, "iteminkwell");
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if(this.isInCreativeTab(tab)) {
            ItemStack stack = new ItemStack(this);
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("ink", 0);
            stack.setTagCompound(nbt);
            items.add(stack);
        }
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);

        if(!stack.hasTagCompound()){
            stack.setTagCompound( new NBTTagCompound());
        }

        if(!stack.getTagCompound().hasKey("ink")){
            stack.getTagCompound().setInteger("ink", 0);
        }

        if(stack.getTagCompound().hasKey("ink")){
            int ink = stack.getTagCompound().getInteger("ink");
            if (ink > 64){
                stack.getTagCompound().setInteger("ink", 16);
            }
            if (ink < 0){
                stack.getTagCompound().setInteger("ink", 0);
            }
        }
    }

}
