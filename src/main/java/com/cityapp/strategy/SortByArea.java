package com.cityapp.strategy;

import com.cityapp.model.City;

import java.util.Comparator;
import java.util.List;

public class SortByArea implements SortStrategy {

    @Override
    public void sort(List<City> cities) {
        cities.sort(Comparator.comparingDouble(City::getArea).reversed());
    }
}
