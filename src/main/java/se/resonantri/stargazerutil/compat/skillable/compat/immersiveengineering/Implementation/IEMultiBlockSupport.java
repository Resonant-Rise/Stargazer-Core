package se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.Implementation;

import blusunrize.immersiveengineering.api.MultiblockHandler;
import crafttweaker.mc1120.commands.CTChatCommand;
import net.minecraftforge.common.MinecraftForge;
import se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.MultiBlockCommand;
import se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.MultiBlockSkill;

import java.util.List;
import java.util.stream.Collectors;

public class IEMultiBlockSupport {
    private static IEMultiBlockHandler multiBlockHandler;

    public static void setup(){
        multiBlockHandler = new IEMultiBlockHandler();
        MinecraftForge.EVENT_BUS.register(multiBlockHandler);
        CTChatCommand.registerCommand(new MultiBlockCommand("ie"){
            @Override
            public List<String> getMultiBlockNames(){
                return MultiblockHandler.getMultiblocks().stream()
                        .map(MultiblockHandler.IMultiblock::getUniqueName)
                        .collect(Collectors.toList());
            }
        });
    }

    public static void addMultiBlockSkill(MultiBlockSkill multiBlockSkill){
        multiBlockHandler.addMultiBlockSkill(multiBlockSkill);
    }
}
