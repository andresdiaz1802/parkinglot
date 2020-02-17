package com.ceiba.parkinglot_adn.presentation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.ceiba.parkinglot_adn.R
import com.ceiba.parkinglot_adn.base.BaseActivity
import com.ceiba.parkinglot_adn.presentation.presenters.MainPresenter

class MainActivity :
    BaseActivity(),
    View.OnClickListener,
    MainPresenter.View {

    private lateinit var mainPresenter: MainPresenter
    private lateinit var plate: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainPresenter = MainPresenter(this)
        plate = findViewById(R.id.et_plate)
    }

    override fun getLayout(): Int = R.layout.activity_main

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_send -> {
                mainPresenter.setEmptyField(plate.text.toString())
            }
        }
    }

    override fun showErrorFieldEmpty() {
        plate.error = getString(R.string.field_not_empty)
    }
}
