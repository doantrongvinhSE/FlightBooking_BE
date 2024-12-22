package com.example.FlightBooking_BE.repository;

import com.example.FlightBooking_BE.model.Customer;
import com.example.FlightBooking_BE.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUser(User user);
}
