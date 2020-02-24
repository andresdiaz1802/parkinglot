package com.ceiba.parkinglot_adn.presentation.views

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ceiba.parkinglot_adn.R
import com.ceiba.parkinglot_adn.databinding.ActivityMainBinding
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.interfaces.MainInterface
import com.ceiba.parkinglot_adn.presentation.presenters.MainPresenter

class MainActivity : AppCompatActivity(), MainInterface.View, View.OnClickListener {

    private lateinit var plate: EditText
    private lateinit var cylindrical: EditText
    private lateinit var type: RadioGroup

    private lateinit var presenter: MainInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        plate = findViewById(R.id.et_plate)
        cylindrical = findViewById(R.id.et_cylindrical)
        type = findViewById(R.id.rg_type)

        presenter = MainPresenter(this)
    }

    fun getBinding(layout: Int): ActivityMainBinding {
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, layout)
//        binding.view = this
        return binding
    }

    override fun showErrorPlate(id: Int) {
        plate.error = getString(id)
    }

    override fun hideErrorPlate() {
        plate.error = null
    }

    override fun showErrorCylindrical(id: Int) {
        cylindrical.error = getString(id)
    }

    override fun hideErrorCylindrical() {
        cylindrical.error = null
    }

    override fun showAllVehicles(vehicles: List<VehicleDomain>) {
        vehicles.forEach { Log.d("MessengerLog", "Aquí va: $it") }
    }

    override fun showAlertSuccess(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }

    override fun stateFieldCylindrical(id: Int) {
        cylindrical.visibility = id
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_send -> {
                presenter.insertVehicle(
                    plate.text.toString(),
                    cylindrical.text.toString(),
                    type.checkedRadioButtonId
                )
            }
            R.id.bt_show_cars -> {
                presenter.consultTableVehicles(0)
            }
        }
    }
}
