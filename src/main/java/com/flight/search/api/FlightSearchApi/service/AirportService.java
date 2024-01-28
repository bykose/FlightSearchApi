package com.flight.search.api.FlightSearchApi.service;

import com.flight.search.api.FlightSearchApi.model.Airport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirportService {
    Airport save(Airport airport);
    void delete(String id);
    Airport update(Airport airport);
    List<Airport> findAll();
    Airport findById(String id);
}
