package se.resonantri.stargazerutil.compat.aquamunda.cuttingboard;

import com.blamejared.mtlib.helpers.LogHelper;
import com.blamejared.mtlib.utils.BaseAction;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.CraftTweaker;
import mcjty.aquamunda.recipes.CuttingBoardRecipe;
import mcjty.aquamunda.recipes.CuttingBoardRecipeRepository;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("aquamunda")
@ZenClass("mods.stargazerutil.CuttingBoard")
@ZenRegister
public class CuttingBoardTweaker {
    @ZenMethod
    public static void addRecipe(IItemStack[] inputs, IItemStack output, int chopTime, boolean useRoller){
        if (inputs.length > 3){
            CraftTweakerAPI.logError("Itemstack Inputs Array Can Not Be Bigger Than 3 Items!");
            return;
        }
        if (inputs == null || inputs.length < 0){
            CraftTweakerAPI.logError("Itemstack Inputs Array Can Not Be Less Than 1 Item or Null!");
            return;
        }
        if (output == null || output.isEmpty()){
            CraftTweakerAPI.logError("Output ItemStack Is Empty!");
            return;
        }
        if (chopTime <= 0){
            CraftTweakerAPI.logError("Chop Time Can Not Be Lower Than 1!");
            return;
        }
        ItemStack[] realItemInputs = new ItemStack[inputs.length];
        for (int x = 0; x < realItemInputs.length; x++){
            IItemStack itemStack = inputs[x];
            if (itemStack == null){
                CraftTweakerAPI.logError("Found Null ItemStack In CuttingBoard Recipe");
            } else {
                realItemInputs[x] = CraftTweakerMC.getItemStack(inputs[x]);
            }
        }
        ItemStack realOutput = CraftTweakerMC.getItemStack(output);
        CraftTweaker.LATE_ACTIONS.add(new Add(realItemInputs, realOutput, chopTime, useRoller));
    }

    private static class Add extends BaseAction {
        ItemStack[] inputs;
        ItemStack output;
        int chopTime;
        boolean useRoller;

        public Add(ItemStack[] inputs, ItemStack output, int chopTime, boolean useRoller) {
            super("Cutting Board");
            this.inputs = inputs;
            this.output = output;
            this.chopTime = chopTime;
            if (chopTime <= 0){
                this.chopTime = 1;
            }
            this.useRoller = useRoller;
        }

        @Override
        public void apply() {
            CuttingBoardRecipe cuttingBoardRecipe = new CuttingBoardRecipe(inputs[0], inputs[1], inputs[2], output, chopTime, useRoller);
            CuttingBoardRecipeRepository.addRecipe(cuttingBoardRecipe);
        }

        @Override
        protected String getRecipeInfo() {
            return LogHelper.getStackDescription(output);
        }
    }
}