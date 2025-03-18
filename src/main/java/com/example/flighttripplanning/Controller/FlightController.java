package com.example.flighttripplanning.Controller;

import com.example.flighttripplanning.Model.Flight;
import com.example.flighttripplanning.Service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam String from, @RequestParam String to) {
        return flightService.searchFlights(from, to);
    }
}

