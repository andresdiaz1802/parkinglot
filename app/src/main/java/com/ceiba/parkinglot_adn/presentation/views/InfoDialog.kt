package com.ceiba.parkinglot_adn.presentation.views

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.parkinglot_adn.R
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.interfaces.InfoInterface
import com.ceiba.parkinglot_adn.presentation.presenters.InfoPresenter
import java.lang.IllegalStateException

class InfoDialog : DialogFragment(), InfoInterface.View {

    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: InfoInterface.Presenter

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
            arguments?.getString("vehicle")?.let { it1 -> presenter.extractList(it1) }
            builder.setView(view)
                .setPositiveButton(R.string.ok, null)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun addAdapterVehicle(vehicles: List<VehicleDomain>) {
        recyclerView.adapter = InfoAdapter(vehicles)
    }
}