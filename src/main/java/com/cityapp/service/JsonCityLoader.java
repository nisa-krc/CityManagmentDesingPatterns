package com.cityapp.service;

import com.cityapp.model.City;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonCityLoader {

    private static final String DEFAULT_PATH = "/cities.json";

    public List<City> load() {
        return load(DEFAULT_PATH);
    }

    public List<City> load(String classpathResource) {
        InputStream inputStream = getClass().getResourceAsStream(classpathResource);

        if (inputStream == null) {
            throw new RuntimeException("Resource not found on classpath: " + classpathResource);
        }

        try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            Type listType = new TypeToken<List<City>>() {}.getType();
            List<City> cities = new Gson().fromJson(reader, listType);

            if (cities == null || cities.isEmpty()) {
                throw new RuntimeException("cities.json is empty or could not be parsed.");
            }

            return cities;

        } catch (JsonSyntaxException e) {
            throw new RuntimeException("Malformed JSON in " + classpathResource + ": " + e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read resource: " + classpathResource, e);
        }
    }
}
