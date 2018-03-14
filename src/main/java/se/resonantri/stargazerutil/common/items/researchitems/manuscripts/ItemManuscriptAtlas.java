package se.resonantri.stargazerutil.common.items.researchitems.manuscripts;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.darkhax.gamestages.capabilities.PlayerDataHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import org.lwjgl.input.Keyboard;
import se.resonantri.stargazerutil.utils.Constants;
import se.resonantri.stargazerutil.utils.creativetab.CreativeTab;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ItemManuscriptAtlas extends Item {

    public static BiMap<String, String> biMapster = HashBiMap.create();

    public ItemManuscriptAtlas() {
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.stargazerUtils);
        setUnlocalizedName(Constants.MODID + ".itematlas");
        setRegistryName(new ResourceLocation(Constants.MODID, "itematlas"));
    }

    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    static {
        biMapster.put("Aether Atlas", "Aether");
        biMapster.put("Betweenlands Atlas", "Betweenlands");
        biMapster.put("End Atlas", "End");
        biMapster.put("Hunting Dimension Atlas", "Hunting_Dim");
        biMapster.put("Nether Atlas", "Nether");
        biMapster.put("Twilight Forest Atlas", "TwilightForest");
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            Iterator iterator = biMapster.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry value = (Map.Entry) iterator.next();
                ItemStack stack = new ItemStack(this);
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString("Manuscript", value.getKey().toString());
                stack.setTagCompound(nbt);
                items.add(stack);
            }
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        NBTTagCompound nbt = stack.getTagCompound();
        if (stack.hasTagCompound()){
            if (nbt.hasKey("Manuscript")){
                if (biMapster.get(nbt.getString("Manuscript")) != null){
                    PlayerDataHandler.getStageData(playerIn).unlockStage(biMapster.get(nbt.getString("Manuscript")));
                    return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
                }
            }
        }
        return ActionResult.newResult(EnumActionResult.PASS, stack);
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
