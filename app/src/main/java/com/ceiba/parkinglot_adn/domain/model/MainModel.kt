package com.ceiba.parkinglot_adn.domain.model

import com.ceiba.parkinglot_adn.data.repositories.MotorcycleRepositoryImpl
import com.ceiba.parkinglot_adn.data.repositories.Repositories
import com.ceiba.parkinglot_adn.data.repositories.VehicleRepositoryImpl
import com.ceiba.parkinglot_adn.domain.Interfaces
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.domain.tools.*
import com.ceiba.parkinglot_adn.presentation.interfaces.MainInterface
import java.util.*


class MainModel(private val presenter: MainInterface.Presenter) : Interfaces.MainModel {

    private val vehicleRepository: Repositories.VehicleRepository = VehicleRepositoryImpl()
    private val motorcycleRepository: Repositories.MotorcycleRepository = MotorcycleRepositoryImpl()
    private val modelMapper = ModelMapper()
    private val validatesDomain: ValidatesDomain = ValidatesDomain()

    override fun insertVehicle(
        site: Int, plate: String, cylindrical: String, type: Int, active: Boolean
    ) {
        if (!validatesDomain.canAddToParkingLot(
                vehicleRepository.count(type), if (type == 0) TOTAL_CAR else TOTAL_MOTORCYCLE
            )
        ) {
            presenter.showAlert(NO_SPACE)
            return
        }
        if (!validatesDomain.canInParkingLotForDay(5, plate)) {
            presenter.showAlert(NO_PERMISSION)
            return
        }
        if (vehicleRepository.exist(plate)) {
            presenter.showAlert(PLATE_EXIST)
            return
        }
        if (vehicleRepository.isOccupied(site)) {
            presenter.showAlert(SITE_OCCUPIED)
            return
        }
        val status = vehicleRepository.insert(VehicleDomain(plate, Date().time, type, site)).toInt()
        if (status == -1) {
            presenter.showAlert(ERROR)
            return
        }
        if (type == 1) {
            motorcycleRepository.insert(MotorcycleDomain(plate, cylindrical.toDouble()))
            // Validar cuando no se cree eliminando el vehiculo para no tener problemas
        }
        presenter.showAlert(SUCCESS)
    }

    private fun validateExist(plate: String): Boolean {
        if (!vehicleRepository.exist(plate)) {
            presenter.showAlert(PLATE_NOT_EXIST)
            return true
        }
        return false
    }

    override fun consultVehicle(plate: String) {
        if (validateExist(plate)) {
            return
        }
        val vehicleDomain = vehicleRepository.select(plate)
        presenter.showVehicle(vehicleDomain)
    }

    override fun deleteVehicle(plate: String) {
        if (validateExist(plate)) {
            return
        }
        val vehicleDomain = vehicleRepository.select(plate)
        var plus = 0
        if (vehicleDomain.type == ID_MOTORCYCLE) {
            val motorcycleDomain = motorcycleRepository.select(plate)
            plus += validatesDomain.cylindricalIsUp(motorcycleDomain.cylindrical)
        }
        val price = validatesDomain.totalToPay(vehicleDomain.toHour(), vehicleDomain.type) + plus
        presenter.showTotalToPay("The value to be paid is of $price")
        vehicleRepository.delete(plate)
    }

    override fun consultTableVehicles(type: Int) {
        presenter.showAllVehicles(
            modelMapper.toStringModelMapper(vehicleRepository.selectAllType(type))
        )
    }
}