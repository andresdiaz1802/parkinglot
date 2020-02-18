package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.data.dao.MotorcycleDao
import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain

class MotorcycleRepositoryImp(private val motorcycleDao: MotorcycleDao):MotorcycleRepository {
    override fun insert(motorcycleDomain: MotorcycleDomain) {

    }

    override fun selectAll(): List<MotorcycleDomain> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun select(plate: String): MotorcycleDomain {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(plate: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}