package com.ceiba.parkinglot_adn.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ceiba.parkinglot_adn.data.entities.VehicleEntity

@Dao
interface VehicleDao {

    // Create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vehicleEntity: VehicleEntity): Long

    // Read
    @Query("SELECT * FROM vehicles")
    fun selectAll(): List<VehicleEntity>

    @Query("SELECT * FROM vehicles WHERE type=:type")
    fun selectAllType(type: Int): List<VehicleEntity>

    @Query("SELECT * FROM vehicles WHERE plate=:plate")
    fun select(plate: String): List<VehicleEntity>

    // Update

    // Delete
    @Query("DELETE FROM vehicles")
    fun deleteAll()

    @Query("DELETE FROM vehicles WHERE plate=:plate")
    fun delete(plate: String)
}