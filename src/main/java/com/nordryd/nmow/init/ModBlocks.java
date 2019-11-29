package com.nordryd.nmow.init;

import static net.minecraft.block.material.Material.SNOW;

import java.util.ArrayList;
import java.util.List;

import com.nordryd.nmow.block.TestBlock;
import net.minecraft.block.Block;

public interface ModBlocks {
    List<Block> MOD_BLOCKS = new ArrayList<>();

    Block TEST_BLOCK = new TestBlock("test_block", SNOW);
}
