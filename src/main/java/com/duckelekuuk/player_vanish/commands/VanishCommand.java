package com.duckelekuuk.player_vanish.commands;

import com.duckelekuuk.player_vanish.VanishPlayerHandler;
import com.duckelekuuk.player_vanish.constants.VanishConstants;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class VanishCommand implements CommandExecutor, TabExecutor {

    private static final String[] SUB_COMMANDS = {"list"};
    private final VanishPlayerHandler vanishPlayerHandler;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "You have to be a player to execute this command!");
            return true;
        }

        Player player = (Player) commandSender;

        if (args.length == 0) {
            if (vanishPlayerHandler.isVanished(player)) {
                vanishPlayerHandler.showPlayer(player);
                player.sendMessage(ChatColor.GREEN + "You are now visible!");
            } else {
                vanishPlayerHandler.vanishPlayer(player);
                player.sendMessage(ChatColor.GREEN + "You are now vanished!");
            }
            return true;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        if (args.length < 1) return Collections.emptyList();
        if (args.length == 1) {
            return Arrays.stream(SUB_COMMANDS).filter(argument -> commandSender.hasPermission(VanishConstants.COMMAND_PREFIX + argument) && argument.startsWith(args[0])).collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
}
