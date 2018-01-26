package se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.Implementation;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("immersiveengineering")
@ZenClass("mods.stargazerutils.IEMultiBlockSkills")
public class IEMultiBlockSkills {
    @ZenMethod
    public static void addSkills(String[] skills, String multiBlockName){
        CraftTweakerAPI.apply(new ActionAddIEMultiBlockSkill(skills, multiBlockName));
    }

    @ZenMethod
    public static void addSkills(String[] skills, String multiBlockName, String failureMessage){
        CraftTweakerAPI.apply(new ActionAddIEMultiBlockSkill(skills, multiBlockName, failureMessage));
    }
}
