package com.ceiba.parkinglot_adn.domain

import com.ceiba.parkinglot_adn.domain.model.ValidatesDomain
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import org.junit.Assert.assertEquals
import org.junit.Test

class ValidateTest {

    private val validate =
        ValidatesDomain()

    @Test
    fun letterInitPlateIsATest() {
        assertEquals(true, validate.letterInitPlateIsA("ABC234"))
    }

    @Test
    fun canInParkingLotForDayTest() {
        // 0 is sunday and 1 is monday
        assertEquals(true, validate.canInParkingLotForDay(5, "ABC123"))
    }

    @Test
    fun cylindricalIsUpTest() {
        assertEquals(
            2000, validate.cylindricalIsUp(
                MotorcycleDomain("ABC123", 600.0)
            )
        )
    }

    @Test
    fun totalToPayTest() {
        assertEquals(5000.0, validate.totalToPay(5), 0.0)
    }
}