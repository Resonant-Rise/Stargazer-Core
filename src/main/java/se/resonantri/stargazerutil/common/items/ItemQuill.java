package se.resonantri.stargazerutil.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import se.resonantri.stargazerutil.StargazerUtil;
import se.resonantri.stargazerutil.utils.Constants;
import se.resonantri.stargazerutil.utils.CreativeTab;

public class ItemQuill extends Item{
    public ItemQuill(){
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.stargazerUtils);
        setUnlocalizedName(Constants.MODID + ".itemquill");
        setRegistryName(new ResourceLocation(Constants.MODID, "itemquill"));
    }

    public void initModel(){
        StargazerUtil.proxy.registerItemRenderer(this, 0, "itemquill");
    }
}
