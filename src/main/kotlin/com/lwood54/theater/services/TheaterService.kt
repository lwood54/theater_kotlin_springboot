package com.lwood54.theater.services

import com.lwood54.theater.domain.Seat
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class TheaterService {
    private val hiddenSeats = mutableListOf<Seat>()
    private fun getPrice(row: Int, num: Int): BigDecimal {
        return when {
            row >= 14 -> BigDecimal(14.50)
            (num in 1..3) || (num in 34..36) -> BigDecimal(16.50)
            row == 1 -> BigDecimal(21)
            else -> BigDecimal(18.00)
        }
    }
    private fun getDescription(price: BigDecimal, row: Int): String {
        return when {
            row == 14 -> "Cheaper seat"
            row == 15 -> "Back row"
            price ==  BigDecimal(16.50) -> "Restricted view"
            row <= 2 -> "Best view"
            else -> "Standard seat"
        }
    }
    constructor() {
    for (row in (1..15)) {
        for (num in (1..36)) {
            val price = getPrice(row, num)
            val newSeat = Seat((row + 64).toChar(), num, price, getDescription(price, row))
            hiddenSeats.add(newSeat)
        }
    }
    }


    val seats
    get() = hiddenSeats.toList()

    fun find(num: Int, row: Char): Seat {
        return seats.filter { it.row == row && it.num == num }.first()
    }
}

fun main(args: Array<String>) {
    val cheapSeats = TheaterService().seats.filter {it.price == BigDecimal(14.50)}
    val frontSeats = TheaterService().seats.filter {it.price == BigDecimal(21)}
    for (seat in cheapSeats) println(seat)
    for (seat in frontSeats) println(seat)
}