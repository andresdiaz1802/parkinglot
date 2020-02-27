package com.ceiba.parkinglot_adn.domain.interfaces

import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface InfoModelInterface {
    fun extractList(vehicles: List<VehicleDomain>)
}