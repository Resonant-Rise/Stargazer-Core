package se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering;

import com.google.common.base.Strings;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;

public abstract class ActionAddMultiBlockSkills implements IAction {

    private final String[] reqSkills;
    private final String multiBlockName;
    private final String failureMessage;

    public ActionAddMultiBlockSkills(String[] reqSkills, String multiBlockName) {
        this(reqSkills, multiBlockName, "You cannot form this MultiBlock! Further Progression is Required.");
    }

    public ActionAddMultiBlockSkills(String[] reqSkills, String multiBlockName, String failureMessage) {
        this.reqSkills = reqSkills;
        this.multiBlockName = multiBlockName;
        this.failureMessage = failureMessage;
    }

    @Override
    public void apply() {

        if (Strings.isNullOrEmpty(getMultiBlockName())) {
                throw new IllegalArgumentException("MultiBlock Name cannot be Empty");
            } else if (Strings.isNullOrEmpty(getFailureMessage())) {
                throw new IllegalArgumentException("Failure Message cannot be Empty");
            } else if (reqSkills != null){
            for (String strings : reqSkills){
                if (Strings.isNullOrEmpty(strings)){
                    CraftTweakerAPI.logError("Null Value found in Array 'reqSkills'");
                }
            }
        } else {
            CraftTweakerAPI.logError("The Array 'reqSkills' was found to be Null!");
        }
            addToHandler(new MultiBlockSkill(getReqSkills(), getMultiBlockName(), getFailureMessage()));
    }

    public abstract void addToHandler(MultiBlockSkill multiBlockSkill);

    @Override
    public String describe() {
        return "Added Skill Requirements For: " + this.getMultiBlockName() + " || Skills Required: " + this.getReqSkills();
    }

    public String[] getReqSkills() {
        return reqSkills;
    }

    public String getMultiBlockName() {
        return multiBlockName;
    }

    public String getFailureMessage() {
        return failureMessage;
    }
}
