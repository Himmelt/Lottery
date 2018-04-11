package org.soraworld.lottery.config

import org.bukkit.ChatColor
import org.bukkit.plugin.Plugin
import org.soraworld.lottery.constant.Constant
import org.soraworld.lottery.economy.Economy
import org.soraworld.violet.config.IIConfig
import java.io.File

class Config(path: File, plugin: Plugin) : IIConfig(path, plugin) {

    override fun loadOptions() {

    }

    override fun saveOptions() {

    }

    override fun afterLoad() {
        Economy.checkEconomy(this)
    }

    override fun defaultChatColor(): ChatColor {
        return ChatColor.DARK_AQUA
    }

    override fun defaultChatHead(): String {
        return "[" + Constant.PLUGIN_NAME + "] "
    }

    override fun defaultAdminPerm(): String {
        return Constant.PERM_ADMIN
    }

    fun checkEcoType(type: String): Boolean {
        return true
    }

}
