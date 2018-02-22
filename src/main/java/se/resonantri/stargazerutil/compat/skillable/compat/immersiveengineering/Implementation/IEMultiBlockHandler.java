package se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.Implementation;

import com.google.common.collect.Maps;
import se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.MultiBlockSkill;

import java.util.Map;

public class IEMultiBlockHandler {
    private Map<String, MultiBlockSkill> multiBlockSkill;

    public IEMultiBlockHandler() {
        multiBlockSkill = Maps.newHashMap();
    }

    public void addMultiBlockSkill(MultiBlockSkill multiBlockStage) {
        multiBlockSkill.put(multiBlockStage.getMultiBlockName(), multiBlockStage);
    }

//    @SubscribeEvent
//    public void multiBlockForm(MultiblockFormEvent multiblockFormEvent) {
//        IMultiblock multiblock = multiblockFormEvent.getMultiblock();
//        EntityPlayer entityPlayer = multiblockFormEvent.getEntityPlayer();
//        PlayerData data = vazkii.skillable.base.PlayerDataHandler.get(entityPlayer);
//        if (multiBlockSkill.containsKey(multiblock.getUniqueName())) {
//            MultiBlockSkill reqSkills = multiBlockSkill.get(multiblock.getUniqueName());
//
//            //Todo Add Check For Skill Requirements
//            if () {
//                multiblockFormEvent.setCanceled(true);
//                if (entityPlayer.getEntityWorld().isRemote) {
//                    entityPlayer.sendStatusMessage(new TextComponentString(reqSkills.getFailureMessage()), false);
//                }
//            }
//        }
//    }
}
