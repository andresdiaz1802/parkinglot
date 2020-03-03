package com.ceiba.parkinglot_adn.domain

import com.ceiba.parkinglot_adn.domain.business_logic.ValidatesDomain
import org.junit.Assert.assertEquals
import org.junit.Test

class ValidateTest {

    @Test
    fun addCarWithOneInside() {
        val validate = ValidatesDomain()
        val result = validate.canAddToParkingLot(1, TOTAL_CAR)
        assertEquals(true, result)
    }

    @Test
    fun addCarWith20Inside() {
        val validate = ValidatesDomain()
        val result = validate.canAddToParkingLot(20, TOTAL_CAR)
        assertEquals(false, result)
    }

    @Test
    fun addCarWithErrorValue() {
        val validate = ValidatesDomain()
        val result = validate.canAddToParkingLot(-1, TOTAL_CAR)
        assertEquals(false, result)
    }

    @Test
    fun addCarWithErrorValueNull() {
        val validate = ValidatesDomain()
        val result = validate.canAddToParkingLot(null, TOTAL_CAR)
        assertEquals(false, result)
    }

    @Test
    fun addMotorcycleWithOneInside() {
        val validate = ValidatesDomain()
        val result = validate.canAddToParkingLot(1, TOTAL_MOTORCYCLE)
        assertEquals(true, result)
    }

    @Test
    fun addMotorcycleWith20Inside() {
        val validate = ValidatesDomain()
        val result = validate.canAddToParkingLot(10, TOTAL_MOTORCYCLE)
        assertEquals(false, result)
    }

    @Test
    fun addMotorcycleErrorValue() {
        val validate = ValidatesDomain()
        val result = validate.canAddToParkingLot(-1, TOTAL_MOTORCYCLE)
        assertEquals(false, result)
    }

    @Test
    fun addMotorcycleErrorValueNull() {
        val validate = ValidatesDomain()
        val result = validate.canAddToParkingLot(null, TOTAL_MOTORCYCLE)
        assertEquals(false, result)
    }

    @Test
    fun letterPlateInitWithAUpperCase() {
        val validate = ValidatesDomain()
        val result = validate.letterInitPlateIsA("ABC234")
        assertEquals(true, result)
    }

    @Test
    fun letterPlateInitWithALowerCase() {
        val validate = ValidatesDomain()
        val result = validate.letterInitPlateIsA("aBC234")
        assertEquals(true, result)
    }

    @Test
    fun letterPlateInitWithJUpperCase() {
        val validate = ValidatesDomain()
        val result = validate.letterInitPlateIsA("JBC234")
        assertEquals(false, result)
    }

    @Test
    fun letterPlateInitWithJLowerCase() {
        val validate = ValidatesDomain()
        val result = validate.letterInitPlateIsA("jBC234")
        assertEquals(false, result)
    }

    @Test
    fun letterPlateWithErrorValueNull() {
        val validate = ValidatesDomain()
        val result = validate.letterInitPlateIsA(null)
        assertEquals(false, result)
    }

    @Test
    fun canEnterTheParkingLotInSundayWithInitLetterA() {
        val validate = ValidatesDomain()
        val result = validate.canInParkingLotForDay(1, "ABC123")
        assertEquals(true, result)
    }

    @Test
    fun canEnterTheParkingLotInMondayWithInitLetterA() {
        val validate = ValidatesDomain()
        val result = validate.canInParkingLotForDay(2, "ABC123")
        assertEquals(true, result)
    }

    @Test
    fun canEnterTheParkingLotInOtherDayWithInitLetterA() {
        val validate = ValidatesDomain()
        val result = validate.canInParkingLotForDay(5, "ABC123")
        assertEquals(false, result)
    }

    @Test
    fun canEnterTheParkingLotInSundayWithInitLetterH() {
        val validate = ValidatesDomain()
        val result = validate.canInParkingLotForDay(1, "HBC123")
        assertEquals(true, result)
    }

    @Test
    fun canEnterTheParkingLotInMondayWithInitLetterH() {
        val validate = ValidatesDomain()
        val result = validate.canInParkingLotForDay(2, "HBC123")
        assertEquals(true, result)
    }

    @Test
    fun canEnterTheParkingLotInOtherDayWithInitLetterH() {
        val validate = ValidatesDomain()
        val result = validate.canInParkingLotForDay(5, "HBC123")
        assertEquals(true, result)
    }

    @Test
    fun canEnterTheParkingLotWithErrorDay() {
        val validate = ValidatesDomain()
        val result = validate.canInParkingLotForDay(-1, "ABC123")
        assertEquals(false, result)
    }

    @Test
    fun canEnterTheParkingLotWithErrorDayNull() {
        val validate = ValidatesDomain()
        val result = validate.canInParkingLotForDay(null, "ABC123")
        assertEquals(false, result)
    }

    @Test
    fun canEnterTheParkingLotWithErrorPlate() {
        val validate = ValidatesDomain()
        val result = validate.canInParkingLotForDay(1, null)
        assertEquals(false, result)
    }

    @Test
    fun cylindricalIsGreaterThat500() {
        val validate = ValidatesDomain()
        val result = validate.cylindricalIsUp(600.0)
        assertEquals(2000, result)
    }

    @Test
    fun cylindricalIsSmallerThat500() {
        val validate = ValidatesDomain()
        val result = validate.cylindricalIsUp(400.0)
        assertEquals(0, result)
    }

    @Test
    fun cylindricalErrorValueNull() {
        val validate = ValidatesDomain()
        val result = validate.cylindricalIsUp(null)
        assertEquals(0, result)
    }

    @Test
    fun cylindricalErrorValue() {
        val validate = ValidatesDomain()
        val result = validate.cylindricalIsUp(-12.0)
        assertEquals(0, result)
    }

    @Test
    fun totalToPayCarWith10Hours() {
        val validate = ValidatesDomain()
        val result = validate.totalToPay(10, 0)
        assertEquals(8000, result)
    }

    @Test
    fun totalToPayCarWith3Hour() {
        val validate = ValidatesDomain()
        val result = validate.totalToPay(3, 0)
        assertEquals(3000, result)
    }

    @Test
    fun totalToPayCarWith7Hour() {
        val validate = ValidatesDomain()
        val result = validate.totalToPay(7, 0)
        assertEquals(7000, result)
    }

    @Test
    fun totalToPayCarWith10Hour() {
        val validate = ValidatesDomain()
        val result = validate.totalToPay(30, 0)
        assertEquals(14000, result)
    }

    @Test
    fun totalToPayCarWith120Hour() {
        val validate = ValidatesDomain()
        val result = validate.totalToPay(120, 0)
        assertEquals(40000, result)
    }

    @Test
    fun totalToPayMotorcycleWith10Hours() {
        val validate = ValidatesDomain()
        val result = validate.totalToPay(10, 1)
        assertEquals(4000, result)
    }

    @Test
    fun totalToPayMotorcycleWith3Hour() {
        val validate = ValidatesDomain()
        val result = validate.totalToPay(3, 1)
        assertEquals(1500, result)
    }

    @Test
    fun totalToPayMotorcycleWith7Hour() {
        val validate = ValidatesDomain()
        val result = validate.totalToPay(7, 1)
        assertEquals(3500, result)
    }

    @Test
    fun totalToPayMotorcycleWith10Hour() {
        val validate = ValidatesDomain()
        val result = validate.totalToPay(30, 1)
        assertEquals(7000, result)
    }

    @Test
    fun totalToPayMotorcycleWith120Hour() {
        val validate = ValidatesDomain()
        val result = validate.totalToPay(120, 1)
        assertEquals(20000, result)
    }

    @Test
    fun totalToPayMotorcycleWithErrorValue() {
        val validate = ValidatesDomain()
        val result = validate.totalToPay(-1, 1)
        assertEquals(0, result)
    }

    @Test
    fun totalToPayMotorcycleWithErrorValueNull() {
        val validate = ValidatesDomain()
        val result = validate.totalToPay(null, 1)
        assertEquals(0, result)
    }
}