package com.flight.search.api.FlightSearchApi.repository;

import com.flight.search.api.FlightSearchApi.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,String> {
}
