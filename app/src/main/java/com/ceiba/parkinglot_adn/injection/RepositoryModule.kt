package com.ceiba.parkinglot_adn.injection

import com.ceiba.parkinglot_adn.data.repositories.MotorcycleRepositoryImpl
import com.ceiba.parkinglot_adn.data.repositories.Repositories
import com.ceiba.parkinglot_adn.data.repositories.VehicleRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun instanceVehicleRepository(): Repositories.VehicleRepository = VehicleRepositoryImpl()

    @Provides
    fun instanceMotorcycleRepository(): Repositories.MotorcycleRepository =
        MotorcycleRepositoryImpl()
}