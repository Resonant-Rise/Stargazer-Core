package se.resonantri.stargazerutil.compat.aquamunda.cooker;

import com.blamejared.mtlib.helpers.LogHelper;
import com.blamejared.mtlib.utils.BaseAction;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.CraftTweaker;
import mcjty.aquamunda.recipes.CookerRecipe;
import mcjty.aquamunda.recipes.CookerRecipeRepository;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import javax.annotation.Nonnull;

@ModOnly("aquamunda")
@ZenClass("mods.stargazerutil.Cooker")
@ZenRegister
public class CookerTweaker {
    @ZenMethod
    public static void addRecipe(IItemStack input, IItemStack output, @Nonnull String outputSoup, int cookTime) {
        if (input == null || input.isEmpty()) {
            CraftTweakerAPI.logError("Input Can Not Be Null");
            return;
        }
        if (output == null || output.isEmpty()) {
            CraftTweakerAPI.logError("Output Can Not Be Null");
            return;
        }
        if (outputSoup.isEmpty()) {
            CraftTweakerAPI.logError("Output Soup Was Empty, This is most likely intentional!");
            return;
        }
        if (cookTime <= 0) {
            CraftTweakerAPI.logError("Cook Time can not be lower than 1!");
            return;
        }
        ItemStack trueInput = CraftTweakerMC.getItemStack(input);
        ItemStack trueOutput = CraftTweakerMC.getItemStack(output);
        CraftTweaker.LATE_ACTIONS.add(new Add(trueInput, trueOutput, outputSoup, cookTime));
    }

    private static class Add extends BaseAction {
        ItemStack input, output;
        String outputSoup;
        int cookTime;

        public Add(ItemStack input, ItemStack output, String outputSoup, int cookTime) {
            super("Cooker");
            this.input = input;
            this.output = output;
            this.outputSoup = outputSoup;
            this.cookTime = cookTime;
            if (cookTime <= 0){
                this.cookTime = 1;
            }
        }

        @Override
        public void apply() {
            CookerRecipe cookerRecipe = new CookerRecipe(input, output, outputSoup, cookTime);
            CookerRecipeRepository.addRecipe(cookerRecipe);
        }

        @Override
        protected String getRecipeInfo() {
            return LogHelper.getStackDescription(output);
        }
    }
}
