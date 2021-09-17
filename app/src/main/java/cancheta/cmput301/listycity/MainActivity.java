package cancheta.cmput301.listycity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    ListView cityList;
    CitiesAdapter citiesAdapter;
    Button addCityButton;
    Button deleteCityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (citiesAdapter == null) {
            citiesAdapter = new CitiesAdapter(this, CityList.getInstance());
        }
        cityList = findViewById(R.id.city_list);
        cityList.setAdapter(citiesAdapter);

        addCityButton = findViewById(R.id.add_city);
        addCityButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddCityActivity.class);
            startActivity(intent);
            citiesAdapter.notifyDataSetChanged();
        });
        deleteCityButton = findViewById(R.id.delete_city);
        deleteCityButton.setOnClickListener(v -> {
            if (CityList.deleteSelected()) {
                citiesAdapter.notifyDataSetChanged();
                cityList.setAdapter(citiesAdapter);
            }
        });

    }
}