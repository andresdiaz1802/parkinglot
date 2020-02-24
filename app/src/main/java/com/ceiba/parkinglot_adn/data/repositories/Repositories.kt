package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface Repositories {
    interface VehicleRepository {
        fun insert(vehicleDomain: VehicleDomain): Long
        fun selectAll(): List<VehicleDomain>
        fun selectAllType(type: Int): List<VehicleDomain>
        fun select(plate: String): List<VehicleDomain>
        fun deleteAll()
        fun delete(plate: String)
    }

    interface MotorcycleRepository {
        fun insert(motorcycleDomain: MotorcycleDomain)
        fun selectAll(): List<MotorcycleDomain>
        fun select(idVehicle: Int): List<MotorcycleDomain>
        fun deleteAll()
        fun delete(idVehicle: Int)
    }
}