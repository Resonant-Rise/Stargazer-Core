package se.resonantri.stargazerutil.compat.betterquesting.events;

//import betterquesting.api.questing.IQuest;
//import betterquesting.api.questing.tasks.ITask;
//import betterquesting.questing.QuestDatabase;

//public class GetGameStages {
//    @SubscribeEvent
//    public void onGameStageAdded(GameStageEvent.Added event) {
//        EntityPlayer player = event.getPlayer();
//
//        if (player == null)
//            return;
//
//        for (Map.Entry<TaskG, IQuest> set : getGameStages(player.getUniqueID()).entrySet()) {
//            set.getKey().getGameStage(player);
//        }
//    }
//
//    HashMap<TaskGetGameStage, IQuest> getGameStages(UUID uuid) {
//        HashMap<TaskGetGameStage, IQuest> map = new HashMap<TaskGetGameStage, IQuest>();
//        for (IQuest quest : QuestDatabase.INSTANCE.getAllValues()) {
//            for (ITask task : quest.getTasks().getAllValues()) {
//                if (task instanceof TaskGetGameStage && !task.isComplete(uuid)) {
//                    map.put((TaskGetGameStage) task, quest);
//                }
//            }
//        }
//        return map;
//    }
//}
