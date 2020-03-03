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
    fun select(plate: String): VehicleEntity

    @Query("SELECT * FROM vehicles WHERE site=:site")
    fun selectSite(site: Int): List<VehicleEntity>

    @Query("SELECT COUNT(*) FROM vehicles WHERE site=:site LIMIT 1")
    fun isOccupied(site: Int): Boolean

    @Query("SELECT COUNT(*) FROM vehicles WHERE type=:type")
    fun count(type: Int): Int

    @Query("SELECT COUNT(*) FROM vehicles WHERE plate=:plate LIMIT 1")
    fun exist(plate: String): Boolean

    @Query("SELECT COUNT(*) FROM vehicles WHERE type=:type LIMIT 1")
    fun existType(type: Int):Boolean

    // Update

    // Delete
    @Query("DELETE FROM vehicles")
    fun deleteAll()

    @Query("DELETE FROM vehicles WHERE plate=:plate")
    fun delete(plate: String)
}