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
    private final String TAG = "Sample";
    private final String CITIES_COLLECTION = "Cities";
    private final String PROVINCE_NAME = "Province Name";
    private ArrayAdapter<City> cityAdapter;
    private ArrayList<City> cityDataList;
    private EditText addCityEditText;
    private EditText addProvinceEditText;
    private EditText deleteCityEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare the variables so that you will be able to reference it later.
        final ListView cityList = findViewById(R.id.city_list);
        final Button addCityButton = findViewById(R.id.add_city_button);
        addCityEditText = findViewById(R.id.add_city_field);
        addProvinceEditText = findViewById(R.id.add_province_edit_text);

        final Button deleteCityButton = findViewById(R.id.delete_city_button);
        deleteCityEditText = findViewById(R.id.delete_city_field);


        cityDataList = new ArrayList<>();
        cityAdapter = new CustomList(this, cityDataList);
        cityList.setAdapter(cityAdapter);


        addCityButton.setOnClickListener(view -> {
            final String cityName = addCityEditText.getText().toString();
            final String provinceName = addProvinceEditText.getText().toString();

        });

        deleteCityButton.setOnClickListener(view -> {
            final String cityName = deleteCityEditText.getText().toString();
            if (cityName.length() > 0) {
                for (City city : cityDataList) {
                    if (city.getCityName().equals(cityName)) {
                        deleteCityEditText.setText("");
                        break;
                    }
                }

            }
        });

    }
}
