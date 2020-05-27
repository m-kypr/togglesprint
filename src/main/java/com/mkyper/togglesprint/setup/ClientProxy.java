package com.mkyper.togglesprint.setup;

import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;

public class ClientProxy implements IProxy {
    @Override
    public GameSettings getGameSettings() {
        return Minecraft.getInstance().gameSettings;
    }

    @Override
    public FontRenderer getFontRenderer() {
        return Minecraft.getInstance().fontRenderer;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }
}
