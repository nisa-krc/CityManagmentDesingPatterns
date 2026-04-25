package com.cityapp.ui;

import com.cityapp.model.City;
import com.cityapp.strategy.CitySorter;
import com.cityapp.strategy.SortByArea;
import com.cityapp.strategy.SortByName;
import com.cityapp.strategy.SortByPopulation;

import java.util.List;
import java.util.Scanner;

public class SortMenu {

    private final List<City> cities;
    private final ConsoleDisplay display;
    private final Scanner scanner;

    public SortMenu(List<City> cities, ConsoleDisplay display, Scanner scanner) {
        this.cities = cities;
        this.display = display;
        this.scanner = scanner;
    }

    public void show() {
        printMenu();

        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.isEmpty()) continue;

            switch (input) {
                case "1" -> { display.printCities(new CitySorter(new SortByName()).sort(cities)); printMenu(); }
                case "2" -> { display.printCities(new CitySorter(new SortByPopulation()).sort(cities)); printMenu(); }
                case "3" -> { display.printCities(new CitySorter(new SortByArea()).sort(cities)); printMenu(); }
                case "Q" -> { return; }
                default  -> { System.out.println("Gecersiz secim. Lütfen tekrar deneyin."); printMenu(); }
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Siralama Menüsü ---");
        System.out.println("1- Isme göre siralama");
        System.out.println("2- Nüfusa göre siralama");
        System.out.println("3- Yüzölcümüne göre siralama");
        System.out.println("Q- Geri dön");
        System.out.print("Seciminiz: ");
    }
}
