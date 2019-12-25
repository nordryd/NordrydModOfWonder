package com.nordryd.nmow.entities;

import static com.nordryd.nmow.init.ModEntities.tutorial_entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;

// make the extension generic when we make ModEntity?
public class TestEntity extends CreatureEntity {
    public TestEntity(final World worldIn) {
        super(tutorial_entity, worldIn);
    }

    // entity behavior -> look inside forge dependency net.minecraft.entity.ai.goal to see the goals
    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new SwimGoal(this));
        goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.2));
        goalSelector.addGoal(2, new LookRandomlyGoal(this));
    }

    // entity characteristics -> health
    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(5);
    }
}
