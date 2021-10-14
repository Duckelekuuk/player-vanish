package com.duckelekuuk.player_vanish.listeners;

import com.duckelekuuk.player_vanish.constants.VanishPermissions;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPermission(VanishPermissions.ACTION_JOIN_VANISHED)) return;

        // Handle joining in vanish
    }
}
