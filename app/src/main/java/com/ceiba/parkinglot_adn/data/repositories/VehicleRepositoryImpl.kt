package com.ceiba.parkinglot_adn.data.repositories

import com.ceiba.parkinglot_adn.data.dao.VehicleDao
import com.ceiba.parkinglot_adn.domain.objects.VehicleDomain
import com.ceiba.parkinglot_adn.domain.repositories.VehicleRepository
import com.ceiba.parkinglot_adn.domain.tools.ModelMapper
import com.ceiba.parkinglot_adn.presentation.base.BaseApplication
import javax.inject.Inject

class VehicleRepositoryImpl :
    VehicleRepository {

    @Inject
    lateinit var vehicleDao: VehicleDao

    @Inject
    lateinit var mapper: ModelMapper

    init {
        BaseApplication.getApplicationComponent()?.inject(this)
    }

    override fun insert(vehicleDomain: VehicleDomain): Int {
        return vehicleDao.insert(mapper.toVehicleEntity(vehicleDomain)).toInt()
    }

    override fun selectAll(): List<VehicleDomain> {
        return mapper.toVehiclesDomain(vehicleDao.selectAll())
    }

    override fun selectAllType(type: Int): List<VehicleDomain> {
        return mapper.toVehiclesDomain(vehicleDao.selectAllType(type))
    }

    override fun select(plate: String): VehicleDomain {
        return mapper.toVehicleDomain(vehicleDao.select(plate))
    }

    override fun selectSite(site: Int): List<VehicleDomain> {
        return mapper.toVehiclesDomain(vehicleDao.selectSite(site))
    }

    override fun isOccupied(site: Int): Boolean {
        return vehicleDao.isOccupied(site)
    }

    override fun count(type: Int): Int {
        return vehicleDao.count(type)
    }

    override fun exist(plate: String): Boolean {
        return vehicleDao.exist(plate)
    }

    override fun existType(type: Int): Boolean {
        return vehicleDao.existType(type)
    }

    override fun deleteAll() {
        vehicleDao.deleteAll()
    }

    override fun delete(plate: String) {
        vehicleDao.delete(plate)
    }

}