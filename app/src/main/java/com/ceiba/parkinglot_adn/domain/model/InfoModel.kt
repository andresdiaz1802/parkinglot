package com.ceiba.parkinglot_adn.domain.model

import com.ceiba.parkinglot_adn.domain.Interfaces
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.interfaces.InfoInterface
import com.google.gson.Gson

class InfoModel(private val presenter: InfoInterface.Presenter) :
    Interfaces.InfoModel {

    private val gson: Gson = Gson()

    override fun extractList(string: String) {
        presenter.addAdapterVehicle(gson.fromJson(string, Array<VehicleDomain>::class.java).toList())
    }

}