package com.duckelekuuk.player_vanish.listeners;

import com.duckelekuuk.player_vanish.constants.VanishConstants;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPermission(VanishConstants.ACTION_JOIN_VANISHED)) return;

        // Handle joining in vanish
    }
}
