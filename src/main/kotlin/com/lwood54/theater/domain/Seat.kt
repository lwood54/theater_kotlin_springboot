package com.lwood54.theater.domain

import java.math.BigDecimal

data class Seat(val row: Char, val num: Int, val price: BigDecimal, val description: String) {
    // YOU MAY NOT EDIT THIS CLASS
    override fun toString(): String = "Seat $row-$num $$price ($description)"
}