package se.resonantri.stargazerutil.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import se.resonantri.stargazerutil.common.items.ModItems;

public class CreativeTab extends CreativeTabs {
    public static final CreativeTab stargazerUtils = new CreativeTab();

    public CreativeTab() {
        super(Constants.MODID);
        setBackgroundImageName("item_search.png");
    }

    @Override
    public ItemStack getTabIconItem() {
        ItemStack icon = new ItemStack(ModItems.itemInkwell);
        if (!icon.hasTagCompound()){
            icon.setTagCompound(new NBTTagCompound());
        }
        icon.getTagCompound().setInteger("ink", 16);
        return icon;
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
