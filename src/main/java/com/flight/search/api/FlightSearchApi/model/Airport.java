package com.flight.search.api.FlightSearchApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String city;
}
