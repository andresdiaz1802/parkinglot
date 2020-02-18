package com.ceiba.parkinglot_adn.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ceiba.parkinglot_adn.data.entities.MotorcycleEntity

@Dao
interface MotorcycleDao {
    @Query("SELECT * FROM motorcycle")
    fun getMotorcycles(): List<MotorcycleEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(motorcycleEntity: MotorcycleEntity)

    @Query("DELETE FROM motorcycle")
    suspend fun deleteAll()
}