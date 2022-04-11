package com.lwood54.theater.services

import com.lwood54.theater.domain.Seat
import org.springframework.stereotype.Service

@Service
class BookingService() {

    fun isSeatFree(seat: Seat): Boolean {
        return true
    }
}