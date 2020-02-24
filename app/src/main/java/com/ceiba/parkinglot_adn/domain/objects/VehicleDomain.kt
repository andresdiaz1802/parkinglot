package com.ceiba.parkinglot_adn.domain.objects

import java.util.*

open class VehicleDomain {
    lateinit var plate: String
    lateinit var date: Date
    var type: Int = 0
    var active: Boolean = false


    constructor(plate: String, date: Date, type: Int, active: Boolean = true) {
        this.plate = plate
        this.date = date
        this.type = type
        this.active = active
    }

    constructor()

    override fun toString(): String {
        return "VehicleDomain(plate='$plate' type=$type)"
    }


}