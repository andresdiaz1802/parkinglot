package com.ceiba.parkinglot_adn.domain.repositories

import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface VehicleRepository {
    fun insert(vehicleDomain: VehicleDomain): Int
    fun selectAll(): List<VehicleDomain>
    fun selectAllType(type: Int): List<VehicleDomain>
    fun select(plate: String): VehicleDomain
    fun selectSite(site: Int): List<VehicleDomain>
    fun isOccupied(site: Int): Boolean
    fun count(type: Int): Int
    fun exist(plate: String): Boolean
    fun existType(type: Int): Boolean
    fun deleteAll()
    fun delete(plate: String)
}