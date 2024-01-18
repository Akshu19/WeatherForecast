package com.example.weatherforecast.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CityWeatherService {
    public ResponseEntity<Object> getCityInfo(String city) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://forecast9.p.rapidapi.com/rapidapi/forecast/" + city + "/summary/"))
                .header("X-RapidAPI-Key", "94ac71f0c9msh8d5bf23728b3c6dp1f0827jsn39bfcb799372")
                .header("X-RapidAPI-Host", "forecast9.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return new ResponseEntity<Object>(response.body(), HttpStatus.OK);
    }
    //httprequest, resttemplate - client that helps in calling rest resources.

}
