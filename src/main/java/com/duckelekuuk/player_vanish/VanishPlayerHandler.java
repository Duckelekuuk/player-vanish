package com.duckelekuuk.player_vanish;

import com.duckelekuuk.player_vanish.constants.VanishConstants;
import com.duckelekuuk.player_vanish.events.PlayerUnVanishEvent;
import com.duckelekuuk.player_vanish.events.PlayerVanishEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

public class VanishPlayerHandler {

    public void vanishPlayer(Player player) {
        PlayerVanishEvent event = new PlayerVanishEvent(player);
        Bukkit.getPluginManager().callEvent(event);

        if (event.isCancelled()) return;

        player.setMetadata(VanishConstants.METADATA_KEY, new FixedMetadataValue(JavaPlugin.getPlugin(PlayerVanish.class), true));
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.hasPermission(VanishConstants.COMMAND_VANISH)) continue;

            onlinePlayer.hidePlayer(JavaPlugin.getPlugin(PlayerVanish.class), player);
        }
    }

    public void showPlayer(Player player) {
        PlayerUnVanishEvent event = new PlayerUnVanishEvent(player);
        Bukkit.getPluginManager().callEvent(event);

        if (event.isCancelled()) return;

        player.removeMetadata(VanishConstants.METADATA_KEY, JavaPlugin.getPlugin(PlayerVanish.class));
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.hasPermission(VanishConstants.COMMAND_VANISH)) continue;

            onlinePlayer.showPlayer(JavaPlugin.getPlugin(PlayerVanish.class), player);
        }
    }

    public void hideVanishedPlayers(Player player) {
        if (player.hasPermission(VanishConstants.COMMAND_VANISH)) return;

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (!isVanished(onlinePlayer)) continue;
            onlinePlayer.hidePlayer(JavaPlugin.getPlugin(PlayerVanish.class), player);
        }
    }
    public void showVanishedPlayers(Player player) {
        if (player.hasPermission(VanishConstants.COMMAND_VANISH)) return;

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (isVanished(onlinePlayer)) continue;
            onlinePlayer.showPlayer(JavaPlugin.getPlugin(PlayerVanish.class), player);
        }
    }

    public boolean isVanished(Player player) {
        return player.hasMetadata(VanishConstants.METADATA_KEY);
    }
}
