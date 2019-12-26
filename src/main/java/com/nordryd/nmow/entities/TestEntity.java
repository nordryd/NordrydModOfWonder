package com.nordryd.nmow.entities;

import static com.nordryd.nmow.init.ModEntities.tutorial_entity;
import static com.nordryd.nmow.util.ModUtility.getEntityModelResourceLocation;
import static net.minecraftforge.api.distmarker.Dist.CLIENT;

import javax.annotation.Nullable;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.DolphinModel;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

// make the extension generic when we make ModEntity?
public class TestEntity extends CreatureEntity {

    public TestEntity(EntityType<? extends CreatureEntity> entityType, final World world) {
        super((EntityType<? extends CreatureEntity>) tutorial_entity, world);
        setCustomNameVisible(true);
    }

    private TestEntity(final World world) {
        super((EntityType<? extends CreatureEntity>) tutorial_entity, world);
        setCustomNameVisible(true);
    }

    // if the priority for walking is 0 (top), then they'll do nothing else? walking should always be low bc it's always possible
    // entity behavior -> look inside forge dependency net.minecraft.entity.ai.goal to see the goals
    @Override
    protected void registerGoals() {
        // NearestAttackableTargetGoal(entity, targetEntity, shouldCheckSight)
        goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this,
                getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue()));
        goalSelector.addGoal(5, new LookRandomlyGoal(this));
        goalSelector.addGoal(3, new SwimGoal(this));
//        goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, false));
        targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, DonkeyEntity.class, true));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, CowEntity.class, true));
        // the above just selects the target for attacking
        // there must be an additional goal for actually moving the entity there
    }

    // entity characteristics -> health
    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25);
        getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35);
        getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLOCK_COMPOSTER_FILL;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_GRINDSTONE_USE;
    }

    @Override
    public boolean isAggressive() {
        return super.isAggressive();
    }

    @OnlyIn(CLIENT)
    public static class Model extends DolphinModel<TestEntity> {
        @Override
        public void setRotationAngles(final TestEntity entity, final float p_212844_2_, final float p_212844_3_,
                final float p_212844_4_, final float yAxisRotation, final float xAxisRotation, final float p_212844_7_) {
            super.setRotationAngles(entity, p_212844_2_, p_212844_3_, p_212844_4_, yAxisRotation, 45f, p_212844_7_);
        }
    }


    @OnlyIn(CLIENT)
    public static class Render extends LivingRenderer<TestEntity, Model> {

        public Render(final EntityRendererManager manager) {
            super(manager, new Model(), 0f);
        }

        @Override
        public ResourceLocation getEntityTexture(final TestEntity entity) {
            return getEntityModelResourceLocation("test_entity.png");
        }

        public static class RenderFactory implements IRenderFactory<TestEntity> {
            @Override
            public EntityRenderer<? super TestEntity> createRenderFor(final EntityRendererManager manager) {
                return new Render(manager);
            }
        }
    }
}
