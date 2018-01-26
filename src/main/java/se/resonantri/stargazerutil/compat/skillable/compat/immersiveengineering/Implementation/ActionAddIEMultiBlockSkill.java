package se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.Implementation;

import se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.ActionAddMultiBlockSkills;
import se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.MultiBlockSkill;

public class ActionAddIEMultiBlockSkill extends ActionAddMultiBlockSkills {

    public ActionAddIEMultiBlockSkill(String[] reqSkills, String multiBlockName) {
        super(reqSkills, multiBlockName);
    }

    public ActionAddIEMultiBlockSkill(String[] reqSkills, String multiBlockName, String failureMessage) {
        super(reqSkills, multiBlockName, failureMessage);
    }

    @Override
    public void addToHandler(MultiBlockSkill multiBlockStage) {

    }
}
