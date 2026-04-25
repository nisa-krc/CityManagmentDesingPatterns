package com.cityapp;

import com.cityapp.model.City;
import com.cityapp.repository.CityRepository;
import com.cityapp.strategy.CitySorter;
import com.cityapp.strategy.SortByArea;
import com.cityapp.strategy.SortByName;
import com.cityapp.strategy.SortByPopulation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<City> cities = CityRepository.getInstance().getCities();
        CitySorter sorter = new CitySorter(new SortByName());

        System.out.println("=== Sorted by Name ===");
        sorter.sort(cities).forEach(c -> System.out.println(c.getName()));

        sorter.setStrategy(new SortByPopulation());
        System.out.println("\n=== Sorted by Population (desc) ===");
        sorter.sort(cities).forEach(c -> System.out.printf("%-15s %,d%n", c.getName(), c.getPopulation()));

        sorter.setStrategy(new SortByArea());
        System.out.println("\n=== Sorted by Area (desc) ===");
        sorter.sort(cities).forEach(c -> System.out.printf("%-15s %.1f km²%n", c.getName(), c.getArea()));
    }
}
