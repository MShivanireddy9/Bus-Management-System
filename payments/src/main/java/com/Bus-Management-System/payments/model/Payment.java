package com.tcs.payments.model;


import java.time.LocalDate;
import java.util.UUID;

//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.databind.util.StdConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import org.springframework.core.convert.converter.Converter;
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
//    @JsonSerialize(converter = UUIDToStringConverter.class)
//    @JsonDeserialize(converter = StringToUUIDConverter.class)
    private UUID paymentId;

    @Column(name = "booking_id", nullable = false, unique = true)
    private int bookingId;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    // Constructors

    public Payment() {
        this.paymentId = UUID.randomUUID();
    }
//    @Override
//    public UUID convert(String value) {
//        return UUID.fromString(value);
//    }
    public Payment(int bookingId) {
        this.paymentId = UUID.randomUUID();
        this.bookingId = bookingId;
        this.paymentDate = LocalDate.now();
        System.out.println(LocalDate.now());
    }

    // Getters and Setters

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = LocalDate.now();
    }
    public UUID getPaymentIdByBookingId(int bookingId) {
        if (this.bookingId == bookingId) {
            return paymentId;
        }
        return null;
    }
//    public class UUIDToStringConverter extends StdConverter<UUID, String> {
//        @Override
//        public String convert(UUID value) {
//            return value.toString();
//        }
//    }
//    public class StringToUUIDConverter implements Converter<String, UUID> {
//
//        @Override
//        public UUID convert(String source) {
//            // Implement the conversion logic from String to UUID
//            // You can use UUID.fromString method to convert the string representation to UUID
//            return UUID.fromString(source);
//        }
//    }
//    public class StringToUUIDConverter extends StdConverter<String, UUID> {
//        @Override
//        public UUID convert(String value) {
//            return UUID.fromString(value);
//        }
//    }
    // Additional methods

    // ...
}
