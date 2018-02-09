package se.resonantri.stargazerutil.common.items;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import se.resonantri.stargazerutil.common.items.ResearchSystem.ItemResearch;
import se.resonantri.stargazerutil.common.items.ResearchSystem.ItemTheorem;
import se.resonantri.stargazerutil.common.items.ResearchSystem.manuscripts.ItemManuscriptAboriculture;
import se.resonantri.stargazerutil.common.items.ResearchSystem.manuscripts.ItemManuscriptAgriculture;
import se.resonantri.stargazerutil.common.items.ResearchSystem.manuscripts.ItemManuscriptAtlas;
import se.resonantri.stargazerutil.common.items.ResearchSystem.manuscripts.ItemManuscriptHusbandry;

public class ModItems {

    @ObjectHolder("stargazerutil:itemquill")
    public static ItemQuill itemQuill;

    @ObjectHolder("stargazerutil:iteminkwell")
    public static ItemInkwell itemInkwell;

    @ObjectHolder("stargazerutil:itemparchment")
    public static ItemParchment itemParchment;

    @ObjectHolder("stargazerutil:itemresearch")
    public static ItemResearch itemResearch;

    @ObjectHolder("stargazerutil:itemtheorem")
    public static ItemTheorem itemTheorem;

    @ObjectHolder("stargazerutil:itemaboriculture")
    public static ItemManuscriptAboriculture manuscriptAboriculture;

    @ObjectHolder("stargazerutil:itemagriculture")
    public static ItemManuscriptAgriculture manuscriptAgriculture;

    @ObjectHolder("stargazerutil:itematlas")
    public static ItemManuscriptAtlas manuscriptAtlas;

    @ObjectHolder("stargazerutil:itemhusbandry")
    public static ItemManuscriptHusbandry manuscriptHusbandry;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        itemQuill.initModel();
        itemInkwell.initModel();
        itemParchment.initModel();
        itemResearch.initModel();
        itemTheorem.initModel();
        manuscriptAboriculture.initModel();
        manuscriptAgriculture.initModel();
        manuscriptAtlas.initModel();
        manuscriptHusbandry.initModel();
    }
}
