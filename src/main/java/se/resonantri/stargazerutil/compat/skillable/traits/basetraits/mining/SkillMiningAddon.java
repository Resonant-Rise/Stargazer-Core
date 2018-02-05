package se.resonantri.stargazerutil.compat.skillable.traits.basetraits.mining;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.Skillable;
import vazkii.skillable.event.RegisterUnlockablesEvent;
import vazkii.skillable.skill.SkillMining;

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
