package com.example.demo.RestService;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.City;
import com.example.demo.DataManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PopulationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/population/{city}")
    public Population greeting(@RequestParam(value = "radius", defaultValue = "0") String radius, @PathVariable String city) throws Exception {

        DataManager dataManager = new DataManager();
        dataManager.loadCityData();

        City city1 = dataManager.getCityByName(city);
        System.out.println(city1.getName() + " : " + city1.getLatitude() + " : " + city1.getLongitude());


        return new Population(counter.incrementAndGet(), String.format(template, radius));
    }
}