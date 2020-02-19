package com.ceiba.parkinglot_adn.presentation.presenters

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ceiba.parkinglot_adn.domain.services.RegisterServices

class MainPresenter(private val viewPresenter: ViewPresenter) {

    val plate: MutableLiveData<String> = MutableLiveData()
    val cylindrical: MutableLiveData<String> = MutableLiveData()

    fun onClickSend() {
        Log.d("Presenter", "${plate.value}")
        val registerServices: RegisterServices = RegisterServices()
    }

    interface ViewPresenter {
    }
}