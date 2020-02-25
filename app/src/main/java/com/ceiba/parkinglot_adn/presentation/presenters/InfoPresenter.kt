package com.ceiba.parkinglot_adn.presentation.presenters

import com.ceiba.parkinglot_adn.domain.Interfaces
import com.ceiba.parkinglot_adn.domain.model.InfoModel
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.interfaces.InfoInterface

class InfoPresenter(private val view: InfoInterface.View) :
    InfoInterface.Presenter {
    private val model: Interfaces.InfoModel = InfoModel(this)
    override fun addAdapterVehicle(vehicles: List<VehicleDomain>) {
        view.addAdapterVehicle(vehicles)
    }

    override fun extractList(string: String) {
        model.extractList(string)
    }

}