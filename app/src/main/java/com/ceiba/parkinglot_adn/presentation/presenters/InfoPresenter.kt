package com.ceiba.parkinglot_adn.presentation.presenters

import com.ceiba.parkinglot_adn.domain.interfaces.InfoModelInterface
import com.ceiba.parkinglot_adn.domain.services.InfoService
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.interfaces.InfoActivityInterface
import com.ceiba.parkinglot_adn.presentation.interfaces.InfoPresenterInterface

class InfoPresenter(private val view: InfoActivityInterface) :
    InfoPresenterInterface {

    private val model: InfoModelInterface = InfoService(this)

    override fun addAdapterVehicle(vehicles: List<VehicleDomain>) {
        view.addAdapterVehicle(vehicles)
    }

    override fun extractList(vehicles: List<VehicleDomain>) {
        model.extractList(vehicles)
    }

}