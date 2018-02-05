package se.resonantri.stargazerutil.compat.tinkers.materials;

import com.google.common.collect.Lists;
import se.resonantri.stargazerutil.compat.CompatModule;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;

import java.util.List;

import static se.resonantri.stargazerutil.compat.tinkers.CustomTraits.buttery;
import static se.resonantri.stargazerutil.compat.tinkers.CustomTraits.infernal;
import static slimeknights.tconstruct.library.materials.MaterialTypes.HEAD;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;
import static slimeknights.tconstruct.tools.TinkerTraits.*;

public final class BWMMaterials extends CompatModule {
    public static final List<Material> materials = Lists.newArrayList();

    public static final Material concHellfire = new Material("concentrated_hellfire", 0x990000);
    public static final Material diamond = new Material("diamond", 0x19C9C9);
    public static final Material soulsteel = new Material("soulsteel", 0x374545);
    public static final Material tallow = new Material("tallow", 0xF6CB4C);

    @Override
    public void preInit() {
        TinkerRegistry.addMaterialStats(tallow,
                new HeadMaterialStats(16, 9.0f, 1.0f, STONE),
                new HandleMaterialStats(0.1f, 0),
                new ExtraMaterialStats(0));
        TinkerRegistry.integrate(tallow, "tallow");

        TinkerRegistry.addMaterialStats(concHellfire,
                new HeadMaterialStats(550, 4.8f, 6.0f, IRON),
                new HandleMaterialStats(1.0f, -200),
                new ExtraMaterialStats(100));
        TinkerRegistry.integrate(concHellfire, "ingotConcentratedHellfire, dustHellfire");

        TinkerRegistry.addMaterialStats(diamond,
                new HeadMaterialStats(1000, 7.0f, 7.1f, OBSIDIAN),
                new HandleMaterialStats(0.5f, 1000),
                new ExtraMaterialStats(300));
        TinkerRegistry.integrate(diamond, "ingotDiamond");

        TinkerRegistry.addMaterialStats(soulsteel,
                new HeadMaterialStats(600, 7.0f, 8.1f, COBALT),
                new HandleMaterialStats(1.0f, 100),
                new ExtraMaterialStats(30));
        TinkerRegistry.integrate(soulsteel, "ingotSoulforgedSteel");
    }

    @Override
    public void init() {
        // Concentrated Hellfire
        concHellfire.setCraftable(true);
        concHellfire.addItem("dustHellfire", 1, Material.VALUE_Shard);
        concHellfire.addItem("ingotConcentratedHellfire", 1, Material.VALUE_Ingot);
        concHellfire.setRepresentativeItem("ingotConcentratedHellfire");
        concHellfire.addTrait(autosmelt, HEAD);
        concHellfire.addTrait(infernal, HEAD);

        // Diamond Ingot
        diamond.setCraftable(true);
        diamond.addItem("ingotDiamond", 1, Material.VALUE_Ingot);
        diamond.setRepresentativeItem("ingotDiamond");
        diamond.addTrait(duritos, HEAD);

        // Soulforged Steel
        soulsteel.setCraftable(true);
        soulsteel.addItem("ingotSoulforgedSteel", 1, Material.VALUE_Ingot);
        soulsteel.setRepresentativeItem("ingotSoulforgedSteel");
        soulsteel.addTrait(unnatural, HEAD);
        soulsteel.addTrait(sharp);

        // Tallow
        tallow.setCraftable(true);
        tallow.addItem("tallow", 1, Material.VALUE_Ingot);
        tallow.setRepresentativeItem("tallow");
        tallow.addTrait(buttery);
    }

    @Override
    public void postInit() {

    }

    @Override
    public void loadComplete() {

    }

    @Override
    public void clientPostInit() {
        concHellfire.setRenderInfo(new MaterialRenderInfo.Metal(0x990000, 0.1f, 0.2f, 0f));
        diamond.setRenderInfo(new MaterialRenderInfo.Metal(0x19C9C9, 0.1f, 0.2f, 0f));
        soulsteel.setRenderInfo(new MaterialRenderInfo.Metal(0x374545, 0.1f, 0.2f, 0f));
        tallow.setRenderInfo(new MaterialRenderInfo.Metal(0xF6CB4C, 0.1f, 0.2f, 0f));
    }
}
