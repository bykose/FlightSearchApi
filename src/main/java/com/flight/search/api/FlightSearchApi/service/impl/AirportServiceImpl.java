package com.flight.search.api.FlightSearchApi.service.impl;

import com.flight.search.api.FlightSearchApi.model.Airport;
import com.flight.search.api.FlightSearchApi.repository.AirportRepository;
import com.flight.search.api.FlightSearchApi.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;
    @Override
    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public void delete(String id) {
        airportRepository.deleteById(id);
    }

    @Override
    public Airport update(Airport airport) {
        Airport existAirport = airportRepository.findById(airport.getId()).orElse(null);
        if(existAirport != null) {
            existAirport.setCity(airport.getCity());
            existAirport = airportRepository.save(existAirport);
        }
        return existAirport;
    }

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public Airport findById(String id) {
        return airportRepository.findById(id).orElse(null);
    }

}
