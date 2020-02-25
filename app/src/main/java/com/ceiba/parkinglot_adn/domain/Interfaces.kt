package com.ceiba.parkinglot_adn.domain

interface Interfaces {
    interface MainModel{
        fun insertVehicle(plate: String, cylindrical: String, type: Int, active: Boolean = true)
        fun consultTableVehicles(type: Int)
    }
    interface InfoModel{
        fun extractList(string: String)
    }
}