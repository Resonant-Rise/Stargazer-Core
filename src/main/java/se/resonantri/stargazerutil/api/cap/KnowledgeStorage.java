package se.resonantri.stargazerutil.api.cap;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class KnowledgeStorage implements Capability.IStorage<IKnowledgeHandler> {

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IKnowledgeHandler> capability, IKnowledgeHandler instance, EnumFacing side) {
        final NBTTagList compound = new NBTTagList();
        return compound;
    }

    @Override
    public void readNBT(Capability<IKnowledgeHandler> capability, IKnowledgeHandler instance, EnumFacing side, NBTBase nbt) {
        final NBTTagCompound compound = (NBTTagCompound) nbt;
        instance.addString(compound.getString("knowledge"));
    }
}
