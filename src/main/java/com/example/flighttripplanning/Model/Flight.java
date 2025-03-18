package com.example.flighttripplanning.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightId;

    @JsonProperty("from")
    private String fromLocation;

    @JsonProperty("to")
    private String toLocation;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @JsonProperty("availableSeats")
    private int availableSeats;

    @JsonProperty("price")
    private double Price;

    @Embedded
    @JsonProperty("aircraft")
    private Aircraft aircraft;
}
