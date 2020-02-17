package com.ceiba.parkinglot_adn.presentation.presenters

class MainPresenter(private val view: View) {

    fun setEmptyField(plate: String) {
        if (plate == ""){
            view.showErrorFieldEmpty()
        }
    }

    interface View {
        fun showErrorFieldEmpty()
    }
}