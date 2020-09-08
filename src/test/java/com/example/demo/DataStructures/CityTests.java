package com.example.demo.DataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityTests {

    private City city;

    @BeforeEach
    void setUp() {
        this.city = new City("London");
        this.city.setLatitude(100);
        this.city.setLongitude(-100);
    }

    @Test
    void getLongitudeTest() {
        assertEquals(this.city.getLongitude(), -100);
    }

    @Test
    void getLatitudeTests() {
        assertEquals(this.city.getLatitude(), 100);
    }
}
