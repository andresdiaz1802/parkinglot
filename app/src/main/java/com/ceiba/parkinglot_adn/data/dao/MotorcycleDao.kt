package com.ceiba.parkinglot_adn.data.dao

import androidx.room.*
import com.ceiba.parkinglot_adn.data.entities.MotorcycleEntity

@Dao
interface MotorcycleDao {
    @Query("SELECT * FROM motorcycle")
    fun selectAll(): List<MotorcycleEntity>

//    @Query("SELECT * FROM motorcycle WHERE plate = :plate")
//    fun select(plate: String): List<MotorcycleEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(motorcycleEntity: MotorcycleEntity)

    @Query("DELETE FROM motorcycle")
    fun deleteAll()

//    @Query("DELETE FROM motorcycle WHERE plate = :plate")
//    fun delete(plate: String)
//
//    @Update(onConflict = OnConflictStrategy.IGNORE)
//    fun update(plate: String)
}