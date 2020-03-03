package com.ceiba.parkinglot_adn.domain

import com.ceiba.parkinglot_adn.domain.business_logic.ValidatesDomain
import com.ceiba.parkinglot_adn.domain.interfaces.MotorcycleRepositoryInterface
import com.ceiba.parkinglot_adn.domain.interfaces.VehicleRepositoryInterface
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.domain.services.MainService
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

private const val NO_SPACE = "no_space"
private const val NO_PERMISSION = "no_permission"
private const val PLATE_EXIST = "plate_exist"
private const val SITE_OCCUPIED = "site_occupied"
private const val ERROR = "error"
private const val SUCCESS = "success"
private const val ID_MOTORCYCLE = 1

class ServicesDomainTest {

    @get:Rule
    var mockitoRule: MockitoRule? = MockitoJUnit.rule()

    @InjectMocks
    lateinit var mainService: MainService

    @Mock
    lateinit var validatesDomain: ValidatesDomain

    @Mock
    lateinit var vehicleRepository: VehicleRepositoryInterface

    @Mock
    lateinit var motorcycleRepository: MotorcycleRepositoryInterface

    @Mock
    lateinit var vehicle: VehicleDomain

    @Mock
    lateinit var motorcycle: MotorcycleDomain

    @Mock
    lateinit var vehicles: List<VehicleDomain>

    @Test
    fun insertCarFailedForSpace() {
        // Arrange
        val type = 0
        val plate = "ABC123"
        val cylindrical = "0"
        val site = 0
        `when`(validatesDomain.canAddToParkingLot(vehicleRepository.count(type), TOTAL_CAR))
            .thenReturn(false)
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
        `when`(validatesDomain.canAddToParkingLot(vehicleRepository.count(type), TOTAL_CAR))
            .thenReturn(true)
        `when`(validatesDomain.canInParkingLotForDay(day, plate)).thenReturn(false)
        // Act
        val result = mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(NO_PERMISSION, result)
    }

    @Test
    fun insertCarFailedForPlateExist() {
        // Arrange
        val type = 0
        val plate = "ABC123"
        val cylindrical = "0"
        val site = 0
        val day = 5
        `when`(validatesDomain.canAddToParkingLot(vehicleRepository.count(type), TOTAL_CAR))
            .thenReturn(true)
        `when`(validatesDomain.canInParkingLotForDay(day, plate)).thenReturn(true)
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
        val plate = "ABC123"
        val cylindrical = "0"
        val site = 0
        val day = 5
        `when`(validatesDomain.canAddToParkingLot(vehicleRepository.count(type), TOTAL_CAR))
            .thenReturn(true)
        `when`(validatesDomain.canInParkingLotForDay(day, plate)).thenReturn(true)
        `when`(vehicleRepository.exist(plate)).thenReturn(false)
        `when`(vehicleRepository.isOccupied(site)).thenReturn(true)
        // Act
        val result = mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(SITE_OCCUPIED, result)
    }

//    @Test
//    fun insertCarFailedForInsertDAO() {
//        /**
//         * Revisar este test
//         */
//        // Arrange
//        val type = 0
//        val plate = "ABC123"
//        val cylindrical = "0"
//        val site = 0
//        val day = 5
//        val status = -1
//        `when`(validatesDomain.canAddToParkingLot(vehicleRepository.count(type), TOTAL_CAR))
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

    @Test
    fun insertCarSuccess() {
        // Arrange
        val type = 0
        val plate = "ABC123"
        val cylindrical = "0"
        val site = 0
        val day = 5
        `when`(validatesDomain.canAddToParkingLot(vehicleRepository.count(type), TOTAL_CAR))
            .thenReturn(true)
        `when`(validatesDomain.canInParkingLotForDay(day, plate)).thenReturn(true)
        `when`(vehicleRepository.exist(plate)).thenReturn(false)
        `when`(vehicleRepository.isOccupied(site)).thenReturn(false)
        `when`(vehicleRepository.insert(vehicle)).thenReturn(2L)
        // Act
        val result =
            mainService.insertVehicle(site, plate, cylindrical, type)
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
        `when`(validatesDomain.canAddToParkingLot(vehicleRepository.count(type), TOTAL_CAR))
            .thenReturn(false)
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
        `when`(validatesDomain.canAddToParkingLot(vehicleRepository.count(type), TOTAL_MOTORCYCLE))
            .thenReturn(true)
        `when`(validatesDomain.canInParkingLotForDay(day, plate)).thenReturn(false)
        // Act
        val result = mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(NO_PERMISSION, result)
    }

    @Test
    fun insertMotorcycleFailedForPlateExist() {
        // Arrange
        val type = 1
        val plate = "ABC123"
        val cylindrical = "600"
        val site = 0
        val day = 5
        `when`(validatesDomain.canAddToParkingLot(vehicleRepository.count(type), TOTAL_MOTORCYCLE))
            .thenReturn(true)
        `when`(validatesDomain.canInParkingLotForDay(day, plate)).thenReturn(true)
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
        val plate = "ABC123"
        val cylindrical = "6000"
        val site = 0
        val day = 5
        `when`(validatesDomain.canAddToParkingLot(vehicleRepository.count(type), TOTAL_MOTORCYCLE))
            .thenReturn(true)
        `when`(validatesDomain.canInParkingLotForDay(day, plate)).thenReturn(true)
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

    @Test
    fun insertMotorcycleSuccess() {
        // Arrange
        val type = 1
        val plate = "ABC123"
        val cylindrical = "200"
        val site = 0
        val day = 5
        `when`(validatesDomain.canAddToParkingLot(vehicleRepository.count(type), TOTAL_MOTORCYCLE))
            .thenReturn(true)
        `when`(validatesDomain.canInParkingLotForDay(day, plate)).thenReturn(true)
        `when`(vehicleRepository.exist(plate)).thenReturn(false)
        `when`(vehicleRepository.isOccupied(site)).thenReturn(false)
        `when`(vehicleRepository.insert(vehicle)).thenReturn(2L)
        // Act
        val result =
            mainService.insertVehicle(site, plate, cylindrical, type)
        // Assert
        assertEquals(SUCCESS, result)
    }

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
        val plate = "ABC123"
        `when`(vehicleRepository.exist(plate)).thenReturn(true)
        `when`(vehicleRepository.select(plate)).thenReturn(vehicle)
        // Act
        val result = mainService.consultVehicle(plate)
        // Assert
        assertEquals(vehicle, result)
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
        val plate = "ABC123"
        `when`(vehicleRepository.exist(plate)).thenReturn(true)
        `when`(vehicleRepository.select(plate)).thenReturn(vehicle)
        `when`(vehicle.type).thenReturn(0)
        `when`(validatesDomain.totalToPay(vehicle.toHour(), vehicle.type)).thenReturn(8000)
        // Act
        val result = mainService.deleteVehicle(plate)
        // Assert
        assertEquals("The value to be paid is of 8000", result)
    }

    @Test
    fun deleteMotorcycleCylindricalOf800() {
        // Arrange
        val plate = "ABC123"
        `when`(vehicleRepository.exist(plate)).thenReturn(true)
        `when`(vehicleRepository.select(plate)).thenReturn(vehicle)
        `when`(vehicle.type).thenReturn(ID_MOTORCYCLE)
        `when`(motorcycleRepository.select(plate)).thenReturn(motorcycle)
        `when`(motorcycle.cylindrical).thenReturn(800.0)
        `when`(validatesDomain.totalToPay(vehicle.toHour(), vehicle.type)).thenReturn(8000)
        // Act
        val result = mainService.deleteVehicle(plate)
        // Assert
        assertEquals("The value to be paid is of 10000", result)
    }

    @Test
    fun deleteMotorcycleCylindricalOf200() {
        // Arrange
        val plate = "ABC123"
        `when`(vehicleRepository.exist(plate)).thenReturn(true)
        `when`(vehicleRepository.select(plate)).thenReturn(vehicle)
        `when`(vehicle.type).thenReturn(ID_MOTORCYCLE)
        `when`(motorcycleRepository.select(plate)).thenReturn(motorcycle)
        `when`(motorcycle.cylindrical).thenReturn(200.0)
        `when`(validatesDomain.totalToPay(vehicle.toHour(), vehicle.type)).thenReturn(8000)
        // Act
        val result = mainService.deleteVehicle(plate)
        // Assert
        assertEquals("The value to be paid is of 8000", result)
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
        `when`(vehicleRepository.existType(type)).thenReturn(true)
        `when`(vehicleRepository.selectAllType(type)).thenReturn(vehicles)
        // Act
        val result = mainService.consultTableVehicles(type)
        // Assert
        assertEquals(vehicles, result)
    }

}