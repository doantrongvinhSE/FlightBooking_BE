package com.example.FlightBooking_BE.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "flight_code", nullable = false)
    private String flightCode;

    @Column(name = "route_id", nullable = false)
    private long routeId;

    @Column(name = "aircraft_id", nullable = false)
    private long aircraftId;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departure;

    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrival;

    private String status;
}
