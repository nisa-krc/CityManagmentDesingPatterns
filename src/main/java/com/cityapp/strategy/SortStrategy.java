package com.cityapp.strategy;

import com.cityapp.model.City;

import java.util.List;

public interface SortStrategy {
    void sort(List<City> cities);
}
