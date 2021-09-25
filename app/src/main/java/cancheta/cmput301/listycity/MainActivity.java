package cancheta.cmput301.listycity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * MainActivity
 *
 * Main app activity
 */
public class MainActivity extends AppCompatActivity implements AddCityFragment.OnFragmentActionListener, EditCityFragment.OnFragmentActionListener {
    private static final String[][] defaultCities = {{"Edmonton", "AB"}, {"Toronto", "ON"}, {"Hamilton", "ON"},
            {"Denver", "CO"}, {"Los Angeles", "CA"}, {"Vancouver", "BC"},};
    private final ArrayList<City> cityArrayList = new ArrayList<>();

    // needs to be moved as members to update the UI
    private ListView cityList;
    private CitiesAdapter citiesAdapter;

    private void updateListView() {
        citiesAdapter.notifyDataSetChanged();
        cityList.setAdapter(citiesAdapter);
    }

    public void onOkPressed(City c) {
        cityArrayList.add(c);
        updateListView();
    }


    public void onSavePressed(City c, int position) {
        cityArrayList.set(position, c);
        updateListView();
    }

    public void onDeletePressed(City c) {
        cityArrayList.remove(c);
        updateListView();
    }

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
        addCityButton.setOnClickListener(v ->
                new AddCityFragment().show(getSupportFragmentManager(), getString(R.string.add_city_uc))
        );

        citiesAdapter = new CitiesAdapter(this, cityArrayList);
        cityList = findViewById(R.id.city_list);
        cityList.setAdapter(citiesAdapter);
        cityList.setOnItemClickListener((adapterView, view, i, l) ->
                new EditCityFragment(cityArrayList.get(i), i).show(getSupportFragmentManager(), getString(R.string.edit_city_uc))
        );
    }

    private static class CitiesAdapter extends ArrayAdapter<City> {
        private final ArrayList<City> cities;
        private final Context context;

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