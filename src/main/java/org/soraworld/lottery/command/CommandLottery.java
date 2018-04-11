package org.soraworld.lottery.command;

import org.bukkit.plugin.Plugin;
import org.soraworld.lottery.config.Config;
import org.soraworld.violet.command.CommandViolet;

public class CommandLottery extends CommandViolet {

    public CommandLottery(String name, String perm, final Config config, Plugin plugin) {
        super(name, perm, config, plugin);
    }

}
