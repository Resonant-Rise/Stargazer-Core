package se.resonantri.stargazerutil.common.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import se.resonantri.stargazerutil.utils.Constants;
import se.resonantri.stargazerutil.utils.CreativeTab;

public class ItemQuill extends Item {
    public ItemQuill() {
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.stargazerUtils);
        setUnlocalizedName(Constants.MODID + ".itemquill");
        setRegistryName(new ResourceLocation(Constants.MODID, "itemquill"));
    }

    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
