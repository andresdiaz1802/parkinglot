package com.ceiba.parkinglot_adn.presentation.interfaces

import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface InfoPresenterInterface {
    fun addAdapterVehicle(vehicles: List<VehicleDomain>)
    fun extractList(vehicles: List<VehicleDomain>)
}