package com.ceiba.parkinglot_adn.domain

import org.junit.Assert.assertEquals
import org.junit.Test

class ValidateTest {

    private val validate = Validates()

    @Test
    fun letterInitPlateIsATest() {
        assertEquals(false, validate.letterInitPlateIsA("ABC234"))
    }

    @Test
    fun canInParkingLotForDayTest() {
        // 0 is sunday and 1 is monday
        assertEquals(false, validate.canInParkingLotForDay(0, true))
    }

    /*@Test
    fun cylindricalIsUpTest() {
        Assert.assertEquals(
            2000, validate.cylindricalIsUp(
                MotorcycleDomain("ABC123", 600)
            )
        )
    }*/

    @Test
    fun totalToPayTest() {
        assertEquals(5000.0, validate.totalToPay(5), 0.0)
    }
}