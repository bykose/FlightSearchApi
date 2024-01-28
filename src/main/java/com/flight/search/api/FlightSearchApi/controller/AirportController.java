package com.flight.search.api.FlightSearchApi.controller;

import com.flight.search.api.FlightSearchApi.model.Airport;
import com.flight.search.api.FlightSearchApi.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/airports")
public class AirportController {
    private final AirportService airportService;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.findAll();
    }

    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable String id) {
        return airportService.findById(id);
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.save(airport);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable String id) {
        airportService.delete(id);
    }

    @PutMapping("/{id}")
    public Airport updateAirport(@RequestBody Airport updatedAirport) {
        return airportService.update(updatedAirport);
    }
}
