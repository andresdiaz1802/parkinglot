package com.ceiba.parkinglot_adn.domain.model

import com.ceiba.parkinglot_adn.domain.objects.Motorcycle_Domain
import com.ceiba.parkinglot_adn.domain.tools.PRICE_CAR_DAY
import com.ceiba.parkinglot_adn.domain.tools.PRICE_CAR_HOUR

class ValidatesDomain {

    private val LETTER_A: Char = 'a'

    fun canAddToParkingLot(count: Int, total: Int): Boolean {
        if (count < total) {
            return true
        }
        return false
    }

    fun letterInitPlateIsA(plate: String): Boolean {
        if (plate[0].equals(LETTER_A, ignoreCase = true)) {
            return true
        }
        return false
    }

    fun canInParkingLotForDay(day: Int, plate: String): Boolean {
        if ((day == 1 || day == 2) && letterInitPlateIsA(plate)) {
            return false
        }
        return true
    }

    fun cylindricalIsUp(motorcycleDomain: Motorcycle_Domain): Int {
        if (motorcycleDomain.cylindrical > 500) {
            return 2000
        }
        return 0
    }

    fun totalToPay(hours: Int): Double {
        if (hours < 9) {
            return hours * PRICE_CAR_HOUR
        }
        var days: Int = hours / 24
        return PRICE_CAR_DAY
    }
}