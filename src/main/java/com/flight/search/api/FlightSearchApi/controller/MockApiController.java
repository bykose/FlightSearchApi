package com.flight.search.api.FlightSearchApi.controller;

import com.flight.search.api.FlightSearchApi.model.Flight;
import com.flight.search.api.FlightSearchApi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fetchFlights")
public class MockApiController {
    private final FlightService flightService;
    @GetMapping()
    public List<Flight> fetchFlights() {
        return flightService.fetchFlights();
    }
}
