package se.resonantri.stargazerutil.compat.betterquesting;

import betterquesting.api.api.IQuestExpansion;
import se.resonantri.stargazerutil.StargazerUtil;

public class SGU_Expansion implements IQuestExpansion {
    @Override
    public void loadExpansion() {
        StargazerUtil.proxy.registerExpansion();
    }
}
