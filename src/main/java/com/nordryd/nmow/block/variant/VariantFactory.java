package com.nordryd.nmow.block.variant;

import static com.nordryd.nmow.block.variant.Branches.BRANCH_SEGMENTS;
import static com.nordryd.nmow.init.ModBlocks.BRANCHES;

import com.nordryd.nmow.block.types.BranchPartType;
import net.minecraft.block.state.IBlockState;

public class VariantFactory {
    public static IBlockState getBranchBlock(final BranchPartType branchSegment) {
        return BRANCHES.getDefaultState().withProperty(BRANCH_SEGMENTS, branchSegment);
    }
}
