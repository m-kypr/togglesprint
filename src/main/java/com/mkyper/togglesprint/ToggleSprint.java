package com.mkyper.togglesprint;

import com.mkyper.togglesprint.setup.ClientSetup;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("togglesprint")
public class ToggleSprint {
    public static final String MODID = "togglesprint";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();


    public ToggleSprint() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
//        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(ClientSetup.instance);
    }

}
