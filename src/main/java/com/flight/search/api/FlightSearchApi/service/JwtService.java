package com.flight.search.api.FlightSearchApi.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public interface JwtService {

    String extractUsername(String jwtToken);
    Claims extractAllClaims(String jwtToken);
    String generateToken(UserDetails userDetails);
    String generateRefreshToken(UserDetails userDetails);
    boolean isTokenExpired(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    Date extractExpiration(String token);
}
