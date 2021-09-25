package cancheta.cmput301.listycity;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class EditCityFragment extends CityFragment {
    private final City city;
    private final int position;
    private OnFragmentActionListener listener;

    public EditCityFragment(City city, int position) {
        this.city = city;
        this.position = position;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof AddCityFragment.OnFragmentActionListener) {
            listener = (OnFragmentActionListener) context;
        } else {
            throw new RuntimeException(String.format("%s must implement %s", context, AddCityFragment.OnFragmentActionListener.class.getName()));
        }
    }

    @Override
    protected AlertDialog.Builder buildBuilder(AlertDialog.Builder builder, EditText cityName, EditText provinceName) {
        cityName.setText(city.getName());
        provinceName.setText(city.getProvince());
        return builder.setTitle(R.string.edit_city)
                .setNegativeButton("Delete", (dialogInterface, i) -> listener.onDeletePressed(city))
                .setPositiveButton("Save", (dialogInterface, i) -> {
                    String city = cityName.getText().toString();
                    String province = provinceName.getText().toString();
                    listener.onSavePressed(new City(city, province), position);
                })
                .setNeutralButton("Close", null);
    }

    public interface OnFragmentActionListener {
        void onSavePressed(City city, int position);

        void onDeletePressed(City city);
    }
}
