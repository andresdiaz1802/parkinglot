package com.ceiba.parkinglot_adn.domain.model

import com.ceiba.parkinglot_adn.data.entities.VehicleEntity
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.google.gson.Gson

class ModelMapper {
    private var gson: Gson = Gson()

    private fun toString(value: Any): String {
        return gson.toJson(value)
    }

    fun toVehiclesDomain(value: Any): List<VehicleDomain> {
        return gson.fromJson(toString(value), Array<VehicleDomain>::class.java).toList()
    }

    fun toVehicleEntity(value: Any): VehicleEntity {
        return gson.fromJson(toString(value), VehicleEntity::class.java)
    }
}