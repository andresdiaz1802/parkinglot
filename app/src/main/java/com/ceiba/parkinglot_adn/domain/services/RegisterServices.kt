package com.ceiba.parkinglot_adn.domain.services

import com.ceiba.parkinglot_adn.data.ParkingLotRoomDatabase
import com.ceiba.parkinglot_adn.data.repositories.CarRepository
import com.ceiba.parkinglot_adn.data.repositories.CarRepositoryImpl
import com.ceiba.parkinglot_adn.presentation.base.BaseApplication

class RegisterServices {

    private lateinit var carRepository: CarRepository

    init {
        carRepository =
            CarRepositoryImpl(
                ParkingLotRoomDatabase.getDatabase(
                    BaseApplication().getContext()
                ).carDao()
            )
    }
}