package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.data.dao.CarDao
import com.ceiba.parkinglot_adn.domain.model.ModelMapper
import com.ceiba.parkinglot_adn.domain.objects.CarDomain

class CarRepositoryImpl(private val carDao: CarDao) : CarRepository {

    private var modelMapper: ModelMapper = ModelMapper()

    override fun selectAll(): List<CarDomain> {
        return modelMapper.toCarDomain(carDao.getCars())
    }

    override fun select(plate: String): CarDomain {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(plate: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insert(carDomain: CarDomain) {
        carDao.insert(modelMapper.toCarEntity(carDomain))
    }
}