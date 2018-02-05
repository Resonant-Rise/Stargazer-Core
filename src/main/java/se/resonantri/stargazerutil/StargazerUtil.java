package se.resonantri.stargazerutil;

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
import se.resonantri.stargazerutil.compat.CompatModule;
import se.resonantri.stargazerutil.utils.Constants;
import se.resonantri.stargazerutil.utils.StargazerConfig;

@Mod(modid = Constants.MODID, name = Constants.NAME, version = Constants.VERSION, dependencies = Constants.DEPS, acceptedMinecraftVersions = Constants.MCVERS)
public class StargazerUtil {
    @SidedProxy(clientSide = "se.resonantri.stargazerutil.client.ClientProxy", serverSide = "se.resonantri.stargazerutil.common.CommonProxy")
    public static CommonProxy proxy;

    @Instance
    public static StargazerUtil instance;
    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
        CompatModule.doModulesPreInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        CompatModule.doModulesInit();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        StargazerConfig.postInit(event);
        CompatModule.doModulesPostInit();
    }

    @EventHandler
    public void serverStart(FMLServerStartingEvent event) {
        CompatModule.doModulesLoadComplete();
    }
}
