package com.flight.search.api.FlightSearchApi.controller;

import com.flight.search.api.FlightSearchApi.model.Flight;
import com.flight.search.api.FlightSearchApi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {
    private final FlightService flightService;
    @GetMapping()
    public List<Flight> searchFlights(@RequestParam String departureCity,
                                      @RequestParam String arrivalCity,
                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date departureTime,
                                      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date returnTime) {
        return flightService.searchWithParams(departureCity, arrivalCity, departureTime, returnTime);
    }
}
