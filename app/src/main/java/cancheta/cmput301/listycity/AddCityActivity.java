package cancheta.cmput301.listycity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddCityActivity extends AppCompatActivity {
    Button addCityButton;
    EditText cityField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
    }

    @Override
    protected void onStart() {
        super.onStart();
        addCityButton = findViewById(R.id.add_city);
        cityField = findViewById(R.id.city_name);
        addCityButton.setOnClickListener(v -> {
            String city = cityField.getText().toString().trim();
            if (city.isEmpty()) return;
            CityList.getInstance().add(city);
            finish();
        });
    }
}