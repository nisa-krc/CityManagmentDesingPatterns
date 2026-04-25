package com.cityapp.ui;

import com.cityapp.model.City;

import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    private final List<City> cities;
    private final ConsoleDisplay display;
    private final Scanner scanner;

    public ConsoleMenu(List<City> cities) {
        this.cities = cities;
        this.display = new ConsoleDisplay();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("========================================");
        System.out.println("   City Management App  —  BM324");
        System.out.println("========================================");

        printMenu();

        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.isEmpty()) continue;

            switch (input) {
                case "1" -> { new SortMenu(cities, display, scanner).show(); printMenu(); }
                case "2" -> { new FilterMenu(cities, display, scanner).show(); printMenu(); }
                case "Q" -> {
                    System.out.println("Cikiliyor...");
                    scanner.close();
                    return;
                }
                default -> {
                    System.out.println("Gecersiz secim. Lütfen tekrar deneyin.");
                    printMenu();
                }
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Ana Menü ---");
        System.out.println("1- Listeleme icin tür secin");
        System.out.println("2- Filtreleme icin tür secin");
        System.out.println("Q- Cikis");
        System.out.print("Seciminiz: ");
    }
}
