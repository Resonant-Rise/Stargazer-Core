package se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering;

import blusunrize.immersiveengineering.api.MultiblockHandler;
import crafttweaker.mc1120.commands.CTChatCommand;
import net.minecraftforge.common.MinecraftForge;
import se.resonantri.stargazerutil.compat.CompatModule;
import se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.Implementation.IEMultiBlockHandler;

import java.util.List;
import java.util.stream.Collectors;

import static se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.ImmersiveEngineering.IESkills;

public class ImmersiveEngineeringCompat extends CompatModule {
    private static IEMultiBlockHandler multiBlockHandler;

    public static void addMultiBlockSkill(MultiBlockSkill multiBlockSkill) {
        multiBlockHandler.addMultiBlockSkill(multiBlockSkill);
    }

    @Override
    public void preInit() {
        if (IESkills) {
            multiBlockHandler = new IEMultiBlockHandler();
            MinecraftForge.EVENT_BUS.register(multiBlockHandler);
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void postInit() {

    }

    @Override
    public void loadComplete() {
        if (IESkills) {
            CTChatCommand.registerCommand(
                    new MultiBlockCommand("ie") {
                        @Override
                        public List<String> getMultiBlockNames() {
                            return MultiblockHandler
                                    .getMultiblocks().stream()
                                    .map(MultiblockHandler.IMultiblock::getUniqueName)
                                    .collect(Collectors.toList());
                        }
                    }
            );
        }
    }
}
