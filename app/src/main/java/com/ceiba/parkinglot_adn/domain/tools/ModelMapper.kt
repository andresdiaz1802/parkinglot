package com.ceiba.parkinglot_adn.domain.tools

import com.ceiba.parkinglot_adn.data.entities.MotorcycleEntity
import com.ceiba.parkinglot_adn.data.entities.RegisterEntity
import com.ceiba.parkinglot_adn.data.entities.VehicleEntity
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.objects.RegisterDomain
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

    fun toVehicleEntity(value: Any): VehicleEntity {
        return gson.fromJson(toStringModelMapper(value), VehicleEntity::class.java)
    }

    fun toMotorcycleDomain(value: Any): List<MotorcycleDomain> {
        return gson.fromJson(toStringModelMapper(value), Array<MotorcycleDomain>::class.java)
            .toList()
    }

    fun toMotorcycleEntity(value: Any): MotorcycleEntity {
        return gson.fromJson(toStringModelMapper(value), MotorcycleEntity::class.java)
    }

    fun toRegisterDomain(value: Any): List<RegisterDomain> {
        return gson.fromJson(toStringModelMapper(value), Array<RegisterDomain>::class.java).toList()
    }

    fun toRegisterEntity(value: Any): RegisterEntity {
        return gson.fromJson(toStringModelMapper(value), RegisterEntity::class.java)
    }
}