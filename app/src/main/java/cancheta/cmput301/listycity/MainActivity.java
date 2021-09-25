package cancheta.cmput301.listycity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddCityFragment.OnFragmentActionListener {
    private final ArrayList<City> cityArrayList = new ArrayList<>();
    private static final String[][] defaultCities = { { "Edmonton", "AB" }, { "Toronto", "ON" }, { "Hamilton", "ON" },
            { "Denver", "CO" }, { "Los Angeles", "CA" }, { "Vancouver", "BC" }, };

    private void initList() {
        for (String[] tuple : defaultCities) {
            cityArrayList.add(new City(tuple[0], tuple[1]));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();

        final FloatingActionButton addCityButton = findViewById(R.id.add_city_button);
        addCityButton.setOnClickListener(v-> new AddCityFragment().show(getSupportFragmentManager(),getString(R.string.add_city_uc)));
    }

    public void onOkPressed(City c) {
        cityArrayList.add(c);
    }

    @Override
    protected void onStart() {
        super.onStart();
        CitiesAdapter citiesAdapter = new CitiesAdapter(this, cityArrayList);
        ListView cityList = findViewById(R.id.city_list);
        cityList.setAdapter(citiesAdapter);

        cityList.setOnItemClickListener((adapterView, view, i, l) -> cityList.setAdapter(citiesAdapter));

    }

    private static class CitiesAdapter extends ArrayAdapter<City> {
        private final ArrayList<City> cities;
        private Context context;
        public CitiesAdapter(Context context, ArrayList<City> cities) {
            super(context, R.layout.city_list_view, cities);
            this.cities = cities;
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                City data = cities.get(position);
                convertView = LayoutInflater.from(context).inflate(R.layout.city_list_view, parent, false);

                TextView cityName = convertView.findViewById(R.id.textView);
                cityName.setText(data.toString());
            }

            return convertView;
        }
    }
}