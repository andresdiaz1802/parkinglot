package com.ceiba.parkinglot_adn.domain

import com.ceiba.parkinglot_adn.tools.PRICE_CAR_DAY
import com.ceiba.parkinglot_adn.tools.PRICE_CAR_HOUR

class Validates {

    private val LETTER_A: String = "a"

    fun letterInitPlateIsA(plate: String): Boolean {
        if (plate.substring(0).toLowerCase() == LETTER_A) {
            return true
        }
        return false
    }

    fun canInParkingLotForDay(day: Int, isA: Boolean): Boolean {
        if ((day == 0 || day == 1) && isA) {
            return false
        }
        return true
    }

    /*fun cylindricalIsUp(motorcycleDomain: MotorcycleDomain): Int {
        if (motorcycleDomain.getCylindrical() > 500) {
            return 2000
        }
        return 0
    }*/

    fun totalToPay(hours: Int): Double {
        if (hours < 9) {
            return hours * PRICE_CAR_HOUR
        }
        var days: Int = hours / 24
        return PRICE_CAR_DAY
    }
}