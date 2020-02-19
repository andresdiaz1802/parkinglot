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
        return modelMapper.toMotorcyclesDomain(motorcycleDao.selectAll())
    }

//    override fun select(plate: String): List<MotorcycleDomain> =
//        modelMapper.toMotorcyclesDomain(motorcycleDao.select(plate))

//    override fun delete(plate: String) {
//        motorcycleDao.delete(plate)
//    }

    override fun deleteAll() {
        motorcycleDao.deleteAll()
    }

//    override fun update(plate: String) {
//        motorcycleDao.update(plate)
//    }

}