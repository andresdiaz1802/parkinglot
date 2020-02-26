package com.ceiba.parkinglot_adn.domain.model

import com.ceiba.parkinglot_adn.domain.Interfaces
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.base.BaseApplication
import com.ceiba.parkinglot_adn.presentation.interfaces.InfoInterface
import com.google.gson.Gson
import javax.inject.Inject

class InfoModel(private val presenter: InfoInterface.Presenter) :
    Interfaces.InfoModel {

    @Inject
    lateinit var gson: Gson

    init {
        BaseApplication.getApplicationComponent()?.inject(this)
    }

    override fun extractList(string: String) {
        presenter.addAdapterVehicle(
            gson.fromJson(
                string,
                Array<VehicleDomain>::class.java
            ).toList()
        )
    }

}