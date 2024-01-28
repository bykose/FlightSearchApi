package com.flight.search.api.FlightSearchApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    private Airport departureAirport;
    @ManyToOne
    private Airport arrivalAirport;
    private Date departureDate;
    private Date returnDate;
    private Double price;

    @Override
    public String toString() {
        return "Flights{" +
                "id='" + id + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                "arrivalAirport='" + arrivalAirport + '\'' +
                "departureDate='" + departureDate + '\'' +
                "returnDate='" + returnDate + '\'' +
                "price='" + price + '\'' +
                "}";
    }

}
