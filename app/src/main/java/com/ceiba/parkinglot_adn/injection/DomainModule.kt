package com.ceiba.parkinglot_adn.injection

import com.ceiba.parkinglot_adn.domain.tools.ModelMapper
import com.ceiba.parkinglot_adn.domain.tools.ValidatesDomain
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun instanceModelMapper(): ModelMapper = ModelMapper()

    @Provides
    fun instanceValidatiesDomain(): ValidatesDomain = ValidatesDomain()

    @Provides
    fun instanceGson(): Gson = Gson()
}