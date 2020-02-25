package com.ceiba.parkinglot_adn.presentation.presenters

import android.os.Bundle
import android.view.View
import com.ceiba.parkinglot_adn.R
import com.ceiba.parkinglot_adn.domain.Interfaces
import com.ceiba.parkinglot_adn.domain.model.MainModel
import com.ceiba.parkinglot_adn.presentation.interfaces.MainInterface

private const val VEHICLE = "vehicle"

class MainPresenter(private val view: MainInterface.View) : MainInterface.Presenter {

    private val model: Interfaces.MainModel = MainModel(this)

    private fun getIdVehicle(type: Int): Int {
        return if (type == R.id.rb_motorcycle) 1 else 0
    }

    override fun insertVehicle(
        site: String, plate: String, cylindrical: String, type: Int, active: Boolean
    ) {
        var count = 0
        val typeVehicle = getIdVehicle(type)
        if (site.isEmpty()) {
            view.showErrorSite(R.string.field_not_empty)
        } else count++
        if (plate.isEmpty()) {
            view.showErrorPlate(R.string.field_not_empty)
        } else count++
        if (typeVehicle == 1) {
            if (cylindrical.isEmpty()) {
                view.showErrorCylindrical(R.string.field_not_empty)
            } else count++
        } else count++
        if (count == 3) model.insertVehicle(site, plate, cylindrical, typeVehicle, active)
    }

    override fun showAllVehicles(string: String) {
        val args = Bundle()
        args.putString(VEHICLE, string)
        view.showAllVehicles(args)
    }

    override fun showAlert(string: String) {
        view.showAlert(
            when (string) {
                "no_space" -> R.string.no_space
                else -> R.string.error
            }
        )
    }

    override fun stateAction(idAction: Int, idType: Int) {
        when (idAction) {
            R.id.rb_add -> {
                view.actionAdd(idType == R.id.rb_motorcycle)
            }
            R.id.rb_search, R.id.rb_get_out -> {
                view.actionSearchOrGetOut()
            }
        }
    }

    override fun stateFieldCylindrical(type: Int) {
        view.stateFieldCylindrical(if (type == 0) View.GONE else View.VISIBLE)
    }

    override fun consultTableVehicles(type: Int) {
        model.consultTableVehicles(type)
    }
}