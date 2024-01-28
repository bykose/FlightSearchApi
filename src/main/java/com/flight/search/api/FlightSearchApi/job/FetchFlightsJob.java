package com.flight.search.api.FlightSearchApi.job;

import com.flight.search.api.FlightSearchApi.model.Flight;
import com.flight.search.api.FlightSearchApi.service.FlightBatchService;
import com.flight.search.api.FlightSearchApi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
@Component
@Qualifier("fetchFlightsJob")
@ManagedResource(objectName = "com.flight.search.api.FlightSearchApi.job:name=FetchFlightsJob", description = "flights fetch job")
public class FetchFlightsJob {
    @Autowired
    private FlightBatchService flightBatchService ;
    @Autowired
    private FlightService flightService;
    @Scheduled(fixedRate = 2000L)
    public void fetchJob() throws IOException, InterruptedException {
        System.out.println("*******Fetch Flights Job Started*******");
        List<Flight> flights = flightBatchService.fetchFlights();
        flights.forEach(flightService::save);
        System.out.println("*******Fetch Flights Job Finished*******");
    }
}
