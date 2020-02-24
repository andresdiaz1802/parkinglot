package com.ceiba.parkinglot_adn.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ceiba.parkinglot_adn.data.entities.MotorcycleEntity

@Dao
interface MotorcycleDao {

    // Create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(motorcycleEntity: MotorcycleEntity)

    // Read
    @Query("SELECT * FROM motorcycles")
    fun selectAll(): List<MotorcycleEntity>

    @Query("SELECT * FROM motorcycles WHERE id_vehicle=:idVehicle")
    fun select(idVehicle: Int): List<MotorcycleEntity>

    //Update

    //Delete
    @Query("DELETE FROM motorcycles")
    fun deleteAll()

    @Query("DELETE FROM motorcycles WHERE id_vehicle=:idVehicle")
    fun delete(idVehicle: Int)
}