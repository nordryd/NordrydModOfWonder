package com.nordryd.nmow.registry;

import static com.nordryd.nmow.NordrydModOfWonder.LOGGER;
import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import com.nordryd.nmow.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = MOD)
public class RegistryHandler {
    @SubscribeEvent
    public static void registerBlocks(final Register<Block> blockRegistryEvent) {
        LOGGER.info("HELLO from Register Block");
    }

    @SubscribeEvent
    public static void registerItems(final Register<Item> itemRegistryEvent) {
        itemRegistryEvent.getRegistry().registerAll(ModItems.MOD_ITEMS.toArray(new Item[0]));
        LOGGER.info("items registered");
    }
}
