package com.nordryd.nmow.init;

import static com.nordryd.nmow.init.ModItemGroups.MASTER;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;
import static com.nordryd.nmow.util.ModUtility.getResourceLocation;
import static java.util.Arrays.stream;
import static net.minecraft.entity.EntityType.Builder.create;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.nordryd.nmow.NordrydModOfWonder;
import com.nordryd.nmow.entities.TestEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class ModEntities {

    public static final List<Entity> MOD_ENTITIES = new ArrayList<>();

    public static EntityType<?> tutorial_entity =
            create(TestEntity::new, EntityClassification.CREATURE).build(NordrydModOfWonder.MODID + ":test_entity")
                                                                  .setRegistryName(getResourceLocation("test_entity"));

    public static Item registerEntitySpawnEgg(final String registryName, final EntityType<?> entityType,
            final int primaryColor, final int secondaryColor) {
        final Item spawnEgg = new SpawnEggItem(entityType, primaryColor, secondaryColor, new Item.Properties().group(MASTER))
                .setRegistryName(getResourceLocation(registryName));
        MOD_ITEMS.add(spawnEgg);
        return spawnEgg;
    }

    public static void registerEntityWorldSpawn(final EntityType<?> entity, final Biome... biomes) {
        // SpawnListEntry(entity to spawn, the chance to spawn, the min pod size, the max pod size)
        stream(biomes).filter(Objects::nonNull).forEach(
                biome -> biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 1000, 1, 10)));
    }
}
