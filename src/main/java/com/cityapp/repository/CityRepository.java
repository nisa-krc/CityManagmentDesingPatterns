package com.cityapp.repository;

import com.cityapp.model.City;
import com.cityapp.service.JsonCityLoader;

import java.util.Collections;
import java.util.List;

public class CityRepository {

    private static CityRepository instance;
    private final List<City> cities;

    private CityRepository() {
        cities = new JsonCityLoader().load();
    }

    public static CityRepository getInstance() {
        if (instance == null) {
            instance = new CityRepository();
        }
        return instance;
    }

    public List<City> getCities() {
        return Collections.unmodifiableList(cities);
    }
}
