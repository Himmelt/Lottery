package org.soraworld.lottery.economy

import net.milkbowl.vault.economy.Economy
import net.milkbowl.vault.economy.EconomyResponse
import org.bukkit.Bukkit
import org.soraworld.lottery.config.Config

class VaultEconomy @Throws(Exception::class)
internal constructor(config: Config) : IEconomy {

    private val vaultEco: Economy

    init {
        var economy: Economy? = null
        val provider = Bukkit.getServicesManager().getRegistration(Economy::class.java)
        if (provider != null) economy = provider.provider
        if (economy == null) {
            throw Exception("noVaultImpl")
        }
        config.console("vaultImpl", provider!!.plugin.name, economy.name)
        vaultEco = economy
    }

    override fun setEco(player: String, amount: Double): Boolean {
        return if (takeEco(player, getEco(player))) {
            addEco(player, amount)
        } else false
    }

    override fun addEco(player: String, amount: Double): Boolean {
        return vaultEco.depositPlayer(Bukkit.getOfflinePlayer(player), amount).type == EconomyResponse.ResponseType.SUCCESS
    }

    override fun getEco(player: String): Double {
        return vaultEco.getBalance(Bukkit.getOfflinePlayer(player))
    }

    override fun hasEnough(player: String, amount: Double): Boolean {
        return vaultEco.has(Bukkit.getOfflinePlayer(player), amount)
    }

    override fun takeEco(player: String, amount: Double): Boolean {
        return vaultEco.withdrawPlayer(Bukkit.getOfflinePlayer(player), amount).type == EconomyResponse.ResponseType.SUCCESS
    }

}
