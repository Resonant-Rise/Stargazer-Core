package se.resonantri.stargazerutil.common.blocks;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    @ObjectHolder("stargazerutil:scribetable")
    public static BlockScribeTable scribeTable;

    @ObjectHolder("stargazerutil:bookbindingtable")
    public static BlockBookBindingTable bookBindingTable;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        scribeTable.initModel();
        bookBindingTable.initModel();
    }
}
