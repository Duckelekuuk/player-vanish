package com.duckelekuuk.player_vanish;

import com.duckelekuuk.player_vanish.commands.VanishCommand;
import com.duckelekuuk.player_vanish.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerVanish extends JavaPlugin {

    private final VanishPlayerHandler vanishPlayerHandler = new VanishPlayerHandler();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

        getCommand("vanish").setExecutor(new VanishCommand());
    }
}
