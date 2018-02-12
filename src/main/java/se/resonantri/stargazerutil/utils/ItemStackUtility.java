package se.resonantri.stargazerutil.utils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nullable;

public abstract class ItemStackUtility {

    @Nullable
    public static ResourceLocation getItemNameFromRegistry(Item item) {
        IForgeRegistry<Item> itemRegistry = ForgeRegistries.ITEMS;
        if (itemRegistry.containsValue(item)) {
            return itemRegistry.getKey(item);
        } else {
            return null;
        }
    }

    @Nullable
    public static String getItemNameFromRegistryAsString(Item item) {
        ResourceLocation itemNameFromRegistry = getItemNameFromRegistry(item);
        if (itemNameFromRegistry == null) {
            return null;
        }
        return itemNameFromRegistry.toString();
    }

    @Nullable
    public static String getStringForItemStack(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return null;
        }

        Item item = itemStack.getItem();
        String itemStackString = getItemNameFromRegistryAsString(item);
        if (itemStackString == null) {
            return null;
        }

        int meta = itemStack.getItemDamage();
        if (meta != OreDictionary.WILDCARD_VALUE) {
            return itemStackString + ':' + meta;
        } else {
            return itemStackString;
        }
    }
}
