package cancheta.cmput301.listycity;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CitiesAdapter extends ArrayAdapter<String> {
    private static final int COLOUR_WHITE = Color.parseColor("#FFFFFF");
    private static final int COLOUR_GREY = Color.parseColor("#CCCCCC");

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
            cityName.setBackgroundColor(COLOUR_WHITE);

            convertView.setOnClickListener(v -> {
                int oldPosition = CityList.getSelected();
                // deselect option
                if (oldPosition == position) {
                    cityName.setBackgroundColor(COLOUR_WHITE);
                    CityList.setSelected(CityList.NO_SELECTED);
                    return;
                }
                if (oldPosition != CityList.NO_SELECTED) {
                    View oldSelected = parent.getChildAt(oldPosition);
                    oldSelected.setBackgroundColor(COLOUR_WHITE);
                }
                cityName.setBackgroundColor(COLOUR_GREY);
                CityList.setSelected(position);
            });
        }

        return convertView;
    }
}

