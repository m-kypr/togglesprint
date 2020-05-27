package com.mkyper.togglesprint.setup;

import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;

public interface IProxy {

    GameSettings getGameSettings();
    FontRenderer getFontRenderer();
    PlayerEntity getClientPlayer();
}
