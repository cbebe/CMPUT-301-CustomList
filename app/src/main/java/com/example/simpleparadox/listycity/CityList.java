package com.example.simpleparadox.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of City objects
 *
 * @author Charles Ancheta
 * @version 1.0
 * @see City
 */
public class CityList {
    private final List<City> cities = new ArrayList<>();

    /**
     * This add a city to the list if the city does not exist
     *
     * @param city This is a candidate city to add
     * @throws IllegalArgumentException If city is already in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     *
     * @return Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks if a city is present in the list.
     * If it does then remove it from the list, if not then throw an exception
     *
     * @param city This is a candidate city to delete
     * @throws IllegalArgumentException If city is not present in the list
     */
    public void delete(City city) {
        if (this.hasCity(city)) {
            this.cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Find given city in the list
     *
     * @param city This is a candidate city to find
     * @return Whether or not it belongs in the list
     */
    public boolean hasCity(City city) {
        return this.cities.contains(city);
    }

    /**
     * Counts the number of cities in the list
     *
     * @return How many cities are in the list
     */
    public int countCities() {
        return this.cities.size();
    }
}
