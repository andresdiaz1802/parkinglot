package com.ceiba.parkinglot_adn.domain.model

import com.ceiba.parkinglot_adn.data.repositories.MotorcycleRepositoryImpl
import com.ceiba.parkinglot_adn.data.repositories.Repositories
import com.ceiba.parkinglot_adn.data.repositories.VehicleRepositoryImpl
import com.ceiba.parkinglot_adn.domain.Interfaces
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.domain.tools.ModelMapper
import com.ceiba.parkinglot_adn.domain.tools.TOTAL_CAR
import com.ceiba.parkinglot_adn.domain.tools.TOTAL_MOTORCYCLE
import com.ceiba.parkinglot_adn.domain.tools.ValidatesDomain
import com.ceiba.parkinglot_adn.presentation.interfaces.MainInterface
import java.util.*

private const val NO_SPACE = "no_space"

class MainModel(private val presenter: MainInterface.Presenter) : Interfaces.MainModel {

    private val vehicleRepository: Repositories.VehicleRepository = VehicleRepositoryImpl()
    private val motorcycleRepository: Repositories.MotorcycleRepository = MotorcycleRepositoryImpl()
    private val modelMapper = ModelMapper()
    private val validatesDomain: ValidatesDomain = ValidatesDomain()

    override fun insertVehicle(
        site: String, plate: String, cylindrical: String, type: Int, active: Boolean
    ) {
        if (validatesDomain.canAddToParkingLot(
                vehicleRepository.count(type),
                if (type == 0) TOTAL_CAR else TOTAL_MOTORCYCLE
            )
        ) {
            val id = vehicleRepository.insert(VehicleDomain(plate, Date(), type, active)).toInt()
            if (id != -1) {
                if (type == 1) {
                    motorcycleRepository.insert(MotorcycleDomain(id, cylindrical.toDouble()))
                }
                presenter.showAlert("Success")
            } else presenter.showAlert("Error")
        } else {
            presenter.showAlert(NO_SPACE)
        }
    }

    override fun consultTableVehicles(type: Int) {
        presenter.showAllVehicles(
            modelMapper.toStringModelMapper(vehicleRepository.selectAllType(type))
        )
    }
}