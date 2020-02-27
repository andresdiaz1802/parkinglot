package com.ceiba.parkinglot_adn.presentation.interfaces

import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface InfoActivityInterface {
    fun addAdapterVehicle(vehicles: List<VehicleDomain>)
}