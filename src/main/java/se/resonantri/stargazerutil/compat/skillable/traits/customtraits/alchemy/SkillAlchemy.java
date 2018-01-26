package se.resonantri.stargazerutil.compat.skillable.traits.customtraits.alchemy;

import net.minecraft.init.Blocks;
import vazkii.skillable.skill.Skill;

public class SkillAlchemy extends Skill {
    public SkillAlchemy() {
        super("alchemy", 8, Blocks.CAULDRON);
    }

    @Override
    public void initUnlockables() {
        addUnlockable(new TraitAccelerated());
    }
}
