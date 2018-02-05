package se.resonantri.stargazerutil.compat.skillable.traits.customtraits.alchemy;

import net.minecraft.init.Blocks;
import se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.Skillable;
import vazkii.skillable.skill.Skill;

public class SkillAlchemy extends Skill {
    public SkillAlchemy() {
        super("alchemy", 8, Blocks.CAULDRON);
    }

    @Override
    public void initUnlockables() {
        if (Skillable.Accelerated) {
            addUnlockable(new UnlockableAccelerated());
        }
    }
}
