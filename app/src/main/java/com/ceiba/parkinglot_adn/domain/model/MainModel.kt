package com.ceiba.parkinglot_adn.domain.model

import com.ceiba.parkinglot_adn.data.repositories.MotorcycleRepositoryImpl
import com.ceiba.parkinglot_adn.data.repositories.Repositories
import com.ceiba.parkinglot_adn.data.repositories.VehicleRepositoryImpl
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.interfaces.MainInterface
import java.util.*

class MainModel(private val presenter: MainInterface.Presenter) : MainInterface.Model {

    private val vehicleRepository: Repositories.VehicleRepository = VehicleRepositoryImpl()
    private val motorcycleRepository: Repositories.MotorcycleRepository = MotorcycleRepositoryImpl()

    override fun insertVehicle(plate: String, cylindrical: String, type: Int, active: Boolean) {
        val id = vehicleRepository.insert(VehicleDomain(plate, Date(), type, active))
        if (type == 1) {
            motorcycleRepository.insert(MotorcycleDomain(id.toInt(), cylindrical.toDouble()))
        }
        presenter.showAlertSuccess("Success")
    }

    override fun consultTableVehicles(type: Int) {
        presenter.showAllVehicles(vehicleRepository.selectAllType(type))
    }
}