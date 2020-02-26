package com.ceiba.parkinglot_adn.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "motorcycles",
    foreignKeys = [
        ForeignKey(
            entity = VehicleEntity::class,
            parentColumns = ["plate"],
            childColumns = ["plate"],
            onDelete = CASCADE
        )
    ]
)
class MotorcycleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "plate") val plate: String,
    @ColumnInfo(name = "cylindrical") val cylindrical: Int
)