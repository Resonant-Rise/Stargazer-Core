package se.resonantri.stargazerutil.api.cap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;
import se.resonantri.stargazerutil.StargazerUtil;
import se.resonantri.stargazerutil.utils.Constants;

import static se.resonantri.stargazerutil.api.cap.KnowledgeCapabilities.CAPABILITY_KNOWLEDGE;

public class KnowledgeEventHandler {

    public static IKnowledgeHandler getHandler(EntityPlayer entity) {
        if (entity.hasCapability(CAPABILITY_KNOWLEDGE, EnumFacing.DOWN)) {
            return entity.getCapability(CAPABILITY_KNOWLEDGE, EnumFacing.DOWN);
        }
        return null;
    }

    @SubscribeEvent
    public void clonePlayerKnowledge(PlayerEvent.Clone event) {
        try {
            KnowledgeProvider ksO = (KnowledgeProvider) getHandler(event.getOriginal());
            NBTTagCompound nbt = ksO.serializeNBT();
            KnowledgeProvider ksC = (KnowledgeProvider) getHandler(event.getEntityPlayer());
            ksC.deserializeNBT(nbt);
        } catch (Exception e) {
            StargazerUtil.logger.log(Level.ERROR, "Could not clone player " + event.getOriginal().getName() + " knowledge when changing dimensions");
        }
    }

    @SubscribeEvent
    public void attachCapsToPlayer(AttachCapabilitiesEvent<EntityPlayer> event) {
        event.addCapability(new ResourceLocation(Constants.MODID, Constants.MODID), new KnowledgeProvider());
    }
}
