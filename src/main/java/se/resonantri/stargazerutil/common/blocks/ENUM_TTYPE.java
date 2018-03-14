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

    public String getName() {
        return this.name;
    }
}

