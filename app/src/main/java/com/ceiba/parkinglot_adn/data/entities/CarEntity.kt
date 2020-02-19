package com.ceiba.parkinglot_adn.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "car")
class CarEntity(
    @PrimaryKey
    @ColumnInfo(name = "plate")
    val plate: String
)