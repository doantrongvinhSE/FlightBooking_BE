package com.example.FlightBooking_BE.service;

import com.example.FlightBooking_BE.model.User;

import java.util.Optional;

public interface UserService {
    User findUserByEmail(String email);
    User findUserById(long id);
    User save(User user);
//    Boolean existsByEmail(String email);
}
