package com.ceiba.parkinglot_adn.presentation.presenters

import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.interfaces.InfoActivityInterface
import com.ceiba.parkinglot_adn.presentation.interfaces.InfoPresenterInterface

class InfoPresenter(private val view: InfoActivityInterface) :
    InfoPresenterInterface {

    override fun extractList(vehicles: List<VehicleDomain>) {
        view.addAdapterVehicle(vehicles)
    }

}