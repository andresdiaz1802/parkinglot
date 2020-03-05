package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.data.dao.MotorcycleDao
import com.ceiba.parkinglot_adn.domain.repositories.MotorcycleRepository
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain
import com.ceiba.parkinglot_adn.domain.tools.ModelMapper
import com.ceiba.parkinglot_adn.presentation.base.BaseApplication
import javax.inject.Inject

class MotorcycleRepositoryImpl :
    MotorcycleRepository {

    @Inject
    lateinit var motorcycleDao: MotorcycleDao
    @Inject
    lateinit var mapper: ModelMapper

    init {
        BaseApplication.getApplicationComponent()?.inject(this)
    }

    override fun insert(motorcycleDomain: MotorcycleDomain) {
        motorcycleDao.insert(mapper.toMotorcycleEntity(motorcycleDomain))
    }

    override fun selectAll(): List<MotorcycleDomain> {
        return mapper.toMotorcyclesDomain(motorcycleDao.selectAll())
    }

    override fun select(plate: String): MotorcycleDomain? {
        val motorcycle = motorcycleDao.select(plate)
        return if (motorcycle != null) mapper.toMotorcycleDomain(motorcycle)
        else null
    }

    override fun deleteAll() {
        motorcycleDao.deleteAll()
    }

    override fun delete(plate: String) {
        motorcycleDao.delete(plate)
    }
}