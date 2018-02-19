package se.resonantri.stargazerutil.api.cap;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class KnowledgeCapabilities {
    @CapabilityInject(IKnowledgeHandler.class)
    public static final Capability<IKnowledgeHandler> CAPABILITY_KNOWLEDGE = null;
}
