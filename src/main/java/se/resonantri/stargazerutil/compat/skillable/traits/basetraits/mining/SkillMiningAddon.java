package se.resonantri.stargazerutil.compat.skillable.traits.basetraits.mining;

import vazkii.skillable.skill.SkillMining;
import vazkii.skillable.skill.mining.TraitFossilDigger;
import vazkii.skillable.skill.mining.TraitObsidianSmasher;

public class SkillMiningAddon extends SkillMining{

    @Override
    public void initUnlockables() {
        addUnlockable(new UnlockableLuckyMiner());
        addUnlockable(new TraitFossilDigger());
        addUnlockable(new TraitObsidianSmasher());
    }
}
