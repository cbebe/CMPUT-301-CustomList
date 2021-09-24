package cancheta.cmput301.listycity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddCityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button addCityButton = findViewById(R.id.add_city);
        EditText cityField = findViewById(R.id.city_name);
        EditText provinceField = findViewById(R.id.province_name);
        addCityButton.setOnClickListener(v -> {
            String city = cityField.getText().toString().trim();
            String province = provinceField.getText().toString().trim();

            if (city.isEmpty())
                return;
            if (province.isEmpty())
                return;
            CityList.getInstance().add(new City(city, province));
            finish();
        });
    }
}