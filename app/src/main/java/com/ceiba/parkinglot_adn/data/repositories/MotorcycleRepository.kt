package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain

interface MotorcycleRepository {
    fun insert(motorcycleDomain: MotorcycleDomain)
    fun selectAll(): List<MotorcycleDomain>
//    fun select(plate: String): List<MotorcycleDomain>
//    fun delete(plate: String)
    fun deleteAll()
//    fun update(plate: String)
}