package se.resonantri.stargazerutil.compat.skillable;

import net.minecraftforge.fml.common.Loader;
import se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.Implementation.IEMultiBlockSupport;

import static se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.Skillable.*;

public class SkillableCompat {
    public static void setup(){
        if (alchemy){

        }

        if (luckyMiner){

        }

        if (accelerated){

        }

        if (Loader.isModLoaded("crafttweaker")){
            if (IESkills){
                IEMultiBlockSupport.setup();
            }
        }

    }
}
