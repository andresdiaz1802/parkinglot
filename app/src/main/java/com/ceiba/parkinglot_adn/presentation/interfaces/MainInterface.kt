package com.ceiba.parkinglot_adn.presentation.interfaces

import android.os.Bundle
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface MainInterface {

    interface View {
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

    interface Presenter {
        fun insertVehicle(
            site: String, plate: String, cylindrical: String, type: Int, active: Boolean = true
        )

        fun deleteVehicle(plate: String)
        fun showVehicle(vehicleDomain: VehicleDomain)
        fun consultVehicle(plate: String)
        fun showAllVehicles(string: String)
        fun showAlert(string: String)
        fun stateAction(idAction: Int, idType: Int)
        fun stateFieldCylindrical(type: Int)
        fun consultTableVehicles(type: Int)
        fun showTotalToPay(string: String)
    }
}