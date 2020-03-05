package com.ceiba.parkinglot_adn.injection

import com.ceiba.parkinglot_adn.data.repositories.MotorcycleRepositoryImpl
import com.ceiba.parkinglot_adn.data.repositories.VehicleRepositoryImpl
import com.ceiba.parkinglot_adn.domain.services.MainServiceImpl
import com.ceiba.parkinglot_adn.domain.tools.ModelMapper
import com.ceiba.parkinglot_adn.presentation.presenters.MainPresenter
import dagger.Component

@Component(modules = [RepositoryModule::class, DomainModule::class, DataModule::class, ServicesModule::class])
interface ApplicationComponent {
    fun inject(mainPresenter: MainPresenter)
    fun inject(mainService: MainServiceImpl)
    fun inject(modelMapper: ModelMapper)
    fun inject(vehicleRepositoryImpl: VehicleRepositoryImpl)
    fun inject(motorcycleRepositoryImpl: MotorcycleRepositoryImpl)
}