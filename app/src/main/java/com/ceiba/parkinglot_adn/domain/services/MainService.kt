package com.ceiba.parkinglot_adn.domain.services

import com.ceiba.parkinglot_adn.domain.TOTAL_CAR
import com.ceiba.parkinglot_adn.domain.TOTAL_MOTORCYCLE
import com.ceiba.parkinglot_adn.domain.business_logic.ValidatesDomain
import com.ceiba.parkinglot_adn.domain.interfaces.MainServiceInterface
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

class MainService : MainServiceInterface {

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
    ): String {
        if (!validatesDomain.canAddToParkingLot(
                vehicleRepository.count(type), if (type == 0) TOTAL_CAR else TOTAL_MOTORCYCLE
            )
        ) {
            return NO_SPACE
        }
        if (!validatesDomain.canInParkingLotForDay(5, plate)) {
            return NO_PERMISSION
        }
        if (vehicleRepository.exist(plate)) {
            return PLATE_EXIST
        }
        if (vehicleRepository.isOccupied(site)) {
            return SITE_OCCUPIED
        }
        val status = vehicleRepository.insert(VehicleDomain(plate, Date().time, type, site))
        if (status == -1L) {
            return ERROR
        }
        if (type == 1) {
            motorcycleRepository.insert(MotorcycleDomain(plate, cylindrical.toDouble()))
            // Validar cuando no se cree eliminando el vehiculo para no tener problemas
        }
        return SUCCESS
    }

    private fun validateExist(plate: String): Boolean {
        if (!vehicleRepository.exist(plate)) {
            return true
        }
        return false
    }

    override fun consultVehicle(plate: String): VehicleDomain? {
        if (validateExist(plate)) {
            return null
        }
        return vehicleRepository.select(plate)
    }

    override fun deleteVehicle(plate: String): String? {
        if (validateExist(plate)) {
            return null
        }
        val vehicleDomain = vehicleRepository.select(plate)
        var plus = 0
        if (vehicleDomain.type == ID_MOTORCYCLE) {
            val motorcycleDomain = motorcycleRepository.select(plate)
            plus += validatesDomain.cylindricalIsUp(motorcycleDomain.cylindrical)
        }
        val price = validatesDomain.totalToPay(vehicleDomain.toHour(), vehicleDomain.type) + plus
        vehicleRepository.delete(plate)
        return "The value to be paid is of $price"
    }

    override fun consultTableVehicles(type: Int): List<VehicleDomain>? {
        if (!vehicleRepository.existType(type)){
            return null
        }
        return vehicleRepository.selectAllType(type)
    }
}