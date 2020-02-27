package com.ceiba.parkinglot_adn.domain.services

import com.ceiba.parkinglot_adn.domain.TOTAL_CAR
import com.ceiba.parkinglot_adn.domain.TOTAL_MOTORCYCLE
import com.ceiba.parkinglot_adn.domain.business_logic.ValidatesDomain
import com.ceiba.parkinglot_adn.domain.interfaces.MainModelInterface
import com.ceiba.parkinglot_adn.domain.interfaces.MotorcycleRepositoryInterface
import com.ceiba.parkinglot_adn.domain.interfaces.VehicleRepositoryInterface
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.base.BaseApplication
import com.ceiba.parkinglot_adn.presentation.interfaces.MainPresenterInterface
import java.util.*
import javax.inject.Inject

private const val NO_SPACE = "no_space"
private const val SUCCESS = "success"
private const val ERROR = "error"
private const val NO_PERMISSION = "no_permission"
private const val SITE_OCCUPIED = "site_occupied"
private const val PLATE_EXIST = "plate_exist"
private const val PLATE_NOT_EXIST = "plate_not_exist"

private const val ID_MOTORCYCLE = 1

class MainModel(private val presenter: MainPresenterInterface) : MainModelInterface {

    @Inject
    lateinit var vehicleRepository: VehicleRepositoryInterface
    @Inject
    lateinit var motorcycleRepository: MotorcycleRepositoryInterface
    @Inject
    lateinit var validatesDomain: ValidatesDomain

    init {
        BaseApplication.getApplicationComponent()?.inject(this)
    }

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
        presenter.showAllVehicles(vehicleRepository.selectAllType(type))
    }
}