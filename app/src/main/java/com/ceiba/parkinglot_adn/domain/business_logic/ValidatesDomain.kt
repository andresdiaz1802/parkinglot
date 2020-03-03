package com.ceiba.parkinglot_adn.domain.business_logic

private const val LETTER_A: Char = 'a'
private const val PRICE_CAR_HOUR = 1000
private const val PRICE_MOTORCYCLE_HOUR = 500
private const val PRICE_CAR_DAY = 8000
private const val PRICE_MOTORCYCLE_DAY = 4000

class ValidatesDomain {

    fun canAddToParkingLot(count: Int?, total: Int): Boolean {
        return count in 0 until total
    }

    fun letterInitPlateIsA(plate: String?): Boolean {
        if (plate == null) return false
        return plate[0].equals(LETTER_A, ignoreCase = true)
    }

    fun canInParkingLotForDay(day: Int?, plate: String?): Boolean {
        if (day == -1 || day == null) return false
        if (plate == null) return false
        val initLetter = letterInitPlateIsA(plate)
        val isDay = day in 1..2
        return if (initLetter) isDay else true
    }

    fun cylindricalIsUp(cylindrical: Double?): Int {
        if (cylindrical == null || cylindrical < 0) return 0
        return if (cylindrical > 500) 2000 else 0
    }

    fun totalToPay(hours: Int?, type: Int): Int {
        if (hours == null || hours < 0) return 0
        val priceHour = if (type == 0) PRICE_CAR_HOUR else PRICE_MOTORCYCLE_HOUR
        val priceDay = if (type == 0) PRICE_CAR_DAY else PRICE_MOTORCYCLE_DAY
        if (hours < 9) return hours * priceHour
        else if (hours < 24) return priceDay
        val totalDays = hours / 24
        val totalHours = (((hours.toDouble() / 24) - totalDays) * 24).toInt()
        return totalDays * priceDay + totalHours * priceHour
    }
}