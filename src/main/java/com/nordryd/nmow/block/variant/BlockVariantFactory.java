package com.nordryd.nmow.block.variant;

import static com.nordryd.nmow.block.variant.Branches.VARIANT;
import static com.nordryd.nmow.init.ModBlocks.BRANCHES;

import com.nordryd.nmow.block.variant.types.BranchSegments;
import net.minecraft.block.state.IBlockState;

public class BlockVariantFactory {
    public static IBlockState getBranchBlock(final BranchSegments branchSegment) {
        return BRANCHES.getDefaultState().withProperty(VARIANT, branchSegment);
    }
}
