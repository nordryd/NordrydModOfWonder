package com.nordryd.nmow.config;

import static net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import static net.minecraftforge.common.ForgeConfigSpec.Builder;

import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class OreGenConfig {
    public static IntValue test_ore_chance;
    public static BooleanValue generate_overworld;

    public static void init(final Builder server) {
        server.comment("OreGen Config");

        test_ore_chance = server.comment("Max number of ore veins that can spawn in one chunk")
                                .defineInRange("oreGen.test_ore_chance", 100, 1, 1000);
        generate_overworld =
                server.comment("Enable ores to spawn in the OVERWORLD").define("oreGen.generate_overworld", true);
    }
}
