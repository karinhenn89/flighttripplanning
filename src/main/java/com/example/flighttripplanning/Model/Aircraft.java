package com.example.flighttripplanning.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;

@Embeddable
public class Aircraft {

    @JsonProperty("type")
    private String type;

    @JsonProperty("allSeats")
    private int allSeats;
}

