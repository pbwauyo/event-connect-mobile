package com.planetsystems.events.util

object Utility {
    fun isNinValid(nin: String): Boolean {
        return nin.length == 14 && (nin.startsWith("CF") || nin.startsWith("CM"))
    }
}