package com.example.FlightBooking_BE.common.security;

public class SecurityConstants {
    public static final int TOKEN_EXPIRATION = 7200;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String AUTHORIZATION = "Authorization";
    public static final String REGISTER_PATH = "/api/v1/auth/**";
}
