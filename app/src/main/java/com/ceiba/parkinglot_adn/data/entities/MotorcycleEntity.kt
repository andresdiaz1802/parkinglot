package com.ceiba.parkinglot_adn.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "motorcycle")
class MotorcycleEntity(
    @PrimaryKey
    @ColumnInfo(name = "plate") val plate: String,
    @ColumnInfo(name = "cylindrical") val cylindrical: Double
)