package com.nordryd.nmow.block.types;

import static java.util.Arrays.stream;

import net.minecraft.util.IStringSerializable;

public enum BranchPartType implements IStringSerializable {

    SEED(0, "seed"),
    STEM(1, "stem"),
    LEAF(2, "leaf");

    private static final BranchPartType[] META_LOOKUP = new BranchPartType[values().length];
    private final int meta;
    private final String name, unlocalizedName;

    BranchPartType(final int meta, final String name) {
        this.meta = meta;
        this.name = name;
        this.unlocalizedName = name;
    }

    public int getMeta() {
        return meta;
    }

    public String getName() {
        return name;
    }

    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    public static BranchPartType byMetadata(final int meta) {
        return META_LOOKUP[meta];
    }

    static {
        stream(values()).forEach(type -> META_LOOKUP[type.getMeta()] = type);
    }
}
