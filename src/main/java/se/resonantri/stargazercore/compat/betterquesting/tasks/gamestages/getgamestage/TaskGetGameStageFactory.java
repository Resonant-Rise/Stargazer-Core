package se.resonantri.stargazercore.compat.betterquesting.tasks.gamestages.getgamestage;

import betterquesting.api.enums.EnumSaveType;
import betterquesting.api.misc.IFactory;
import com.google.gson.JsonObject;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import se.resonantri.stargazercore.StargazerCore;

//public class TaskGetGameStageFactory implements IFactory<TaskGetGameStage> {
//
//    @Override
//    public ResourceLocation getRegistryName() {
//        return new ResourceLocation(StargazerCore.MODID, "getgamestage");
//    }
//
//    @Override
//    public TaskGetGameStage createNew() {
//        return new TaskGetGameStage();
//    }
//
//    @Override
//    public TaskGetGameStage loadFromNBT(NBTTagCompound nbtTagCompound) {
//        return null;
//    }
//
//    @Override
//    public TaskGetGameStage loadFromJson(JsonObject json) {
//        TaskGetGameStage task = new TaskGetGameStage();
//        task.readFromJson(json, EnumSaveType.CONFIG);
//        return task;
//    }
//}
