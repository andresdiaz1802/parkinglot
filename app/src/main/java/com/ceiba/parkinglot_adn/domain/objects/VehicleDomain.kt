package com.ceiba.parkinglot_adn.domain.objects

import java.util.*
import java.util.concurrent.TimeUnit

open class VehicleDomain {
    lateinit var plate: String
    var inputDate: Long = 0
    var type: Int = 0
    var site: Int = 0


    constructor(plate: String, inputDate: Long, type: Int, site: Int) {
        this.plate = plate
        this.inputDate = inputDate
        this.type = type
        this.site = site
    }

    constructor()

    override fun toString(): String {
        return "VehicleDomain(plate='$plate' type=$type)"
    }

    fun toDate(): Date {
        return Date(inputDate)
    }

    fun toHour(): Int {
        val now = Date().time + 1000 * 60 * 60
        return TimeUnit.MILLISECONDS.toHours(now - inputDate).toInt()
    }


}