package com.ceiba.parkinglot_adn.injection

import com.ceiba.parkinglot_adn.domain.businesslogic.ValidatesDomain
import com.ceiba.parkinglot_adn.domain.repositories.MotorcycleRepository
import com.ceiba.parkinglot_adn.domain.repositories.VehicleRepository
import com.ceiba.parkinglot_adn.domain.services.MainService
import com.ceiba.parkinglot_adn.domain.services.MainServiceImpl
import dagger.Module
import dagger.Provides

@Module
class ServicesModule {

    @Provides
    fun instanceMainServiceImp(
        vehicleRepository: VehicleRepository,
        motorcycleRepository: MotorcycleRepository,
        validatesDomain: ValidatesDomain
    ): MainService = MainServiceImpl(vehicleRepository, motorcycleRepository, validatesDomain)
}