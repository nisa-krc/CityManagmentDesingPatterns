package com.cityapp;

/**
 * Entry point of the City Management Application.
 *
 * Startup sequence:
 *   1. JsonCityLoader  → reads cities.json from classpath
 *   2. CityRepository  → stores the loaded cities (Singleton)
 *   3. ConsoleMenu     → drives the interactive CLI loop
 *
 * These will be wired together in Phase 8 (Application Wiring).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== City Management App - BM324 ===");
        System.out.println("Phase 1 complete: Project skeleton is ready.");
    }
}
