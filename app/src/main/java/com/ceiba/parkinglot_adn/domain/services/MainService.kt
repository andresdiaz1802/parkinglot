package com.ceiba.parkinglot_adn.domain.services

import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface MainService {
    fun insertVehicle(
        site: Int, plate: String, cylindrical: String, type: Int, active: Boolean = true
    ): String

    fun consultVehicle(plate: String): VehicleDomain?
    fun deleteVehicle(plate: String): String?
    fun consultTableVehicles(type: Int): List<VehicleDomain>?
}