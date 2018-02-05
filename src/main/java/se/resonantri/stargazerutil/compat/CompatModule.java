///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///   This class is taken from IE by BluSunrize                                                                                                             ///
///   It's been modified in some areas to fit our purposes                                                                                                  ///
///   To see the original class see link below:                                                                                                             ///
///   https://github.com/BluSunrize/ImmersiveEngineering/blob/master/src/main/java/blusunrize/immersiveengineering/common/util/compat/IECompatModule.java   ///
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package se.resonantri.stargazerutil.compat;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import se.resonantri.stargazerutil.compat.skillable.compat.immersiveengineering.ImmersiveEngineeringCompat;
import se.resonantri.stargazerutil.compat.tinkers.TinkersCommands;
import se.resonantri.stargazerutil.compat.tinkers.materials.AstralSorceryMaterials;
import se.resonantri.stargazerutil.compat.tinkers.materials.BWMMaterials;
import se.resonantri.stargazerutil.compat.tinkers.materials.TechRebornMaterials;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import static se.resonantri.stargazerutil.StargazerUtil.logger;
import static se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.Modules.compat;

public abstract class CompatModule {
    public static boolean serverStartingDone = false;

    public static HashMap<String, Class<? extends CompatModule>> moduleClasses = new HashMap<String, Class<? extends CompatModule>>();
    public static Set<CompatModule> modules = new HashSet<CompatModule>();

    static {
        moduleClasses.put("astralsorcery", AstralSorceryMaterials.class);
        moduleClasses.put("betterwithmods", BWMMaterials.class);
        moduleClasses.put("immersiveengineering", ImmersiveEngineeringCompat.class);
        moduleClasses.put("tconstruct", TinkersCommands.class);
        moduleClasses.put("techreborn", TechRebornMaterials.class);
    }

    public static void doModulesPreInit() {
        for (Entry<String, Class<? extends CompatModule>> e : moduleClasses.entrySet())
            if (Loader.isModLoaded(e.getKey())) {
                try {
                    Boolean enabled = compat.get(e.getKey());
                    if (enabled == null || !enabled.booleanValue())
                        continue;
                    CompatModule m = e.getValue().newInstance();
                    modules.add(m);
                    m.preInit();
                } catch (Exception exception) {
                    logger.error("Compat module for " + e.getKey() + " could not be preInitialized. Report this!");
                }
            }
    }

    public static void doModulesInit() {
        for (CompatModule compat : CompatModule.modules) {
            try {
                compat.init();
            } catch (Exception exception) {
                logger.error("Compat module for " + compat + " could not be initialized");
            }
        }
    }

    public static void doModulesPostInit() {
        for (CompatModule compat : CompatModule.modules) {
            try {
                compat.postInit();
            } catch (Exception exception) {
                logger.error("Compat module for " + compat + " could not be postInitialized");
            }
        }
    }

    public static void doModulesLoadComplete() {
        if (!serverStartingDone) {
            serverStartingDone = true;
            for (CompatModule compat : CompatModule.modules) {
                try {
                    compat.loadComplete();
                } catch (Exception exception) {
                    logger.error("Compat module for " + compat + " could not be initialized");
                    exception.printStackTrace();
                }
            }
        }
    }

    public abstract void preInit();

    public abstract void init();

    public abstract void postInit();

    public void loadComplete() {
    }

    @SideOnly(Side.CLIENT)
    public void clientPreInit() {
    }

    @SideOnly(Side.CLIENT)
    public void clientInit() {
    }

    @SideOnly(Side.CLIENT)
    public void clientPostInit() {
    }
}
