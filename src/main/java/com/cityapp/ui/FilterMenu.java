package com.cityapp.ui;

import com.cityapp.iterator.CloudyCityIterator;
import com.cityapp.iterator.RainyCityIterator;
import com.cityapp.iterator.SnowyCityIterator;
import com.cityapp.iterator.SunnyCityIterator;
import com.cityapp.model.City;

import java.util.List;
import java.util.Scanner;

public class FilterMenu {

    private final List<City> cities;
    private final ConsoleDisplay display;
    private final Scanner scanner;

    public FilterMenu(List<City> cities, ConsoleDisplay display, Scanner scanner) {
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
                case "1" -> { display.printIterator(new SunnyCityIterator(cities)); printMenu(); }
                case "2" -> { display.printIterator(new CloudyCityIterator(cities)); printMenu(); }
                case "3" -> { display.printIterator(new RainyCityIterator(cities)); printMenu(); }
                case "4" -> { display.printIterator(new SnowyCityIterator(cities)); printMenu(); }
                case "Q" -> { return; }
                default  -> { System.out.println("Gecersiz secim. Lütfen tekrar deneyin."); printMenu(); }
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Filtreleme Menüsü ---");
        System.out.println("1- Günesli sehirler");
        System.out.println("2- Bulutlu sehirler");
        System.out.println("3- Yagmurlu sehirler");
        System.out.println("4- Karli sehirler");
        System.out.println("Q- Geri dön");
        System.out.print("Seciminiz: ");
    }
}
