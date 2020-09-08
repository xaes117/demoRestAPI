package com.example.demo.RestService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PopulationTests {

    Population population;

    @BeforeEach
    void setUp() {
        this.population = new Population(1, 1000);
    }

    @Test
    void getIdTest() {
        assertEquals(this.population.getId(), 1);
    }

    @Test
    void getPopulationSizeTest() {
        assertEquals(this.population.getPopulationSize(), 1000);
    }
}
