package se.resonantri.stargazercore;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;
import se.resonantri.stargazercore.common.CommonProxy;
import se.resonantri.stargazercore.compat.betterquesting.BetterQuestingCompat;
import se.resonantri.stargazercore.compat.botania.BotaniaCompat;
import se.resonantri.stargazercore.compat.gamestages.GameStagesCompat;
import se.resonantri.stargazercore.compat.skillable.SkillableCompat;
import se.resonantri.stargazercore.compat.tinkers.TinkersCompat;
import se.resonantri.stargazercore.utils.StargazerConfig;

import static se.resonantri.stargazercore.utils.StargazerConfig.StargazerConfigs.Modules.*;

@Mod(modid = StargazerCore.MODID,
        name = StargazerCore.NAME,
        version = StargazerCore.VERSION,
        dependencies = StargazerCore.DEPS,
        acceptedMinecraftVersions = StargazerCore.MCVERS)

public class StargazerCore {
    public static final String MODID = "stargazercore";
    public static final String NAME = "StargazerCore";
    public static final String VERSION = "1.0.0";
    public static final String DEPS = "required:forge@[14.23.1.2586,)";
    public static final String MCVERS = "1.12, 1.12.1, 1.12.2";

    @SidedProxy(clientSide = "se.resonantri.stargazercore.client.ClientProxy", serverSide = "se.resonantri.stargazercore.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static StargazerCore instance;
    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        proxy.preInit(event);
        StargazerConfig.preInit(event);

        if (Loader.isModLoaded("betterquesting")){
            if (BQModule){
                BetterQuestingCompat.setup();
            }
        }

        if (Loader.isModLoaded("botania")){
            if (BotaniaModule){
                BotaniaCompat.setup();
            }
        }

        if (Loader.isModLoaded("gamestages")){
            if (GameStageModule){
                GameStagesCompat.setup();
            }
        }

        if (Loader.isModLoaded("skillable")){
            if (SkillableModule){
                SkillableCompat.setup();
            }
        }

        if (Loader.isModLoaded("tinkersconstruct")){
            if (TinkersModule){
                TinkersCompat.setup();
            }
        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    }

    @EventHandler
    public void serverStart(FMLServerStartingEvent event){
        TinkersCompat.registerCommands();
    }
}
