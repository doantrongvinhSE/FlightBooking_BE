package com.example.FlightBooking_BE.service;

import com.example.FlightBooking_BE.dto.request.CustomerRegistrationRequest;
import com.example.FlightBooking_BE.dto.response.CustomerRegistrationResponse;
import com.example.FlightBooking_BE.model.Customer;

public interface CustomerService {
    CustomerRegistrationResponse registerCustomer(CustomerRegistrationRequest request);
    Customer getCustomerById(long id);
    Customer updateCustomer(Customer customer);
    boolean existsByEmail(String email);
}
