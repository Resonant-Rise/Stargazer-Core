package se.resonantri.stargazerutil.common.items.researchitems;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import org.lwjgl.input.Keyboard;
import se.resonantri.stargazerutil.utils.Constants;
import se.resonantri.stargazerutil.utils.creativetab.CreativeTab;

import javax.annotation.Nullable;
import java.util.List;

public class ItemResearch extends Item {
    public ItemResearch() {
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.stargazerUtils);
        setUnlocalizedName(Constants.MODID + ".itemresearch");
        setRegistryName(new ResourceLocation(Constants.MODID, "itemresearch"));
    }

    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        NBTTagCompound nbt = stack.getTagCompound();

        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            if (nbt.hasKey("Research")) {
                tooltip.add(TextFormatting.GRAY + "Research: " + TextFormatting.LIGHT_PURPLE + I18n.format(nbt.getString("Research")));
            } else if (!nbt.hasKey("Research")) {
                tooltip.add(TextFormatting.GRAY + "Research: " + TextFormatting.DARK_PURPLE + "NULL");
            }
        } else if (!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            tooltip.add(TextFormatting.GRAY + "Press Shift for research Information");
        }
    }
}
