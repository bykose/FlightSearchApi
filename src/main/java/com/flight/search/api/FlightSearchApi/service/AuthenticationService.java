package com.flight.search.api.FlightSearchApi.service;

import com.flight.search.api.FlightSearchApi.ReqRes.AuthenticationRequest;
import com.flight.search.api.FlightSearchApi.ReqRes.AuthenticationResponse;
import com.flight.search.api.FlightSearchApi.ReqRes.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
