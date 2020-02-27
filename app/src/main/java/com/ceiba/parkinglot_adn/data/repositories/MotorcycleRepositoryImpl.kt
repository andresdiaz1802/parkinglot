package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.data.dao.MotorcycleDao
import com.ceiba.parkinglot_adn.domain.interfaces.MotorcycleRepositoryInterface
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.tools.ModelMapper
import javax.inject.Inject

class MotorcycleRepositoryImpl : MotorcycleRepositoryInterface {

    @Inject
    lateinit var motorcycleDao: MotorcycleDao
    @Inject
    lateinit var mapper: ModelMapper

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