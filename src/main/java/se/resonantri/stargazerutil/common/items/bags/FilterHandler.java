package se.resonantri.stargazerutil.common.items.bags;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import se.resonantri.stargazerutil.utils.ItemStackUtility;

import java.util.HashSet;
import java.util.Set;

public class FilterHandler implements IFilterHandler{
    private final Set<String> acceptedItemStacks = new HashSet<>();
    private final Set<String> rejectedItemStacks = new HashSet<>();
    private final Set<Integer> validOreIds = new HashSet<>();

    @Override
    public void acceptItem(ItemStack validItemStack) {
        String itemStackString = ItemStackUtility.getStringForItemStack(validItemStack);
        if (itemStackString != null) {
            this.acceptedItemStacks.add(itemStackString);
        }
    }

    @Override
    public void acceptOreDictName(String validOreDictName) {
        if (OreDictionary.doesOreNameExist(validOreDictName)) {
            int oreId = OreDictionary.getOreID(validOreDictName);
            this.validOreIds.add(oreId);
        }
    }

    @Override
    public void rejectItem(ItemStack invalidItemStack) {
        String itemStackString = ItemStackUtility.getStringForItemStack(invalidItemStack);
        if (itemStackString != null) {
            this.rejectedItemStacks.add(itemStackString);
        }
    }

    @Override
    public void rejectOreDictName(String invalidOreDictName) {
        if (OreDictionary.doesOreNameExist(invalidOreDictName)) {
            int oreId = OreDictionary.getOreID(invalidOreDictName);
            this.validOreIds.remove(oreId);
        }
    }

    @Override
    public void clear() {
        acceptedItemStacks.clear();
        rejectedItemStacks.clear();
        validOreIds.clear();
    }

    @Override
    public boolean test(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }

        Item item = stack.getItem();
        String itemStackStringWild = ItemStackUtility.getItemNameFromRegistryAsString(item);
        if (rejectedItemStacks.contains(itemStackStringWild)) {
            return false;
        }
        if (acceptedItemStacks.contains(itemStackStringWild)) {
            return true;
        }

        int meta = stack.getMetadata();
        if (meta != OreDictionary.WILDCARD_VALUE) {
            String itemStackString = itemStackStringWild + ':' + meta;
            if (rejectedItemStacks.contains(itemStackString)) {
                return false;
            }
            if (acceptedItemStacks.contains(itemStackString)) {
                return true;
            }
        }

        int[] oreIds = OreDictionary.getOreIDs(stack);
        for (int oreId : oreIds) {
            if (validOreIds.contains(oreId)) {
                acceptedItemStacks.add(itemStackStringWild);
                return true;
            }
        }

        return false;
    }

    public Set<Integer> getValidOreIds() {
        return validOreIds;
    }

    public Set<String> getAcceptedItemStacks() {
        return acceptedItemStacks;
    }

    public Set<String> getRejectedItemStacks() {
        return rejectedItemStacks;
    }
}
