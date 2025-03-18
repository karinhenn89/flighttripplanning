package com.example.flighttripplanning.Service;

import com.example.flighttripplanning.Repository.FlightRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.example.flighttripplanning.Model.Flight;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlightService {

    private final ObjectMapper objectMapper;
    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(ObjectMapper objectMapper, FlightRepository flightRepository) {
        this.objectMapper = objectMapper;
        this.flightRepository = flightRepository;
    }

    @PostConstruct
    public void loadFlightsToDatabase() throws IOException {
        File file = new ClassPathResource("data/flights.json").getFile();
        List<Flight> flights = objectMapper.readValue(file, new TypeReference<List<Flight>>() {});

        flightRepository.deleteAll();
        flightRepository.saveAll(flights);
    }

    public Map<String, List<String>> getAllFlightsFromLocation() {
        List<String> fromLocation = flightRepository.findDistinctFromLocation();
        return Map.of("fromLocation", fromLocation);
    }

    public Map<String, List<String>> getToLocationsByFrom(String fromLocation) {
        List<String> toLocations = flightRepository.findDistinctToLocationByFromLocation(fromLocation);
        return Map.of("toLocations", toLocations);
    }

    public List<Flight> searchFlights(String from, String to) {
        return flightRepository.findByFromLocationIgnoreCaseAndToLocationIgnoreCase(from, to);
    }

}
