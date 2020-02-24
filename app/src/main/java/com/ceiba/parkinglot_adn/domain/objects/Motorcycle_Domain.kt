package com.ceiba.parkinglot_adn.domain.objects

class Motorcycle_Domain {
    lateinit var plate: String
    var cylindrical: Double = 0.0


    constructor(plate: String, cylindrical: Double) {
        this.plate = plate
        this.cylindrical = cylindrical
    }

    constructor()
}