package com.example.simpleparadox.listycity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare the variables so that you will be able to reference it later.
        final ListView cityListView = findViewById(R.id.city_list);

        final String[] cities = {"Edmonton", "Vancouver", "Toronto", "Hamilton", "Denver", "Los Angeles"};
        final String[] provinces = {"AB", "BC", "ON", "ON", "CO", "CA"};

        final CityList cityDataList = new CityList();
        for (int i = 0; i < cities.length; ++i) {
            cityDataList.add(new City(cities[i], provinces[i]));
        }
        ArrayAdapter<City> cityAdapter = new CustomList(this, cityDataList.getCities());
        cityListView.setAdapter(cityAdapter);
    }
}
