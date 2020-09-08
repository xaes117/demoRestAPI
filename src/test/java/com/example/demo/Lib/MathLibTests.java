package com.example.demo.Lib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathLibTests {

    @Test
    void distanceTest() {
        // Answer should be in miles
        assertEquals(60.0, MathLib.distance(0, 1, 0, 0));
        assertEquals(85.0, MathLib.distance(0, 1, 1, 0));
        assertEquals(0.0, MathLib.distance(0, 0, 0, 0));

    }
}
