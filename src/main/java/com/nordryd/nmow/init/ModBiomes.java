package com.nordryd.nmow.init;

import java.util.ArrayList;
import java.util.List;

import com.nordryd.nmow.world.biomes.ModBiome;
import com.nordryd.nmow.world.biomes.TestBiome;

public interface ModBiomes {
    List<ModBiome> MOD_BIOMES = new ArrayList<>();

    ModBiome TEST_BIOME = new TestBiome("TEST BIOME");
}
