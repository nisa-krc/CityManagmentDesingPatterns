package com.cityapp.strategy;

import com.cityapp.model.City;

import java.util.Comparator;
import java.util.List;

public class SortByName implements SortStrategy {

    @Override
    public void sort(List<City> cities) {
        cities.sort(Comparator.comparing(City::getName));
    }
}
