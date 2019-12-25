package com.nordryd.nmow.util;

import static com.nordryd.nmow.NordrydModOfWonder.MODID;

import net.minecraft.util.ResourceLocation;

public class ModUtility {
    public static ResourceLocation getResourceLocation(final String resource) {
        return new ResourceLocation(MODID, resource);
    }
}
