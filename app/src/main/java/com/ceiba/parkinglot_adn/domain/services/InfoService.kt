package com.ceiba.parkinglot_adn.domain.services

import com.ceiba.parkinglot_adn.domain.interfaces.InfoModelInterface
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.base.BaseApplication
import com.ceiba.parkinglot_adn.presentation.interfaces.InfoPresenterInterface
import com.google.gson.Gson
import javax.inject.Inject

class InfoService(private val presenter: InfoPresenterInterface) :
    InfoModelInterface {

    @Inject
    lateinit var gson: Gson

    init {
        BaseApplication.getApplicationComponent()?.inject(this)
    }

    override fun extractList(vehicles: List<VehicleDomain>) {
        presenter.addAdapterVehicle(vehicles)
    }

}