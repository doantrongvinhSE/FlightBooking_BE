package com.example.FlightBooking_BE.service;

import com.example.FlightBooking_BE.dto.request.CustomerRegistrationRequest;
import com.example.FlightBooking_BE.dto.response.CustomerRegistrationResponse;
import com.example.FlightBooking_BE.model.Customer;
import com.example.FlightBooking_BE.model.User;
import com.example.FlightBooking_BE.repository.CustomerRepository;
import com.example.FlightBooking_BE.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public CustomerRegistrationResponse registerCustomer(CustomerRegistrationRequest request) {
        validateRegistrationRequest(request);

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);

        // create customer
        Customer customer = new Customer();
        customer.setUser(savedUser);
        customer.setFullName(request.getFullName());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setDateOfBirth(request.getDateOfBirth());
        customerRepository.save(customer);


        return new CustomerRegistrationResponse(
                savedUser.getId(),
                savedUser.getEmail(),
                customer.getFullName(),
                "Registration successful"
        );
    }

    @Override
    public Customer getCustomerById(long id) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    private void validateRegistrationRequest(CustomerRegistrationRequest request) {
        if (existsByEmail(request.getEmail())) {
            throw new RuntimeException("Username already exists");
        }
    }
}
