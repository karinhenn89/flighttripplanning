package com.example.flighttripplanning.Repository;

import com.example.flighttripplanning.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByFromLocationIgnoreCaseAndToLocationIgnoreCase(String from, String to);

    @Query("SELECT DISTINCT r.fromLocation FROM Flight r")
    List<String> findDistinctFromLocation();

    @Query("SELECT DISTINCT r.toLocation FROM Flight r WHERE r.fromLocation = :fromLocation")
    List<String> findDistinctToLocationByFromLocation(@Param("fromLocation") String fromLocation);
}
