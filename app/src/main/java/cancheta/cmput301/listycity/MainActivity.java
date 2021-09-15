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

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    private static final String[] defaultCities = {
            "Edmonton", "Vancouver", "Calgary", "Moscow",
            "Berlin", "Vienna", "Tokyo"
    };
    ListView cityList;
    ArrayList<String> cities = new ArrayList<>();
    CitiesAdapter citiesAdapter;
    Button addCityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        addCityButton = findViewById(R.id.add_city);
        citiesAdapter = new CitiesAdapter(this, cities);
        cities.addAll(Arrays.asList(defaultCities));
        cityList.setAdapter(citiesAdapter);

        addCityButton.setOnClickListener(v-> {
            Intent intent = new Intent(MainActivity.this, AddCityActivity.class);
            startActivity(intent);
        });
    }

    private class CitiesAdapter extends ArrayAdapter<String> {
        public CitiesAdapter(Context context, ArrayList<String> cities) {
            super(context, R.layout.city_list_view, cities);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String data = cities.get(position);
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.city_list_view, parent, false);

                viewHolder.text = convertView.findViewById(R.id.textView);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.text.setText(data);

            return convertView;
        }

        private class ViewHolder {
            TextView text;
        }

    }
}