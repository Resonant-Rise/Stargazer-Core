package se.resonantri.stargazerutil.utils;

import com.google.common.collect.Maps;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import se.resonantri.stargazerutil.compat.CompatModule;
import slimeknights.mantle.pulsar.config.ForgeCFG;

import java.util.Map;

public class StargazerConfig {

    public static ForgeCFG pulseConfig = new ForgeCFG("StargazerTinkerModules", "Modules");

    public static void postInit(FMLPostInitializationEvent e) {

    }

    @Config(modid = Constants.MODID)
    public static class StargazerConfigs {
        public static Modules modules;
        public static BetterQuesting betterQuesting;
        public static GameStages gameStages;
        public static ImmersiveEngineering immersiveEngineering;
        public static Skillable skillable;

        public static class Modules {
            @Comment({"A list of all mods that SG:U has integrated compatability for", "Setting any of these to false disables the respective compat"})
            public static Map<String, Boolean> compat = Maps.newHashMap(Maps.toMap(CompatModule.moduleClasses.keySet(), (s) -> Boolean.TRUE));
        }

        public static class BetterQuesting {
            @Comment("Enable GameStage Tasks/Rewards")
            public static boolean GSTasksRewards = true;

            @Comment("Enable Skillable Tasks/Rewards")
            public static boolean SkillableTasksRewards = true;

            @Comment("Enable Tinker's Construct Tasks/Rewards")
            public static boolean TiCoTasksRewards = true;
        }

        public static class GameStages {

        }

        public static class ImmersiveEngineering {
            @Comment("Enable IEMultiBlock Support for Skills")
            public static boolean IESkills = true;
        }

        public static class Skillable {
            @Comment("Enable Alchemy Skill")
            public static boolean Alchemy = true;

            @Comment("Enable 'Lucky Miner' Trait")
            public static boolean LuckyMiner = true;

            @Comment("Lucky Miner Trait Cost")
            public static int LuckyMinerCost = 2;

            @Comment("Enable 'Accelerated' Trait")
            public static boolean Accelerated = true;

            @Comment("Accelerated Trait Cost")
            public static int AcceleratedCost = 2;
        }

        public static class TinkersConstruct {
            @Comment("Enable Modifier Dump")
            public static boolean ModifierDump = true;
        }
    }
}