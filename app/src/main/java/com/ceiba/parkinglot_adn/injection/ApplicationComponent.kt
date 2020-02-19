package com.ceiba.parkinglot_adn.injection

import com.ceiba.parkinglot_adn.data.repositories.MotorcycleRepositoryImpl
import dagger.Component

@Component(modules = [DataModule::class])
interface ApplicationComponent {
    fun inject(motorcycleRepositoryImpl: MotorcycleRepositoryImpl)
}