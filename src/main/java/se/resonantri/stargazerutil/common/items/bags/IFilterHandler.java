package se.resonantri.stargazerutil.common.items.bags;

import net.minecraft.item.ItemStack;

import java.util.function.Predicate;

public interface IFilterHandler extends Predicate<ItemStack>{
    // Valid ItemStack/OreDict
    void acceptItem(ItemStack validItemStack);
    void acceptOreDictName(String validOreDictName);

    // Invalid ItemStack/OreDict
    void rejectItem(ItemStack invalidItemStack);
    void rejectOreDictName(String invalidOreDictName);

    // Clear Lists
    void clear();
}
