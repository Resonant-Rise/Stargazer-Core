package se.resonantri.stargazerutil.compat.tinkers.materials;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import se.resonantri.stargazerutil.compat.CompatModule;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.materials.*;

import static slimeknights.tconstruct.library.utils.HarvestLevels.IRON;
import static slimeknights.tconstruct.tools.TinkerTraits.lightweight;

public class TechRebornMaterials extends CompatModule {
    public static final Material carbonMesh = new Material("carbonmesh", 0x262626);

    @Override
    public void preInit() {
        // Carbon Mesh
        TinkerRegistry.addMaterialStats(carbonMesh,
                new HeadMaterialStats(125, 9.00f, 3.00f, IRON),
                new HandleMaterialStats(1.75f, 275),
                new ExtraMaterialStats(50));
        TinkerRegistry.addMaterialStats(carbonMesh,
                new BowMaterialStats(1.85f, 1.50f, 6.50f));
        TinkerRegistry.integrate(carbonMesh).preInit();
    }

    @Override
    public void init() {
        // Carbon Mesh
        carbonMesh.setCraftable(true);
        carbonMesh.addItem(new ItemStack(Item.getByNameOrId("techreborn:part"), 1, 35), 1, Material.VALUE_Fragment);
        carbonMesh.addItem(new ItemStack(Item.getByNameOrId("techreborn:part"), 1, 34), 1, Material.VALUE_Shard);
        carbonMesh.addItem(new ItemStack(Item.getByNameOrId("techreborn:plates"), 1, 2), 1, Material.VALUE_Ingot);
        carbonMesh.setRepresentativeItem(new ItemStack(Item.getByNameOrId("techreborn:part"), 1, 34));
        carbonMesh.addTrait(lightweight);
    }

    @Override
    public void postInit() {

    }

    @Override
    public void clientPostInit() {
        carbonMesh.setRenderInfo(new MaterialRenderInfo.Metal(0x262626, 0.1f, 0.2f, 0f));
    }
}
