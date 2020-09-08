package com.example.demo.RestService;

import com.example.demo.DataManager;
import com.example.demo.DemoApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PopulationControllerTests {

    @BeforeEach
    void setUp() throws Exception {
        DemoApplication.setManager(new DataManager());
    }

    @Test
    void getPopulationTest() throws Exception {
        assertEquals(6, new PopulationController().getPopulation(0, "London").getPopulationSize());
    }

    @Test
    void getPopulationTest2() throws Exception {

        PopulationController controller = new PopulationController();

        boolean alwaysExpanding = true;

        double prev = 0;
        double current = 0;

        // Check to see if the population is always expanding as the radius increases
        for (int i = 1; i < 2000; i = i + 50) {

            prev = current;
            current = controller.getPopulation(i, "London").getPopulationSize();

            if (prev > current) {
                alwaysExpanding = false;
            }
        }

        assertTrue(alwaysExpanding);

    }
}
