package com.example.weatherforecast.controller;

import com.example.weatherforecast.service.CityWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CityWeatherController {
    @Autowired
    CityWeatherService cityWeatherService;
    @GetMapping(name = "/cityWeather/{city}")
    public ResponseEntity<Object> getCityWeather(@PathVariable final String city) throws IOException, InterruptedException {
        return cityWeatherService.getCityInfo(city);
    }
}
