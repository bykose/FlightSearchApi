package com.flight.search.api.FlightSearchApi.service;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
public interface LogoutService{

    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication);
}
