package com.tcs.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.payments.model.Payment;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    // You can add custom query methods or use the default methods provided by JpaRepository

    // Example custom query method to find a payment by bookingId
    Payment findByBookingId(int bookingId);

    // Example custom query method to find a payment by paymentDate
    List<Payment> findByPaymentDate(LocalDate paymentDate);

    // You can also use the default methods provided by JpaRepository
    // For example, findById(), save(), deleteById(), etc.
}
