package com.ceiba.parkinglot_adn.presentation.presenters

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.ceiba.parkinglot_adn.R
import com.ceiba.parkinglot_adn.domain.model.MainModel
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.interfaces.MainInterface

class MainPresenter(private val view: MainInterface.View) : MainInterface.Presenter {

    private val model: MainInterface.Model = MainModel(this)

    // Value 0 is car and value 1 is motorcycle
    val type: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }
    val plate: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val cylindrical: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    var showField: Boolean = false
//    private val registerServices: RegisterServices = RegisterServices(context)

    init {
        type.postValue(R.id.rb_car)
    }

    fun showCylindricalField() {
//        Log.d("MessengerMotorcycle", "$showField")
//        showField = false
    }

    fun hideCylindricalField() {
//        Log.d("MessengerMotorcycle", "$showField")
//        showField = true
    }

    override fun insertVehicle(plate: String, cylindrical: String, type: Int, active: Boolean) {
        var count = 0
        val typeVehicle = if (type == R.id.rb_motorcycle) 1 else 0
        if (plate.isEmpty()) {
            view.showErrorPlate(R.string.field_not_empty)
        } else count++
        if (typeVehicle == 1) {
            if (cylindrical.isEmpty()) view.showErrorCylindrical(R.string.field_not_empty)
            else count++
        } else count++
        if (count == 2) model.insertVehicle(plate, cylindrical, typeVehicle, active)
    }

    override fun showErrorPlate(id: Int) {
        view.showErrorPlate(id)
    }

    override fun hideErrorPlate() {
        view.hideErrorPlate()
    }

    override fun showErrorCylindrical(id: Int) {
        view.showErrorCylindrical(id)
    }

    override fun hideErrorCylindrical() {
        view.hideErrorCylindrical()
    }

    override fun showAllVehicles(vehicles: List<VehicleDomain>) {
        view.showAllVehicles(vehicles)
    }

    override fun showAlertSuccess(string: String) {
        view.showAlertSuccess(string)
    }

    override fun stateFieldCylindrical(type: Int) {
        view.stateFieldCylindrical(if (type == 0) View.GONE else View.VISIBLE)
    }

    override fun consultTableVehicles(type: Int) {
        model.consultTableVehicles(type)
    }
}