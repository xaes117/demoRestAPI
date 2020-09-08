package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataManagerTests {

    private DataManager manager;

    @BeforeEach
    void setUp() throws Exception {
        this.manager = new DataManager();
        this.manager.loadCityData();
        this.manager.loadPersonData();
    }

    @Test
    void getCityByNameTest() throws Exception {
        String city = this.manager.getCityByName("London").getName();
        assertEquals("London", city);
    }

    @Test
    void getPersonByIdTest() throws Exception {
        Person person = this.manager.getPersonByID(1);
        assertEquals(34.003135, person.getLatitude());
        assertEquals(-117.7228641, person.getLongitude());
    }

    @Test
    void withinDistanceTest() {
    }
}
