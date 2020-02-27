package com.ceiba.parkinglot_adn.presentation.interfaces

import android.os.Bundle
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface MainActivityInterface {
    // Shows

    fun showVehicle(vehicleDomain: VehicleDomain)
    fun showTotalToPay(string: String)
    fun showErrorCylindrical(id: Int)
    fun showAllVehicles(args: Bundle)
    fun showErrorPlate(id: Int)
    fun showErrorSite(id: Int)
    fun showAlert(id: Int)
    // Hides

    fun hideErrorSite()
    fun hideErrorPlate()
    fun hideErrorCylindrical()
    //Others

    fun stateFieldCylindrical(id: Int)
    fun actionAdd(flag: Boolean)
    fun actionSearchOrGetOut()
}