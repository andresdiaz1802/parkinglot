package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface Repositories {
    interface VehicleRepository {
        fun insert(vehicleDomain: VehicleDomain): Long
        fun selectAll(): List<VehicleDomain>
        fun selectAllType(type: Int): List<VehicleDomain>
        fun select(plate: String): VehicleDomain
        fun selectSite(site: Int): List<VehicleDomain>
        fun isOccupied(site: Int): Boolean
        fun count(type: Int): Int
        fun exist(plate: String): Boolean
        fun deleteAll()
        fun delete(plate: String)
    }

    interface MotorcycleRepository {
        fun insert(motorcycleDomain: MotorcycleDomain)
        fun selectAll(): List<MotorcycleDomain>
        fun select(plate: String): MotorcycleDomain
        fun deleteAll()
        fun delete(plate: String)
    }
}