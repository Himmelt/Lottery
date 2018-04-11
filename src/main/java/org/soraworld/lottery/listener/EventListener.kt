package org.soraworld.lottery.listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.soraworld.lottery.config.Config

class EventListener(private val config: Config) : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {

    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
    }

}
