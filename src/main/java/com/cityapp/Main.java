package com.cityapp;

import com.cityapp.repository.CityRepository;
import com.cityapp.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        try {
            new ConsoleMenu(CityRepository.getInstance().getCities()).start();
        } catch (RuntimeException e) {
            System.err.println("[HATA] Uygulama baslatilamadi: " + e.getMessage());
            System.exit(1);
        }
    }
}
