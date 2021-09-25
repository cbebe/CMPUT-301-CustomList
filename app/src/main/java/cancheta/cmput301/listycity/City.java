package cancheta.cmput301.listycity;

import androidx.annotation.NonNull;

/**
 * City class that holds information about its name and its province name
 */
public class City {
    private final String name;
    private final String province;

    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public String getProvince() {
        return province;
    }


    @NonNull
    @Override
    public String toString() {
        return name + "\t\t" + province;
    }
}
