package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.data.ParkingLotRoomDatabase
import com.ceiba.parkinglot_adn.data.dao.RegisterDao
import com.ceiba.parkinglot_adn.domain.objects.RegisterDomain
import com.ceiba.parkinglot_adn.domain.tools.ModelMapper
import com.ceiba.parkinglot_adn.presentation.base.BaseApplication

class RegisterRepositoryImpl : Repositories.RegisterRepository {

    private val registerDao: RegisterDao =
        ParkingLotRoomDatabase.getDatabase(BaseApplication.getContext()).registerDao()
    private val mapper = ModelMapper()

    override fun insert(registerDomain: RegisterDomain) {
        registerDao.insert(mapper.toRegisterEntity(registerDomain))
    }

    override fun selectAll(): List<RegisterDomain> {
        return mapper.toRegisterDomain(registerDao.selectAll())
    }

    override fun select(plate: String): List<RegisterDomain> {
        return mapper.toRegisterDomain(registerDao.select(plate))
    }

    override fun deleteAll() {
        registerDao.deleteAll()
    }

    override fun delete(plate: String) {
        registerDao.delete(plate)
    }
}