package com.ceiba.parkinglot_adn.injection

import com.ceiba.parkinglot_adn.domain.tools.ModelMapper
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun modelMapperProvider(): ModelMapper =
        ModelMapper()

}