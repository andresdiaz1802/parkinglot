package com.ceiba.parkinglot_adn.presentation.presenters

import android.os.Bundle
import android.view.View
import com.ceiba.parkinglot_adn.R
import com.ceiba.parkinglot_adn.domain.interfaces.MainModelInterface
import com.ceiba.parkinglot_adn.domain.services.MainModel
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.interfaces.MainActivityInterface
import com.ceiba.parkinglot_adn.presentation.interfaces.MainPresenterInterface
import java.io.Serializable

private const val VEHICLE = "vehicle"
private const val NO_SPACE = "no_space"
private const val NO_PERMISSION = "no_permission"
private const val SUCCESS = "success"
private const val SITE_OCCUPIED = "site_occupied"
private const val PLATE_EXIST = "plate_exist"
private const val PLATE_NOT_EXIST = "plate_not_exist"
private const val EMPTY = "empty"

class MainPresenter(private val view: MainActivityInterface) : MainPresenterInterface {

    private val model: MainModelInterface = MainModel(this)

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
        if (count == 3) model.insertVehicle(site.toInt(), plate, cylindrical, typeVehicle, active)
    }

    override fun deleteVehicle(plate: String) {
        if (plate.isEmpty()) {
            view.showErrorPlate(R.string.field_not_empty)
        } else {
            model.deleteVehicle(plate)
        }
    }

    override fun showVehicle(vehicleDomain: VehicleDomain) {
        view.showVehicle(vehicleDomain)
    }

    override fun consultVehicle(plate: String) {
        if (plate.isEmpty()) {
            view.showErrorPlate(R.string.field_not_empty)
        }
        model.consultVehicle(plate)
    }

    override fun showAllVehicles(vehicles: List<VehicleDomain>) {
        val args = Bundle()
        args.putSerializable(VEHICLE, vehicles as Serializable)
        view.showAllVehicles(args)
    }

    override fun showAlert(string: String) {
        view.showAlert(
            when (string) {
                SUCCESS -> R.string.successfully_saved
                NO_SPACE -> R.string.no_space
                NO_PERMISSION -> R.string.no_permission
                SITE_OCCUPIED -> R.string.site_occupied
                PLATE_EXIST -> R.string.plate_exist
                PLATE_NOT_EXIST -> R.string.plate_not_exist
                EMPTY -> R.string.empty
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

    override fun showTotalToPay(string: String) {
        view.showTotalToPay(string)
    }
}