package com.ceiba.parkinglot_adn.presentation.interfaces

import android.os.Bundle
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface MainInterface {

    interface View {
        fun showErrorSite(id: Int)
        fun hideErrorSite()
        fun showErrorPlate(id: Int)
        fun hideErrorPlate()
        fun showErrorCylindrical(id: Int)
        fun hideErrorCylindrical()
        fun showAllVehicles(args: Bundle)
        fun showAlert(id: Int)
        fun stateFieldCylindrical(id: Int)
        fun actionAdd(flag: Boolean)
        fun actionSearchOrGetOut()
    }

    interface Presenter {
        fun insertVehicle(
            site: String, plate: String, cylindrical: String, type: Int, active: Boolean = true
        )

        fun showAllVehicles(string: String)
        fun showAlert(string: String)
        fun stateAction(idAction: Int, idType: Int)
        fun stateFieldCylindrical(type: Int)
        fun consultTableVehicles(type: Int)
    }
}