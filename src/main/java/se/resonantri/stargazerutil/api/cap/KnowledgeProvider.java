package se.resonantri.stargazerutil.api.cap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static se.resonantri.stargazerutil.api.cap.KnowledgeCapabilities.CAPABILITY_KNOWLEDGE;

public class KnowledgeProvider implements ICapabilitySerializable<NBTTagCompound> {

    IKnowledgeHandler instance = CAPABILITY_KNOWLEDGE.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CAPABILITY_KNOWLEDGE;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return hasCapability(capability, facing) ? CAPABILITY_KNOWLEDGE.<T>cast(instance) : null;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        return (NBTTagCompound) CAPABILITY_KNOWLEDGE.getStorage().writeNBT(CAPABILITY_KNOWLEDGE, instance, null);
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        CAPABILITY_KNOWLEDGE.getStorage().readNBT(CAPABILITY_KNOWLEDGE, instance, null, nbt);
    }
}
