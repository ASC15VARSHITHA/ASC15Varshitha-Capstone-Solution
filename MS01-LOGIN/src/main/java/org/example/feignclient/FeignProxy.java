package org.example.feignclient;

import org.example.model.BookingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("Booking-Feign")
public interface FeignProxy {
    @GetMapping("/bookings/allbookings")
    List<BookingDTO> getAllBookings();
}
