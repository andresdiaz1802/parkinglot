package com.ceiba.parkinglot_adn.presentation.interfaces

import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface MainPresenterInterface {

    fun insertVehicle(
        site: String, plate: String, cylindrical: String, type: Int, active: Boolean = true
    )

    fun deleteVehicle(plate: String)
    fun consultVehicle(plate: String)
    fun showAllVehicles(vehicles: List<VehicleDomain>)
    fun stateAction(idAction: Int, idType: Int)
    fun stateFieldCylindrical(type: Int)
    fun consultTableVehicles(type: Int)
    fun showTotalToPay(string: String)
}