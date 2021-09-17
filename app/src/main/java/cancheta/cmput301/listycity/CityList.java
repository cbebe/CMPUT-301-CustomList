package cancheta.cmput301.listycity;

import java.util.ArrayList;
import java.util.Arrays;

public class CityList extends ArrayList<String> {
    private static final String[] defaultCities = {
            "Edmonton", "Vancouver", "Calgary", "Moscow",
            "Berlin", "Vienna", "Tokyo"
    };
    private static CityList instance;

    private CityList() {
        super();
    }

    public static CityList getInstance() {
        if (instance == null) {
            instance = new CityList();
            instance.addAll(Arrays.asList(defaultCities));
        }
        return instance;
    }
}
