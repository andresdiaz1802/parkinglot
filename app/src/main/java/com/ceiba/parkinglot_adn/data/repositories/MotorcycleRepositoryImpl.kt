package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.data.dao.MotorcycleDao
import com.ceiba.parkinglot_adn.domain.model.ModelMapper
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain

class MotorcycleRepositoryImpl(private val motorcycleDao: MotorcycleDao) : MotorcycleRepository {

    private var modelMapper: ModelMapper = ModelMapper()

    override fun insert(motorcycleDomain: MotorcycleDomain) {
        motorcycleDao.insert(modelMapper.toMotorcycleEntity(motorcycleDomain))
    }

    override fun selectAll(): List<MotorcycleDomain> {
        return modelMapper.toMotorcycleDomain(motorcycleDao.getMotorcycles())
    }

    override fun select(plate: String): MotorcycleDomain {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(plate: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}