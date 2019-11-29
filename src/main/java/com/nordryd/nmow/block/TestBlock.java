package com.nordryd.nmow.block;

import com.nordryd.nmow.util.values.HarvestLevels;
import com.nordryd.nmow.util.values.ToolTypes;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TestBlock extends ModBlock {
    public TestBlock(final String name, final Material material) {
        super(name, material);
        setSoundType(SoundType.METAL);
        setHardness(5.0F);
        setResistance(15.0F);
        setHarvestLevel(ToolTypes.PICKAXE, HarvestLevels.DIAMOND);
    }
}
