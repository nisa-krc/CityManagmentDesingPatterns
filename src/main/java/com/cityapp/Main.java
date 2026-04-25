package com.cityapp;

import com.cityapp.iterator.CityIterator;
import com.cityapp.iterator.CloudyCityIterator;
import com.cityapp.iterator.RainyCityIterator;
import com.cityapp.iterator.SnowyCityIterator;
import com.cityapp.iterator.SunnyCityIterator;
import com.cityapp.model.City;
import com.cityapp.repository.CityRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<City> cities = CityRepository.getInstance().getCities();

        printFiltered("SUNNY  ☀", new SunnyCityIterator(cities));
        printFiltered("CLOUDY ⛅", new CloudyCityIterator(cities));
        printFiltered("RAINY  🌧", new RainyCityIterator(cities));
        printFiltered("SNOWY  ❄", new SnowyCityIterator(cities));
    }

    private static void printFiltered(String label, CityIterator iterator) {
        System.out.println("\n=== " + label + " Cities ===");
        boolean found = false;
        while (iterator.hasNext()) {
            City city = iterator.next();
            System.out.printf("  %-15s temp: %.1f°C%n", city.getName(), city.getCurrentTemperature());
            found = true;
        }
        if (!found) {
            System.out.println("  (none)");
        }
    }
}
