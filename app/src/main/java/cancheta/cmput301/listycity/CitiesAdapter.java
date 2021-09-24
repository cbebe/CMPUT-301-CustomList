package cancheta.cmput301.listycity;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * CitiesAdapter
 * ArrayAdapter class for city_list_view layout
 */
public class CitiesAdapter extends ArrayAdapter<City> {
    /**
     * Colour constants for TextView background
     **/
    private static final int BG_COLOUR_DESELECTED = Color.parseColor("#FFFFFF");
    private static final int BG_COLOUR_SELECTED = Color.parseColor("#CCCCCC");

    public CitiesAdapter(Context context, ArrayList<City> cities) {
        super(context, R.layout.city_list_view, cities);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            City data = CityList.getInstance().get(position);
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.city_list_view, parent, false);

            TextView cityName = convertView.findViewById(R.id.textView);
            cityName.setText(data.toString());
            cityName.setBackgroundColor(CityList.isSelected(data) ? BG_COLOUR_SELECTED : BG_COLOUR_DESELECTED);

            convertView.setOnClickListener(v -> {
                // invert colour
                cityName.setBackgroundColor(CityList.isSelected(data) ? BG_COLOUR_DESELECTED : BG_COLOUR_SELECTED);
                CityList.toggleSelected(data);
            });
        }

        return convertView;
    }
}

