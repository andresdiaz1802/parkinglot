package com.ceiba.parkinglot_adn.domain.model

import com.ceiba.parkinglot_adn.data.entities.CarEntity
import com.ceiba.parkinglot_adn.data.entities.MotorcycleEntity
import com.ceiba.parkinglot_adn.domain.objects.CarDomain
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.google.gson.Gson

class ModelMapper {
    private var gson: Gson = Gson()

    private fun toString(value: Any): String {
        return gson.toJson(value)
    }

    fun toCarDomain(value: Any): List<CarDomain> {
        return gson.fromJson(toString(value), Array<CarDomain>::class.java).toList()
    }

    fun toCarEntity(value: Any): CarEntity {
        return gson.fromJson(toString(value), CarEntity::class.java)
    }

    fun toMotorcycleDomain(value: Any): List<MotorcycleDomain> {
        return gson.fromJson(toString(value), Array<MotorcycleDomain>::class.java).toList()
    }

    fun toMotorcycleEntity(value: Any): MotorcycleEntity {
        return gson.fromJson(toString(value), MotorcycleEntity::class.java)
    }
}