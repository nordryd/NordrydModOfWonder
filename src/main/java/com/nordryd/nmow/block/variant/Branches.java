package com.nordryd.nmow.block.variant;

import static com.nordryd.nmow.Main.proxy;
import static com.nordryd.nmow.block.variant.types.BranchSegments.STEM;
import static com.nordryd.nmow.init.ModBlocks.MOD_BLOCKS;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static net.minecraft.block.properties.PropertyEnum.create;
import static net.minecraft.item.Item.getItemFromBlock;

import com.nordryd.nmow.block.properties.BlockProperties;
import com.nordryd.nmow.block.variant.types.BranchSegments;
import com.nordryd.nmow.init.blocks.item.ItemBlockVariants;
import com.nordryd.nmow.util.IHasModel;
import com.nordryd.nmow.util.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Branches extends Block implements IHasModel, IMetaName {

    public static final PropertyEnum<BranchSegments> VARIANT = create("variant", BranchSegments.class);

    public Branches(final BlockProperties blockProperties) {
        super(blockProperties.material());
        setUnlocalizedName(blockProperties.name());
        setRegistryName(blockProperties.name());
        setCreativeTab(blockProperties.creativeTab());
        setSoundType(blockProperties.soundType());
        setHarvestLevel(blockProperties.toolTypeRequired().getStringId(), blockProperties.toolMaterialRequired().getLevel());

        if (blockProperties.hardness() != null) {
            setHardness(blockProperties.hardness());
        }

        if (blockProperties.resistance() != null) {
            setResistance(blockProperties.resistance());
        }

        if (blockProperties.lightLevel() != null) {
            setLightLevel(blockProperties.lightLevel());
        }

        if (blockProperties.lightOpacity() != null) {
            setLightOpacity(blockProperties.lightOpacity());
        }

        if (blockProperties.isUnbreakable()) {
            setBlockUnbreakable();
        }

        setDefaultState(this.getBlockState().getBaseState().withProperty(VARIANT, STEM));

        MOD_BLOCKS.add(this);
        MOD_ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public int damageDropped(final IBlockState blockState) {
        return blockState.getValue(VARIANT).getMeta();
    }

    @Override
    public void getSubBlocks(final CreativeTabs itemIn, final NonNullList<ItemStack> items) {
        stream(BranchSegments.values()).forEach(branchSegment -> items.add(new ItemStack(this, 1, branchSegment.getMeta())));
    }

    @Override
    public IBlockState getStateFromMeta(final int meta) {
        return getDefaultState().withProperty(VARIANT, BranchSegments.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(final IBlockState blockState) {
        return blockState.getValue(VARIANT).getMeta();
    }

    @Override
    public ItemStack getPickBlock(final IBlockState blockState, final RayTraceResult target, final World world,
            final BlockPos pos, final EntityPlayer player) {
        return new ItemStack(getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    public String getSpecialName(final ItemStack stack) {
        return BranchSegments.values()[stack.getItemDamage()].getName();
    }

    @Override
    public void registerModels() {
        range(0, BranchSegments.values().length).forEach(variantIndex -> proxy
                .registerVariantRenderer(getItemFromBlock(this), variantIndex,
                        "branches_" + BranchSegments.values()[variantIndex].getName(), "inventory"));
    }
}
