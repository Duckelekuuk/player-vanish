package com.duckelekuuk.player_vanish.commands;

import com.duckelekuuk.player_vanish.VanishPlayerHandler;
import com.duckelekuuk.player_vanish.constants.VanishConstants;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class VanishCommand implements CommandExecutor, TabExecutor {

    private static final String[] SUB_COMMANDS = {"list"};
    private final VanishPlayerHandler vanishPlayerHandler;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length < 1) return Collections.emptyList();
        if (strings.length == 1) {
            return Arrays.stream(SUB_COMMANDS).filter(argument -> commandSender.hasPermission(VanishConstants.COMMAND_PREFIX + argument) && argument.startsWith(strings[0])).collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
}
