package se.resonantri.stargazerutil.compat.betterquesting.tasks.gamestages.getgamestage;

import betterquesting.api.api.ApiReference;
import betterquesting.api.api.QuestingAPI;
import betterquesting.api.client.gui.misc.IGuiEmbedded;
import betterquesting.api.enums.EnumSaveType;
import betterquesting.api.jdoc.IJsonDoc;
import betterquesting.api.properties.NativeProps;
import betterquesting.api.questing.IQuest;
import betterquesting.api.questing.tasks.IProgression;
import betterquesting.api.questing.tasks.ITask;
import betterquesting.api.questing.tasks.ITickableTask;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Level;
import se.resonantri.stargazerutil.StargazerUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static net.darkhax.gamestages.capabilities.PlayerDataHandler.getStageData;

public class TaskGetGameStage implements ITask, IProgression<Boolean>, ITickableTask {
    private ArrayList<UUID> completeUsers = new ArrayList<>();
    public final HashMap<UUID, Boolean> userProgress = new HashMap<UUID, Boolean>();
    public String targetGameStage = "test";

    public void getGameStage(@Nonnull EntityPlayer player) {
        if (!isComplete(player.getUniqueID())) {
            if (getStageData(player).hasUnlockedStage(targetGameStage)) {
                this.setComplete(player.getUniqueID());
            }
        }
    }

    @Override
    public void setUserProgress(UUID uuid, Boolean progress) {
        userProgress.put(uuid, progress);
    }

    @Override
    public Boolean getUsersProgress(UUID... uuids) {
        for (UUID uuid : uuids){
            Boolean n = userProgress.get(uuid);
            if (n){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean getGlobalProgress() {
        for (Boolean value : userProgress.values()){
            if (value){
                return true;
            }
        }
        return false;
    }

    @Override
    public float getParticipation(UUID uuid) {
        return 0;
    }

    @Override
    public String getUnlocalisedName() {
        return "stargazerutil.task.gamestage";
    }

    @Override
    public ResourceLocation getFactoryID() {
        return TaskGetGameStageFactory.INSTANCE.getRegistryName();
    }

    @Override
    public void detect(EntityPlayer player, IQuest iQuest) {
        UUID playerID = QuestingAPI.getQuestingUUID(player);
        if (isComplete(playerID)){
            return;
        }
        String targetStage = targetGameStage;
        if (getStageData(player).hasUnlockedStage(targetStage)){
            setComplete(playerID);
        }
    }

    @Override
    public boolean isComplete(UUID uuid) {
        return completeUsers.contains(uuid);
    }

    @Override
    public void setComplete(UUID uuid) {
        if (!completeUsers.contains(uuid)){
            completeUsers.add(uuid);
        }
    }

    @Override
    public void resetUser(UUID uuid) {
        completeUsers.remove(uuid);
        userProgress.remove(uuid);
    }

    @Override
    public void resetAll() {
        completeUsers.clear();
        userProgress.clear();
    }

    @Override
    public IJsonDoc getDocumentation() {
        return null;
    }

    @Override
    public IGuiEmbedded getTaskGui(int i, int i1, int i2, int i3, IQuest iQuest) {
        return null;
    }

    @Nullable
    @Override
    public GuiScreen getTaskEditor(GuiScreen guiScreen, IQuest iQuest) {
        return null;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound, EnumSaveType enumSaveType) {
        if (enumSaveType == EnumSaveType.PROGRESS){
            this.writeProgressToJson(compound);
        } else if (enumSaveType != EnumSaveType.CONFIG){
            return compound;
        }
        compound.setString("gamestage", targetGameStage);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound, EnumSaveType enumSaveType) {
        if (enumSaveType == EnumSaveType.PROGRESS){
            this.readProgressFromJson(compound);
        } else if (enumSaveType != EnumSaveType.CONFIG){
            return;
        }
        targetGameStage = compound.getString("gamestage");
    }

    public void readProgressFromJson(NBTTagCompound json){
        completeUsers = new ArrayList<UUID>();
        NBTTagList cList = json.getTagList("completedUsers", 8);
        for (int i = 0; i < cList.tagCount(); i++){
            NBTBase entry = cList.get(i);
            if (entry == null || entry.getId() != 8){
                continue;
            }

            try {
                completeUsers.add(UUID.fromString(((NBTTagString)entry).getString()));
            } catch (Exception e){
                StargazerUtil.logger.log(Level.ERROR, "Unable to load UUID for Task", e);
            }
        }
        userProgress.clear();
        NBTTagList pList = json.getTagList("userProgresss", 10);
        for (int i = 0; i < pList.tagCount(); i++){
            NBTBase entry = pList.get(i);
            if (entry == null || entry.getId() != 10){
                continue;
            }
            NBTTagCompound pTag = (NBTTagCompound)entry;
            UUID uuid;
            try {
                uuid = UUID.fromString(pTag.getString("uuid"));
            } catch (Exception e){
                StargazerUtil.logger.log(Level.ERROR, "Unable to load user progress from Task", e);
                continue;
            }
            userProgress.put(uuid, pTag.getBoolean("value"));
        }
    }

    public NBTTagCompound writeProgressToJson(NBTTagCompound json)
    {
        NBTTagList jArray = new NBTTagList();
        for(UUID uuid : completeUsers)
        {
            jArray.appendTag(new NBTTagString(uuid.toString()));
        }
        json.setTag("completeUsers", jArray);

        NBTTagList progArray = new NBTTagList();
        for(Map.Entry<UUID,Boolean> entry : userProgress.entrySet())
        {
            NBTTagCompound pJson = new NBTTagCompound();
            pJson.setString("uuid", entry.getKey().toString());
            pJson.setBoolean("value", entry.getValue());
            progArray.appendTag(pJson);
        }
        json.setTag("userProgress", progArray);

        return json;
    }

    @Override
    public void updateTask(EntityPlayer entityPlayer, IQuest iQuest) {
        UUID playerId = QuestingAPI.getQuestingUUID(entityPlayer);
        if (entityPlayer.ticksExisted%60 == 0 && !QuestingAPI.getAPI(ApiReference.SETTINGS).getProperty(NativeProps.EDIT_MODE)){
            if (!getStageData(entityPlayer).hasUnlockedStage(targetGameStage)){
                setUserProgress(playerId, getStageData(entityPlayer).hasUnlockedStage(targetGameStage));
            }
            if (getStageData(entityPlayer).hasUnlockedStage(targetGameStage)){
                setComplete(playerId);
            }
        }
    }
}
