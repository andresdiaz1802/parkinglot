package com.ceiba.parkinglot_adn.domain.interfaces

interface MainModelInterface {
    fun insertVehicle(
        site: Int, plate: String, cylindrical: String, type: Int, active: Boolean = true
    )

    fun consultVehicle(plate: String)
    fun deleteVehicle(plate: String)
    fun consultTableVehicles(type: Int)
}