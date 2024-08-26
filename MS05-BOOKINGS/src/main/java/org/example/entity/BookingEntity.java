package org.example.entity;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class BookingEntity {
    @Id
    @Column(name = "booking_id")
    private String bookingId;
    @Column(name = "passenger_name")
    private String passengerName;
    @Column(name = "booking_date")
    private LocalDate bookingDate;
    @Column(name = "seat_number")
    private Integer seatNumber;
    @Column(name = "cost")
    private Double cost;
    @Column(name = "total_amount")
    private Double totalAmount;
    @Column(name = "departure_date_time")
    private LocalDateTime departureDateAndTime;
    @Column(name = "arrival_date_time")
    private LocalDateTime arrivalDateAndTime;

    //Default Constructor
    public BookingEntity() {}

    //Constructor
    public BookingEntity(String bookingId, String passengerName, LocalDate bookingDate,
                         Integer seatNumber, Double cost, Double totalAmount, LocalDateTime departureDateAndTime,
                         LocalDateTime arrivalDateAndTime) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.bookingDate = bookingDate;
        this.seatNumber = seatNumber;
        this.cost = cost;
        this.totalAmount = totalAmount;
        this.departureDateAndTime = departureDateAndTime;
        this.arrivalDateAndTime = arrivalDateAndTime;
    }

    //Getters and Setters
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

    @Override
    public String toString() {
        return "BookingEntity{" +
                "bookingId='" + bookingId + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", bookingDate=" + bookingDate +
                ", seatNumber=" + seatNumber +
                ", cost=" + cost +
                ", totalAmount=" + totalAmount +
                ", departureDateAndTime=" + departureDateAndTime +
                ", arrivalDateAndTime=" + arrivalDateAndTime +
                '}';
    }
}
