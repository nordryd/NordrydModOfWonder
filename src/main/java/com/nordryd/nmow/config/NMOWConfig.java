package com.nordryd.nmow.config;

import static com.electronwill.nightconfig.core.io.WritingMode.REPLACE;
import static com.nordryd.nmow.NordrydModOfWonder.LOGGER;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class NMOWConfig {
    public static final ForgeConfigSpec server_config;

    static {
        final ForgeConfigSpec.Builder server_builder = new ForgeConfigSpec.Builder();
        OreGenConfig.init(server_builder);
        server_config = server_builder.build();
    }

    public static void loadConfig(final ForgeConfigSpec config, final String path) {
        LOGGER.info("Loading config: " + path);
        final CommentedFileConfig file =
                CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(REPLACE).build();
        LOGGER.info("Build config: " + path);
        file.load();
        LOGGER.info("Loaded config: " + path);
        config.setConfig(file);
    }
}
