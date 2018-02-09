package se.resonantri.stargazerutil.common.research.triggers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import se.resonantri.stargazerutil.common.items.ModItems;
import se.resonantri.stargazerutil.common.research.IResearchEventHandler;
import se.resonantri.stargazerutil.utils.NBTTagList;


public class TestCase implements IResearchEventHandler {

    @Override
    @SubscribeEvent
    public void onBlockDrops(HarvestDropsEvent event) {
        Block block = event.getState().getBlock();
        EntityPlayer player = event.getHarvester();
        World world = event.getWorld();

        if (!world.isRemote) {
            ItemStack stack = new ItemStack(ModItems.itemResearch);
            stack.setTagCompound(new NBTTagCompound());

            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
            }

            stack.getTagCompound().setString("Research", NBTTagList.STONEBREAK);

            if (player != null) {
                if (block instanceof BlockStone) {
                    event.getDrops().add(stack);
                }
            }
        }
    }

    @Override
    @SubscribeEvent
    public void onPlayerTick(PlayerTickEvent event) {

    }
}
