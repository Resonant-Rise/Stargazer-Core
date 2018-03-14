package se.resonantri.stargazerutil.compat.aquamunda.grindstone;

import com.blamejared.mtlib.helpers.LogHelper;
import com.blamejared.mtlib.utils.BaseAction;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.CraftTweaker;
import mcjty.aquamunda.recipes.GrindstoneRecipe;
import mcjty.aquamunda.recipes.GrindstoneRecipeRepository;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("aquamunda")
@ZenClass("mods.stargazerutil.GrindstoneTweaker")
@ZenRegister
public class GrindstoneTweaker{
    @ZenMethod
    public static void addRecipe(IItemStack input, IItemStack output, int grindTime){
        if (input == null || input.isEmpty()){
            CraftTweakerAPI.logError("Input Can Not Be Null Or Empty!");
            return;
        }
        if (output == null || output.isEmpty()){
            CraftTweakerAPI.logError("Output Can Not Be Null Or Empty");
            return;
        }
        if (grindTime <= 0){
            CraftTweakerAPI.logError("Grind Time Can Not Be Lower Than 1!");
            return;
        }
        ItemStack trueInput = CraftTweakerMC.getItemStack(input);
        ItemStack trueOutput = CraftTweakerMC.getItemStack(output);
        CraftTweaker.LATE_ACTIONS.add(new Add(trueInput, trueOutput, grindTime));
    }

    private static class Add extends BaseAction {
        ItemStack input;
        ItemStack output;
        int grindTime;

        protected Add(ItemStack input, ItemStack output, int grindTime) {
            super("Grindstone");
            this.input = input;
            this.output = output;
            this.grindTime = grindTime;
            if (grindTime <= 0){
                this.grindTime = 1;
            }
        }

        @Override
        public void apply() {
            GrindstoneRecipe grindstoneRecipe = new GrindstoneRecipe(input, output, grindTime);
            GrindstoneRecipeRepository.addRecipe(grindstoneRecipe);
        }

        @Override
        protected String getRecipeInfo() {
            return LogHelper.getStackDescription(output);
        }
    }
}
