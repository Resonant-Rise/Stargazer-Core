package se.resonantri.stargazerutil.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import se.resonantri.stargazerutil.common.items.ModItems;

public class CreativeTab extends CreativeTabs {
    public static final CreativeTab stargazerUtils = new CreativeTab();

    public CreativeTab() {
        super(Constants.MODID);
        setBackgroundImageName("item_search.png");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.itemQuill);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
