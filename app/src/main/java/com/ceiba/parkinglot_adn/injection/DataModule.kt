package com.ceiba.parkinglot_adn.injection

import com.ceiba.parkinglot_adn.data.ParkingLotRoomDatabase
import com.ceiba.parkinglot_adn.data.dao.MotorcycleDao
import com.ceiba.parkinglot_adn.data.dao.VehicleDao
import com.ceiba.parkinglot_adn.presentation.base.BaseApplication
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun instanceVehicleDao(): VehicleDao =
        ParkingLotRoomDatabase.getDatabase(BaseApplication.getContext()).vehicleDao()

    @Provides
    fun instanceMotorcycleDao(): MotorcycleDao =
        ParkingLotRoomDatabase.getDatabase(BaseApplication.getContext()).motorcycleDao()
}