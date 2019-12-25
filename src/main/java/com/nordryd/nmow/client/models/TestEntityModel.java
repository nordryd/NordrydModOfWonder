package com.nordryd.nmow.client.models;

import static net.minecraftforge.api.distmarker.Dist.CLIENT;

import com.nordryd.nmow.entities.TestEntity;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(CLIENT)
public class TestEntityModel extends CowModel<TestEntity> {}
