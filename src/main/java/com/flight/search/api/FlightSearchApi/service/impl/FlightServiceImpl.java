package com.flight.search.api.FlightSearchApi.service.impl;

import com.flight.search.api.FlightSearchApi.model.Airport;
import com.flight.search.api.FlightSearchApi.model.Flight;
import com.flight.search.api.FlightSearchApi.repository.FlightRepository;
import com.flight.search.api.FlightSearchApi.service.AirportService;
import com.flight.search.api.FlightSearchApi.service.FlightService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final AirportService airportService;
    @Override
    @Transactional
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    @Transactional
    public void delete(String id) {
        flightRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Flight update(Flight flight) {
        Flight existFligt = flightRepository.findById(flight.getId()).orElse(null);
        if(existFligt != null) {
            existFligt.setPrice(flight.getPrice());
            existFligt.setArrivalAirport(flight.getArrivalAirport());
            existFligt.setDepartureAirport(flight.getDepartureAirport());
            existFligt.setDepartureDate(flight.getDepartureDate());
            existFligt.setReturnDate(flight.getReturnDate());
            existFligt = flightRepository.save(existFligt);
        }
        return existFligt;
    }

    @Override
    @Transactional
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    @Transactional
    public Flight findById(String id) {
        return flightRepository.findById(id).orElse(null);
    }

    @Override
    public List<Flight> searchWithParams(String departureCity, String arrivalCity, Date departureDate, Date returnDate) {
        List<Flight> flights = findAll();
        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {

            if (flight.getDepartureAirport().getCity().equals(departureCity) &&
                    flight.getArrivalAirport().getCity().equals(arrivalCity) &&
                    flight.getDepartureDate().equals(departureDate)) {
                result.add(flight);
            }
        }

        if (returnDate != null) {

            for (Flight flight : flights) {

                if (flight.getDepartureAirport().getCity().equals(arrivalCity) &&
                        flight.getArrivalAirport().getCity().equals(departureCity) &&
                        flight.getDepartureDate().equals(returnDate) &&
                        flight.getReturnDate() == null) {

                    result.add(flight);
                }
            }
        }

        return result;
    }

    @Override
    public List<Flight> fetchFlights() {
        return generateMockFlights();
    }

    private List<Flight> generateMockFlights() {
        List<Flight> flights = new ArrayList<>();
        List<Airport> airports = new ArrayList<>();
        List<String> cities = new ArrayList<>();
        cities.add("Ankara");
        cities.add("Istanbul");
        cities.add("Izmir");
        cities.add("Antalya");
        cities.add("Mugla");
        cities.add("Malatya");
        cities.forEach(s -> {
            Airport airport = new Airport();
            UUID uuid = UUID.randomUUID();
            airport.setId(uuid.toString());
            airport.setCity(s);
            airports.add(airport);
        });

        airports.forEach(airportService::save);

        for(int i=0; i<5; i++){
            Flight flight = new Flight();
            UUID uuid = UUID.randomUUID();
            int randomIndex = ThreadLocalRandom.current().nextInt(0, 4 + 1);
            int randomIndex2 = ThreadLocalRandom.current().nextInt(0, 4 + 1);
            Date returnDate = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(returnDate);
            c.add(Calendar.DATE, 2);
            returnDate = c.getTime();

            flight.setId(uuid.toString());
            flight.setDepartureAirport(airports.get(randomIndex));
            flight.setArrivalAirport(airports.get(randomIndex2));
            flight.setPrice(1000.0);
            flight.setDepartureDate(new Date());
            flight.setReturnDate(returnDate);
            flights.add(flight);
        }

        return flights;
    }
}
