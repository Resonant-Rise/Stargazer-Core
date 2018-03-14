package se.resonantri.stargazerutil.compat.skillable.traits.basetraits.mining;

import codersafterdark.reskillable.event.RegisterUnlockablesEvent;
import codersafterdark.reskillable.skill.SkillMining;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.Skillable;

@EventBusSubscriber
public class SkillMiningAddon {

    @SubscribeEvent
    public void addMiningTraits(RegisterUnlockablesEvent event) {
        if (event.getSkill() instanceof SkillMining) {
            if (Skillable.LuckyMiner) {
                event.register(new UnlockableLuckyMiner());
            }
        }
    }
}
