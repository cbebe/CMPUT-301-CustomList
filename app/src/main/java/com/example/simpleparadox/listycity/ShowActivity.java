package com.example.simpleparadox.listycity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Button backButton = findViewById(R.id.button_back);
        String cityName = getIntent().getStringExtra(MainActivity.CITY_EXTRA);
        TextView cityView = findViewById(R.id.textview_city);
        cityView.setText(cityName);
        backButton.setOnClickListener(v -> finish());
    }
}