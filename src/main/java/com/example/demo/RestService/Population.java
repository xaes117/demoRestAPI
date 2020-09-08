package com.example.demo.RestService;

public class Population {

    private final long id;
    private final double populationSize;

    public Population(long id, double populationSize) {
        this.id = id;
        this.populationSize = populationSize;
    }

    public long getId() {
        return id;
    }

    public double getPopulationSize() {
        return populationSize;
    }

}
