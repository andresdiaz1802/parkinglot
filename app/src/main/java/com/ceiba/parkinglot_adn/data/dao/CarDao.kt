package com.ceiba.parkinglot_adn.data.dao

import androidx.room.*
import com.ceiba.parkinglot_adn.data.entities.CarEntity

@Dao
interface CarDao {
    @Query("SELECT * FROM car")
    fun selectAll(): List<CarEntity>

//    @Query("SELECT * FROM car WHERE plate = :plate")
//    fun select(plate: String): List<CarEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(carEntity: CarEntity)

    @Query("DELETE FROM car")
    fun deleteAll()

//    @Query("DELETE FROM car WHERE plate = :plate")
//    fun delete(plate: String)
//
//    @Update(onConflict = OnConflictStrategy.IGNORE)
//    fun update(plate: String)
}