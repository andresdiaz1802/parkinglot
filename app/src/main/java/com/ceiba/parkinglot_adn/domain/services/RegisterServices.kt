package com.ceiba.parkinglot_adn.domain.services

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.ceiba.parkinglot_adn.R
import com.ceiba.parkinglot_adn.data.ParkingLotRoomDatabase
import com.ceiba.parkinglot_adn.data.repositories.CarRepository
import com.ceiba.parkinglot_adn.data.repositories.CarRepositoryImpl
import com.ceiba.parkinglot_adn.domain.model.ValidatesDomain
import com.ceiba.parkinglot_adn.domain.objects.CarDomain
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.tools.TOTAL_CAR
import java.util.*

class RegisterServices(private var context: Context) {

    private var carRepository: CarRepository = CarRepositoryImpl(
        ParkingLotRoomDatabase.getDatabase(context).carDao()
    )
    private var validatesDomain: ValidatesDomain = ValidatesDomain();

    fun registerCar(carDomain: CarDomain) {
        if (validatesDomain.canAddToParkingLot(carRepository.count(), TOTAL_CAR)) {
            if (validatesDomain.canInParkingLotForDay(weekDay(), carDomain.plate)) {
                carRepository.insert(carDomain)
                toastMessage(R.string.successfully_saved)
            } else {
                toastMessage(R.string.invalid_plate_day)
            }
        } else {
            toastMessage(R.string.no_space)
        }
    }

    fun showCars() {
        if (carRepository.count() > 0) {
            carRepository.selectAll().forEach { Log.d("MessengerCar", "$it") }
        } else {
            toastMessage(R.string.no_car)
        }
    }

    fun registerMotorcycle(motorcycleDomain: MotorcycleDomain) {
        toastMessage(R.string.add_motorcycle)
    }

    private fun weekDay(): Int {
        val calendar: Calendar = Calendar.getInstance()
        calendar.time = Date()
        return calendar.get(Calendar.DAY_OF_WEEK)
    }

    private fun toastMessage(message: Int): Unit {
        return Toast.makeText(
            context, context.getString(message), Toast.LENGTH_LONG
        ).show()
    }
}