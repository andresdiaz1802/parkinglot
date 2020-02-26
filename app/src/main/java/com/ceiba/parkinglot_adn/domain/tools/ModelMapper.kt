package com.ceiba.parkinglot_adn.domain.tools

import com.ceiba.parkinglot_adn.data.entities.MotorcycleEntity
import com.ceiba.parkinglot_adn.data.entities.VehicleEntity
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.google.gson.Gson

class ModelMapper {
    private var gson: Gson = Gson()

    fun toStringModelMapper(value: Any): String {
        return gson.toJson(value)
    }

    fun toVehiclesDomain(value: Any): List<VehicleDomain> {
        return gson.fromJson(toStringModelMapper(value), Array<VehicleDomain>::class.java).toList()
    }

    fun toVehicleDomain(value: Any): VehicleDomain {
        return gson.fromJson(toStringModelMapper(value), VehicleDomain::class.java)
    }

    fun toVehicleEntity(value: Any): VehicleEntity {
        return gson.fromJson(toStringModelMapper(value), VehicleEntity::class.java)
    }

    fun toMotorcyclesDomain(value: Any): List<MotorcycleDomain> {
        return gson.fromJson(toStringModelMapper(value), Array<MotorcycleDomain>::class.java)
            .toList()
    }

    fun toMotorcycleDomain(value: Any): MotorcycleDomain {
        return gson.fromJson(toStringModelMapper(value), MotorcycleDomain::class.java)
    }

    fun toMotorcycleEntity(value: Any): MotorcycleEntity {
        return gson.fromJson(toStringModelMapper(value), MotorcycleEntity::class.java)
    }
}