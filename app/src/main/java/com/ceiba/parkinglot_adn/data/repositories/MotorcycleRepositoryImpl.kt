package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.data.ParkingLotRoomDatabase
import com.ceiba.parkinglot_adn.data.dao.MotorcycleDao
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.tools.ModelMapper
import com.ceiba.parkinglot_adn.presentation.base.BaseApplication

class MotorcycleRepositoryImpl : Repositories.MotorcycleRepository {

    private val motorcycleDao: MotorcycleDao =
        ParkingLotRoomDatabase.getDatabase(BaseApplication.getContext()).motorcycleDao()
    private val mapper: ModelMapper = ModelMapper()

    override fun insert(motorcycleDomain: MotorcycleDomain) {
        motorcycleDao.insert(mapper.toMotorcycleEntity(motorcycleDomain))
    }

    override fun selectAll(): List<MotorcycleDomain> {
        return mapper.toMotorcyclesDomain(motorcycleDao.selectAll())
    }

    override fun select(plate: String): MotorcycleDomain {
        return mapper.toMotorcycleDomain(motorcycleDao.select(plate))
    }

    override fun deleteAll() {
        motorcycleDao.deleteAll()
    }

    override fun delete(plate: String) {
        motorcycleDao.delete(plate)
    }
}