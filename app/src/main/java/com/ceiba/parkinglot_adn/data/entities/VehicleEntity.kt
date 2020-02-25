package com.ceiba.parkinglot_adn.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicles")
class VehicleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "plate") val plate: String,
//    @ColumnInfo(name = "inputDate") val inputDate: Date,
    @ColumnInfo(name = "type") val type: Int,
    @ColumnInfo(name = "active") val active: Boolean
)