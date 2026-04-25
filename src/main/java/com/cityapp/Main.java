package com.cityapp;

import com.cityapp.model.City;
import com.cityapp.repository.CityRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CityRepository repo1 = CityRepository.getInstance();
        CityRepository repo2 = CityRepository.getInstance();

        System.out.println("=== Singleton Test ===");
        System.out.println("repo1 == repo2: " + (repo1 == repo2));
        System.out.println();

        List<City> cities = repo1.getCities();
        System.out.println("Loaded " + cities.size() + " cities via CityRepository:\n");
        for (City city : cities) {
            System.out.println(city);
        }
    }
}
