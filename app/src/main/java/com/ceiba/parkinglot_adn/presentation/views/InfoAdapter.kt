package com.ceiba.parkinglot_adn.presentation.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.parkinglot_adn.R
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain

class InfoAdapter(private val vehicles: List<VehicleDomain>) :
    RecyclerView.Adapter<InfoAdapter.VehicleViewHolder>() {

    class VehicleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val site: TextView = itemView.findViewById(R.id.tv_site)
        val plate: TextView = itemView.findViewById(R.id.tv_plate)
        val date: TextView = itemView.findViewById(R.id.tv_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder =
        VehicleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_info, parent, false
            )
        )

    override fun getItemCount(): Int = vehicles.size

    override fun onBindViewHolder(holderVehicle: VehicleViewHolder, position: Int) {
        val vehicle = vehicles[position]
        holderVehicle.site.text = "${vehicle.site}"
        holderVehicle.plate.text = vehicle.plate
        holderVehicle.date.text = "${vehicle.toDate()}"

    }

}