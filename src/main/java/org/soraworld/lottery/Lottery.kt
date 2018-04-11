package org.soraworld.lottery

import org.bukkit.event.Listener
import org.soraworld.lottery.command.CommandLottery
import org.soraworld.lottery.config.Config
import org.soraworld.lottery.constant.Constant
import org.soraworld.lottery.listener.EventListener
import org.soraworld.violet.VioletPlugin
import org.soraworld.violet.command.IICommand
import org.soraworld.violet.config.IIConfig
import java.io.File
import java.util.*

class Lottery : VioletPlugin() {

    override fun registerConfig(path: File): IIConfig {
        return Config(path, this)
    }

    override fun registerEvents(config: IIConfig?): ArrayList<Listener> {
        val listeners = ArrayList<Listener>()
        if (config is Config) listeners.add(EventListener(config))
        return listeners
    }

    override fun registerCommand(config: IIConfig?): IICommand? {
        return if (config is Config) CommandLottery(Constant.PLUGIN_ID, null, config, this) else null
    }

    override fun afterEnable() {
    }

    override fun beforeDisable() {
    }

}
