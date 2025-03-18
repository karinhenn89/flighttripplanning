package com.example.flighttripplanning.Repository;

import com.example.flighttripplanning.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByFromLocationIgnoreCaseAndToLocationIgnoreCase(String from, String to);
}
