package com.example.flighttripplanning.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Aircraft {

    @JsonProperty("type")
    private String type;

    @JsonProperty("allSeats")
    private int allSeats;

}

