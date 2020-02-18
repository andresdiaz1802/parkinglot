package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain

interface MotorcycleRepository {
    fun insert(motorcycleDomain: MotorcycleDomain)
    fun selectAll(): List<MotorcycleDomain>
    fun select(plate: String): MotorcycleDomain
    fun delete(plate: String)
}