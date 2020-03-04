package com.ceiba.parkinglot_adn

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.ceiba.parkinglot_adn.presentation.views.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class AutomatedTesting {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    private val pageParkingLot = PageParkingLot()

    @Test
    fun registerCarWithFieldsEmpty() {
        pageParkingLot.selectActionAddVehicle()
        pageParkingLot.selectTypeCar()
        pageParkingLot.clickInButtonSend()
    }

    @Test
    fun registerCarOnlyWithSite() {
        pageParkingLot.selectActionAddVehicle()
        pageParkingLot.selectTypeCar()
        pageParkingLot.writeSiteInParkingLot()
        pageParkingLot.clickInButtonSend()
    }

    @Test
    fun registerCar() {
        pageParkingLot.selectActionAddVehicle()
        pageParkingLot.selectTypeCar()
        pageParkingLot.writeSiteInParkingLot()
        pageParkingLot.writePlate()
        pageParkingLot.clickInButtonSend()
    }

    @Test
    fun registerMotorcycleFieldsEmpty() {
        pageParkingLot.selectActionAddVehicle()
        pageParkingLot.selectTypeMotorcycle()
        pageParkingLot.clickInButtonSend()
    }

    @Test
    fun registerMotorcycleOnlyWithSite() {
        pageParkingLot.selectActionAddVehicle()
        pageParkingLot.selectTypeMotorcycle()
        pageParkingLot.writeSiteInParkingLot()
        pageParkingLot.clickInButtonSend()
    }

    @Test
    fun registerMotorcycle() {
        pageParkingLot.selectActionAddVehicle()
        pageParkingLot.selectTypeMotorcycle()
        pageParkingLot.writeSiteInParkingLot()
        pageParkingLot.writePlate()
        pageParkingLot.writeCylindrical()
        pageParkingLot.clickInButtonSend()
    }

    @Test
    fun searchVehicle() {
        pageParkingLot.selectActionSearch()
        pageParkingLot.writePlate()
        pageParkingLot.clickInButtonSend()
    }

    @Test
    fun getOutVehicle() {
        pageParkingLot.selectActionGetOut()
        pageParkingLot.writePlate()
        pageParkingLot.clickInButtonSend()
    }

    @Test
    fun showAllListCar() {
        pageParkingLot.clickInButtonShowListCart()
        pageParkingLot.clickInButtonOkInDialog()
    }

    @Test
    fun showAllListMotorcycle() {
        pageParkingLot.clickInButtonShowListMotorcycle()
        pageParkingLot.clickInButtonOkInDialog()
    }
}