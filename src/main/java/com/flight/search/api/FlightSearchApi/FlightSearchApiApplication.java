package com.flight.search.api.FlightSearchApi;

import com.flight.search.api.FlightSearchApi.ReqRes.RegisterRequest;
import com.flight.search.api.FlightSearchApi.enums.Role;
import com.flight.search.api.FlightSearchApi.model.User;
import com.flight.search.api.FlightSearchApi.repository.UserRepository;
import com.flight.search.api.FlightSearchApi.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

@SpringBootApplication
@EnableScheduling
public class FlightSearchApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSearchApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.username("admin")
					.password("1234")
					.role(Role.ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var user = RegisterRequest.builder()
					.firstname("test")
					.lastname("user")
					.username("test")
					.password("123456")
					.role(Role.USER)
					.build();
			System.out.println("User token: " + service.register(user).getAccessToken());

		};
	}
}
