package com.ceiba.parkinglot_adn.domain

import com.ceiba.parkinglot_adn.domain.businesslogic.ValidatesDomain
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.domain.repositories.MotorcycleRepository
import com.ceiba.parkinglot_adn.domain.repositories.VehicleRepository
import com.ceiba.parkinglot_adn.domain.services.MainServiceImpl
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import java.util.*
import kotlin.collections.ArrayList

private const val NO_SPACE = "no_space"
private const val NO_PERMISSION = "no_permission"
private const val PLATE_EXIST = "plate_exist"
private const val SITE_OCCUPIED = "site_occupied"
private const val ERROR = "error"
private const val SUCCESS = "success"
private const val ID_MOTORCYCLE = 1

class DomainServicesTest {

    @get:Rule
    var mockitoRule: MockitoRule? = MockitoJUnit.rule()

    @Mock
    lateinit var vehicleRepository: VehicleRepository

    @Mock
    lateinit var motorcycleRepository: MotorcycleRepository

    private lateinit var validatesDomain: ValidatesDomain

    lateinit var mainService: MainServiceImpl

    @Before
    fun setup() {
        validatesDomain = ValidatesDomain()
        mainService = MainServiceImpl(vehicleRepository, motorcycleRepository, validatesDomain)
    }

    @Test
    fun insertCarFailedForSpace() {
        // Arrange
        val type = 0
        val plate = "ABC123"
        val cylindrical = "0"
        val site = 0
        `when`(vehicleRepository.count(type)).thenReturn(20)
        // Act
        val result = mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(NO_SPACE, result)
    }

    @Test
    fun insertCarFailedForPlateAndDay() {
        // Arrange
        val type = 0
        val plate = "ABC123"
        val cylindrical = "0"
        val site = 0
        val day = 5
        `when`(vehicleRepository.count(type)).thenReturn(2)
        // Act
        val result = mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(NO_PERMISSION, result)
    }

    @Test
    fun insertCarFailedForPlateExist() {
        // Arrange
        val type = 0
        val plate = "HBC123"
        val cylindrical = "0"
        val site = 0
        val day = 5
        `when`(vehicleRepository.count(type)).thenReturn(2)
        `when`(vehicleRepository.exist(plate)).thenReturn(true)
        // Act
        val result = mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(PLATE_EXIST, result)
    }

    @Test
    fun insertCarFailedForSiteOccupied() {
        // Arrange
        val type = 0
        val plate = "HBC123"
        val cylindrical = "0"
        val site = 0
        val day = 5
        `when`(vehicleRepository.count(type)).thenReturn(2)
        `when`(vehicleRepository.exist(plate)).thenReturn(false)
        `when`(vehicleRepository.isOccupied(site)).thenReturn(true)
        // Act
        val result = mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(SITE_OCCUPIED, result)
    }

    @Test
    fun insertCarFailedForInsertDAO() {
        // Arrange
        val type = 0
        val plate = "HBC123"
        val cylindrical = "0"
        val site = 0
        val day = 5
        val vehicleDomain = VehicleDomain(plate, Date().time, type, site)
        `when`(vehicleRepository.count(type)).thenReturn(2)
        `when`(vehicleRepository.exist(plate)).thenReturn(false)
        `when`(vehicleRepository.isOccupied(site)).thenReturn(false)
        `when`(vehicleRepository.insert(vehicleDomain)).thenReturn(0)
        // Act
        val result = mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(ERROR, result)
    }

    @Test
    fun insertCarSuccess() {
        // Arrange
        val type = 0
        val plate = "HBC123"
        val cylindrical = "0"
        val site = 0
        val vehicleDomain = VehicleDomain(plate, Date().time, type, site)
        `when`(vehicleRepository.count(type)).thenReturn(2)
        `when`(vehicleRepository.exist(plate)).thenReturn(false)
        `when`(vehicleRepository.isOccupied(site)).thenReturn(false)
        `when`(vehicleRepository.insert(vehicleDomain)).thenReturn(1)
        // Act
        val result = mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(SUCCESS, result)
    }

    @Test
    fun insertMotorcycleFailedForSpace() {
        // Arrange
        val type = 1
        val plate = "ABC123"
        val cylindrical = "400"
        val site = 0
        `when`(vehicleRepository.count(type)).thenReturn(10)
        // Act
        val result = mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(NO_SPACE, result)
    }

    @Test
    fun insertMotorcycleFailedForPlateAndDay() {
        // Arrange
        val type = 1
        val plate = "ABC123"
        val cylindrical = "600"
        val site = 0
        val day = 5
        `when`(vehicleRepository.count(type)).thenReturn(1)
        // Act
        val result = mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(NO_PERMISSION, result)
    }

    @Test
    fun insertMotorcycleFailedForPlateExist() {
        // Arrange
        val type = 1
        val plate = "HBC123"
        val cylindrical = "600"
        val site = 0
        val day = 5
        `when`(vehicleRepository.count(type)).thenReturn(1)
        `when`(vehicleRepository.exist(plate)).thenReturn(true)
        // Act
        val result = mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(PLATE_EXIST, result)
    }

    @Test
    fun insertMotorcycleFailedForSiteOccupied() {
        // Arrange
        val type = 1
        val plate = "HBC123"
        val cylindrical = "6000"
        val site = 0
        `when`(vehicleRepository.count(type)).thenReturn(1)
        `when`(vehicleRepository.exist(plate)).thenReturn(false)
        `when`(vehicleRepository.isOccupied(site)).thenReturn(true)
        // Act
        val result = mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(SITE_OCCUPIED, result)
    }

//    @Test
//    fun insertMotorcycleFailedForInsertDAO() {
//        /**
//         * Revisar este test
//         */
//        // Arrange
//        val type = 1
//        val plate = "ABC123"
//        val cylindrical = "0"
//        val site = 0
//        val day = 5
//        `when`(validatesDomain.canAddToParkingLot(vehicleRepository.count(type), TOTAL_MOTORCYCLE))
//            .thenReturn(true)
//        `when`(validatesDomain.canInParkingLotForDay(day, plate)).thenReturn(true)
//        `when`(vehicleRepository.exist(plate)).thenReturn(false)
//        `when`(vehicleRepository.isOccupied(site)).thenReturn(false)
//        `when`(vehicleRepository.insert(vehicle)).thenReturn(1L)
//        // Act
//        val result =
//            mainService.insertVehicle(site, plate, cylindrical, type)
//        // Assert
//        assertEquals(ERROR, result)
//    }

//    @Test
//    fun insertMotorcycleSuccess() {
//        // Arrange
//        val type = 1
//        val plate = "ABC123"
//        val cylindrical = "200"
//        val site = 0
//        val day = 5
//        `when`(validatesDomain.canAddToParkingLot(vehicleRepository.count(type), TOTAL_MOTORCYCLE))
//            .thenReturn(true)
//        `when`(validatesDomain.canInParkingLotForDay(day, plate)).thenReturn(true)
//        `when`(vehicleRepository.exist(plate)).thenReturn(false)
//        `when`(vehicleRepository.isOccupied(site)).thenReturn(false)
//        `when`(vehicleRepository.insert(VehicleDomain(plate, Date().time, type, site)))
//            .thenReturn(1L)
//        // Act
//        val result =
//            mainServiceImpl.insertVehicle(site, plate, cylindrical, type)
//        // Assert
//        assertEquals(SUCCESS, result)
//    }

    @Test
    fun consultVehicleWithPlateNull() {
        // Arrange
        val plate = "ABC123"
        `when`(vehicleRepository.exist(plate)).thenReturn(false)
        // Act
        val result = mainService.consultVehicle(plate)
        // Assert
        assertEquals(null, result)
    }

    @Test
    fun consultVehicleWithPlateSuccess() {
        // Arrange
        val type = 1
        val plate = "ABC123"
        val site = 0
        val vehicleDomain = VehicleDomain(plate, Date().time, type, site)
        `when`(vehicleRepository.exist(plate)).thenReturn(true)
        `when`(vehicleRepository.select(plate)).thenReturn(vehicleDomain)
        // Act
        val result = mainService.consultVehicle(plate)
        // Assert
        assertEquals(vehicleDomain, result)
    }

    @Test
    fun deleteVehicleThatNotExist() {
        // Arrange
        val plate = "ABC123"
        `when`(vehicleRepository.exist(plate)).thenReturn(false)
        // Act
        val result = mainService.deleteVehicle(plate)
        // Assert
        assertEquals(null, result)
    }

    @Test
    fun deleteCar() {
        // Arrange
        val type = 0
        val plate = "HBC123"
        val cylindrical = "0"
        val site = 0
        val day = 5
        val vehicleDomain = VehicleDomain(plate, Date().time, type, site)
        `when`(vehicleRepository.exist(plate)).thenReturn(true)
        `when`(vehicleRepository.select(plate)).thenReturn(vehicleDomain)
        // Act
        val result = mainService.deleteVehicle(plate)
        // Assert
        assertEquals("The value to be paid is of 1000", result)
    }

    @Test
    fun deleteMotorcycleCylindricalOf800() {
        // Arrange
        val type = 1
        val plate = "HBC123"
        val cylindrical = 800.0
        val site = 0
        val day = 5
        val vehicle = VehicleDomain(plate, Date().time, type, site)
        val motorcycle = MotorcycleDomain(vehicle.plate, cylindrical)
        `when`(vehicleRepository.exist(plate)).thenReturn(true)
        `when`(vehicleRepository.select(plate)).thenReturn(vehicle)
        `when`(motorcycleRepository.select(plate)).thenReturn(motorcycle)
        // Act
        val result = mainService.deleteVehicle(plate)
        // Assert
        assertEquals("The value to be paid is of 2500", result)
    }

    @Test
    fun deleteMotorcycleCylindricalOf200() {
        // Arrange
        val type = 1
        val plate = "HBC123"
        val cylindrical = 200.0
        val site = 0
        val day = 5
        val vehicle = VehicleDomain(plate, Date().time, type, site)
        val motorcycle = MotorcycleDomain(vehicle.plate, cylindrical)
        `when`(vehicleRepository.exist(plate)).thenReturn(true)
        `when`(vehicleRepository.select(plate)).thenReturn(vehicle)
        `when`(motorcycleRepository.select(plate)).thenReturn(motorcycle)
        // Act
        val result = mainService.deleteVehicle(plate)
        // Assert
        assertEquals("The value to be paid is of 500", result)
    }

    @Test
    fun consultTableCarEmpty() {
        // Arrage
        val type = 0
        `when`(vehicleRepository.existType(type)).thenReturn(false)
        // Act
        val result = mainService.consultTableVehicles(type)
        // Assert
        assertEquals(null, result)
    }

    @Test
    fun consultTableMotorcycleEmpty() {
        // Arrage
        val type = 1
        `when`(vehicleRepository.existType(type)).thenReturn(false)
        // Act
        val result = mainService.consultTableVehicles(type)
        // Assert
        assertEquals(null, result)
    }

    @Test
    fun consultTableCarNoEmpty() {
        // Arrage
        val type = 0
        val plate = "HBC123"
        val site = 0
        val vehicles: List<VehicleDomain> = ArrayList()
        vehicles.plus(VehicleDomain(plate, Date().time, type, site))
        `when`(vehicleRepository.existType(type)).thenReturn(true)
        `when`(vehicleRepository.selectAllType(type)).thenReturn(vehicles)
        // Act
        val result = mainService.consultTableVehicles(type)
        // Assert
        assertEquals(vehicles, result)
    }

    @Test
    fun consultTableMotorcycleNoEmpty() {
        // Arrage
        val type = 1
        val plate = "HBC123"
        val site = 0
        val vehicles: List<VehicleDomain> = ArrayList()
        vehicles.plus(VehicleDomain(plate, Date().time, type, site))
        `when`(vehicleRepository.existType(type)).thenReturn(true)
        `when`(vehicleRepository.selectAllType(type)).thenReturn(vehicles)
        // Act
        val result = mainService.consultTableVehicles(type)
        // Assert
        assertEquals(vehicles, result)
    }

}