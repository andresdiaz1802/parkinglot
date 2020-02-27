package com.ceiba.parkinglot_adn.injection

import com.ceiba.parkinglot_adn.data.repositories.MotorcycleRepositoryImpl
import com.ceiba.parkinglot_adn.data.repositories.VehicleRepositoryImpl
import com.ceiba.parkinglot_adn.domain.interfaces.MotorcycleRepositoryInterface
import com.ceiba.parkinglot_adn.domain.interfaces.VehicleRepositoryInterface
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun instanceVehicleRepository(): VehicleRepositoryInterface = VehicleRepositoryImpl()

    @Provides
    fun instanceMotorcycleRepository(): MotorcycleRepositoryInterface =
        MotorcycleRepositoryImpl()
}