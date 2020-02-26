package com.ceiba.parkinglot_adn.domain

import com.ceiba.parkinglot_adn.domain.tools.ValidatesDomain
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
        assertEquals(true, validate.canInParkingLotForDay(1, "ABC123"))
        assertEquals(true, validate.canInParkingLotForDay(2, "ABC123"))
        assertEquals(false, validate.canInParkingLotForDay(5, "ABC123"))
        assertEquals(true, validate.canInParkingLotForDay(1, "HBC123"))
        assertEquals(true, validate.canInParkingLotForDay(2, "HBC123"))
        assertEquals(true, validate.canInParkingLotForDay(5, "HBC123"))
    }

    @Test
    fun cylindricalIsUpTest() {
//        assertEquals(
//            2000, validate.cylindricalIsUp(
//                MotorcycleDomain("ABC123", 600.0)
//            )
//        )
    }

    @Test
    fun totalToPayTest() {
        assertEquals(8000, validate.totalToPay(10, 0))
        assertEquals(3000, validate.totalToPay(3, 0))
        assertEquals(7000, validate.totalToPay(7, 0))
        assertEquals(8000, validate.totalToPay(10, 0))
        assertEquals(14000, validate.totalToPay(30, 0))
        assertEquals(40000, validate.totalToPay(120, 0))
        assertEquals(40000, validate.totalToPay(120, 0))
    }
}