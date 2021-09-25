package cancheta.cmput301.listycity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * CityFragment
 * <p>
 * Abstract DialogFragment base class for Cities
 * Contains  city name and province name text boxes
 */
public abstract class CityFragment extends DialogFragment {
    protected AlertDialog.Builder buildBuilder(AlertDialog.Builder builder, EditText cityName, EditText provinceName) {
        return builder;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstance) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.city_fragment_layout, null);
        // Inflate the layout for this fragment
        EditText cityName = view.findViewById(R.id.city_name_editText);
        EditText provinceName = view.findViewById(R.id.province_name_editText);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return buildBuilder(builder.setView(view), cityName, provinceName).create();
    }
}
