package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PopulationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/population")
    public Population greeting(@RequestParam(value = "radius", defaultValue = "0") String name) {
        return new Population(counter.incrementAndGet(), String.format(template, name));
    }
}