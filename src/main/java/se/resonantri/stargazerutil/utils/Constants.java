/**
 * This class was created by <Darkhax>. It is distributed as part of Bookshelf. You can find
 * the original source here: https://github.com/Darkhax-Minecraft/Bookshelf
 * <p>
 * Bookshelf is Open Source and distributed under the GNU Lesser General Public License version
 * 2.1.
 */

package se.resonantri.stargazerutil.utils;

import java.util.Random;

public final class Constants {

    //Mod Constants
    public static final String MODID = "stargazerutil";
    public static final String NAME = "Stargazer Utilities";
    public static final String VERSION = "1.0.0";
    public static final String DEPS = "required-after:forge@[14.23.1.2608,);after:skillable;after:tconstruct@[1.12-2.9.0.58,);after:mantle@[1.12-1.3.1.22,);required-after:base@[1.12-3.6.0,)";
    public static final String MCVERS = "[1.12,1.12.2]";

    // System Constants
    public static final Random RANDOM = new Random();

    //GUI's
    public enum GUI_ENUM {
        SCRIBING, BINDING
    }

}
