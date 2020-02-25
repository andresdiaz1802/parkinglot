package com.ceiba.parkinglot_adn.presentation.interfaces

import android.os.Bundle
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

interface InfoInterface {
    interface View {
        fun addAdapterVehicle(vehicles: List<VehicleDomain>)
    }

    interface Presenter {
        fun addAdapterVehicle(vehicles: List<VehicleDomain>)
        fun extractList(string: String)
    }
}