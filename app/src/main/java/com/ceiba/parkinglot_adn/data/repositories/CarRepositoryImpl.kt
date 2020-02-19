package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.data.dao.CarDao
import com.ceiba.parkinglot_adn.domain.model.ModelMapper
import com.ceiba.parkinglot_adn.domain.objects.CarDomain

class CarRepositoryImpl(private val carDao: CarDao) : CarRepository {

    private var modelMapper: ModelMapper = ModelMapper()

    override fun selectAll(): List<CarDomain> = modelMapper.toCarsDomain(carDao.selectAll())

//    override fun select(plate: String): List<CarDomain> =
//        modelMapper.toCarsDomain(carDao.select(plate))

//    override fun delete(plate: String) {
//        carDao.delete(plate)
//    }

    override fun deleteAll() {
        carDao.deleteAll()
    }

//    override fun update(plate: String) {
//        carDao.update(plate)
//    }

    override fun insert(carDomain: CarDomain) {
        carDao.insert(modelMapper.toCarEntity(carDomain))
    }
}