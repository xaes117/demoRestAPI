package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private static DataManager manager;

	public static void main(String[] args) {
		try {
			DemoApplication.manager = new DataManager();
			SpringApplication.run(DemoApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public static void setManager(DataManager manager) {
        DemoApplication.manager = manager;
    }

    public static DataManager getManager() {
		return manager;
	}
}
