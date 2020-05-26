package com.mkyper.togglesprint;

import com.mkyper.togglesprint.setup.ClientSetup;
import com.mkyper.togglesprint.setup.ModSetup;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("togglesprint")
public class ToggleSprint {
    public static final String MODID = "togglesprint";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public static KeyBinding toggleSprint;
    public static Minecraft minecraft;
    private boolean toggled = false;

    public ToggleSprint() {
        toggleSprint = new KeyBinding("Toggle Sprint", 86, "key.categories.movement");
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SuppressWarnings({"ConstantConditions", "RedundantSuppression"})
    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent event) {
        if (toggleSprint.isPressed()) {
            toggled = !toggled;
        }
        KeyBinding.setKeyBindState(minecraft.gameSettings.keyBindSprint.getKey(), toggled);
    }

    @SubscribeEvent
    public void render(final RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            if (toggled) {
                minecraft.fontRenderer.drawString("[Sprinting (toggled)]", 2, 2, 0xffffff);
            } else if (minecraft.player.isSprinting()) {
                minecraft.fontRenderer.drawString("[Sprinting (Key held)]", 2, 2, 0xffffff);
            }
        }
    }
}
