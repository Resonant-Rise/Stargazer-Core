package se.resonantri.stargazerutil.compat.tinkers.materials;

import se.resonantri.stargazerutil.compat.CompatModule;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;

import static se.resonantri.stargazerutil.compat.tinkers.CustomTraits.starascribed1;
import static se.resonantri.stargazerutil.compat.tinkers.CustomTraits.starascribed2;
import static slimeknights.tconstruct.library.materials.MaterialTypes.*;
import static slimeknights.tconstruct.library.utils.HarvestLevels.DIAMOND;
import static slimeknights.tconstruct.tools.TinkerTraits.sharp;

public class AstralSorceryMaterials extends CompatModule {
    public static final Material starmetal = new Material("starmetal", 0x0f5edd);

    @Override
    public void preInit() {
        // Starmetal
        TinkerRegistry.addMaterialStats(starmetal,
                new HeadMaterialStats(204, 6.00f, 4.00f, DIAMOND),
                new HandleMaterialStats(0.85f, 60),
                new ExtraMaterialStats(50));
        TinkerRegistry.integrate(starmetal, "ingotAstralStarmetal");
    }

    @Override
    public void init() {
        // Starmetal
        starmetal.setCraftable(true);
        starmetal.addItem("ingotAstralStarmetal", 1, Material.VALUE_Ingot);
        starmetal.setRepresentativeItem("ingotAstralStarmetal");
        starmetal.addTrait(starascribed2, HEAD);
        starmetal.addTrait(starascribed1, HANDLE);
        starmetal.addTrait(starascribed1, EXTRA);
        starmetal.addTrait(sharp, HEAD);
    }

    @Override
    public void postInit() {

    }

    @Override
    public void clientPostInit() {
        starmetal.setRenderInfo(new MaterialRenderInfo.Metal(0x0f5edd, 0.1f, 0.2f, 0f));
    }
}
