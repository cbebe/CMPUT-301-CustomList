package cancheta.cmput301.listycity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CityList extends ArrayList<String> {
    private static final String[] defaultCities = {
            "Edmonton", "Vancouver", "Calgary", "Moscow",
            "Berlin", "Vienna", "Tokyo"
    };
    private static HashSet<String> selected =  new HashSet<>();
    private static CityList instance;

    private CityList() {
        super();
    }

    public static boolean deleteSelected() {
        if (selected.size() == 0) {
            return false;
        }
        for (String s : selected) {
            instance.remove(s);
        }
        selected.clear();
        return true;
    }

    public static CityList getInstance() {
        if (instance == null) {
            instance = new CityList();
            instance.addAll(Arrays.asList(defaultCities));
        }
        return instance;
    }

    public static void addSelected(String city) {
        selected.add(city);
    }

    public static void removeSelected(String city) {
        selected.remove(city);
    }

    public static boolean isSelected(String city) {
        return selected.contains(city);
    }

}
