package com.ceiba.parkinglot_adn.domain.interfaces

import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface VehicleRepositoryInterface {
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