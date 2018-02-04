package se.resonantri.stargazerutil;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;
import se.resonantri.stargazerutil.common.CommonProxy;
import se.resonantri.stargazerutil.compat.betterquesting.BetterQuestingCompat;
import se.resonantri.stargazerutil.compat.botania.BotaniaCompat;
import se.resonantri.stargazerutil.compat.gamestages.GameStagesCompat;
import se.resonantri.stargazerutil.compat.skillable.SkillableCompat;
import se.resonantri.stargazerutil.compat.tinkers.SGTinkersIntegration;
import se.resonantri.stargazerutil.compat.tinkers.TinkersCompat;
import se.resonantri.stargazerutil.compat.tinkers.materials.AssortedMaterials;
import se.resonantri.stargazerutil.compat.tinkers.materials.BWMMaterials;
import se.resonantri.stargazerutil.utils.Constants;
import se.resonantri.stargazerutil.utils.StargazerConfig;
import slimeknights.mantle.pulsar.control.PulseManager;

import static se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.Modules.*;

@Mod(modid = Constants.MODID,
        name = Constants.NAME,
        version = Constants.VERSION,
        dependencies = Constants.DEPS,
        acceptedMinecraftVersions = Constants.MCVERS)

public class StargazerUtil {
    @SidedProxy(clientSide = "se.resonantri.stargazerutil.client.ClientProxy", serverSide = "se.resonantri.stargazerutil.common.CommonProxy")
    public static CommonProxy proxy;

    public static PulseManager pulseManager = new PulseManager(StargazerConfig.pulseConfig);

    @Instance
    public static StargazerUtil instance;
    public static Logger logger;


    static {
        pulseManager.registerPulse(new AssortedMaterials());
        pulseManager.registerPulse(new BWMMaterials());
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        proxy.preInit(event);

        if (Loader.isModLoaded("betterquesting") && BQModule){
                BetterQuestingCompat.setup();
        }

        if (Loader.isModLoaded("botania") && BotaniaModule){
                BotaniaCompat.setup();
        }

        if (Loader.isModLoaded("gamestages") && GameStageModule){
                GameStagesCompat.setup();
        }

        if (Loader.isModLoaded("skillable") && SkillableModule){
                SkillableCompat.setup();
        }

        if (Loader.isModLoaded("tinkersconstruct") && TinkersModule){
            TinkersCompat.setup();
            SGTinkersIntegration.preInit(event);
        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        StargazerConfig.postInit(event);
        if (Loader.isModLoaded("tinkersconstruct") && TinkersModule){
            SGTinkersIntegration.postInit(event);
        }
    }

    @EventHandler
    public void serverStart(FMLServerStartingEvent event){
        TinkersCompat.registerCommands();
    }
}
