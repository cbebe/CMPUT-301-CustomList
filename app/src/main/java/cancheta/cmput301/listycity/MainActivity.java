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


public class MainActivity extends AppCompatActivity {
    ListView cityList;
    CitiesAdapter citiesAdapter;
    Button addCityButton;

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
    }

    private class CitiesAdapter extends ArrayAdapter<String> {
        public CitiesAdapter(Context context, ArrayList<String> cities) {
            super(context, R.layout.city_list_view, cities);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                String data = CityList.getInstance().get(position);
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.city_list_view, parent, false);

                TextView cityName = convertView.findViewById(R.id.textView);
                cityName.setText(data);
            }

            return convertView;
        }

//        private class ViewHolder {
//            TextView text;
//        }

    }
}