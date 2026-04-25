package com.cityapp.ui;

import com.cityapp.iterator.CityIterator;
import com.cityapp.model.City;

import java.util.List;

public class ConsoleDisplay {

    private static final String LINE = "-".repeat(55);

    public void printCities(List<City> cities) {
        System.out.println(LINE);
        System.out.printf("%-15s %12s %12s %7s %s%n",
                "Şehir", "Nüfus", "Alan (km²)", "Sıcak.", "Hava");
        System.out.println(LINE);
        for (City city : cities) {
            printRow(city);
        }
        System.out.println(LINE);
        System.out.println("Toplam: " + cities.size() + " şehir");
    }

    public void printIterator(CityIterator iterator) {
        System.out.println(LINE);
        System.out.printf("%-15s %12s %12s %7s %s%n",
                "Şehir", "Nüfus", "Alan (km²)", "Sıcak.", "Hava");
        System.out.println(LINE);
        int count = 0;
        while (iterator.hasNext()) {
            printRow(iterator.next());
            count++;
        }
        System.out.println(LINE);
        if (count == 0) {
            System.out.println("Bu kritere uyan şehir bulunamadı.");
        } else {
            System.out.println("Toplam: " + count + " şehir");
        }
    }

    private void printRow(City city) {
        System.out.printf("%-15s %,12d %12.1f %6.1f° %s%n",
                city.getName(),
                city.getPopulation(),
                city.getArea(),
                city.getCurrentTemperature(),
                city.getCurrentWeatherState());
    }
}
