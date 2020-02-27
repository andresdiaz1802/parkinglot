package com.ceiba.parkinglot_adn.injection

import com.ceiba.parkinglot_adn.data.repositories.MotorcycleRepositoryImpl
import com.ceiba.parkinglot_adn.data.repositories.VehicleRepositoryImpl
import com.ceiba.parkinglot_adn.domain.services.InfoService
import com.ceiba.parkinglot_adn.domain.services.MainModel
import com.ceiba.parkinglot_adn.domain.tools.ModelMapper
import dagger.Component

@Component(modules = [RepositoryModule::class, DomainModule::class, DataModule::class])
interface ApplicationComponent {
    fun inject(mainModel: MainModel)
    fun inject(infoService: InfoService)
    fun inject(modelMapper: ModelMapper)
    fun inject(vehicleRepositoryImpl: VehicleRepositoryImpl)
    fun inject(motorcycleRepositoryImpl: MotorcycleRepositoryImpl)
}