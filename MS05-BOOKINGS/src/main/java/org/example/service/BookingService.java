package org.example.service;

import org.example.entity.BookingEntity;
import org.example.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    // Booking id Auto generation method
    private String substringBookingId() {
        Integer bookingCount = bookingRepository.findAll().size() + 1;
        return String.format("B%04d", bookingCount);
    }

    // CRUD-CREATE
    public BookingEntity createBooking(BookingEntity bookingEntity) {
        bookingEntity.setBookingId(substringBookingId());
        return bookingRepository.save(bookingEntity);
    }

    //CRUD-UPDATE
    public BookingEntity updateBooking(String bookingId, BookingEntity bookingEntity) {
        bookingEntity.setBookingId(bookingId);
        return bookingRepository.save(bookingEntity);
    }

    //CRUD-DELETE
    public void  deleteBooking(String bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    // SEARCH BY ID
    public BookingEntity getBookingById(String bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(()-> new RuntimeException("Booking Id not found"));
    }

    // CRUD-READ
    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }

}
