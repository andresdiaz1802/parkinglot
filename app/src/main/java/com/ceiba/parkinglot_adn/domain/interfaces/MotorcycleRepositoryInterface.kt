package com.ceiba.parkinglot_adn.domain.interfaces

import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain

interface MotorcycleRepositoryInterface {
    fun insert(motorcycleDomain: MotorcycleDomain)
    fun selectAll(): List<MotorcycleDomain>
    fun select(plate: String): MotorcycleDomain
    fun deleteAll()
    fun delete(plate: String)
}