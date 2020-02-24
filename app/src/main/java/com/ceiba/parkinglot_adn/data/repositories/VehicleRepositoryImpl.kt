package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.data.ParkingLotRoomDatabase
import com.ceiba.parkinglot_adn.data.dao.VehicleDao
import com.ceiba.parkinglot_adn.domain.model.ModelMapper
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.presentation.base.BaseApplication

class VehicleRepositoryImpl : Repositories.VehicleRepository {

    private val vehicleDao: VehicleDao =
        ParkingLotRoomDatabase.getDatabase(BaseApplication.getContext()).vehicleDao()
    private val mapper: ModelMapper = ModelMapper()

    override fun insert(vehicleDomain: VehicleDomain): Long {
        return vehicleDao.insert(mapper.toVehicleEntity(vehicleDomain))
    }

    override fun selectAll(): List<VehicleDomain> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selectAllType(type: Int): List<VehicleDomain> {
        return mapper.toVehiclesDomain(vehicleDao.selectAllType(type))
    }

    override fun select(plate: String): List<VehicleDomain> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(plate: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}