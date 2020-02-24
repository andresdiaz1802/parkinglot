package com.ceiba.parkinglot_adn.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ceiba.parkinglot_adn.data.dao.MotorcycleDao
import com.ceiba.parkinglot_adn.data.dao.VehicleDao
import com.ceiba.parkinglot_adn.data.entities.MotorcycleEntity
import com.ceiba.parkinglot_adn.data.entities.VehicleEntity

@Database(
    entities = [
        VehicleEntity::class, MotorcycleEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ParkingLotRoomDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
    abstract fun motorcycleDao(): MotorcycleDao

    companion object {
        @Volatile
        private var INSTANCE: ParkingLotRoomDatabase? = null

        fun getDatabase(context: Context): ParkingLotRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ParkingLotRoomDatabase::class.java,
                    "parking_lot"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}