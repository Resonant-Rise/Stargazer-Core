package se.resonantri.stargazerutil.common.blocks;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    @ObjectHolder("stargazerutil:scribing")
    public static BlockScribing blockScribing;

    @ObjectHolder("stargazerutil:binding")
    public static BlockBinding blockBinding;

    @ObjectHolder("stargazerutil:table")
    public static BlockTable blockTable;

    @ObjectHolder("stargazerutil:table_double")
    public static BlockTableDouble blockTableDouble;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockScribing.initModel();
        blockBinding.initModel();
        blockTable.initModel();
        blockTableDouble.initModel();
    }
}
