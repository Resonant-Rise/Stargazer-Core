package se.resonantri.stargazerutil.compat.tinkers;

import com.google.common.eventbus.Subscribe;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import se.resonantri.stargazerutil.compat.tinkers.materials.AssortedMaterials;
import se.resonantri.stargazerutil.compat.tinkers.materials.BWMMaterials;
import slimeknights.mantle.pulsar.pulse.Pulse;
import slimeknights.tconstruct.common.TinkerPulse;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;

import static se.resonantri.stargazerutil.compat.tinkers.materials.AssortedMaterials.carbonMesh;
import static se.resonantri.stargazerutil.compat.tinkers.materials.AssortedMaterials.starmetal;
import static se.resonantri.stargazerutil.compat.tinkers.materials.BWMMaterials.*;

@Pulse(id = "TinkersCompatSG", forced = true)
public class SGTinkersIntegration extends TinkerPulse{

    @Subscribe
    public static void preInit(FMLPreInitializationEvent event){
        //Assorted Materials
        integrate(carbonMesh);
        integrate(starmetal);

        //BWM Materials
        integrate(concHellfire);
        integrate(diamond);
        integrate(soulsteel);
        integrate(tallow);
    }

    @Subscribe
    public static void postInit(FMLPostInitializationEvent event){
        AssortedMaterials.setupClientPostInit(event);
        BWMMaterials.setupClientPostInit(event);
    }

    private static MaterialIntegration integrate(Material material) {
        return add(new MaterialIntegration(material));
    }

    private static MaterialIntegration integrate(Material material, String oreRequirement) {
        MaterialIntegration materialIntegration = new MaterialIntegration(oreRequirement, material, null, null);
        materialIntegration.setRepresentativeItem(oreRequirement);
        return add(materialIntegration);
    }

    private static MaterialIntegration add(MaterialIntegration integration) {
        return TinkerRegistry.integrate(integration);
    }
}
