package org.soraworld.lottery.economy

import org.black_ixx.playerpoints.PlayerPoints
import org.black_ixx.playerpoints.PlayerPointsAPI
import org.bukkit.Bukkit

class PointsEconomy @Throws(Exception::class)
internal constructor() : IEconomy {

    private val pointsAPI: PlayerPointsAPI

    init {
        var api: PlayerPointsAPI? = null
        val plugin = Bukkit.getPluginManager().getPlugin("PlayerPoints")
        if (plugin is PlayerPoints) {
            api = plugin.api
        }
        if (api == null) throw Exception()
        pointsAPI = api
    }

    override fun setEco(player: String, amount: Double): Boolean {
        return pointsAPI.set(player, amount.toInt())
    }

    override fun addEco(player: String, amount: Double): Boolean {
        return pointsAPI.give(player, amount.toInt())
    }

    override fun getEco(player: String): Double {
        return pointsAPI.look(player).toDouble()
    }

    override fun hasEnough(player: String, amount: Double): Boolean {
        return pointsAPI.look(player) >= amount
    }

    override fun takeEco(player: String, amount: Double): Boolean {
        return pointsAPI.take(player, amount.toInt())
    }

}
