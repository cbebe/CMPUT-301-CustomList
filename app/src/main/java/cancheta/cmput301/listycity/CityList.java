package cancheta.cmput301.listycity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Array Singleton containing cities
 */
public class CityList extends ArrayList<String> {
    /** Initial data for CityList **/
    private static final String[] defaultCities = {
            "Edmonton", "Vancouver", "Calgary", "Moscow",
            "Berlin", "Vienna", "Tokyo"
    };
    /** Static Set containing cities selected for deletion **/
    private static HashSet<String> selected =  new HashSet<>();
    /** Singleton instance of CityList **/
    private static CityList instance;

    /**
     * Private constructor for singleton instance
     */
    private CityList() {
        super();
    }

    /**
     * Deletes selected cities from the list
     * @return true if any city was deleted
     */
    public static boolean deleteSelected() {
        if (selected.size() == 0) return false;

        for (String s : selected) {
            instance.remove(s);
        }

        selected.clear();

        return true;
    }

    /**
     * Gets CityList singleton instance
     * @return the CityList instance
     */
    public static CityList getInstance() {
        if (instance == null) {
            instance = new CityList();
            instance.addAll(Arrays.asList(defaultCities));
        }
        return instance;
    }

    /**
     * Toggles selection of a city from the selected set
     * @param city city to toggle selection
     */
    public static void toggleSelected(String city) {
        if (selected.contains(city)) {
            selected.remove(city);
        } else {
            selected.add(city);
        }
    }

    /**
     * Checks if the given city is in the selected set
     * @param city String to check existence in the set
     * @return true if the city is in selected
     */
    public static boolean isSelected(String city) {
        return selected.contains(city);
    }
}
