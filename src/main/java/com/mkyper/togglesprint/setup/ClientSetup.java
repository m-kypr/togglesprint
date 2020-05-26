package com.mkyper.togglesprint.setup;

import com.mkyper.togglesprint.ToggleSprint;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ToggleSprint.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    public static void init(final FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(ToggleSprint.toggleSprint);
        ToggleSprint.minecraft = Minecraft.getInstance();
        ToggleSprint.LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }
}
