package com.nordryd.nmow.registry;

import static com.nordryd.nmow.NordrydModOfWonder.LOGGER;
import static com.nordryd.nmow.init.ModBlocks.MOD_BLOCKS;
import static com.nordryd.nmow.init.ModEntities.registerEntityWorldSpawn;
import static com.nordryd.nmow.init.ModEntities.tutorial_entity;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;
import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(bus = MOD)
public class RegistryHandler {

    @SubscribeEvent
    public static void registerItems(final Register<Item> itemRegistryEvent) {
        itemRegistryEvent.getRegistry().registerAll(MOD_ITEMS.toArray(new Item[0]));
        LOGGER.info("items registered");
    }

    @SubscribeEvent
    public static void registerBlocks(final Register<Block> blockRegistryEvent) {
        blockRegistryEvent.getRegistry().registerAll(MOD_BLOCKS.toArray(new Block[0]));
        LOGGER.info("blocks registered");
    }

    @SubscribeEvent
    public static void registerEntities(final Register<EntityType<?>> entityRegisterEvent) {
        entityRegisterEvent.getRegistry().register(tutorial_entity);
        registerEntityWorldSpawn(tutorial_entity, Biomes.BADLANDS, Biomes.PLAINS, Biomes.FLOWER_FOREST, Biomes.RIVER);
    }
}
