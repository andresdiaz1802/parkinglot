package com.ceiba.parkinglot_adn.presentation.interfaces

import android.os.Bundle
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface MainInterface {

    interface View {
        fun showErrorPlate(id: Int)
        fun hideErrorPlate()
        fun showErrorCylindrical(id: Int)
        fun hideErrorCylindrical()
        fun showAllVehicles(args: Bundle)
        fun showAlertSuccess(string: String)
        fun stateFieldCylindrical(id: Int)
    }

    interface Presenter {
        fun insertVehicle(plate: String, cylindrical: String, type: Int, active: Boolean = true)
        fun showErrorPlate(id: Int)
        fun hideErrorPlate()
        fun showErrorCylindrical(id: Int)
        fun hideErrorCylindrical()
        fun showAllVehicles(string: String)
        fun showAlertSuccess(string: String)
        fun stateFieldCylindrical(type: Int)
        fun consultTableVehicles(type: Int)
    }
}