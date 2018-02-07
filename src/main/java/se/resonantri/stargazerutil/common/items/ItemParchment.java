package se.resonantri.stargazerutil.common.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import se.resonantri.stargazerutil.StargazerUtil;
import se.resonantri.stargazerutil.utils.Constants;
import se.resonantri.stargazerutil.utils.CreativeTab;

public class ItemParchment extends Item {
    public ItemParchment() {
        setMaxStackSize(64);
        setCreativeTab(CreativeTab.stargazerUtils);
        setUnlocalizedName(Constants.MODID + ".itemparchment");
        setRegistryName(new ResourceLocation(Constants.MODID, "itemparchment"));
    }

    public void initModel() {
        StargazerUtil.proxy.registerItemRenderer(this, 0, "itemparchment");
    }
}
