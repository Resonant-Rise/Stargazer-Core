package se.resonantri.stargazercore.utils;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import se.resonantri.stargazercore.StargazerCore;

public class StargazerConfig {
    public static void preInit(FMLPreInitializationEvent e){

    }

    @Config(modid = StargazerCore.MODID)
    public static class StargazerConfigs{
        public static Modules modules;
        public static BetterQuesting betterQuesting;
        public static GameStages gameStages;
        public static Skillable skillable;
        public TinkersConstruct tinkersConstruct;

        public static class Modules{
            @Comment("Enable Botania Moduel")
            public static boolean BotaniaModule = true;

            @Comment("Enable Tinker's Module")
            public static boolean TinkersModule = true;

            @Comment("Enable GameStage Module")
            public static boolean GameStageModule = true;

            @Comment("Enable Skillable Module")
            public static boolean SkillableModule = true;

            @Comment("Enable BetterQuesting Module")
            public static boolean BQModule = true;
        }

        public static class BetterQuesting{
            @Comment("Enable GameStage Tasks/Rewards")
            public static boolean GSTasksRewards = true;

            @Comment("Enable Skillable Tasks/Rewards")
            public static boolean SkillableTasksRewards = true;

            @Comment("Enable Tinker's Construct Tasks/Rewards")
            public static boolean TiCoTasksRewards = true;
        }

        public static class GameStages{

        }

        public static class Skillable{

        }

        public static class TinkersConstruct{
            @Comment("Enable Modifier Dump")
            public static boolean ModifierDump = true;
        }
    }

}
