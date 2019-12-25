package com.nordryd.nmow.client.render;

import static net.minecraftforge.api.distmarker.Dist.CLIENT;
import static net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler;

import com.nordryd.nmow.entities.TestEntity;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(CLIENT)
public class TestRenderRegistry {
    public static void registerEntityRenders() {
        registerEntityRenderingHandler(TestEntity.class, new TestEntityRender.RenderFactory());
    }
}
