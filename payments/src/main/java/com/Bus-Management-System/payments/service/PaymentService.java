//package com.tcs.payments.service;
//
//import java.time.LocalDate;
//import java.util.UUID;
//
//import org.springframework.stereotype.Service;
//
//import com.tcs.payments.model.Payment;
//import com.tcs.payments.repository.PaymentRepository;
//
//import jakarta.persistence.EntityNotFoundException;
//
//@Service
//public class PaymentService {
//
//    private final PaymentRepository paymentRepository;
//    private final PaymentEventProducer paymentEventProducer;
//
//    public PaymentService(PaymentRepository paymentRepository, PaymentEventProducer paymentEventProducer) {
//        this.paymentRepository = paymentRepository;
//        this.paymentEventProducer = paymentEventProducer;
//    }
//
//    public Payment getPayment(UUID paymentId) {
//        return paymentRepository.findById(paymentId)
//                .orElseThrow(()->new EntityNotFoundException("Payment not found with ID: " + paymentId));
//    }
//
//    public Payment createPayment(Payment payment) {
////        Payment payment = new Payment(bookingId, paymentDate);
//
//        Payment createdPayment = paymentRepository.save(payment);
//
//        // Publish payment event to the event queue
//        paymentEventProducer.publishPaymentEvent(createdPayment);
//
//        return createdPayment;
//    }
//
//    public Payment updatePayment(UUID paymentId, Payment payment) {
//        Payment existingPayment = getPayment(paymentId);
//
//        // Update existing payment attributes
//        existingPayment.setBookingId(payment.getBookingId());
//        existingPayment.setPaymentDate(payment.getPaymentDate());
//        // Update other attributes as needed
//
//        Payment updatedPayment = paymentRepository.save(existingPayment);
//
//        // Publish payment event to the event queue
//        paymentEventProducer.publishPaymentEvent(updatedPayment);
//
//        return updatedPayment;
//    }
//
//    public void deletePayment(UUID paymentId) {
//        Payment existingPayment = getPayment(paymentId);
//        paymentRepository.delete(existingPayment);
//    }
//}
//
package com.tcs.payments.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tcs.payments.model.Payment;
import com.tcs.payments.repository.PaymentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment getPayment(UUID paymentId) {
    	System.out.println("getPayment");
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found with ID: " + paymentId));
    }
    public Payment getPaymentIdByBookingId(int bid) throws EntityNotFoundException{
    	if(paymentRepository.findByBookingId(bid)!= null)
        {
        	return paymentRepository.findByBookingId(bid);
        }
        throw new EntityNotFoundException("bookingid is not found with ID: " + bid);
    }
    public Payment createPayment(Payment payment) {
        Payment createdPayment = paymentRepository.save(payment);
        return createdPayment;
    }

    public Payment updatePayment(UUID paymentId, Payment payment) {
    	System.out.println("updatePayment");
        Payment existingPayment = getPayment(paymentId);

        // Update existing payment attributes
        existingPayment.setBookingId(payment.getBookingId());
        existingPayment.setPaymentDate(payment.getPaymentDate());
        // Update other attributes as needed

        Payment updatedPayment = paymentRepository.save(existingPayment);
        return updatedPayment;
    }

    public void deletePayment(UUID paymentId) {
    	System.out.println("deletePayment");
        Payment existingPayment = getPayment(paymentId);
        paymentRepository.delete(existingPayment);
    }
}
