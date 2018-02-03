package se.resonantri.stargazerutil.compat.tinkers.materials;

import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;

import java.util.List;

import static se.resonantri.stargazerutil.compat.tinkers.CustomTraits.starascribed1;
import static se.resonantri.stargazerutil.compat.tinkers.CustomTraits.starascribed2;
import static slimeknights.tconstruct.library.materials.MaterialTypes.HANDLE;
import static slimeknights.tconstruct.library.materials.MaterialTypes.HEAD;
import static slimeknights.tconstruct.library.utils.HarvestLevels.DIAMOND;
import static slimeknights.tconstruct.library.utils.HarvestLevels.IRON;
import static slimeknights.tconstruct.tools.TinkerTraits.*;

public class AssortedMaterials {
    public static final List<Material> materials = Lists.newArrayList();

    public static final Material starmetal         = mat("starmetal", 0x000099);
    public static final Material carbonMesh        = mat("carbonmesh", 0x262626);

    private static Material mat(String name, int color){
        Material mat = new Material(name, color, true);
        materials.add(mat);
        return mat;
    }

    @Subscribe
    public void setupMaterialStats(FMLPreInitializationEvent event){
        registerToolMaterialStats();
        registerBowMaterialStats();
    }

    @Subscribe
    public void setupMaterials(FMLInitializationEvent event){
        // Starmetal
        starmetal.setCraftable(true);
        starmetal.addItem("ingotAstralStarmetal", 1, Material.VALUE_Ingot);
        starmetal.setRepresentativeItem("ingotAstralStarmetal");
        starmetal.addTrait(starascribed2, HEAD);
        starmetal.addTrait(starascribed1, HANDLE);
        starmetal.addTrait(sharp, HEAD);

        // Carbon Mesh
        carbonMesh.setCraftable(true);
        carbonMesh.addItem(new ItemStack(Item.getByNameOrId("techreborn:part"), 1, 34), 1, Material.VALUE_Shard);
        carbonMesh.setRepresentativeItem(new ItemStack(Item.getByNameOrId("techreborn:part"), 1, 34));
        carbonMesh.addTrait(lightweight);
    }

    public void registerToolMaterialStats(){
        // Starmetal
        TinkerRegistry.addMaterialStats(starmetal,
                new HeadMaterialStats(204, 6.00f, 4.00f, DIAMOND),
                new HandleMaterialStats(0.85f,60),
                new ExtraMaterialStats(50)
                );

        // Carbon Mesh
        TinkerRegistry.addMaterialStats(carbonMesh,
                new HeadMaterialStats(125, 9.00f, 3.00f, IRON),
                new HandleMaterialStats(1.75f,275),
                new ExtraMaterialStats(50)
                );
    }

    public void registerBowMaterialStats(){
        // Carbon Mesh
        TinkerRegistry.addMaterialStats(carbonMesh,
                new BowMaterialStats(1.85f, 1.50f, 6.50f)
                );
        }
}
