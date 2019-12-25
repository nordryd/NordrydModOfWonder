package com.nordryd.nmow.client.render;

import static com.nordryd.nmow.util.ModUtility.getResourceLocation;

import com.nordryd.nmow.client.models.TestEntityModel;
import com.nordryd.nmow.entities.TestEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class TestEntityRender extends LivingRenderer<TestEntity, TestEntityModel> {

    public TestEntityRender(final EntityRendererManager manager) {
        super(manager, new TestEntityModel(), 0f);
    }

    @Override
    public ResourceLocation getEntityTexture(final TestEntity entity) {
        return getResourceLocation("textures/entity/test_entity.png");
    }

    public static class RenderFactory implements IRenderFactory<TestEntity> {
        @Override
        public EntityRenderer<? super TestEntity> createRenderFor(final EntityRendererManager manager) {
            return new TestEntityRender(manager);
        }
    }
}
