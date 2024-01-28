package com.flight.search.api.FlightSearchApi.repository;

import com.flight.search.api.FlightSearchApi.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {
}
