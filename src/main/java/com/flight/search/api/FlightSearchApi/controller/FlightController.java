package com.flight.search.api.FlightSearchApi.controller;

import com.flight.search.api.FlightSearchApi.model.Flight;
import com.flight.search.api.FlightSearchApi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flights")
public class FlightController {
    private final FlightService flightService;
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.findAll();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable String id) {
        return flightService.findById(id);
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.save(flight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable String id) {
        flightService.delete(id);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@RequestBody Flight updatedFlight) {
        return flightService.update(updatedFlight);
    }

}
