package com.ceiba.parkinglot_adn.domain.model

import android.util.Log
import com.ceiba.parkinglot_adn.data.repositories.MotorcycleRepositoryImpl
import com.ceiba.parkinglot_adn.data.repositories.Repositories
import com.ceiba.parkinglot_adn.data.repositories.VehicleRepositoryImpl
import com.ceiba.parkinglot_adn.domain.Interfaces
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.interfaces.MainInterface
import java.util.*

class MainModel(private val presenter: MainInterface.Presenter) : Interfaces.MainModel {

    private val vehicleRepository: Repositories.VehicleRepository = VehicleRepositoryImpl()
    private val motorcycleRepository: Repositories.MotorcycleRepository = MotorcycleRepositoryImpl()
    private val modelMapper = ModelMapper()

    override fun insertVehicle(plate: String, cylindrical: String, type: Int, active: Boolean) {
        val id = vehicleRepository.insert(VehicleDomain(plate, Date(), type, active)).toInt()
        if (id != -1) {
            if (type == 1) {
                motorcycleRepository.insert(MotorcycleDomain(id, cylindrical.toDouble()))
            }
            presenter.showAlertSuccess("Success")
        } else presenter.showAlertSuccess("Error")
    }

    override fun consultTableVehicles(type: Int) {
        presenter.showAllVehicles(
            modelMapper.toStringModelMapper(vehicleRepository.selectAllType(type))
        )
    }
}