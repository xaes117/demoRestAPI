package com.example.demo.RestService;

public class Population {

    private final long id;
    private final String populationSize;

    public Population(long id, String content) {
        this.id = id;
        this.populationSize = content;
    }

    public long getId() {
        return id;
    }

    public String getPopulationSize() {
        return populationSize;
    }

}
