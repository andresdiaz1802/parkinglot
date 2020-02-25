package com.ceiba.parkinglot_adn.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicles")
class VehicleEntity(
    @PrimaryKey
    @ColumnInfo(name = "plate") val plate: String,
    @ColumnInfo(name = "inputDate") val inputDate: Long,
    @ColumnInfo(name = "type") val type: Int,
    @ColumnInfo(name = "site") val site: Int
)