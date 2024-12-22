package com.example.FlightBooking_BE.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationResponse {
    private Long userId;
    private String username;
    private String email;
    private String message;
}
