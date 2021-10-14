package com.duckelekuuk.player_vanish.listeners;

import com.duckelekuuk.player_vanish.VanishPlayerHandler;
import com.duckelekuuk.player_vanish.constants.VanishConstants;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {

    private final VanishPlayerHandler vanishPlayerHandler;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPermission(VanishConstants.ACTION_JOIN_VANISHED)) return;

        // Handle joining in vanish
        vanishPlayerHandler.hideVanishedPlayers(event.getPlayer());
    }
}
