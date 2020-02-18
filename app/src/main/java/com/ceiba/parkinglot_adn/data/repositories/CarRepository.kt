package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.domain.objects.CarDomain

interface CarRepository {
    fun insert(carDomain: CarDomain)
    fun selectAll(): List<CarDomain>
    fun select(plate: String): CarDomain
    fun delete(plate: String)
}