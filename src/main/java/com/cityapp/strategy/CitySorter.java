package com.cityapp.strategy;

import com.cityapp.model.City;

import java.util.ArrayList;
import java.util.List;

public class CitySorter {

    private SortStrategy strategy;

    public CitySorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public List<City> sort(List<City> cities) {
        List<City> sorted = new ArrayList<>(cities);
        strategy.sort(sorted);
        return sorted;
    }
}
