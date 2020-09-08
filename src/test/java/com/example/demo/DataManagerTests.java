package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataManagerTests {

    DataManager manager;

    @BeforeEach
    void setUp() throws Exception {
        this.manager = new DataManager();
        this.manager.loadCityData();
    }

    @Test
    void getCityByNameTest() throws Exception {
        String city = this.manager.getCityByName("London").getName();
        assertEquals("London", city);
    }
}
