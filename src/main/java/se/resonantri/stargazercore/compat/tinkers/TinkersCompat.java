package se.resonantri.stargazercore.compat.tinkers;

import crafttweaker.mc1120.commands.CTChatCommand;
import se.resonantri.stargazercore.compat.tinkers.commands.ModifierDumpCommand;

public class TinkersCompat {
    public static void setup(){

    }

    public static void registerCommands(){
        CTChatCommand.registerCommand(new ModifierDumpCommand());
    }
}
