package com.nordryd.nmow.util.values;

public enum ToolType {
    PICKAXE("pickaxe"),
    SWORD("sword"),
    AXE("axe"),
    SHOVEL("spade"),
    HOE("hoe");

    private final String stringId;

    ToolType(final String stringId) {
        this.stringId = stringId;
    }

    public String getStringId(){
        return stringId;
    }
}
