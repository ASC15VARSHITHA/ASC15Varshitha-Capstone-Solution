package org.example.controller;

import org.example.entity.BookingEntity;
import org.example.model.BookingDTO;
import org.example.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public BookingEntity createBooking(@RequestBody BookingEntity bookingEntity) {
        return bookingService.createBooking(bookingEntity);
    }


    @PutMapping("/update/{bookingId}")
    public BookingEntity updateBooking(@PathVariable String bookingId, @RequestBody BookingEntity bookingEntity) {
        return bookingService.updateBooking(bookingId, bookingEntity);
    }

    @DeleteMapping("/delete/{bookingId}")
    public void deleteBooking(@PathVariable String bookingId) {
        bookingService.deleteBooking(bookingId);
    }

    @GetMapping("/search/{bookingId}")
    public BookingEntity getBookingById(@PathVariable String bookingId) {
        return bookingService.getBookingById(bookingId);
    }

//    @GetMapping("/allbookings")
//    public List<BookingEntity> getAllBookings() {
//        return bookingService.getAllBookings();
//    }

    @GetMapping("/allbookings")
    public List<BookingDTO> getAllBookings() {
        return bookingService.getAllBookings().stream().map(bookingEntity -> new BookingDTO(
                bookingEntity.getBookingId(),
                bookingEntity.getPassengerName(),
                bookingEntity.getBookingDate(),
                bookingEntity.getSeatNumber(),
                bookingEntity.getCost(),
                bookingEntity.getTotalAmount(),
                bookingEntity.getDepartureDateAndTime(),
                bookingEntity.getArrivalDateAndTime()
        )).toList();
}