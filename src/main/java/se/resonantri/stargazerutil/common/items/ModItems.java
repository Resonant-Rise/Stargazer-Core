package se.resonantri.stargazerutil.common.items;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    @ObjectHolder("stargazerutil:itemquill")
    public static ItemQuill itemQuill;

    @ObjectHolder("stargazerutil:iteminkwell")
    public static ItemInkwell itemInkwell;

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        itemQuill.initModel();
        itemInkwell.initModel();
    }
}
