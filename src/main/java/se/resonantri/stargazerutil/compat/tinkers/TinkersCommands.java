package se.resonantri.stargazerutil.compat.tinkers;

import crafttweaker.mc1120.commands.CTChatCommand;
import se.resonantri.stargazerutil.compat.CompatModule;
import se.resonantri.stargazerutil.compat.tinkers.commands.ModifierDumpCommand;

import static se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.TinkersConstruct.ModifierDump;

public class TinkersCommands extends CompatModule {
    @Override
    public void preInit() {

    }

    @Override
    public void init() {

    }

    @Override
    public void postInit() {

    }

    @Override
    public void loadComplete() {
        if (ModifierDump) {
            CTChatCommand.registerCommand(new ModifierDumpCommand());
        }
    }
}
