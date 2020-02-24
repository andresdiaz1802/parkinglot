package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.domain.objects.MotorcycleDomain

class MotorcycleRepositoryImpl : Repositories.MotorcycleRepository {
    override fun insert(motorcycleDomain: MotorcycleDomain) {

    }

    override fun selectAll(): List<MotorcycleDomain> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun select(idVehicle: Int): List<MotorcycleDomain> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(idVehicle: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}