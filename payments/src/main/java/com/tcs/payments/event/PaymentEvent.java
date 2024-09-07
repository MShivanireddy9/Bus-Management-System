package com.tcs.payments.event;

import java.util.UUID;

import java.time.LocalDate;

public class PaymentEvent {
    private UUID paymentId;
    private int bookingId;
    private LocalDate paymentDate;
    private String eventDescription;

    public PaymentEvent() {
        // Default constructor
    }

    public PaymentEvent(UUID paymentId, int bookingId, LocalDate paymentDate, String eventDescription) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.paymentDate = paymentDate;
        this.eventDescription = eventDescription;
    }

    // Getters and setters

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int i) {
        this.bookingId = i;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
