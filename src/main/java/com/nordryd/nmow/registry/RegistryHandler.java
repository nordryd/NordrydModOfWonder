package com.nordryd.nmow.registry;

import static com.nordryd.nmow.init.ModBlocks.MOD_BLOCKS;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;

import com.nordryd.nmow.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(final Register<Item> event) {
        event.getRegistry().registerAll(MOD_ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(final Register<Block> event) {
        event.getRegistry().registerAll(MOD_BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(final ModelRegistryEvent event) {
    	MOD_ITEMS.stream().filter(IHasModel.class::isInstance).forEach(item -> ((IHasModel)item).registerModels());
        MOD_BLOCKS.stream().filter(IHasModel.class::isInstance).forEach(block -> ((IHasModel)block).registerModels());
    }
}
