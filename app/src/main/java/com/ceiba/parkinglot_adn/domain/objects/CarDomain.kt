package com.ceiba.parkinglot_adn.domain.objects

class CarDomain {
    lateinit var plate: String

    constructor()

    constructor(plate: String) {
        this.plate = plate
    }

    override fun toString(): String {
        return "CarDomain(plate='$plate')"
    }


}