package com.nordryd.nmow.block.properties;

import static com.nordryd.nmow.util.values.HarvestLevel.IRON;
import static com.nordryd.nmow.util.values.ToolType.PICKAXE;

import com.nordryd.nmow.init.ModCreativeTabs;
import com.nordryd.nmow.util.values.HarvestLevel;
import com.nordryd.nmow.util.values.ToolType;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockProperties {
    private final String name;
    private Material material = Material.ROCK;
    private SoundType soundType = SoundType.STONE;
    private HarvestLevel toolMaterialRequired = IRON;
    private ToolType toolTypeRequired = PICKAXE;
    private Integer lightOpacity;
    private Float hardness, resistance, lightLevel;
    private CreativeTabs creativeTab = ModCreativeTabs.MASTER;
    private boolean isUnbreakable = false;

    /**
     * {@link BlockProperties} constructor.
     *
     * @param name the block's unlocalized/registry name.
     */
    public BlockProperties(final String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public Material material() {
        return material;
    }

    public SoundType soundType() {
        return soundType;
    }

    public HarvestLevel toolMaterialRequired() {
        return toolMaterialRequired;
    }

    public ToolType toolTypeRequired() {
        return toolTypeRequired;
    }

    public Integer lightOpacity() {
        return lightOpacity;
    }

    public Float hardness() {
        return hardness;
    }

    public Float resistance() {
        return resistance;
    }

    public Float lightLevel() {
        return lightLevel;
    }

    public CreativeTabs creativeTab() {
        return creativeTab;
    }

    public boolean isUnbreakable() {
        return isUnbreakable;
    }

    /**
     * @param material the {@link Material} of the block. Default: STONE.
     * @return the current {@link BlockProperties}
     */
    public BlockProperties material(final Material material) {
        this.material = material;
        return this;
    }

    /**
     * @param soundType the {@link SoundType sounds} the block will use. Default: STONE.
     * @return the current {@link BlockProperties}
     */
    public BlockProperties soundType(final SoundType soundType) {
        this.soundType = soundType;
        return this;
    }


    /**
     * @param toolTypeRequired the {@link ToolType tool type} required to break the block and yield a drop.
     * Default: Pickaxe.
     * @return the current {@link BlockProperties}
     */
    public BlockProperties toolTypeRequired(final ToolType toolTypeRequired) {
        this.toolTypeRequired = toolTypeRequired;
        return this;
    }

    /**
     * @param toolMaterialRequired the {@link HarvestLevel tool material} required to break the block and yield a drop.
     * Default: Iron.
     * @return the current {@link BlockProperties}
     */
    public BlockProperties toolMaterialRequired(final HarvestLevel toolMaterialRequired) {
        this.toolMaterialRequired = toolMaterialRequired;
        return this;
    }

    /**
     * @param lightOpacity how much light can shine through the block, if at all.
     * @return the current {@link BlockProperties}
     */
    public BlockProperties lightOpacity(final int lightOpacity) {
        this.lightOpacity = lightOpacity;
        return this;
    }

    /**
     * @param hardness difficulty to break the block (harder block takes longer to break).
     * <i>e.g.</i> Dirt = 0.5, Obsidian = 50.
     * @return the current {@link BlockProperties}
     */
    public BlockProperties hardness(final float hardness) {
        this.hardness = hardness;
        return this;
    }

    /**
     * @param resistance strength against explosives.
     * @return the current {@link BlockProperties}
     */
    public BlockProperties resistance(final float resistance) {
        this.resistance = resistance;
        return this;
    }

    /**
     * @param lightLevel intensity of light emitted from the block.
     * <i>e.g.</i> torch = 14, redstone torch = 7.
     * @return the current {@link BlockProperties}
     */
    public BlockProperties lightLevel(final float lightLevel) {
        this.lightLevel = lightLevel;
        return this;
    }

    /**
     * @param creativeTab the {@link CreativeTabs creative tab} this block exists in.
     * @return the current {@link BlockProperties}
     */
    public BlockProperties creativeTab(final CreativeTabs creativeTab) {
        this.creativeTab = creativeTab;
        return this;
    }

    /**
     * Makes the block unbreakable (basically bedrock).
     *
     * @return the current {@link BlockProperties}
     */
    public BlockProperties makeUnbreakable() {
        this.isUnbreakable = true;
        return this;
    }

}
