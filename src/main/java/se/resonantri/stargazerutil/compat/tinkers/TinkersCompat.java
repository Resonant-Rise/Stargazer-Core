package se.resonantri.stargazerutil.compat.tinkers;

import crafttweaker.mc1120.commands.CTChatCommand;
import se.resonantri.stargazerutil.compat.tinkers.commands.ModifierDumpCommand;
import se.resonantri.stargazerutil.utils.StargazerConfig;

import static se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.TinkersConstruct.ModifierDump;

public class TinkersCompat {
    public static void setup(){

    }

    public static void registerCommands(){
        if (ModifierDump){
            CTChatCommand.registerCommand(new ModifierDumpCommand());
        }
    }
}
