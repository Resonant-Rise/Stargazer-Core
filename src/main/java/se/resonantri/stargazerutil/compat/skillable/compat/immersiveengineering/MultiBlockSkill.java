package se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering;

public class MultiBlockSkill {
    private final String[] reqSkills;
    private final String multiBlockName;
    private final String failureMessage;

    public MultiBlockSkill(String[] reqSkills, String multiBlockName, String failureMessage) {
        this.reqSkills = reqSkills;
        this.multiBlockName = multiBlockName;
        this.failureMessage = failureMessage;
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
