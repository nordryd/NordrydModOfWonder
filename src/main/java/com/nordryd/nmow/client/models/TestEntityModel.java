package com.nordryd.nmow.client.models;

import static net.minecraftforge.api.distmarker.Dist.CLIENT;

import com.nordryd.nmow.entities.TestEntity;
import net.minecraft.client.renderer.entity.model.DolphinModel;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(CLIENT)
public class TestEntityModel extends DolphinModel<TestEntity> {
    @Override
    public void setRotationAngles(final TestEntity p_212844_1_, final float p_212844_2_, final float p_212844_3_,
            final float p_212844_4_, final float p_212844_5_, final float p_212844_6_, final float p_212844_7_) {
        super.setRotationAngles(p_212844_1_, p_212844_2_, p_212844_3_, p_212844_4_, p_212844_5_, p_212844_6_, p_212844_7_);
    }
}
