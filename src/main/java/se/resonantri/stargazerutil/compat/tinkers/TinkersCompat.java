package se.resonantri.stargazerutil.compat.tinkers;

import crafttweaker.mc1120.commands.CTChatCommand;
import se.resonantri.stargazerutil.compat.tinkers.commands.ModifierDumpCommand;
import se.resonantri.stargazerutil.compat.tinkers.materials.AssortedMaterials;
import se.resonantri.stargazerutil.compat.tinkers.materials.BWMMaterials;
import slimeknights.mantle.pulsar.pulse.Pulse;
import slimeknights.tconstruct.common.TinkerPulse;

import static se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.TinkersConstruct.ModifierDump;

public class TinkersCompat extends TinkerPulse{
    public static AssortedMaterials assortedMaterials;
    public static BWMMaterials bwmMaterials;

    public static void setup(){
        assortedMaterials = new AssortedMaterials();
        bwmMaterials = new BWMMaterials();
    }

    public static void registerCommands(){
        if (ModifierDump){
            CTChatCommand.registerCommand(new ModifierDumpCommand());
        }
    }
}
