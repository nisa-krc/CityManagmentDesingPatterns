package com.cityapp.model;

/**
 * Represents a city with its core properties.
 *
 * Fields are named exactly as they appear in cities.json so that
 * Gson can deserialize them automatically without any extra mapping.
 *
 * Used by:
 *   - Strategy Pattern  → sorted by name, population, or area
 *   - Iterator Pattern  → filtered by currentWeatherState
 */
public class City {

    private String name;
    private long population;
    private double area;
    private double currentTemperature;
    private WeatherState currentWeatherState;

    // ── Constructors ────────────────────────────────────────────────────────

    /** No-arg constructor required by Gson for deserialization. */
    public City() {}

    public City(String name, long population, double area,
                double currentTemperature, WeatherState currentWeatherState) {
        this.name = name;
        this.population = population;
        this.area = area;
        this.currentTemperature = currentTemperature;
        this.currentWeatherState = currentWeatherState;
    }

    // ── Getters ─────────────────────────────────────────────────────────────

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public WeatherState getCurrentWeatherState() {
        return currentWeatherState;
    }

    // ── Setters ─────────────────────────────────────────────────────────────

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public void setCurrentWeatherState(WeatherState currentWeatherState) {
        this.currentWeatherState = currentWeatherState;
    }

    // ── toString ─────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return String.format(
            "City{name='%s', population=%,d, area=%.1f km², temp=%.1f°C, weather=%s}",
            name, population, area, currentTemperature, currentWeatherState
        );
    }
}
