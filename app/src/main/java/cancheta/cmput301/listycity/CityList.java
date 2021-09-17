package cancheta.cmput301.listycity;

import java.util.ArrayList;
import java.util.Arrays;

public class CityList extends ArrayList<String> {
    private static final String[] defaultCities = {
            "Edmonton", "Vancouver", "Calgary", "Moscow",
            "Berlin", "Vienna", "Tokyo"
    };
    public static final int NO_SELECTED = -1;

    private static int selected;
    private static CityList instance;

    private CityList() {
        super();
    }

    public static boolean deleteSelected() {
        if (selected == NO_SELECTED) {
            return false;
        }
        String value = instance.get(selected);
        instance.remove(value);
        selected = NO_SELECTED;
        return true;
    }

    public static CityList getInstance() {
        if (instance == null) {
            instance = new CityList();
            instance.addAll(Arrays.asList(defaultCities));
        }
        return instance;
    }

    public static int getSelected() {
        return selected;
    }

    public static void setSelected(int selected) {
        CityList.selected = selected;
    }
}
