package com.example.simpleparadox.listycity;

/**
 * Data model class for a City
 *
 * @author Charles Ancheta
 * @version 1.0
 */
public class City implements Comparable<City> {
    private final String city;
    private final String province;

    /**
     * Constructor for City class
     *
     * @param city     This is the name of the city
     * @param province This is the name of the province
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the name of the city
     *
     * @return The city name
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Gets the province name of the city
     *
     * @return The province name
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares two cities' names
     *
     * @param city This is the City to which to compare the calling City
     * @return Result of comparison between city Strings
     */
    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }
}
