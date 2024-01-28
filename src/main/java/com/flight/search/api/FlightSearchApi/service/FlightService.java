package com.flight.search.api.FlightSearchApi.service;

import com.flight.search.api.FlightSearchApi.model.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public interface FlightService {
    Flight save(Flight flight);
    void delete(String id);
    Flight update(Flight flight);
    List<Flight> findAll();
    Flight findById(String id);
    List<Flight> searchWithParams(String departureCity, String arrivalCity, Date departureDate, Date returnDate);
    List<Flight> fetchFlights();
}
