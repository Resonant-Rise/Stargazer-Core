package se.resonantri.stargazerutil.common.items.ResearchSystem;

import net.minecraft.client.resources.I18n;
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

public class ItemManuscript extends Item {
    public ItemManuscript() {
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.stargazerUtils);
        setUnlocalizedName(Constants.MODID + ".itemmanuscript");
        setRegistryName(new ResourceLocation(Constants.MODID, "itemmanuscript"));
    }

    public void initModel() {
        StargazerUtil.proxy.registerItemRenderer(this, 0, "itemmanuscript");
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        NBTTagCompound nbt = stack.getTagCompound();

        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            if (nbt.hasKey("Manuscript")) {
                tooltip.add(TextFormatting.GRAY + "Manuscript: " + TextFormatting.LIGHT_PURPLE + I18n.format(nbt.getString("Manuscript")));
            } else if (!nbt.hasKey("Manuscript")) {
                tooltip.add(TextFormatting.GRAY + "Manuscript: " + TextFormatting.DARK_PURPLE + "NULL");
            }
        } else if (!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            tooltip.add(TextFormatting.GRAY + "Press Shift for Manuscript Information");
        }
    }
}
