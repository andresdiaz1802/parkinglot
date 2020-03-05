package com.ceiba.parkinglot_adn.injection

import com.ceiba.parkinglot_adn.data.repositories.MotorcycleRepositoryImpl
import com.ceiba.parkinglot_adn.data.repositories.VehicleRepositoryImpl
import com.ceiba.parkinglot_adn.domain.repositories.MotorcycleRepository
import com.ceiba.parkinglot_adn.domain.repositories.VehicleRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun instanceVehicleRepository(): VehicleRepository = VehicleRepositoryImpl()

    @Provides
    fun instanceMotorcycleRepository(): MotorcycleRepository =
        MotorcycleRepositoryImpl()
}