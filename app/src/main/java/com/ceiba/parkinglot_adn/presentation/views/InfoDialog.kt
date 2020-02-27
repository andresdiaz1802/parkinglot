package com.ceiba.parkinglot_adn.presentation.views

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.parkinglot_adn.R
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.interfaces.InfoActivityInterface
import com.ceiba.parkinglot_adn.presentation.interfaces.InfoPresenterInterface
import com.ceiba.parkinglot_adn.presentation.presenters.InfoPresenter

private const val VEHICLE = "vehicle"

class InfoDialog : DialogFragment(), InfoActivityInterface {

    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: InfoPresenterInterface

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val view = requireActivity().layoutInflater.inflate(
                R.layout.dialog_info, null
            )
            recyclerView = view.findViewById<RecyclerView>(R.id.rv_list).apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, 2)
            }
            presenter = InfoPresenter(this)
            arguments?.getSerializable(VEHICLE)
                ?.let { it1 -> (presenter as InfoPresenter).extractList(it1 as List<VehicleDomain>) }
            builder.setView(view)
                .setPositiveButton(R.string.ok, null)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun addAdapterVehicle(vehicles: List<VehicleDomain>) {
        recyclerView.adapter = InfoAdapter(vehicles)
    }
}