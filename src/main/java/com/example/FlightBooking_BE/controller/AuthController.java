package com.example.FlightBooking_BE.controller;

import com.example.FlightBooking_BE.dto.request.CustomerRegistrationRequest;
import com.example.FlightBooking_BE.dto.response.CustomerRegistrationResponse;
import com.example.FlightBooking_BE.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:5173")  // Allow frontend URL
@Validated
public class AuthController {
    private final CustomerService customerService;

    @Autowired
    public AuthController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerRegistrationResponse> registerCustomer(@Valid @RequestBody CustomerRegistrationRequest request) {
        CustomerRegistrationResponse response = customerService.registerCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
