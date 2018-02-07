package se.resonantri.stargazerutil.common.items;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import se.resonantri.stargazerutil.common.items.ResearchSystem.ItemManuscript;
import se.resonantri.stargazerutil.common.items.ResearchSystem.ItemResearch;
import se.resonantri.stargazerutil.common.items.ResearchSystem.ItemTheorem;

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

    @ObjectHolder("stargazerutil:itemmanuscript")
    public static ItemManuscript itemManuscript;


    @SideOnly(Side.CLIENT)
    public static void initModels(){
        itemQuill.initModel();
        itemInkwell.initModel();
        itemParchment.initModel();
        itemResearch.initModel();
        itemTheorem.initModel();
        itemManuscript.initModel();
    }
}
