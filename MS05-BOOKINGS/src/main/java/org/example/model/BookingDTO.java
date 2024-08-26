package org.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingDTO {
        private String bookingId;
        private String passengerName;
        private LocalDate bookingDate;
        private Integer seatNumber;
        private Double cost;
        private Double totalAmount;
        private LocalDateTime departureDateAndTime;
        private LocalDateTime arrivalDateAndTime;

    public BookingDTO(String bookingId, String passengerName, LocalDate bookingDate, Integer seatNumber, Double cost, Double totalAmount, LocalDateTime departureDateAndTime, LocalDateTime arrivalDateAndTime) {
        this.bookingId = bookingId;
        this.passengerName=passengerName;
        this.bookingDate=bookingDate;
        this.cost=cost;
        this.seatNumber=seatNumber;
    }


    // Getters and Setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getDepartureDateAndTime() {
        return departureDateAndTime;
    }

    public void setDepartureDateAndTime(LocalDateTime departureDateAndTime) {
        this.departureDateAndTime = departureDateAndTime;
    }

    public LocalDateTime getArrivalDateAndTime() {
        return arrivalDateAndTime;
    }

    public void setArrivalDateAndTime(LocalDateTime arrivalDateAndTime) {
        this.arrivalDateAndTime = arrivalDateAndTime;
    }
}
