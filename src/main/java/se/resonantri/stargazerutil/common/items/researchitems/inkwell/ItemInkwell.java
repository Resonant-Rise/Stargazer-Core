package se.resonantri.stargazerutil.common.items.researchitems.inkwell;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import se.resonantri.stargazerutil.utils.Constants;
import se.resonantri.stargazerutil.utils.creativetab.CreativeTab;

public class ItemInkwell extends Item {

    public ItemInkwell() {
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.stargazerUtils);
        setUnlocalizedName(Constants.MODID + ".iteminkwell");
        setRegistryName(new ResourceLocation(Constants.MODID, "iteminkwell"));
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelResourceLocation T0 = new ModelResourceLocation(getRegistryName() + "_Tier0", "inventory");
        ModelResourceLocation T1 = new ModelResourceLocation(getRegistryName() + "_Tier1", "inventory");
        ModelResourceLocation T2 = new ModelResourceLocation(getRegistryName() + "_Tier2", "inventory");
        ModelResourceLocation T3 = new ModelResourceLocation(getRegistryName() + "_Tier3", "inventory");
        ModelResourceLocation T4 = new ModelResourceLocation(getRegistryName() + "_Tier4", "inventory");
        ModelResourceLocation T5 = new ModelResourceLocation(getRegistryName() + "_Tier5", "inventory");
        ModelResourceLocation T6 = new ModelResourceLocation(getRegistryName() + "_Tier6", "inventory");
        ModelBakery.registerItemVariants(this, T0, T1, T2, T3, T4, T5, T6);
        ModelLoader.setCustomMeshDefinition(this, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                if (Empty(stack)) {
                    return T0;
                } else if (Tier1(stack)) {
                    return T1;
                } else if (Tier2(stack)) {
                    return T2;
                } else if (Tier3(stack)) {
                    return T3;
                } else if (Tier4(stack)) {
                    return T4;
                } else if (Tier5(stack)) {
                    return T5;
                } else {
                    return T6;
                }
            }
        });
    }

    private NBTTagCompound getTagCompoundSafe(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }

    public boolean Empty(ItemStack stack) {
        int InkInt = getTagCompoundSafe(stack).getInteger("ink");
        if (InkInt == 0) {
            return true;
        }
        return false;
    }

    public boolean Tier1(ItemStack stack) {
        int InkInt = getTagCompoundSafe(stack).getInteger("ink");
        if (InkInt == 1) {
            return true;
        }
        if (InkInt == 2) {
            return true;
        }
        if (InkInt == 3) {
            return true;
        }
        return false;
    }

    public boolean Tier2(ItemStack stack) {
        int InkInt = getTagCompoundSafe(stack).getInteger("ink");
        if (InkInt == 4) {
            return true;
        }
        if (InkInt == 5) {
            return true;
        }
        if (InkInt == 6) {
            return true;
        }
        return false;
    }

    public boolean Tier3(ItemStack stack) {
        int InkInt = getTagCompoundSafe(stack).getInteger("ink");
        if (InkInt == 7) {
            return true;
        }
        if (InkInt == 8) {
            return true;
        }
        if (InkInt == 9) {
            return true;
        }
        return false;
    }

    public boolean Tier4(ItemStack stack) {
        int InkInt = getTagCompoundSafe(stack).getInteger("ink");
        if (InkInt == 10) {
            return true;
        }
        if (InkInt == 11) {
            return true;
        }
        if (InkInt == 12) {
            return true;
        }
        return false;
    }

    public boolean Tier5(ItemStack stack) {
        int InkInt = getTagCompoundSafe(stack).getInteger("ink");
        if (InkInt == 13) {
            return true;
        }
        if (InkInt == 14) {
            return true;
        }
        if (InkInt == 15) {
            return true;
        }
        return false;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            for (int i = 0; i < 7; i++) {
                ItemStack stack = new ItemStack(this);
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setInteger("ink", i * 3);
                stack.setTagCompound(nbt);
                items.add(stack);
            }
        }
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);

        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        if (!stack.getTagCompound().hasKey("ink")) {
            stack.getTagCompound().setInteger("ink", 0);
        }

        if (stack.getTagCompound().hasKey("ink")) {
            int ink = stack.getTagCompound().getInteger("ink");
            if (ink > 16) {
                stack.getTagCompound().setInteger("ink", 16);
            }
            if (ink < 0) {
                stack.getTagCompound().setInteger("ink", 0);
            }
        }
    }
}
