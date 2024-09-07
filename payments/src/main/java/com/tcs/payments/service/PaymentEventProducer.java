//package com.tcs.payments.service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//
//@Service
//public class PaymentEventProducer {
//	@Autowired
//    private final RestTemplate restTemplate;
//
//    @Autowired
//    public PaymentEventProducer(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public int checkAvailability(String busNumber, int numberOfSeats) throws InventoryServiceException {
//        // Call the inventory service to check available seats
//        ResponseEntity<BusInventory> response = restTemplate.getForEntity("http://localhost:8080/inventory/{busNumber}", BusInventory.class, busNumber, numberOfSeats);
//        if (response.getStatusCode() == HttpStatus.OK) {
//        	BusInventory inventory = response.getBody();
//            if (inventory != null) {
//                int availableSeats = inventory.getAvailableSeats();
//                System.out.print(availableSeats);
//                return availableSeats ;
//            }
//            throw new InventoryServiceException("Failed to check availability from the inventory service.");
//        } else {
//            throw new InventoryServiceException("Failed to check availability from the inventory service.");
//            
//        }
//
//    }
//
//    public void reserveSeats(String busNumber, int numberOfSeats) {
//        // Call the inventory service to reserve seats
//    	Map<String, Object> requestBody = new HashMap<>();
//        requestBody.put("busNumber", busNumber);
//        requestBody.put("availableSeats", numberOfSeats);
//        System.out.println(numberOfSeats);
//        ResponseEntity<Void> response = restTemplate.postForEntity("http://localhost:8080/inventory", requestBody, Void.class, busNumber, numberOfSeats);
//        if (response.getStatusCode() != HttpStatus.CREATED) {
//            throw new InventoryServiceException("Failed to reserve seats from the inventory service.");
//        }
//        System.out.println(requestBody);
//        System.out.println(numberOfSeats);
//    }
//
//    public void releaseSeats(String busNumber, int numberOfSeats) {
//        // Call the inventory service to release seats
//    	Map<String, Object> requestBody = new HashMap<>();
//        requestBody.put("busNumber", busNumber);
//        requestBody.put("numberOfSeats", numberOfSeats);
//        ResponseEntity<Void> response = restTemplate.postForEntity("http://localhost:8080/inventory/{busNumber}", null, Void.class, busNumber, numberOfSeats);
//        if (response.getStatusCode() != HttpStatus.OK) {
//            throw new InventoryServiceException("Failed to release seats from the inventory service.");
//        }
//    }
//}
