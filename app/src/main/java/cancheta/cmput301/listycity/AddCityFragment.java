package cancheta.cmput301.listycity;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class AddCityFragment extends CityFragment {
    private OnFragmentActionListener listener;

    @Override
    protected AlertDialog.Builder buildBuilder(AlertDialog.Builder builder, EditText cityName, EditText provinceName) {
        return builder.setTitle(R.string.add_city)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", ((dialogInterface, i) -> {
                    String city = cityName.getText().toString();
                    String province = provinceName.getText().toString();
                    listener.onOkPressed(new City(city, province));
                }));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentActionListener) {
            listener = (OnFragmentActionListener) context;
        } else {
            throw new RuntimeException(String.format("%s must implement %s", context, OnFragmentActionListener.class.getName()));
        }
    }

    public interface OnFragmentActionListener {
        void onOkPressed(City newCity);
    }
}
