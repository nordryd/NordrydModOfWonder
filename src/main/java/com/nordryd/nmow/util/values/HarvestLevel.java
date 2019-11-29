package com.nordryd.nmow.util.values;

public enum HarvestLevel {
    WOOD(0),
    STONE(1),
    IRON(2),
    DIAMOND(3),
    GOLD(STONE.level),
    TEST(10);

    private final int level;

    HarvestLevel(final int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
