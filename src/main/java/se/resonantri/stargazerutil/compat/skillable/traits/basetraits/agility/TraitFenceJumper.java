//////////////////////////////////////////
///
///
///
///
//////////////////////////////////////////

package se.resonantri.stargazerutil.compat.skillable.traits.basetraits.agility;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockWall;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vazkii.skillable.skill.base.Trait;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;

public class TraitFenceJumper extends Trait{
    public TraitFenceJumper() {
        super("fence_jumper", 3, 2, 2, "agility:16");
    }

    @SideOnly(CLIENT)
    @SubscribeEvent
    public void playerJumped(LivingJumpEvent event){
        if (event.getEntity() instanceof EntityPlayerSP){
            EntityPlayerSP player = (EntityPlayerSP) event.getEntity();
            if (player.movementInput.jump && isPlayerNextToFence(player)){
                player.motionY += 0.05D;
            }
        }
    }

    @SideOnly(CLIENT)
    public boolean isPlayerNextToFence(EntityPlayerSP playerSP){
        double x = playerSP.motionX - 1.0D;
        double y = playerSP.motionY;
        double z = playerSP.motionZ - 1.0D;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (i == x && j == z){
                    continue;
                }
                Block block = getBlock(playerSP.getEntityWorld(), new BlockPos(x + i, y, z + j));
                if ((block instanceof BlockFence) || (block instanceof BlockWall)){
                    return true;
                }
            }
        }
        return false;
    }
}