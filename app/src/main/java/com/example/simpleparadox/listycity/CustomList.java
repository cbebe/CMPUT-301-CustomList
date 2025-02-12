package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private final ArrayList<City> cities;
    private final Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    /**
     * This method will get the size of the list
     *
     * @return The size of the list
     */
    public int getCount() {
        return cities.size();
    }

    /**
     * This method returns true if the given city is in the list, false otherwise
     *
     * @param city The City to search for
     * @return Whether the list contains the city or not
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This method deletes the given city from the list
     *
     * @param city The City to delete
     */
    public void deleteCity(City city) {
        cities.remove(city);
    }

    /**
     * This method will add a City object into the list
     *
     * @param city City to add to the list
     */
    public void addCity(City city) {
        cities.add(city);
    }

    /**
     * This method counts the number of cities in the list
     *
     * @return The number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }
}
