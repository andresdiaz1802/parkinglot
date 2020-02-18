package com.ceiba.parkinglot_adn.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ceiba.parkinglot_adn.data.entities.CarEntity

@Dao
interface CarDao {
    @Query("SELECT * FROM car")
    fun getCars(): List<CarEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(carEntity: CarEntity)

    @Query("DELETE FROM car")
    suspend fun deleteAll()
}