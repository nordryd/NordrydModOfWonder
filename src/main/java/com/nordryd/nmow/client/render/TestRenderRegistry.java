package com.nordryd.nmow.client.render;

import static com.nordryd.nmow.init.ModEntities.tutorial_entity;
import static net.minecraftforge.api.distmarker.Dist.CLIENT;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(CLIENT)
public class TestRenderRegistry {
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(tutorial_entity, new TestEntityRender.RenderFactory());
    }
}
