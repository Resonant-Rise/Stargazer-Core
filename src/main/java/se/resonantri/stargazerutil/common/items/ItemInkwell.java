package se.resonantri.stargazerutil.common.items;

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
import se.resonantri.stargazerutil.utils.CreativeTab;

import javax.annotation.Nonnull;

public class ItemInkwell extends Item{

    public ItemInkwell() {
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.stargazerUtils);
        setUnlocalizedName(Constants.MODID + ".iteminkwell");
        setRegistryName(new ResourceLocation(Constants.MODID, "iteminkwell"));
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomMeshDefinition(this, new ItemMeshDefinition(){
                    @Override
                    @Nonnull
                    public ModelResourceLocation getModelLocation(@Nonnull ItemStack stack) {
                        int inkAmount = stack.getTagCompound().getInteger("ink");
                        int tier = new Double(Math.ceil(inkAmount/3f)).intValue();
                        String name = getRegistryName().toString();
                        return new ModelResourceLocation(new ResourceLocation(name + tier), "inventory");
                    }
                }
        );
        ModelBakery.registerItemVariants(this, new ResourceLocation("stargazerutil", "iteminkwell"));
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
