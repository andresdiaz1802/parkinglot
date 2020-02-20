package com.ceiba.parkinglot_adn.presentation.presenters

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import androidx.lifecycle.MutableLiveData
import com.ceiba.parkinglot_adn.R
import com.ceiba.parkinglot_adn.domain.objects.CarDomain
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.services.RegisterServices

class MainPresenter(private val viewPresenter: ViewPresenter, private val context: Context) {

    // Value 0 is car and value 1 is motorcycle
    val type: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }
    val plate: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val cylindrical: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    var showField: Boolean = false
    private val registerServices: RegisterServices = RegisterServices(context)

    init {
        type.postValue(R.id.rb_car)
    }

    fun onClickSend() {
        when (type.value) {
            R.id.rb_car -> registerServices.registerCar(CarDomain(plate.value.toString()))
            R.id.rb_motorcycle -> {
                registerServices.registerMotorcycle(
                    MotorcycleDomain(
                        plate.value.toString(),
                        cylindrical.value!!.toDouble()
                    )
                )
            }
        }
    }

    fun onClickShowCars() {
        registerServices.showCars()
    }

    fun showCylindricalField() {
        Log.d("MessengerMotorcycle", "$showField")
        showField = false
    }

    fun hideCylindricalField() {
        Log.d("MessengerMotorcycle", "$showField")
        showField = true
    }

    interface ViewPresenter {
    }
}