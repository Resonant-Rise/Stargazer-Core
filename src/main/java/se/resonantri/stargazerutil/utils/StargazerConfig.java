package se.resonantri.stargazerutil.utils;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.mantle.pulsar.config.ForgeCFG;

public class StargazerConfig {

    public static ForgeCFG pulseConfig = new ForgeCFG("StargazerTinkerModules", "Modules");

    public static void postInit(FMLPostInitializationEvent e){

    }

    @Config(modid = Constants.MODID)
    public static class StargazerConfigs{
        public static Modules modules;
        public static BetterQuesting betterQuesting;
        public static GameStages gameStages;
        public static Skillable skillable;
        public static TinkersConstruct tinkersConstruct;


        public static class Modules{
            @Comment("Enable BetterQuesting Module")
            public static boolean BQModule = true;

            @Comment("Enable Botania Moduel")
            public static boolean BotaniaModule = true;

            @Comment("Enable Tinker's Module")
            public static boolean TinkersModule = true;

            @Comment("Enable GameStage Module")
            public static boolean GameStageModule = true;

            @Comment("Enable Skillable Module")
            public static boolean SkillableModule = true;
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
            @Comment("Enable IEMultiBlock Support for Skills")
            public static boolean IESkills = true;

            @Comment("Enable Alchemy Skill")
            public static boolean alchemy = true;

            @Comment("Enable 'Lucky Miner' Trait")
            public static boolean luckyMiner = true;

            @Comment("Lucky Miner Trait Cost")
            public static int luckyMinerCost = 2;

            @Comment("Enable 'Accelerated' Trait")
            public static boolean accelerated = true;

            @Comment("Accelerated Trait Cost")
            public static int acceleratedCost = 2;
        }

        public static class TinkersConstruct{
            @Comment("Enable Modifier Dump")
            public static boolean ModifierDump = true;
        }
    }

}
