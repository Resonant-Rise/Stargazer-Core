package se.resonantri.stargazerutil.common.blocks;

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

    public static ENUM_TTYPE indexOf(int index) {
        return ENUM_TTYPE.values()[index];
    }

    @Override
    public String getName() {
        return this.name();
    }

    public int getIndex() {
        return this.index;
    }
}
