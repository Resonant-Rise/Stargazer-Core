package se.resonantri.stargazerutil.common.items.ResearchSystem;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import se.resonantri.stargazerutil.StargazerUtil;
import se.resonantri.stargazerutil.utils.Constants;
import se.resonantri.stargazerutil.utils.CreativeTab;

import javax.annotation.Nullable;
import java.util.List;

public class ItemTheorem extends Item{

    public ItemTheorem(){
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.stargazerUtils);
        setUnlocalizedName(Constants.MODID + ".itemtheorem");
        setRegistryName(new ResourceLocation(Constants.MODID, "itemtheorem"));
    }

    public void initModel(){
        StargazerUtil.proxy.registerItemRenderer(this, 0, "itemtheorem");
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        NBTTagCompound nbt = stack.getTagCompound();

        if (!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
            if (nbt.hasKey("Theorem")){
                tooltip.add(TextFormatting.GRAY + "Theorem: " + TextFormatting.LIGHT_PURPLE + nbt.getString("Theorem"));
            } else if (!nbt.hasKey("Theorem")){
                tooltip.add(TextFormatting.GRAY + "Theorem: " + TextFormatting.DARK_PURPLE + "NULL");
            }
        } else if (!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
            tooltip.add(TextFormatting.GRAY + "Press Shift for Theorem Information");
        }
    }
}
