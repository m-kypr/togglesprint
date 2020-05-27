package com.mkyper.togglesprint.setup;

import com.mkyper.togglesprint.ToggleSprint;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ToggleSprint.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup extends ClientProxy {

    public static final ClientSetup instance = new ClientSetup();
    private static final KeyBinding toggleSprint = new KeyBinding("Toggle Sprint", 86, "key.categories.togglesprint");
    private boolean toggled = false;

    public static void init(final FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(toggleSprint);
    }

    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent event) {
        if (toggleSprint.isPressed()) toggled = !toggled;
        KeyBinding.setKeyBindState(getGameSettings().keyBindSprint.getKey(), toggled);
    }

    @SubscribeEvent
    public void render(final RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            if (toggled) {
                getFontRenderer().drawString("[Sprinting (Toggled)]", 2, 2, 0xffffff);
            } else if (getClientPlayer().isSprinting()) {
                getFontRenderer().drawString("[Sprinting (Key Held)]", 2, 2, 0xffffff);
            }
        }
    }
}
