package se.resonantri.stargazerutil.compat.tinkers;

import com.google.common.eventbus.Subscribe;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;
import slimeknights.mantle.pulsar.pulse.Pulse;
import slimeknights.tconstruct.common.TinkerPulse;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;

import static se.resonantri.stargazerutil.StargazerUtil.logger;
import static se.resonantri.stargazerutil.compat.tinkers.materials.AssortedMaterials.carbonMesh;
import static se.resonantri.stargazerutil.compat.tinkers.materials.AssortedMaterials.starmetal;
import static se.resonantri.stargazerutil.compat.tinkers.materials.BWMMaterials.*;

@Pulse(id = "TinkersCompatSG", modsRequired = "tconstruct", forced = true)
public class SGTinkersIntegration extends TinkerPulse{

    @Subscribe
    public void preInit(FMLPreInitializationEvent event){
        //Assorted Materials
        integrate(carbonMesh);
        integrate(starmetal);

        //BWM Materials
        integrate(concHellfire);
        integrate(diamond);
        integrate(soulsteel);
        integrate(tallow);
        logger.printf(Level.INFO, "SGIntegration file PreInit");
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
