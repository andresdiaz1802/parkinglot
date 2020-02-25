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
            parentColumns = ["plate"],
            childColumns = ["plate"]
        )
    ]
)
class MotorcycleEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "plate") val plate: Int,
    @ColumnInfo(name = "cylindrical") val cylindrical: Double
)