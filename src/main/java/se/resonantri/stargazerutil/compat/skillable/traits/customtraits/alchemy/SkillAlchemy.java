package se.resonantri.stargazerutil.compat.skillable.traits.customtraits.alchemy;

import net.minecraft.init.Blocks;
import vazkii.skillable.skill.Skill;

import static se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.Skillable.Alchemy;

public class SkillAlchemy extends Skill {
    public SkillAlchemy() {
        super("Alchemy", 8, Blocks.CAULDRON);
    }

    @Override
    public void initUnlockables() {
        if (Alchemy) {
            addUnlockable(new UnlockableAccelerated());
        }
    }
}
