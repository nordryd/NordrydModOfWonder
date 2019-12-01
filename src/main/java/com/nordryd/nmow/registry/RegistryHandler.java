package com.nordryd.nmow.registry;

import static com.nordryd.nmow.init.ModBiomes.MOD_BIOMES;
import static com.nordryd.nmow.init.ModBlocks.MOD_BLOCKS;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;
import static net.minecraftforge.fml.common.registry.GameRegistry.registerWorldGenerator;

import com.nordryd.nmow.util.IHasModel;
import com.nordryd.nmow.world.biomes.ModBiome;
import com.nordryd.nmow.world.gen.OreGenerator;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public interface RegistryHandler {
    @SubscribeEvent
    static void onItemRegister(final Register<Item> event) {
        event.getRegistry().registerAll(MOD_ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    static void onBlockRegister(final Register<Block> event) {
        event.getRegistry().registerAll(MOD_BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    static void onModelRegister(final ModelRegistryEvent event) {
        MOD_ITEMS.stream().filter(IHasModel.class::isInstance).forEach(item -> ((IHasModel) item).registerModels());
        MOD_BLOCKS.stream().filter(IHasModel.class::isInstance).forEach(block -> ((IHasModel) block).registerModels());
    }

    static void preInitRegistries() {
        registerWorldGenerator(new OreGenerator(), 0);
        MOD_BIOMES.forEach(ModBiome::registerModBiome);
    }
}
