package com.ceiba.parkinglot_adn.domain

interface Interfaces {
    interface MainModel {
        fun insertVehicle(
            site: Int, plate: String, cylindrical: String, type: Int, active: Boolean = true
        )

        fun consultVehicle(plate: String)
        fun deleteVehicle(plate: String)
        fun consultTableVehicles(type: Int)
    }

    interface InfoModel {
        fun extractList(string: String)
    }
}