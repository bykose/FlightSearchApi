package com.flight.search.api.FlightSearchApi.service;

import com.flight.search.api.FlightSearchApi.model.Flight;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@Service
public interface FlightBatchService {
    List<Flight> fetchFlights() throws IOException, InterruptedException;
}
