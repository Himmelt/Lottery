package org.soraworld.lottery.economy

import com.earth2me.essentials.Essentials
import com.earth2me.essentials.api.Economy

import java.math.BigDecimal

class EssEconomy internal constructor() : IEconomy {

    init {
        Essentials::class.toString()
        Economy::class.toString()
    }

    override fun setEco(player: String, amount: Double): Boolean {
        return try {
            Economy.setMoney(player, BigDecimal.valueOf(amount))
            true
        } catch (ignored: Throwable) {
            false
        }
    }

    override fun addEco(player: String, amount: Double): Boolean {
        return try {
            Economy.add(player, BigDecimal.valueOf(amount))
            true
        } catch (ignored: Throwable) {
            false
        }
    }

    override fun getEco(player: String): Double {
        return try {
            Economy.getMoneyExact(player).toDouble()
        } catch (ignored: Throwable) {
            0.0
        }
    }

    override fun hasEnough(player: String, amount: Double): Boolean {
        return try {
            Economy.hasEnough(player, BigDecimal.valueOf(amount))
        } catch (ignored: Throwable) {
            false
        }
    }

    override fun takeEco(player: String, amount: Double): Boolean {
        return try {
            Economy.substract(player, BigDecimal.valueOf(amount))
            true
        } catch (ignored: Throwable) {
            false
        }
    }

}
