package com.cityapp.iterator;

import com.cityapp.model.City;
import com.cityapp.model.WeatherState;

import java.util.List;

public class SnowyCityIterator implements CityIterator {

    private final List<City> cities;
    private int index = 0;

    public SnowyCityIterator(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean hasNext() {
        while (index < cities.size()) {
            if (cities.get(index).getCurrentWeatherState() == WeatherState.SNOWY) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public City next() {
        return cities.get(index++);
    }
}
