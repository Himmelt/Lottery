package org.soraworld.lottery.economy

import org.soraworld.lottery.config.Config

object Economy {

    private var economy: IEconomy? = null

    fun checkEconomy(config: Config) {
        when {
            config.checkEcoType("Vault") -> try {
                economy = VaultEconomy(config)
                config.console("EcoSupport", "Vault")
            } catch (e: Throwable) {
                if (e.message == "noVaultImpl") {
                    config.console("noVaultImpl")
                } else {
                    config.console("EcoNotSupport", "Vault")
                }
            }
            config.checkEcoType("Essentials") -> try {
                economy = EssEconomy()
                config.console("EcoSupport", "Essentials")
            } catch (ignored: Throwable) {
                config.console("EcoNotSupport", "Essentials")
            }
            config.checkEcoType("PlayerPoints") -> try {
                economy = PointsEconomy()
                config.console("EcoSupport", "PlayerPoints")
            } catch (ignored: Throwable) {
                config.console("EcoNotSupport", "PlayerPoints")
            }
            else -> config.console("InvalidEcoSupport")
        }
    }

    fun setEco(player: String, amount: Double): Boolean {
        return economy == null || economy!!.setEco(player, amount)
    }

    fun addEco(player: String, amount: Double): Boolean {
        return economy == null || economy!!.addEco(player, amount)
    }

    fun getEco(player: String): Double {
        return if (economy == null) 0.0 else economy!!.getEco(player)
    }

    fun hasEnough(player: String, amount: Double): Boolean {
        return economy == null || economy!!.hasEnough(player, amount)
    }

    fun takeEco(player: String, amount: Double): Boolean {
        return economy == null || economy!!.takeEco(player, amount)
    }

}
