package com.example.demo.RestService;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.DataStructures.City;
import com.example.demo.DataManager;
import com.example.demo.DemoApplication;
import com.example.demo.Lib.MathLib;
import com.example.demo.DataStructures.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
class PopulationController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/population/{city}")
    public Population getPopulation(@RequestParam(value = "radius", defaultValue = "0") Integer radius, @PathVariable String city) throws Exception {

        DataManager dataManager = DemoApplication.getManager();

        // If no radius specified return the population in the city
        if (radius == 0) {
            return new Population(counter.incrementAndGet(), dataManager.populationByCity(city));
        }

        City city1 = dataManager.getCityByName(city);

        int population = 0;

        for (Person person : dataManager.getPersonSet()) {

            // if the person and city are within the specified radius increment population by 1
            if (MathLib.distance(person.getLongitude(), person.getLatitude(), city1.getLongitude(), city1.getLatitude()) < radius) {
                population++;
            }
        }

        return new Population(counter.incrementAndGet(), population);
    }

}