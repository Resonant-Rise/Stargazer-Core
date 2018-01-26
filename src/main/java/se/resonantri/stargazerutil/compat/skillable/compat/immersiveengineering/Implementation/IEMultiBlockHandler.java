package se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.Implementation;

import blusunrize.immersiveengineering.api.MultiblockHandler.*;
import com.google.common.collect.Maps;
import net.darkhax.gamestages.capabilities.PlayerDataHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.MultiBlockSkill;

import java.util.Map;

public class IEMultiBlockHandler {
    private Map<String, MultiBlockSkill> multiBlockSkill;

    public IEMultiBlockHandler() {
        multiBlockSkill = Maps.newHashMap();
    }

    public void addMultiBlockSkill(MultiBlockSkill multiBlockStage) {
        multiBlockSkill.put(multiBlockStage.getMultiBlockName(),  multiBlockStage);
    }

//    @SubscribeEvent
//    public void multiBlockForm(MultiblockFormEvent multiblockFormEvent) {
//        IMultiblock multiblock = multiblockFormEvent.getMultiblock();
//        EntityPlayer entityPlayer = multiblockFormEvent.getEntityPlayer();
//        if (multiBlockSkill.containsKey(multiblock.getUniqueName())) {
//            MultiBlockSkill reqSkills = multiBlockSkill.get(multiblock.getUniqueName());
//            if (!PlayerDataHandler.getStageData(entityPlayer).hasLevel(reqSkills.getReqSkills())) {
//                multiblockFormEvent.setCanceled(true);
//                if (entityPlayer.getEntityWorld().isRemote) {
//                    entityPlayer.sendStatusMessage(new TextComponentString(reqSkills.getFailureMessage()), false);
//                }
//            }
//        }
//    }
}
