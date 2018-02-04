package se.resonantri.stargazerutil.compat.tinkers.materials;

import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.mantle.pulsar.pulse.Pulse;
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

@Pulse(id = BWMMaterials.PulseId, description = "All the tool materials added by StargazerUtils", pulsesRequired = BWMMaterials.PulseId, forced = true)
public final class BWMMaterials {
    static final String PulseId = "AssortedMaterials";

    final boolean isBWMLoaded = Loader.isModLoaded("betterwithmods");

    public static final List<Material> materials = Lists.newArrayList();

    public static final Material concHellfire   = mat("concentrated_hellfire", 0x990000);
    public static final Material diamond        = mat("diamond", 0x19C9C9);
    public static final Material soulsteel      = mat("soulsteel", 0x374545);
    public static final Material tallow         = mat("tallow", 0xF6CB4C);

    private static Material mat(String name, int color){
        Material mat = new Material(name, color, true);
        materials.add(mat);
        return mat;
    }


    //////////////////////
    ///     PreInit    ///
    //////////////////////
    @Subscribe
    public void setupMaterialStats(FMLPreInitializationEvent event){
        registerToolMaterialStats();
    }

    private void registerToolMaterialStats(){
        if (isBWMLoaded){
            TinkerRegistry.addMaterialStats(tallow,
                    new HeadMaterialStats(16, 9.0f, 1.0f, STONE),
                    new HandleMaterialStats(0.1f,0),
                    new ExtraMaterialStats(0)
            );

            TinkerRegistry.addMaterialStats(concHellfire,
                    new HeadMaterialStats(550, 4.8f, 6.0f, IRON),
                    new HandleMaterialStats(1.0f, -200),
                    new ExtraMaterialStats(100)
            );

            TinkerRegistry.addMaterialStats(diamond,
                    new HeadMaterialStats(1000, 7.0f, 7.1f, OBSIDIAN),
                    new HandleMaterialStats(0.5f, 1000),
                    new ExtraMaterialStats(300)
            );

            TinkerRegistry.addMaterialStats(soulsteel,
                    new HeadMaterialStats(600, 7.0f, 8.1f, COBALT),
                    new HandleMaterialStats(1.0f, 100),
                    new ExtraMaterialStats(30)
            );
        }
    }


    //////////////////////
    ///     Init       ///
    //////////////////////
    @Subscribe
    public void setupMaterials(FMLInitializationEvent event){
        if (isBWMLoaded){
            // Tallow
            tallow.setCraftable(true);
            tallow.addItem("tallow", 1, Material.VALUE_Ingot);
            tallow.setRepresentativeItem("tallow");
            tallow.addTrait(buttery);

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
        }
    }


    //////////////////////
    ///     PostInit   ///
    //////////////////////
    @Subscribe
    public static void setupClientPostInit(FMLPostInitializationEvent event){
        concHellfire.setRenderInfo(new MaterialRenderInfo.Metal(0x990000, 0.1f, 0.2f, 0f));
        diamond.setRenderInfo(new MaterialRenderInfo.Metal(0x19C9C9, 0.1f, 0.2f, 0f));
        soulsteel.setRenderInfo(new MaterialRenderInfo.Metal(0x374545, 0.1f, 0.2f, 0f));
        tallow.setRenderInfo(new MaterialRenderInfo.Metal(0xF6CB4C, 0.1f, 0.2f, 0f));
    }
}
