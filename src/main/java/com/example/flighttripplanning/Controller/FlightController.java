package com.example.flighttripplanning.Controller;

import com.example.flighttripplanning.Model.Flight;
import com.example.flighttripplanning.Service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/locations-from")
    public Map<String, List<String>> getAllFromLocations() {
        return flightService.getAllFlightsFromLocation();
    }

    @GetMapping("/locations-to/{fromLocation}")
    public Map<String, List<String>> getToLocations(@PathVariable String fromLocation) {
        return flightService.getToLocationsByFrom(fromLocation);
    }

}

