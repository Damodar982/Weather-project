package com.omnify.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:8080")
public class WeatherController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${weather.api.key}")
	private String weatherApiKey;

	@GetMapping("/{location}")
	public ResponseEntity<?> getWeather(@PathVariable String location){
		try {
            String apiUrl = "https://api.tomorrow.io/v4/timelines?location=" + location + "&fields=temperature&timesteps=1h&units=metric&apikey=" + weatherApiKey;

            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

            String json = response.getBody();

            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to fetch weather data.");
        }		
	}
}
