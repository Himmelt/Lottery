package org.soraworld.lottery.economy

interface IEconomy {

    fun setEco(player: String, amount: Double): Boolean

    fun addEco(player: String, amount: Double): Boolean

    fun getEco(player: String): Double

    fun hasEnough(player: String, amount: Double): Boolean

    fun takeEco(player: String, amount: Double): Boolean

}
