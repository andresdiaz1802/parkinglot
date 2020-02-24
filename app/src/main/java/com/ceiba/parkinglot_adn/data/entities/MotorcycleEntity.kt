package com.ceiba.parkinglot_adn.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "motorcycles",
    foreignKeys = [
        ForeignKey(
            entity = VehicleEntity::class,
            parentColumns = ["id"],
            childColumns = ["id_vehicle"]
        )
    ]
)
class MotorcycleEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "id_vehicle") val idVehicle: Int,
    @ColumnInfo(name = "cylindrical") val cylindrical: Double
)