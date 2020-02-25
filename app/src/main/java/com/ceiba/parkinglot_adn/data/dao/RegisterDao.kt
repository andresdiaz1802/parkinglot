package com.ceiba.parkinglot_adn.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ceiba.parkinglot_adn.data.entities.RegisterEntity

@Dao
interface RegisterDao {
    // Create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(registerEntity: RegisterEntity)

    // Read
    @Query("SELECT * FROM registers")
    fun selectAll(): List<RegisterEntity>

    @Query("SELECT * FROM registers WHERE plate=:plate")
    fun select(plate: String): List<RegisterEntity>

    // Update

    // Delete
    @Query("DELETE FROM registers")
    fun deleteAll()

    @Query("DELETE FROM registers WHERE plate=:plate")
    fun delete(plate: String)
}