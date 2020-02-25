package com.ceiba.parkinglot_adn.presentation.views

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ceiba.parkinglot_adn.R
import com.ceiba.parkinglot_adn.presentation.interfaces.MainInterface
import com.ceiba.parkinglot_adn.presentation.presenters.MainPresenter

class MainActivity : AppCompatActivity(), MainInterface.View, View.OnClickListener {

    private lateinit var site: EditText
    private lateinit var plate: EditText
    private lateinit var cylindrical: EditText
    private lateinit var type: RadioGroup
    private lateinit var action: RadioGroup

    private lateinit var presenter: MainInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        site = findViewById(R.id.et_site)
        plate = findViewById(R.id.et_plate)
        cylindrical = findViewById(R.id.et_cylindrical)
        type = findViewById(R.id.rg_type)
        action = findViewById(R.id.rg_action)
        presenter = MainPresenter(this)
    }

    override fun showErrorSite(id: Int) {
        site.error = getString(id)
    }

    override fun hideErrorSite() {
        site.error = null
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

    override fun showAllVehicles(args: Bundle) {
        val dialog = InfoDialog()
        dialog.isCancelable = false
        dialog.arguments = args
        dialog.show(supportFragmentManager, "Information")
    }

    override fun showAlert(id: Int) {
        Toast.makeText(this, getString(id), Toast.LENGTH_LONG).show()
    }

    override fun stateFieldCylindrical(id: Int) {
        cylindrical.visibility = id
    }

    override fun actionAdd(flag: Boolean) {
        site.visibility = View.VISIBLE
        plate.visibility = View.VISIBLE
        cylindrical.visibility = if (flag) View.VISIBLE else View.GONE
    }

    override fun actionSearchOrGetOut() {
        site.visibility = View.GONE
        plate.visibility = View.VISIBLE
        cylindrical.visibility = View.GONE
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_send -> {
                presenter.insertVehicle(
                    site.text.toString(),
                    plate.text.toString(),
                    cylindrical.text.toString(),
                    type.checkedRadioButtonId
                )
            }
            R.id.bt_show_cars -> {
                presenter.consultTableVehicles(0)
            }
            R.id.bt_show_motorcycles -> {
                presenter.consultTableVehicles(1)
            }
            R.id.rb_add, R.id.rb_search, R.id.rb_get_out, R.id.rb_car, R.id.rb_motorcycle -> {
                presenter.stateAction(action.checkedRadioButtonId, type.checkedRadioButtonId)
            }
        }
    }
}
