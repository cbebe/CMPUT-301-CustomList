package cancheta.cmput301.listycity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Array Singleton containing cities
 */
public class CityList extends ArrayList<City> {
    /** Initial data for CityList **/
    private static final String[][] defaultCities = {
            {"Edmonton", "AB"},
            {"Toronto", "ON"},
            {"Hamilton", "ON"},
            {"Denver", "CO"},
            {"Los Angeles", "CA"},
            {"Vancouver", "BC"},
    };
    /** Static Set containing cities selected for deletion **/
    private static final HashSet<City> selected =  new HashSet<>();
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

        for (City c : selected) {
            instance.remove(c);
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
            for (String[] tuple : defaultCities) {
                instance.add(City.from(tuple));
            }
        }
        return instance;
    }

    /**
     * Toggles selection of a city from the selected set
     * @param city city to toggle selection
     */
    public static void toggleSelected(City city) {
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
    public static boolean isSelected(City city) {
        return selected.contains(city);
    }
}
