package se.resonantri.stargazerutil.common.research.triggers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import se.resonantri.stargazerutil.common.items.ResearchSystem.ItemResearch;
import se.resonantri.stargazerutil.common.research.IResearchEventHandler;


public class TestCase implements IResearchEventHandler{

    public static Item RESEARCH = new ItemResearch();

    @Override
    @SubscribeEvent
    public void onBlockDrops(HarvestDropsEvent event){
        Block block = event.getState().getBlock();
        EntityPlayer player = event.getHarvester();
        World world = event.getWorld();
        ItemStack stack = new ItemStack(RESEARCH);
        stack.setTagCompound(new NBTTagCompound());

        if (stack.hasTagCompound()) {
            stack.getTagCompound().setString("Research", "Stone Breakage");
        }

        if (!world.isRemote){
            if (player != null){
                if (block instanceof BlockStone){
                    event.getDrops().add(stack);
                }
            }
        }
    }
}
