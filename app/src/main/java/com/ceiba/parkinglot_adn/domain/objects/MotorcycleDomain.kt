package com.ceiba.parkinglot_adn.domain.objects

import java.util.*

class MotorcycleDomain {
    var idVehicle: Int = 0
    var cylindrical: Double = 0.0

    constructor(idVehicle: Int, cylindrical: Double) {
        this.idVehicle = idVehicle
        this.cylindrical = cylindrical
    }
}