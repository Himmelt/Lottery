package org.soraworld.lottery.command

import org.bukkit.plugin.Plugin
import org.soraworld.lottery.config.Config
import org.soraworld.violet.command.CommandViolet

class CommandLottery(name: String, perm: String, config: Config, plugin: Plugin) : CommandViolet(name, perm, config, plugin)
