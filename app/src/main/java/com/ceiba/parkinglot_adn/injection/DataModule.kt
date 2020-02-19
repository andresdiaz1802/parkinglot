package com.ceiba.parkinglot_adn.injection

import com.ceiba.parkinglot_adn.data.dao.MotorcycleDao
import com.ceiba.parkinglot_adn.data.repositories.MotorcycleRepositoryImpl
import com.ceiba.parkinglot_adn.domain.model.ModelMapper
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun modelMapperProvider(): ModelMapper = ModelMapper()

    @Provides
    fun motorcycleRepository( motorcycleDao: MotorcycleDao): MotorcycleRepositoryImpl = MotorcycleRepositoryImpl(motorcycleDao)
}