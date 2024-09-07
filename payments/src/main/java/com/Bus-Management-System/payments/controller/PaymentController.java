package com.tcs.payments.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.payments.model.Payment;
import com.tcs.payments.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController{
	private final PaymentService paymentService;
	public PaymentController(PaymentService paymentService)
	{
		this.paymentService=paymentService;
	}
	
//	@GetMapping("/payments")
//	public ResponseEntity<Payment> getPayment(@PathVariable("paymentId") String paymentId)
//	{
//		Payment payment = paymentService.getPayment(paymentId);
//        return ResponseEntity.ok(payment);
//	}
	@GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPayment(@PathVariable("paymentId") UUID paymentId) {
        Payment payment = paymentService.getPayment(paymentId);
        return ResponseEntity.ok(payment);
    }

	@GetMapping("/byBookingId/{BookingId}")
    public ResponseEntity<Payment> getPaymentIdByBookingId(@PathVariable("BookingId") int BookingId) {
        Payment payment = paymentService.getPaymentIdByBookingId(BookingId);
        return ResponseEntity.ok(payment);
    }
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPayment);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<Payment> updatePayment(
            @PathVariable("paymentId") UUID paymentId,
            @RequestBody Payment payment) {
        Payment updatedPayment = paymentService.updatePayment(paymentId, payment);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable("paymentId") UUID paymentId) {
        paymentService.deletePayment(paymentId);
        return ResponseEntity.noContent().build();
    }
}

