package com.cityapp;

import com.cityapp.model.City;
import com.cityapp.service.JsonCityLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonCityLoader loader = new JsonCityLoader();
        List<City> cities = loader.load();

        System.out.println("=== City Management App - BM324 ===");
        System.out.println("Loaded " + cities.size() + " cities from cities.json:\n");

        for (City city : cities) {
            System.out.println(city);
        }
    }
}
