package cancheta.cmput301.listycity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        CitiesAdapter citiesAdapter = new CitiesAdapter(this, CityList.getInstance());
        ListView cityList = findViewById(R.id.city_list);
        cityList.setAdapter(citiesAdapter);

        Button addCityButton = findViewById(R.id.add_city);
        addCityButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddCityActivity.class);
            startActivity(intent);
            citiesAdapter.notifyDataSetChanged();
        });
        Button deleteCityButton = findViewById(R.id.delete_city);
        deleteCityButton.setOnClickListener(v -> {
            if (CityList.deleteSelected()) {
                // Re-render ListView
                citiesAdapter.notifyDataSetChanged();
                cityList.setAdapter(citiesAdapter);
            }
        });

        cityList.setOnItemClickListener((adapterView, view, i, l) -> cityList.setAdapter(citiesAdapter));
    }
}