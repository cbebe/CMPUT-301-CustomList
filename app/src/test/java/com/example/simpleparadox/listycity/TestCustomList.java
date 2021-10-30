package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestCustomList {
    private CustomList list;
    City city  = new City("Halifax", "NS");

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(city);
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void hasCityTest() {
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    public void deleteCityTest() {
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
        int listSize = list.getCount();
        list.deleteCity(city);
        assertFalse(list.hasCity(city));
        assertEquals(list.getCount(), listSize - 1);
    }

    @Test
    public void countCitiesTest() {
        assertEquals(list.countCities(), 0);
        list.addCity(city);
        assertEquals(list.countCities(), 1);
        list.deleteCity(city);
        assertEquals(list.countCities(), 0);
    }
}
