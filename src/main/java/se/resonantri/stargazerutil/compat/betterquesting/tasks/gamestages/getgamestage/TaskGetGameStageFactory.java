package se.resonantri.stargazerutil.compat.betterquesting.tasks.gamestages.getgamestage;

import betterquesting.api.enums.EnumSaveType;
import betterquesting.api.misc.IFactory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import se.resonantri.stargazerutil.utils.Constants;

public class TaskGetGameStageFactory implements IFactory<TaskGetGameStage> {

    public static final TaskGetGameStageFactory INSTANCE = new TaskGetGameStageFactory();

    @Override
    public ResourceLocation getRegistryName() {
        return new ResourceLocation(Constants.MODID, "getgamestage");
    }

    @Override
    public TaskGetGameStage createNew() {
        return new TaskGetGameStage();
    }

    @Override
    public TaskGetGameStage loadFromNBT(NBTTagCompound nbtTagCompound) {
        TaskGetGameStage task = new TaskGetGameStage();
        task.writeToNBT(nbtTagCompound, EnumSaveType.CONFIG);
        return task;
    }
}
