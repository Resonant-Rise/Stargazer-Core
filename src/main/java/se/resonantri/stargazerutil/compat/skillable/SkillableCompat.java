package se.resonantri.stargazerutil.compat.skillable;

import net.minecraftforge.common.MinecraftForge;
import se.resonantri.stargazerutil.compat.CompatModule;
import se.resonantri.stargazerutil.compat.skillable.traits.basetraits.mining.SkillMiningAddon;
import se.resonantri.stargazerutil.compat.skillable.traits.customtraits.alchemy.SkillAlchemy;
import se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.Skillable;
import vazkii.skillable.skill.Skills;

public class SkillableCompat extends CompatModule {

    public static SkillMiningAddon skillMiningAddon;

    @Override
    public void preInit() {
        skillMiningAddon = new SkillMiningAddon();
    }

    @Override
    public void init() {
        if (Skillable.Alchemy) {
            Skills.registerSkill("alchemy", new SkillAlchemy());
        }
        MinecraftForge.EVENT_BUS.register(new SkillMiningAddon());
    }

    @Override
    public void postInit() {

    }

    @Override
    public void loadComplete() {

    }
}
