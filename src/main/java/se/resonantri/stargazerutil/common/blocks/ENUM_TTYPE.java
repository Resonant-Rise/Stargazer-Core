/*package se.resonantri.stargazerutil.common.blocks;

<<<<<<< HEAD
public enum ENUM_TTYPE{
    SINGLE,
    LEFT,
    RIGHT
}

=======
import net.minecraft.util.IStringSerializable;

public enum ENUM_TTYPE implements IStringSerializable {
    SINGLE(0, "single"),
    LEFT(1, "left"),
    RIGHT(2, "right");

    private final String name;
    private final int index;

    ENUM_TTYPE(Integer IndexIn, String nameIn) {
        this.name = nameIn;
        this.index = IndexIn;
    }

    @Override
    public String getName() {
        return this.name();
    }
    public int getIndex()
    {
        return this.index;
    }
    public static ENUM_TTYPE indexOf (int index) {return ENUM_TTYPE.values()[index];};
}     */

package se.resonantri.stargazerutil.common.blocks;

import net.minecraft.util.IStringSerializable;

public enum ENUM_TTYPE implements IStringSerializable {
    SINGLE("single"),
    LEFT("left"),
    RIGHT("right");

    private final String name;

    ENUM_TTYPE(String nameIn) {
        this.name = nameIn;
    }

    ;

    public String getName() {
        return this.name;
    }
}
>>>>>>> master
